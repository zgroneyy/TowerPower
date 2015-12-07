package com.java.TowerPower.Model;

import java.awt.Point;
import java.awt.Rectangle;

import com.java.GameEngine.Model.Texture;

public class TileModel extends GameObjectEntityModel {
	private TileType tileType;

	public TileModel(Point point,float angle,Texture texture)
	{
		super(point, angle,texture);
	}
	
	public TileType getTileType() {
		return this.tileType;
	}

	public void setTileType(TileType parTileType) {
		this.tileType = parTileType;
	}
	
	public String toString() {
		return "Tile Model ID: " + this.id + " TileType: " + this.tileType;
	}
}