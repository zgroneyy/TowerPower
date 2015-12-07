package com.java.TowerPower.Controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.util.Map.Entry;
import java.util.Set;

import com.java.GameEngine.Controller.GameObjectController;
import com.java.GameEngine.Model.Texture;
import com.java.GameEngine.View.Canvas;
import com.java.GameEngine.View.Display;
import com.java.TowerPower.Model.ButtonModel;
import com.java.TowerPower.util.TextureManager;

public class ButtonController extends GameObjectController<ButtonModel> {
	public static final int MENU_BUTTON = 0;
	public static final int LEVEL_SELECTION_BUTTON = 1;
	public static final int NEXT_BUTTON = 2;
	public static final int PREV_BUTTON = 3;
	
	public ButtonController() 
	{
		
	}
	
	public ButtonModel getModel(int parId) {
		return super.getModel(parId);
	}

	public void addModel(ButtonModel parModel) {
		super.addModel(parModel);
	}

	/*
	* @Post getModel(parId) == null
	*/
	public void removeModel(int parId) {
		super.removeModel(parId);
	}

	public Set<Entry<Integer, ButtonModel>> getModelEntrySet() {
		return super.getModelEntrySet();
	}

	public void drawModels() {
		Canvas canvas = Display.getInstance().getCanvas();
		for (Entry<Integer, ButtonModel> entry : models.entrySet())
		{
			ButtonModel button = entry.getValue();
			
			canvas.drawTexture(button.getTexture(), button.getPosition(), 0);
			
			Point center = button.getCenterPosition();
			canvas.drawTextOnCenter(button.getText(), button.getFont(), Color.black, center);
		}
	}

	public int getClicked(Point parP) {
		for (Entry<Integer, ButtonModel> entry : models.entrySet())
		{
			if(entry.getValue().contains(parP)){
				entry.getValue().setPressed(true);
				return entry.getKey();
			}
		}
		return -1;
	}

	public void update() {
		super.update();
	}
	
	public static ButtonModel createButton(int buttonType,String buttonText,Point buttonPosition)
	{
		Texture button , buttonPressed , buttonLocked;
		Font font;
		if (buttonType == MENU_BUTTON)
		{
			button = TextureManager.getTexture("menu_button");
			buttonPressed = TextureManager.getTexture("menu_button_pressed");
			buttonLocked = TextureManager.getTexture("menu_button_locked");
			font = new Font("Arial",0,20);
		}
		else if (buttonType == LEVEL_SELECTION_BUTTON)
		{
			button = TextureManager.getTexture("level_button");
			buttonPressed = TextureManager.getTexture("level_button_pressed");
			buttonLocked = TextureManager.getTexture("level_button_locked");
			font = new Font("Calibri",0,30);
		}
		else if(buttonType == NEXT_BUTTON) {
			button = TextureManager.getTexture("next_button");
			buttonPressed = TextureManager.getTexture("next_button_pressed");
			buttonLocked = TextureManager.getTexture("next_button");
			font = new Font("Calibri",0,20);
			
		} 
		else if(buttonType == PREV_BUTTON) {
			button = TextureManager.getTexture("prev_button");
			buttonPressed = TextureManager.getTexture("prev_button_pressed");
			buttonLocked = TextureManager.getTexture("prev_button");
			font = new Font("Calibri",0,20);
			
		} else
			return null;
		
		return new ButtonModel(buttonText, buttonPosition, button, buttonPressed, buttonLocked,font);
	}
}