package com.java.TowerPower.Controller;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.Set;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import com.java.GameEngine.Audio.AudioClip;
import com.java.GameEngine.Audio.AudioManager;
import com.java.GameEngine.Controller.GameObjectController;
import com.java.GameEngine.Model.Texture;
import com.java.GameEngine.View.Display;
import com.java.GameEngine.log.LogManager;
import com.java.TowerPower.Model.EnemyModel;
import com.java.TowerPower.Model.Player;
import com.java.TowerPower.Model.TowerModel;
import com.java.TowerPower.Model.TowerType;
import com.java.TowerPower.util.SoundEffectsManager;
import com.java.TowerPower.util.TextureManager;

public class TowerController extends GameObjectController<TowerModel> {
	
	Player player;
	
	public TowerController(Player p) {
		this.player = p;
	}

	public TowerModel getModel(int parId) {
		return super.getModel(parId);
	}

	/*
	* @Pre parModel != null
	* @Post getModel(parModel.id) != null
	*
	*/
	public void addModel(TowerModel parModel) {
		super.addModel(parModel);
	}

	/*
	* Remove model from model list, which is inherited from GameObjectController
	*
	*/
	public void removeModel(int parId) {
		super.removeModel(parId);
	}

	public Set<Entry<Integer, TowerModel>> getModelEntrySet() {
		return super.getModelEntrySet();
	}

	/*
	* Draw towers using appropriate tower texture and tower data
	*/
	public void drawModels() {
		for(Entry<Integer, TowerModel> entry : getModelEntrySet()) {
			Display.getInstance().getCanvas().drawTexture(entry.getValue().getTexture(), entry.getValue().getPosition(), 0);		
		}
	}

	/*
	* These method is carried to GameMenuController
	*
	*/
	public void onEnemyIsInRange(EnemyModel parE, TowerModel parT) {
		
	}

	public void onAttacked(EnemyModel parE, TowerModel parT) {
		throw new UnsupportedOperationException();
	}

	public static TowerModel createTower(Point point,TowerType type)
	{
		Texture texture;
		switch(type)
		{
			case BARAD_DUR:
				texture = TextureManager.getTexture("tower_barad");
				break;
			case BRONZE:
				texture = TextureManager.getTexture("tower_bronze");
				break;
			case DIAMOND:
				texture = TextureManager.getTexture("tower_diamond");
				break;
			case GOLD:
				texture = TextureManager.getTexture("tower_gold");
				break;
			case SILVER:
				texture = TextureManager.getTexture("tower_silver");
				break;
			default:
				texture = TextureManager.getTexture("tower_bronze");
		}
		
		TowerModel tower = new  TowerModel(point, 0, texture,type);
		
		return tower;
	}
	
	public void onNewTowerRequested(Point p) {
		
		TowerModel towerModel = getOldNextModel();
		if(towerModel == null) {
			towerModel = createTower(p, TowerType.BRONZE);
		} else {
			towerModel.setPosition(p);
			towerModel.setTowerType(TowerType.BRONZE);
		}
		Point pCenter = new Point((int)(p.x - towerModel.getTexture().getSize().getWidth()/2), p.y - (int)(towerModel.getTexture().getSize().getHeight()/2));
		towerModel.setPosition(pCenter);
		if(!isThereATowerNearPoint(pCenter, towerModel.getTexture().getSize())) {
			if(player.getGold() >= 100) {
				addModel(towerModel);
				player.decrementGold(100);
			}
		} else {
			LogManager.getInstance().log("You cannot build a tower near another tower");
		}
	}
	
	/**
	 * Method that return if a tower is build point p 
	 * whether it will intersect with another one or not 
	 * 
	 * @param p
	 * @param dimen
	 * @return
	 */
	private boolean isThereATowerNearPoint(Point p, Dimension dimen) {
		
		Rectangle rectangle = new Rectangle(p, dimen);
		for(Entry<Integer, TowerModel> entry: getModelEntrySet()) {
			if(entry.getValue().intersects(rectangle)) {
				return true;
			}
		}
		return false;
	}
	
	/*
	* Periodic update method
	*/
	public void update() {
		super.update();
	}
	
	public void upgradeTower(int id) {

		if(player.getGold() >= 50) {
			getModel(id).upgrade();
			player.decrementGold(50);
			AudioManager.play(SoundEffectsManager.getInstance().getAudioClip("upgrade"), 1, 1F);
		}
	}
	
	/**
	 * return id of tower if there is clicked one
	 */
	@Override
	public int getClicked(Point point) {
		// TODO Auto-generated method stub
		for(Entry<Integer, TowerModel> entry : getModelEntrySet()) {
			if(entry.getValue().contains(point)) {
				upgradeTower(entry.getValue().getId());
				return entry.getValue().getId();
			}
		}
		return -1;
	}
}