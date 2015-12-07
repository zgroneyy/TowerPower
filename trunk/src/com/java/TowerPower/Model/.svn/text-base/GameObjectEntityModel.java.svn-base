package com.java.TowerPower.Model;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;

import com.java.GameEngine.Model.GameObjectModel;
import com.java.GameEngine.Model.Texture;

public class GameObjectEntityModel extends GameObjectModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Rectangle boundingBox;
	protected float angle;
	protected int speed;
	protected List<Texture> textures;
	
	public GameObjectEntityModel(Point point,float angle,Texture texture)
	{
		this.boundingBox = new Rectangle(point,texture.getSize());
		this.angle = angle;
		
		textures = new LinkedList<>();
		textures.add(texture);
	}
	
	protected Texture getTexture(int textureIndex)
	{
		return textures.get(textureIndex);
	}
	
	public Texture getTexture()
	{
		return getTexture(0);
	}
	
	public Point getPosition() {
		return new Point(boundingBox.x,boundingBox.y);
	}
	public Point getCenterPosition() {
		return new Point((int)boundingBox.getCenterX(), (int)boundingBox.getCenterY());
	}
	
	public void setCenterPosition(Point p) {
		setPosition(new Point(p.x - boundingBox.width/2,p.y - boundingBox.height/2));
	}

	public Dimension getDimension() {
		return boundingBox.getSize();
	}

	public void setPosition(Point parPoint) {
		boundingBox.setLocation(parPoint);
	}

	public void setDimension(Dimension parD) {
		boundingBox.setSize(parD);
	}

	public boolean contains(Point parP) {
		return this.boundingBox.contains(parP);
	}

	public boolean intersects(GameObjectEntityModel parModel) {
		return boundingBox.intersects(parModel.boundingBox);
	}
	
	public boolean intersects(Rectangle rectangle) {
		return boundingBox.intersects(rectangle);
	}

	public boolean contains(GameObjectEntityModel parModel) {
		return boundingBox.contains(parModel.boundingBox);
	}

	public float getAngle() {
		return this.angle;
	}

	/*
	* @Pre parAngle > 0
	*/
	public void setAngle(float parAngle) {
		this.angle = parAngle;
	}

	public int getSpeed()
	{
		return this.speed;
	}
	
	public void move(int dx,int dy)
	{
		this.boundingBox.setLocation(boundingBox.x + dx, boundingBox.y + dy);
	}
}