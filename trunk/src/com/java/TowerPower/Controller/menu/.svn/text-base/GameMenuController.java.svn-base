package com.java.TowerPower.Controller.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.JOptionPane;

import com.java.GameEngine.Audio.AudioManager;
import com.java.GameEngine.Model.Texture;
import com.java.GameEngine.View.Display;
import com.java.TowerPower.Controller.CastleController;
import com.java.TowerPower.Controller.EnemyController;
import com.java.TowerPower.Controller.ProjectileController;
import com.java.TowerPower.Controller.TileController;
import com.java.TowerPower.Controller.TowerController;
import com.java.TowerPower.Controller.TowerPowerController;
import com.java.TowerPower.Model.CastleModel;
import com.java.TowerPower.Model.EnemyModel;
import com.java.TowerPower.Model.Level;
import com.java.TowerPower.Model.Player;
import com.java.TowerPower.Model.ProjectileModel;
import com.java.TowerPower.Model.TowerModel;
import com.java.TowerPower.util.LevelManager;
import com.java.TowerPower.util.SoundEffectsManager;
import com.java.TowerPower.util.TextureManager;

public class GameMenuController extends MenuController
{
	private ProjectileController projectileController;
	private TowerController towerController;
	private EnemyController enemyController;
	private TileController tileController;
	private CastleController castleController;
	private boolean isPaused = false;
	private boolean isFinished = false;
	private boolean isWin = false;
	
	private int currentLevel;
	private int maxNumberOfLevel = 2;
	
	private int gameTime;
	private Player player;
	
	public GameMenuController()
	{
		super(TowerPowerController.NEW_GAME_MENU);
		gameTime = 0;
		currentLevel = 1;
		player = new Player();
		initGameControllers();
		
	}
	
	private void initGameControllers() {

		player.setGold(500);
		towerController = new TowerController(player);
		projectileController = new ProjectileController();
		Level level = LevelManager.getInstance().getLevel(currentLevel);
		tileController = new TileController(level.getEnemyAndTileGirdList());
		castleController = new CastleController(level.getBackgroundId());
		enemyController = new EnemyController(level.getEnemyAndTileGirdList(), currentLevel);
	}
	
	@Override
	public void preUpdate()
	{
		gameTime++; //Increments the game time
	}

	@Override
	public void update()
	{
		detectEnemyInRange();
		detectCastleEnemyCollision();
		
		if(enemyController.isWavesFinished() && castleController.getCastle().getHealth() > 0) {
			isFinished = true;
			isWin = true;
		}
		
		if(castleController.getCastle().getHealth() <= 0) {
			isFinished = true;
			isWin = false;
		}
		if((!isPaused) && (!isFinished)) {
			tileController.update();
			enemyController.update();
			projectileController.update();
			castleController.update();
			towerController.update();
		}
		
		if(isFinished) {
			String gameFinishedMessage = isWin ? "Congratulations!": "You have been defeated";
			JOptionPane.showMessageDialog(null,
				    gameFinishedMessage,
				    "Game Finished",
				    JOptionPane.PLAIN_MESSAGE);
			if(currentLevel < maxNumberOfLevel) {
				isFinished = false;
				currentLevel++;
				initGameControllers();
			} else {
				this.state = TowerPowerController.MAIN_MENU;
			}
		}
	}
	
	private void detectEnemyInRange() {
		for(Entry<Integer, TowerModel> towerEntry : towerController.getModelEntrySet()) {
			for(Entry<Integer, EnemyModel> enemyEntry : enemyController.getModelEntrySet()) {
				if(isEnemyInRange(enemyEntry.getValue(), towerEntry.getValue())) {
					TowerModel tower = towerEntry.getValue();
					if (tower.getAttackTime() <= gameTime){	
						
						ProjectileModel projectileModel = projectileController.getOldNextModel();
						if(projectileModel == null) {
							projectileModel = ProjectileController.createProjectile(tower.getCenterPosition(), enemyEntry.getValue());							
						} else {
							projectileModel = ProjectileController.createProjectileFromExisting(projectileModel, tower.getCenterPosition(), enemyEntry.getValue());
						}
						projectileController.addModel(projectileModel);
						AudioManager.play(SoundEffectsManager.getInstance().getAudioClip("fire"), 1, 1F);
						
						//Sets new attack time
						tower.setAttackTime(gameTime + tower.getAttackSpeed());
					}
				}
			}
		}
	}
	
	public void detectCastleEnemyCollision() {
		for(Entry<Integer, EnemyModel> enemyEntry : enemyController.getModelEntrySet()) {
			CastleModel castleModel = castleController.getCastle();
			if(enemyEntry.getValue().intersects(castleModel)) {
				castleController.onColided(enemyEntry.getValue(), castleModel);
				player.incrementGold(enemyEntry.getValue().getDamage());
				enemyController.removeModel(enemyEntry.getValue().getId());
			}
		}
	}
	
	protected Texture getBackground()
	{
		return TextureManager.getTexture("background_game");
	}
	
	@Override
	public void draw()
	{
		super.draw();

		tileController.drawModels();
		towerController.drawModels();
		enemyController.drawModels();
		projectileController.drawModels();
		castleController.drawModels();
		drawPlayerGold();
	}
	
	private void drawPlayerGold()
	{
		Display.getInstance().getCanvas().drawTexture(TextureManager.getTexture("player_profile"), new Point(480,0), 0F);
		Display.getInstance().getCanvas().drawText("Name : " + player.getName(), new Font("Verdana", Font.BOLD, 12), Color.BLACK, new Point(500, 15));
		Display.getInstance().getCanvas().drawText("Gold : " + player.getGold(), new Font("Verdana", Font.BOLD, 12), Color.BLACK, new Point(500, 30));
		Display.getInstance().getCanvas().drawText("Health : " + castleController.getCastle().getHealth(), new Font("Verdana", Font.BOLD, 12), Color.BLACK, new Point(500, 45));

	}
	
	@Override
	public void onMouseInput(MouseEvent event)
	{
		if(event.getButton() == MouseEvent.BUTTON1) {
			Point p = event.getPoint();
			if(enemyController.getClicked(p) != -1) {
				
			} else if(towerController.getClicked(p) != -1) {
				
			} else if(castleController.getClicked(p) != -1) {
				
			} else if(projectileController.getClicked(p) != -1) {
				
			} else if(tileController.getClicked(p) != -1) {
				
			} else {
				if(tileController.getClickedWithTowerIntersect(p) == -1)
					towerController.onNewTowerRequested(p);
			}
		}
	}

	
	public boolean isClickedOn(Point point, Set<Entry<Integer, TowerModel>> modelSet) {
		
		for(Entry<Integer, TowerModel> entry : modelSet) {
			if(entry.getValue().contains(point)) {
				return true;
			}
		}
		return false;
		
	}

	@Override
	public void onKeyboardInput(KeyEvent event)
	{
		//TODO it seems key event does not come here
		if(event.getKeyChar() == 'P') {
			System.out.println("PPPPP");
			isPaused = !isPaused;
		}
		
	}
	
	/**
	 * Check whether specific enemy is in range or not
	 * 
	 */
	public boolean isEnemyInRange(EnemyModel enemyModel, TowerModel towerModel) {
		double distance = enemyModel.getCenterPosition().distance(towerModel.getCenterPosition());
		return distance < towerModel.getRange();
	}
	
	public int getGameTime()
	{
		return gameTime;
	}
	
	public void setGameTime(int gameTime)
	{
		this.gameTime = gameTime;
	}
}
