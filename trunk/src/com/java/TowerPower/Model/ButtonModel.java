package com.java.TowerPower.Model;

import java.awt.Font;
import java.awt.Point;

import com.java.GameEngine.Model.Texture;

public class ButtonModel extends GameObjectEntityModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String text;
	private boolean pressed;
	private boolean locked;
	private Font font;
	
	public ButtonModel(String text,Point position,Texture buttonTexture,
			 Texture clikedTexture, Texture lockedTexture,Font textFont) {
		super(position,0,buttonTexture);
		
		this.text = text;
		this.pressed = false;
		this.locked = false;
		this.font = textFont;
		
		textures.add(1,clikedTexture);
		textures.add(2,lockedTexture);
		
		this.move(-boundingBox.width/2, -boundingBox.height/2);
	}
	
	public Texture getTexture()
	{
		if (pressed)
			return getTexture(1);
		if (locked)
			return getTexture(2);
		else
			return getTexture(0);
	}
	
	public String getText() {
		return this.text;
	}

	public void setText(String parText) {
		this.text = parText;
	}

	public boolean getPressed() {
		if (!this.pressed && !this.locked)
			return this.pressed;
		
		return false;
	}

	public void setPressed(boolean parPressed) {
		this.pressed = parPressed;
	}
	
	public boolean getLocked() {
		return this.locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}
	
	public Font getFont()
	{
		return this.font;
	}
	
	public String toString() {
		return "Button Model ID: " + this.id + " Text: " + this.text;
	}
	
}