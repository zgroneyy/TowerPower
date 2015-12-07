package com.java.GameEngine.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;

import com.java.GameEngine.Model.Texture;

/**
 * This interface imposes render(draw) methods into a class.
 * <br>It is used for drawing texts/textures.
 * @author Serkan Demirci
 */
public interface Canvas {

	/**
	 * Clears the canvas. After execution of this method
	 * canvas is cleared with specified color.
	 * @param parC Clear color.
	 */
	public void clear(Color parC);

	/**
	 * Draws a texture to canvas.
	 * @param parT Texture to be drawn.
	 * @param parPoint Position of the texture.
	 * @param parAngle Angle of the texture.
	 * @see com.java.GameEngine.Model.Texture
	 */
	public void drawTexture(Texture parT, Point parPoint, float parAngle);

	/**
	 * Draws a string that is aligned to center of given position.
	 * @param parText String to be drawn.
	 * @param parFont Font.
	 * @param parColor Text color.
	 * @param parPoint The position where the string will be drawn
	 */
	public void drawTextOnCenter(String parText, Font parFont,Color parColor,  Point parPoint);

	/**
	 * Draws a string to canvas.
	 * @param parText String to be drawn.
	 * @param parFont parFont Font.
	 * @param parColor Text color.
	 * @param parPoint The position where the string will be drawn.
	 */
	public void drawText(String parText, Font parFont,Color parColor, Point parPoint);

	/**
	 * Returns the position of the mouse.
	 * @return Point that represents position of the mouse.
	 */
	public Point getMousePosition();

	/**
	 * Updates canvas to make the changes visible.<br>
	 * Since the canvas drawing is synchronized all of the changes
	 * is not visible without execution of this method.
	 */
	public void update();
}