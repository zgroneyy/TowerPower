package com.java.TowerPower.Model;

import java.awt.Point;
import java.awt.Rectangle;

import com.java.GameEngine.Model.Texture;
import com.java.TowerPower.util.TextureManager;

public class EnemyModel extends GameObjectEntityModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int health;
	private int movementSpeed;
	private int range = 500;
	private int damage;
	private EnemyType enemyType;
	private Point target;
	private int lastTargetIndex;
	private boolean isDead;

	public EnemyModel(Point position, float angle, Point target, int lastTargetIndex,Texture texture, EnemyType type)
	{
		super(position, angle,texture);
		setTarget(target);
		setLastTargetIndex(lastTargetIndex);
		setDamageAndSpeedAndHealth(type);
		
	}
	
	private void setDamageAndSpeedAndHealth(EnemyType type) {
		this.enemyType = type;
		if(type == EnemyType.ELF) {
			this.health = 100;
			this.setDamage(5);
			this.speed = 1;
			textures.add(0, TextureManager.getTexture("enemy_elf"));
		} else if(type == EnemyType.ORC) {
			this.health = 150;
			this.setDamage(10);
			this.speed = 2;
			textures.add(0, TextureManager.getTexture("enemy_orc"));
		} else if(type == EnemyType.GOBLIN) {
			this.health = 200;
			this.setDamage(15);
			this.speed = 3;
			textures.add(0, TextureManager.getTexture("enemy_goblin"));
		} else if(type == EnemyType.TROLL) {
			this.health = 250;
			this.setDamage(20);
			this.speed = 4;
			textures.add(0, TextureManager.getTexture("enemy_troll"));
		} else {
			this.health = 100;
			this.setDamage(5);
			this.speed = 1;
			textures.add(0, TextureManager.getTexture("enemy_elf"));
		}
	}
	
	public Point getTargetPoint() {
		return target;
	}
	
	public boolean isReached() {
		
		return (Math.abs(getCenterPosition().x - target.x) <= this.speed &&
				Math.abs(getCenterPosition().y - target.y) <= this.speed);
	}
	
	public int getLastTargetIndex() {
		return lastTargetIndex;
	}
	
	public void setLastTargetIndex(int lastTargetIndex) {
		this.lastTargetIndex = lastTargetIndex;
	}
	
	public void setTarget(Point point) {
		this.target = point;
	}

	public int getHealth() {
		return this.health;
	}

	public void setHealth(int parHealth) {
		this.health = parHealth;
		isDead = this.health <= 0;
	}


	public int getRange() {
		return this.range;
	}

	/*
	* @Pre parRange > 0
	*/
	public void setRange(int parRange) {
		this.range = parRange;
	}

	public void damageBy(int damage) {
		this.health = this.health - damage;
		isDead = this.health <= 0;
	}

	public EnemyType getEnemyType() {
		return this.enemyType;
	}

	public void setEnemyType(EnemyType parEnemyType) {
		this.enemyType = parEnemyType;
		setDamageAndSpeedAndHealth(parEnemyType);
	}
	
	public String toString() {
		return "Enemy Model ID: " + this.id + " EnemyType: " + this.enemyType;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	public void clear() {
		lastTargetIndex = 0;
	}

	public boolean isDead()
	{
		return this.isDead;
	}
}