package com.java.TowerPower.Controller.menu;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import com.java.GameEngine.Model.Texture;
import com.java.GameEngine.View.Display;
import com.java.TowerPower.Controller.ButtonController;
import com.java.TowerPower.Model.ButtonModel;
import com.java.TowerPower.util.TextureManager;

public abstract class MenuController{
	protected int state; 
	protected ButtonController buttonController;
	
	public MenuController(int state)
	{
		this.state = state;
		buttonController = new ButtonController();
	}
	
	public int getState()
	{
		return state;
	}
	
	protected ButtonModel getClickedButton(MouseEvent mouseEvent) {
		if(mouseEvent.getButton() == MouseEvent.BUTTON1) {
			int buttonId = buttonController.getClicked(mouseEvent.getPoint());
			return buttonController.getModel(buttonId);
		}
		return null;
	}
	
	/**
	 * Update before inputs
	 */
	public void preUpdate()
	{
		
	}
	
	public void draw()
	{
		Display.getInstance().getCanvas().drawTexture(this.getBackground(), new Point(0,0), 0);
	}
	
	protected Texture getBackground()
	{
		return TextureManager.getTexture("background_main");
	}
	
	public abstract void update();
	public abstract void onMouseInput(MouseEvent event);
	public abstract void onKeyboardInput(KeyEvent event);
}
