package com.java.TowerPower.Controller.menu;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Iterator;

import com.java.GameEngine.View.Display;
import com.java.GameEngine.View.KeyboardInputListener;
import com.java.GameEngine.View.MouseInputListener;
import com.java.TowerPower.Controller.ButtonController;
import com.java.TowerPower.Controller.TowerPowerController;
import com.java.TowerPower.Model.ButtonModel;

public class MainMenuController extends MenuController{
	
	
	private ButtonModel newGameButtonModel = ButtonController.createButton(ButtonController.MENU_BUTTON,"Play Game", new Point(320, 120));
	private ButtonModel settingsButtonModel = ButtonController.createButton(ButtonController.MENU_BUTTON,"Settings", new Point(320, 195));
	private ButtonModel aboutButtonModel = ButtonController.createButton(ButtonController.MENU_BUTTON,"About", new Point(320, 270));
	private ButtonModel helpButtonModel = ButtonController.createButton(ButtonController.MENU_BUTTON,"Help", new Point(320, 345));
	private ButtonModel exitButtonModel = ButtonController.createButton(ButtonController.MENU_BUTTON,"Exit", new Point(320, 420));
	
	
	public MainMenuController() {
		super(TowerPowerController.MAIN_MENU);
		buttonController.addModel(newGameButtonModel);
		buttonController.addModel(settingsButtonModel);
		buttonController.addModel(aboutButtonModel);
		buttonController.addModel(helpButtonModel);
		buttonController.addModel(exitButtonModel);
		
	}
	

	@Override
	public void draw() {
		super.draw();
		buttonController.drawModels();
	}

	@Override
	public int getState() {
		return this.state;
	}

	@Override
	public void update()
	{
		
	}

	@Override
	public void onMouseInput(MouseEvent event)
	{
		ButtonModel buttonModel = getClickedButton(event);
		if(buttonModel != null)
			if(buttonModel.getId() == newGameButtonModel.getId())
				this.state = TowerPowerController.NEW_GAME_MENU;
			else if(buttonModel.getId() == settingsButtonModel.getId())
				this.state = TowerPowerController.SETTINGS_MENU;
			else if(buttonModel.getId() == aboutButtonModel.getId())
				this.state = TowerPowerController.ABOUT_MENU;
			else if(buttonModel.getId() == helpButtonModel.getId())
				this.state = TowerPowerController.HELP_MENU;
			else if(buttonModel.getId() == exitButtonModel.getId())
				this.state = TowerPowerController.EXIT;
	}

	@Override
	public void onKeyboardInput(KeyEvent event)
	{
		
	}

}
