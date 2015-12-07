package com.java.TowerPower.Controller.menu;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import com.java.GameEngine.Model.Texture;
import com.java.GameEngine.View.KeyboardInputListener;
import com.java.GameEngine.View.MouseInputListener;
import com.java.TowerPower.Controller.ButtonController;
import com.java.TowerPower.Controller.SettingsController;
import com.java.TowerPower.Controller.TowerPowerController;
import com.java.TowerPower.Model.ButtonModel;
import com.java.TowerPower.util.TextureManager;
public class SettingsMenuController extends MenuController {
	
	private ButtonModel lowSoundButtonModel = ButtonController.createButton(ButtonController.MENU_BUTTON,"Low", new Point(320, 80));
	private ButtonModel midSoundButtonModel = ButtonController.createButton(ButtonController.MENU_BUTTON,"Medium", new Point(320, 160));
	private ButtonModel highSoundButtonModel = ButtonController.createButton(ButtonController.MENU_BUTTON,"High", new Point(320, 240));
	private ButtonModel defaultSoundButtonModel = ButtonController.createButton(ButtonController.MENU_BUTTON,"Default", new Point(320, 320));
	private ButtonModel exitButtonModel = ButtonController.createButton(ButtonController.MENU_BUTTON,"Back to Main Menu", new Point(320, 400));
	
	public SettingsMenuController()
	{
		super(TowerPowerController.SETTINGS_MENU);
		buttonController.addModel(lowSoundButtonModel);
		buttonController.addModel(midSoundButtonModel);
		buttonController.addModel(highSoundButtonModel);	
		buttonController.addModel(defaultSoundButtonModel);
		buttonController.addModel(exitButtonModel);
		
	}
	
	protected Texture getBackground()
	{
		return TextureManager.getTexture("background_settings");
	}
	//@override method
	public void draw(){
		super.draw();
		buttonController.drawModels();
	}
	public int getState(){
		return this.state;
		
	}
	@Override
	public void update()
	{
		lowSoundButtonModel.setPressed(SettingsController.getInstance().getVolume() == SettingsController.LOW);
		midSoundButtonModel.setPressed(SettingsController.getInstance().getVolume() == SettingsController.MID);
		highSoundButtonModel.setPressed(SettingsController.getInstance().getVolume() == SettingsController.HIGH);
	}
	@Override
	public void onMouseInput(MouseEvent event)
	{
		ButtonModel buttonModel= getClickedButton(event);
		if(buttonModel != null)
			if(buttonModel.getId()==lowSoundButtonModel.getId())
				SettingsController.getInstance().setVolume(SettingsController.LOW);
			else if(buttonModel.getId()==midSoundButtonModel.getId())
				SettingsController.getInstance().setVolume(SettingsController.MID);
			else if(buttonModel.getId()==highSoundButtonModel.getId())
				SettingsController.getInstance().setVolume(SettingsController.HIGH);
			else if(buttonModel.getId()==defaultSoundButtonModel.getId())
				SettingsController.getInstance().setVolume(SettingsController.DEFAULT);
			else if(buttonModel.getId()==exitButtonModel.getId())
				this.state = TowerPowerController.MAIN_MENU;
	}
	@Override
	public void onKeyboardInput(KeyEvent event){}
	
	public void preUpdate()
	{
		defaultSoundButtonModel.setPressed(false);
	}
	
}
