package com.java.TowerPower.Model;

import java.awt.Point;
import java.awt.Rectangle;

import com.java.GameEngine.Model.Texture;

public class TrapModel extends GameObjectEntityModel {
	private int effectArea;
	private int damage;
	private TrapType trapType;

	public TrapModel(Point point,float angle,Texture texture)
	{
		super(point, angle,texture);
	}

	
	public int getEffectArea() {
		return this.effectArea;
	}
	
	/*
	*	@Pre parEffectArea > 0
	*/
	public void setEffectArea(int parEffectArea) {
		this.effectArea = parEffectArea;
	}

	public int getDamage() {
		return this.damage;
	}

	/*
	*	@Pre parDamage > 0
	*/
	public void setDamage(int parDamage) {
		this.damage = parDamage;
	}

	public TrapType getTrapType() {
		return this.trapType;
	}

	public void setTrapType(TrapType parTrapType) {
		this.trapType = parTrapType;
	}
	
	public String toString() {
		return "Trap Model ID: " + this.id + " TrapType: " + this.trapType;
	}
}