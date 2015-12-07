package com.java.GameEngine.Controller;

import com.java.GameEngine.GameEngineConstants;
import com.java.GameEngine.View.Canvas;
import com.java.GameEngine.View.Display;

/**
 * Game Engine class is used regulate game events
 * @author Serkan Demirci
 *
 */
public class GameEngine {
	private GameController controller;
	private double frameRate;
	private double framePeriod;
	private boolean isCloseRequested;
	private Canvas canvas;

	/**
	 * Creates a new GameEngine instance.
	 * @param parController GameController is the game logic
	 * of the game.
	 */
	public GameEngine(GameController parController) {
		this.controller = parController;
		
		setFrameRate(GameEngineConstants.Controller.FRAME_RATE);
		this.canvas = Display.getInstance().getCanvas();
	}

	/**
	 * Is used to start game loop.<br>
	 * Game loop continues until close is requested
	 */
	private void gameLoop() {
		long startTime = System.currentTimeMillis();
		long frameTime;
		
		while (!isCloseRequested) {
			startTime = System.currentTimeMillis();
			
			this.update();
			this.draw();
			
			frameTime = System.currentTimeMillis() - startTime;
			if (frameTime < framePeriod)
				try{
					Thread.sleep((long) (framePeriod - frameTime));
				} catch (InterruptedException e){
					e.printStackTrace();
				}
		}
		
		controller.close();
		Display.getInstance().setVisible(false);
	}

	/**
	 * Initializeses the game.
	 */
	public void initializeGame() {
		Display.getInstance().setVisible(true);
		controller.initialize();
		gameLoop();
	}

	/**
	 * Ends game loop and closes the game.
	 */
	public void closeGame() {
		isCloseRequested = true;
	}

	/**
	 * Sets the frame rate of the game.
	 * <br><strong>Precondition : </strong> parRate > 0
	 * @param parRate Frame rate (frame per second). 
	 */
	public void setFrameRate(double parRate) {
		assert(parRate > 0);
		this.frameRate = parRate;
		framePeriod = 1000/parRate;
	}

	/**
	 * Returns the frame rate of the GameEngine
	 * @return Frame rate (Frame per second)
	 */
	public double getFrameRate() {
		return this.frameRate;
	}

	/**
	 * Fired when update is requested in a frame.
	 */
	private void update() {
		controller.update();
		isCloseRequested = isCloseRequested || controller.isCloseRequested();
	}

	/**
	 * Fired when draw is requested in a frame.
	 */
	private void draw() {
		controller.draw();
		
		canvas.update();
	}
}