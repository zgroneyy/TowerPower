package com.java.TowerPower.Controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.io.File;
import java.io.IOException;

import com.java.GameEngine.Controller.GameController;
import com.java.GameEngine.View.Display;
import com.java.GameEngine.View.KeyboardInputListener;
import com.java.GameEngine.View.MouseInputListener;
import com.java.GameEngine.log.LogManager;
import com.java.TowerPower.Controller.menu.AboutMenuController;
import com.java.TowerPower.Controller.menu.GameMenuController;
import com.java.TowerPower.Controller.menu.HelpMenuController;
import com.java.TowerPower.Controller.menu.MainMenuController;
import com.java.TowerPower.Controller.menu.MenuController;
import com.java.TowerPower.Controller.menu.SettingsMenuController;
import com.java.TowerPower.util.TextureManager;

public class TowerPowerController extends GameController {
	private Display display;

	private int gameState = 0;
	private MenuController menuController;

	private KeyboardInputListener keyListener;
	private MouseInputListener mouseListener;

	public static final int MAIN_MENU = 0;
	public static final int SETTINGS_MENU = 1;
	public static final int LEVEL_SELECT_MENU = 2;
	public static final int NEW_GAME_MENU = 3;
	public static final int GAME_MENU = 4;
	public static final int ABOUT_MENU = 5;
	public static final int HELP_MENU = 6;
	public static final int EXIT = 7;

	public TowerPowerController() {

	}

	/*
	 * Periodic update method
	 * 
	 * Some of these will be carried to GameMenu
	 */
	public void update() {
		if (menuController.getState() != gameState) {
			setGameState(menuController.getState());
			System.out.println(menuController.getState());
		}

		menuController.preUpdate(); // Update before inputs

		// Manages inputs
		while (keyListener.hasNextEvent())
			menuController.onKeyboardInput(keyListener.getNextEvent());
		while (mouseListener.hasNextEvent())
			menuController.onMouseInput(mouseListener.getNextEvent());

		menuController.update();
	}

	public void draw() {
		Display.getInstance().getCanvas().clear(Color.black);
		menuController.draw();
	}

	public void initialize() {
		display = Display.getInstance();
		Point center = new Point(display.getSize().width/2,display.getSize().height/2);
		display.getCanvas().clear(new Color(0,150,255));
		display.getCanvas().drawTextOnCenter("Loading...", new Font("Comic Sans MS",0 , 72 ), Color.black,center);
		display.getCanvas().update();
		
		TextureManager.loadTextures();

		menuController = new MainMenuController();

		keyListener = display.getKeyboardListener();
		mouseListener = display.getMouseListener();

		setGameState(gameState);
	}

	@Override
	public void close() {
		System.out.println("Closing game");
		
		try {
			LogManager.getInstance().save(new File("log.txt"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		System.exit(0);
	}

	@Override
	public boolean isCloseRequested() {
		return Display.getInstance().isCloseRequested() || gameState == EXIT;
	}

	private void setGameState(int state) {
		gameState = state;

		// Changes state
		switch (state) {
		case ABOUT_MENU:
			menuController = new AboutMenuController();
			break;
		case MAIN_MENU:
			menuController = new MainMenuController();
			break;
		case HELP_MENU:
			menuController = new HelpMenuController();
			break;
		case SETTINGS_MENU:
			menuController = new SettingsMenuController();
			break;
		case NEW_GAME_MENU:
			menuController = new GameMenuController();
			break;
		case GAME_MENU:
			menuController = new GameMenuController();
			break;
		}
	}

	public static void throwException(Exception e) {
		LogManager.getInstance().logException(e.getLocalizedMessage());
		String stackTrace = "";
		
		for (StackTraceElement str : e.getStackTrace())
			stackTrace += str;
		LogManager.getInstance().logException(stackTrace);
		
		try {
			LogManager.getInstance().save(new File("log.txt"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		e.printStackTrace();
		System.exit(0);
	}
}