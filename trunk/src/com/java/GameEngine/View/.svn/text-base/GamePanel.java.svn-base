package com.java.GameEngine.View;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import com.java.GameEngine.Model.Texture;

/**
 * GamePanel is a class that draws and shows graphics. Through Display class.
 * @author Serkan Demirci
 *
 */
public class GamePanel extends JPanel implements Canvas{
	private BufferedImage primaryBuffer;
	private BufferedImage secondaryBuffer;

	/**
	 * Constructs a new GamePanel object.
	 * <br> Since its visibility package, it can be created
	 * only by in it's package
	 * @param parWidth Initial width of the panel
	 * @param parHeight Initial height of the panel
	 */
	GamePanel(int parWidth, int parHeight) {
		resizePanel(parWidth,parHeight);
	}
	
	/**
	 * Resizes the GamePanel.
	 * <br><strong>Precondition: </strong> parWidth > 0 , parHeight > 0
	 * @param parWidth New Width 
	 * @param parHeight New Height
	 */
	public void resizePanel(int parWidth, int parHeight) {
		assert(parWidth > 0);
		assert(parHeight > 0);

		//Resize panel
		setSize(parWidth, parHeight);
		
		//Resizes buffers
		primaryBuffer = new BufferedImage(parWidth, parHeight, BufferedImage.TYPE_INT_ARGB);
		secondaryBuffer = new BufferedImage(parWidth, parHeight, BufferedImage.TYPE_INT_ARGB);
		
		//Suggests garbage collection
		System.gc();
	}

	/**
	 * Swaps buffers
	 */
	private void swapBuffers() {
		BufferedImage temp = primaryBuffer;
		primaryBuffer = secondaryBuffer;
		secondaryBuffer = temp;
	}

	/**
	 * Gets buffer graphics of secondary buffer.
	 * <br> All drawing is made to secondary buffer and
	 * primary buffer is shown to user.
	 * @return Graphics2D of the secondary buffer.
	 * It needs to be disposed after usage.
	 */
	private Graphics2D getBufferGraphics()
	{
		return secondaryBuffer.createGraphics();
	}
	
	/*---------------------------------------------------------
	 * 
	 * Canvas methods
	 * 
	 * --------------------------------------------------------
	 */
	/**
	 * @see com.java.GameEngine.View.Canvas
	 */
	public void clear(Color parC) {
		Graphics2D graphics = getBufferGraphics();
		
		graphics.setColor(parC);
		graphics.fillRect(0, 0, getWidth(), getHeight());
		
		graphics.dispose();
	}

	/**
	 * @see com.java.GameEngine.View.Canvas
	 */
	public void drawTexture(Texture parT, Point parPoint, float parAngle) {
		Graphics2D graphics = getBufferGraphics();
		
		BufferedImage image = parT.getImage();
		
		AffineTransform transform = new AffineTransform();
		transform.rotate(parAngle, image.getWidth()/2, image.getHeight()/2);
		transform.translate( parPoint.x, parPoint.y);
		
		graphics.drawImage(image, transform, null);
		
		graphics.dispose();
	}

	/**
	 * @see com.java.GameEngine.View.Canvas
	 */
	public void drawTextOnCenter(String parText, Font parFont,Color parColor, Point parPoint) {
		Graphics2D graphics = getBufferGraphics();
		
		//Sets font and color
		graphics.setFont(parFont);
		graphics.setColor(parColor);
		
		//Finds the width of the text.
		double width = graphics.getFontMetrics().getStringBounds(parText, graphics).getWidth();
		double height = graphics.getFontMetrics().getStringBounds(parText, graphics).getHeight();

		
		//Subtracts the width from point so that text is centered.
		parPoint.setLocation((int) (parPoint.x - width / 2), parPoint.y + height/4);
		
		//Draws string
		graphics.drawString(parText, parPoint.x, parPoint.y);
		
		graphics.dispose();
	}

	public void drawText(String parText, Font parFont,Color parColor,  Point parPoint) {
		Graphics2D graphics = getBufferGraphics();
		
		//Sets font and color
		graphics.setFont(parFont);
		graphics.setColor(parColor);
		
		//Draws string
		graphics.drawString(parText, parPoint.x, parPoint.y);
		
		graphics.dispose();
	}

	/**
	 * @see com.java.GameEngine.View.Canvas
	 */
	public Point getMousePosition() {
		return super.getMousePosition();
	}

	/**
	 * @see com.java.GameEngine.View.Canvas
	 */
	public void update() {
		this.swapBuffers(); //Swaps buffers so that primary becomes secondary
		
		this.repaint();//Repaints
	}
	
	/*---------------------------------------------------------
	 * 
	 * JPanel methods
	 * 
	 * --------------------------------------------------------
	 */
	
	/**
	 * @see javax.swing.JPanel
	 */
	public void paint(Graphics parG) {
		parG.drawImage(primaryBuffer,0,0,primaryBuffer.getWidth(),primaryBuffer.getHeight(),null);
	}
}