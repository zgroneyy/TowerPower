package com.java.GameEngine.Controller;

/**
 * GameController class is used by the GameEngine class.
 * <br>This class handles main logic of the game.
 * <br>Every class should create new class that inherits this class
 * in order handle events such as frame changes.
 * @author Serkan Demirci
 */
public abstract class GameController {
	/**
	 * Update method is called when the GameController
	 * needs to update it's entities.
	 */
	public abstract void update();

	/**
	 * Draw method is called when game needs to draw
	 * some data to the Canvas.
	 * @see com.java.GameEngine.View.Canvas
	 */
	public abstract void draw();

	/**
	 * Initialize is called when game is started.
	 */
	public abstract void initialize();
	
	/**
	 * Fired when a close is requested to GameEngine.
	 */
	public abstract void close();
	
	/**
	 * Fired when gameController wants to quit game
	 */
	public abstract boolean isCloseRequested();
}