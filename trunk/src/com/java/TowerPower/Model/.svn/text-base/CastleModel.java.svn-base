package com.java.TowerPower.Model;

import java.awt.Point;
import java.awt.Rectangle;

import com.java.GameEngine.Model.Texture;

public class CastleModel extends GameObjectEntityModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int health;
	
	
	public void damage(int damage) {
		this.health -= damage; 
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public CastleModel(Point point,float angle,Texture texture)
	{
		super(point, angle,texture);
		this.health = 100;
	}

	private int capacity;

	public int getCapacity() {
		return this.capacity;
	}

	public void setCapacity(Object parCapacity) {
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return "Castle Model ID: " + this.id + " Capacity: " + this.capacity;
	}
}