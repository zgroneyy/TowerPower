package com.java.TowerPower.util;

import java.awt.Dimension;
import java.awt.Point;

import com.java.GameEngine.View.Display;
import com.java.TowerPower.Model.GameObjectEntityModel;

public class PhysicsManager
{
	public static void move(GameObjectEntityModel entity)
	{
		//Calculates speed
		int dx = (int)Math.round(entity.getSpeed() * Math.cos(entity.getAngle()));
		int dy = (int)Math.round(entity.getSpeed() * Math.sin(entity.getAngle()));
		
		entity.move(dx, dy);
	}
	
	public static void moveTo(GameObjectEntityModel entity,Point target)
	{
		//Sets angle
		entity.setAngle(getAngle(entity.getCenterPosition(),target));
		move(entity);
	}
	
	public static void moveTo(GameObjectEntityModel entity,GameObjectEntityModel target)
	{
		//Calculates expected hit angle using trigonometric functions
		double alpha = getAngle(entity.getCenterPosition() , target.getCenterPosition());

		double theta = (target.getSpeed() * Math.sin(alpha))/entity.getSpeed();
		
		if (Math.abs(entity.getAngle() - (float)(alpha + theta)) < 1)
			entity.setAngle((float)(alpha + theta));
		
		move(entity);
	}
	
	public static float getAngle(Point source,Point target)
	{
		//Finds dx , dy
		float dy = target.y - source.y;
		float dx = target.x - source.x;
		
		//Finds angle between two points using slope
		return (float) Math.atan2(dy,dx);
	}
	
	public static boolean isCenterInScreen(GameObjectEntityModel entity)
	{
		Dimension screenDimension = Display.getInstance().getSize();
		int x = entity.getCenterPosition().x;
		int y = entity.getCenterPosition().x;
		
		return x <= screenDimension.width && x >= 0 &&
				y <=screenDimension.height && y >=0;
	}
	
	
	public static boolean isFullyInScreen(GameObjectEntityModel entity)
	{
		Dimension screenDimension = Display.getInstance().getSize();
		int x = entity.getCenterPosition().x;
		int y = entity.getCenterPosition().x;
		
		int width = entity.getDimension().width;
		int height = entity.getDimension().height;
		
		return x <= screenDimension.width - width / 2 && x >= width / 2 &&
				y <=screenDimension.height - height /2 && y >= height / 2;
	}
}
