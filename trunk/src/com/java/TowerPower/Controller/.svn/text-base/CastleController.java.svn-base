package com.java.TowerPower.Controller;

import java.awt.Point;
import java.util.Map.Entry;
import java.util.Set;

import com.java.GameEngine.Controller.GameObjectController;
import com.java.GameEngine.View.Display;
import com.java.TowerPower.TowerPowerConstants;
import com.java.TowerPower.Model.BackgroundId;
import com.java.TowerPower.Model.CastleModel;
import com.java.TowerPower.Model.EnemyModel;
import com.java.TowerPower.util.TextureManager;

public class CastleController extends GameObjectController<CastleModel> {

	private BackgroundId castlePosition;
	private CastleModel castleModel;
	public CastleController(BackgroundId castlePosition) {
		super();
		this.castlePosition = castlePosition;
		Point p = new Point(castlePosition.getX()*TowerPowerConstants.X_DIMENSION_OF_GRID, castlePosition.getY()*TowerPowerConstants.Y_DIMENSION_OF_GRID);
		castleModel = new CastleModel(p, 0, TextureManager.getTexture("castle"));
		
	}
	
	public CastleModel getModel(int parId) {
		return super.getModel(parId);
	}
	
	public CastleModel getCastle() {
		return this.castleModel;
	}

	public void addModel(CastleModel parModel) {
		super.addModel(parModel);
	}

	/*
	* @Post getModel(parId) == null
	*/
	public void removeModel(int parId) {
		
		super.removeModel(parId);
	}

	public Set<Entry<Integer, CastleModel>> getModelEntrySet() {
		return super.getModelEntrySet();
	}

	public void drawModels() {
		Display.getInstance().getCanvas().drawTexture(castleModel.getTexture(), castleModel.getPosition(), castleModel.getAngle());			
	}

	/*
	* Upgrade Castle Type
	* 
	*/
	public void upgradeCastle() {
		throw new UnsupportedOperationException();
	}

	public void onColided(EnemyModel parE, CastleModel parC) {
		parC.damage(parE.getDamage());
	}

	public void update() {
		super.update();
	}
	
	@Override
	public int getClicked(Point point) {
		// TODO Auto-generated method stub
		for(Entry<Integer, CastleModel> entry : getModelEntrySet()) {
			if(entry.getValue().contains(point)) {
				return entry.getValue().getId();
			}
		}
		return -1;
	}
}