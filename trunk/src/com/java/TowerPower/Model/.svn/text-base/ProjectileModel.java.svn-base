package com.java.TowerPower.Model;

import java.awt.Point;
import java.awt.Rectangle;

import com.java.GameEngine.Model.Texture;
import com.java.TowerPower.util.PhysicsManager;

public class ProjectileModel extends GameObjectEntityModel {
	private EnemyModel target;
	private int damage;

	public ProjectileModel(Point point,float angle,Texture texture)
	{
		super(point,angle,texture);
		setTarget(target);
		this.damage = 100;
		this.speed = 10;
	}
	
	public EnemyModel getTarget() {
		return this.target;
	}

	public void setTarget(EnemyModel parTarget) {
		this.target = parTarget;
	}

	public int getDamage() {
		return this.damage;
	}
	/*
	* @Pre parDamage > 0
	*/
	public void setDamage(int parDamage) {
		this.damage = parDamage;
	}
	
	public String toString() {
		return "Projectile Model ID: " + this.id + " Damage: " + this.damage;
	}
	
	public void clear() {
		this.damage = 100;
		this.speed = 5;
	}
}