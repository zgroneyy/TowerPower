package com.java.TowerPower.Model;

import java.awt.Point;

import com.java.GameEngine.Model.Texture;
import com.java.TowerPower.util.TextureManager;

public class TowerModel extends GameObjectEntityModel {
	private int health;
	private int attackSpeed;
	private int damage;
	private int range;
	private TowerType towerType;
	private int attackTime;

	public TowerModel(Point point,float angle,Texture texture,TowerType type)
	{
		super(point, angle,texture);
		this.attackTime = 0;
		this.attackSpeed = 30;
		setDamageAndRange(type);
	}
	
	
	public int getHealth() {
		return this.health;
	}

	public int getRange() {
		return range;
	}

	public int getAttackSpeed() {
		return this.attackSpeed;
	}

	public int getDamage() {
		return damage;
	}
	
	private void setDamageAndRange(TowerType type) {
		this.towerType = type;
		if(type == TowerType.BRONZE) {
			this.range = 100;
			this.damage = 5;
			textures.add(0, TextureManager.getTexture("tower_bronze"));
		} else if(type == TowerType.SILVER) {
			this.range = 150;
			this.damage = 10;
			textures.add(0, TextureManager.getTexture("tower_silver"));
		} else if(type == TowerType.GOLD) {
			this.range = 200;
			this.damage = 15;
			textures.add(0, TextureManager.getTexture("tower_gold"));
		} else if(type == TowerType.DIAMOND) {
			this.range = 250;
			this.damage = 20;
			textures.add(0, TextureManager.getTexture("tower_diamond"));
		} else if(type == TowerType.BARAD_DUR) {
			this.range = 300;
			this.damage = 25;
			textures.add(0, TextureManager.getTexture("tower_barad"));
		} else {
			this.range = 100;
			this.damage = 5;
			textures.add(0, TextureManager.getTexture("tower_bronze"));
		}
	}

	public void setHealth(int parHealth) {
		this.health = parHealth;
	}

	public TowerType getTowerType() {
		return this.towerType;
	}

	public void setTowerType(TowerType parTowerType) {
		this.towerType = parTowerType;
		setDamageAndRange(parTowerType);
	}

	public int getAttackTime() {
		return this.attackTime;
	}
	
	/*
	* @Pre parAttackTime > 0
	*/
	public void setAttackTime(int parAttackTime) {
		this.attackTime = parAttackTime;
	}
	
	public String toString() {
		return "Tower Model ID: " + this.id + " TowerType: " + this.towerType + " Health: " + this.health;
	}
	
	public void upgrade(){
		if(TowerType.values().length > towerType.ordinal() + 1) {
			setDamageAndRange(TowerType.values()[towerType.ordinal()+1]);
		}
	}
	
	public void clear() {
		this.attackTime = 0;
		this.attackSpeed = 30;
	}
}