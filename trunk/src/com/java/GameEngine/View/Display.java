package com.java.GameEngine.View;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import com.java.GameEngine.GameEngineConstants;

/**
 * Display class is used to present data to user.<br>
 * It is used for user / program interaction.
 * @author Serkan Demirci
 */
public class Display{

	//Singleton instance of display
	private static Display instance = null;
	private JFrame frame;
	private GamePanel gamePanel;
	private MouseInputListener mouseListener;
	private KeyboardInputListener keyboardListener;
	private boolean isCloseRequested;
	private boolean isVisible;
	private int width;
	private int height;

	/**
	 * Creates a new instance of Display. 
	 * <br>Since display uses singleton design pattern this
	 *  constructor is private.
	 */
	private Display() {
		this.width = GameEngineConstants.View.DISPLAY_WIDTH;
		this.height = GameEngineConstants.View.DISPLAY_HEIGHT;
		this.isCloseRequested = false;
		this.isVisible = false;
		
		frame = new JFrame();//Creates new frame
		
		//Adjusts some properties of frame
		//frame.setUndecorated(true); //Sets the frame undecorated.
		frame.setResizable(false); //Sets frame unresizable
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		//Adds frame listeners
		mouseListener = new MouseInputListener();
		keyboardListener = new KeyboardInputListener();
		
		//Adds listeners to the frame
		FrameListener frameListener = new FrameListener();
		frame.addWindowListener(frameListener);
		frame.setSize(width,height);
		frame.setLocationRelativeTo(null);
		
		//Initializes gamePanel
		gamePanel = new GamePanel(width, height);
		gamePanel.addKeyListener(frameListener);
		gamePanel.addMouseListener(frameListener);
		
		//Adds gamePanel to frame
		frame.getContentPane().add(gamePanel);
	}
	
	
	/**
	 * Returns the instance of the display.
	 * @return Single instance of the display object.
	 */
	public static Display getInstance() {
		if (instance == null)
			instance = new Display();
		return instance;
	}

	/**
	 * Sets the size of the display.
	 * <br><strong>Precondition : </strong> parX > 0, parY > 0
	 * @param parWidth Width of the display.
	 * @param parHeight Height of the display.
	 */
	public void setSize(int parWidth, int parHeight) {
		assert(parWidth > 0);
		assert(parHeight > 0);
		
		this.width = parWidth;
		this.height = parHeight;
		
		frame.setSize(width,height);
		gamePanel.resizePanel(width, height);
	}
	
	/**
	 * Returns the size of the display panel
	 * @return
	 */
	public Dimension getSize()
	{
		return gamePanel.getSize();
	}

	/**
	 * Returns the Canvas of the display.
	 * @return Canvas
	 * @see com.java.GameEngine.View.Canvas
	 */
	public Canvas getCanvas() {
		return this.gamePanel;
	}

	/**
	 * Returns the keyboard listener.
	 * @return An instance of KeyboardInputListener.
	 *  <br>Display records all key events in that listener.
	 */
	public KeyboardInputListener getKeyboardListener() {
		return this.keyboardListener;
	}

	/**
	 * Returns the mouse listener.
	 * @return An instance of KeyboardInputListener.
	 *  <br>Display records all mouse events in that listener.
	 */
	public MouseInputListener getMouseListener() {
		return this.mouseListener;
	}
	
	/**
	 * Checks whether user is request a close.
	 * @return Whether user requested to close the display.
	 */
	public boolean isCloseRequested() {
		return isCloseRequested;
	}

	/**
	 * Makes display visible.
	 * @param parVisible Visibility of the display.
	 */
	public void setVisible(boolean parVisible) {
		this.isVisible = parVisible;
		this.frame.setVisible(parVisible);
	}

	/**
	 * Checks whether display is visible.
	 * @return True if display is visible
	 */
	public boolean isVisible() {
		return isVisible;
	}
	
	/**
	 * An exit listener that observes the window close.
	 * @author Serkan Demirci
	 *
	 */
	private class FrameListener extends WindowAdapter implements MouseListener,KeyListener
	{
		public void windowClosing(WindowEvent e) {
			isCloseRequested = true;
		}
		public void mousePressed(MouseEvent e)
		{	
			mouseListener.addNewEvent(e);
		}
		
		public void keyPressed(KeyEvent e)
		{
			e.setSource(null);
			keyboardListener.addNewEvent(e);
		}

		//Unimplemented Methods
		public void mouseClicked(MouseEvent e){}
		public void mouseEntered(MouseEvent e){}
		public void mouseExited(MouseEvent e){}
		public void mouseReleased(MouseEvent e){}
		public void keyReleased(KeyEvent e){}
		public void keyTyped(KeyEvent e){}	
	}
}