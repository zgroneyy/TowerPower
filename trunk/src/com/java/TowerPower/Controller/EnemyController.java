package com.java.TowerPower.Controller;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import com.java.GameEngine.Controller.GameObjectController;
import com.java.GameEngine.Model.Texture;
import com.java.GameEngine.View.Display;
import com.java.TowerPower.TowerPowerConstants;
import com.java.TowerPower.Model.BackgroundId;
import com.java.TowerPower.Model.CastleModel;
import com.java.TowerPower.Model.EnemyModel;
import com.java.TowerPower.Model.EnemyType;
import com.java.TowerPower.Model.EnemyWave;
import com.java.TowerPower.Model.ProjectileModel;
import com.java.TowerPower.Model.TrapModel;
import com.java.TowerPower.util.LevelManager;
import com.java.TowerPower.util.PhysicsManager;
import com.java.TowerPower.util.TextureManager;

public class EnemyController extends GameObjectController<EnemyModel> {
	List<BackgroundId> enemyPathPoints;
	List<EnemyWave> enemyWaves;
	EnemyWave enemyWave;
	
	public EnemyController(List<BackgroundId> list, int level) {
		super();
		enemyPathPoints = list;
		enemyWaves = LevelManager.getInstance().getEnemyWaveList(level);
		enemyWave = enemyWaves.get(0);
		enemyWaves.remove(0);
	}
	
	public boolean isWavesFinished() {
		for(EnemyWave enemyWave : enemyWaves) {
			if(!enemyWave.isCompleted())
				return false;
		}
		if(models.size() > 0)
			return false;
		return true;
	}
	

	public EnemyModel getModel(int parId) {
		return super.getModel(parId);
		
	}

	public void addModel(EnemyModel parModel) {
		super.addModel(parModel);
	}
	/*
	* @Post getModel(parId) == null
	*/
	public void removeModel(int parId) {
		super.removeModel(parId);
	}

	public Set<Entry<Integer, EnemyModel>> getModelEntrySet() {
		return super.getModelEntrySet();
	}

	public void drawModels() {
		for(Entry<Integer, EnemyModel> entry: getModelEntrySet()) {
			Display.getInstance().getCanvas().drawTexture(entry.getValue().getTexture(), entry.getValue().getPosition(), 0);
		}
	}

	public void onHit(EnemyModel parE, ProjectileModel parP) {
		throw new UnsupportedOperationException();
	}

	public void onCollided(EnemyModel parE, CastleModel parC) {
		throw new UnsupportedOperationException();
	}

	public void onCollided(EnemyModel parE, TrapModel parT) {
		throw new UnsupportedOperationException();
	}

	public void update() {
		super.update();
		checkEnemyHealthAndPosition();
		produceEnemyIfNeeded();

	}
	
	private void checkEnemyHealthAndPosition() {
		for(Entry<Integer, EnemyModel> entry : getModelEntrySet()) {
			EnemyModel enemyModel = entry.getValue();
			if(enemyModel.getHealth() <= 0) {
				removeModel(enemyModel.getId());
				continue;
			}
			if(enemyModel.isReached() && enemyPathPoints.size() > enemyModel.getLastTargetIndex()+1) {
				BackgroundId backgroundId = enemyPathPoints.get(enemyModel.getLastTargetIndex() + 1);
				Point p = new Point((int)(backgroundId.getX()*64 + TowerPowerConstants.W_ENEMY/2), (int)(backgroundId.getY()*64 + TowerPowerConstants.H_ENEMY/2));
				enemyModel.setTarget(p);
				enemyModel.setLastTargetIndex(enemyModel.getLastTargetIndex()+1);
			} else {
				PhysicsManager.moveTo(enemyModel, enemyModel.getTargetPoint());				
			}
		}
	}
	
	private void produceEnemyIfNeeded() {
		if(enemyWave.shouldProduceEnemy()) {
			BackgroundId backgroundId1 = enemyPathPoints.get(0);
			BackgroundId backgroundId2 = enemyPathPoints.get(1);
			Point p1 = new Point(backgroundId1.getX()*64, backgroundId1.getY()*64);
			Point p2 = new Point(backgroundId2.getX()*64 + TowerPowerConstants.W_ENEMY/2, backgroundId2.getY()*64 + TowerPowerConstants.H_ENEMY/2);
			
			EnemyModel enemyModel = getOldNextModel();
			if(enemyModel == null) {
				enemyModel = createEnemy(p1, p2, enemyWave.getEnemyType());				
			} else {
				enemyModel.clear();
				enemyModel.setPosition(p1);
				enemyModel.setTarget(p2);
				enemyModel.setEnemyType(enemyWave.getEnemyType());
			}
			
			addModel(enemyModel);
			enemyWave.increaseProgress();
			if(enemyWave.isCompleted() && enemyWaves.size() > 0) {
				enemyWave = enemyWaves.get(0);
				enemyWaves.remove(0);
			}
		}
	}
	
	public static EnemyModel createEnemy(Point position,Point target,EnemyType type)
	{
		Texture enemyTexture;
		
		switch(type)
		{
			case ELF:
				enemyTexture = TextureManager.getTexture("enemy_elf");
				break;
			case GOBLIN:
				enemyTexture = TextureManager.getTexture("enemy_goblin");
				break;
			case ORC:
				enemyTexture = TextureManager.getTexture("enemy_orc");
				break;
			case TROLL:
				enemyTexture = TextureManager.getTexture("enemy_troll");
				break;
			default:
				enemyTexture = TextureManager.getTexture("enemy_elf");
		}
		
		EnemyModel e = new EnemyModel(position, 0, target, 0, enemyTexture, type);
		
		return e;
	}


	@Override
	public int getClicked(Point point) {
		// TODO Auto-generated method stub
		for(Entry<Integer, EnemyModel> entry : getModelEntrySet()) {
			if(entry.getValue().contains(point)) {
				return entry.getValue().getId();
			}
		}
		return -1;
	}
}