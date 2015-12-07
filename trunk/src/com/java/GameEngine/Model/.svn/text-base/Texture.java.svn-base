package com.java.GameEngine.Model;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.java.GameEngine.Controller.GameEngine;
import com.java.GameEngine.View.Canvas;

/**
 * Class is used to store texture data. Texture data can be
 * used to draw contents into canvas.
 * @see com.java.GameEngine.View.Canvas
 * @author Serkan Demirci
 *
 */
public class Texture {
	private BufferedImage image;
	
	/**
	 * Creates a texture object using a BufferedImage.
	 * @param parImage
	 * @see {@link BufferedImage}
	 */
	public Texture(BufferedImage parImage){
		this.image = parImage;
	}

	/**
	 * Returns the image that texture holds.
	 * @return Image
	 */
	public BufferedImage getImage() {
		return this.image;
	}

	/**
	 * Loads an texture from a file.
	 * @param parFile File that texture loaded from.
	 * @return A new Texture object that holds the image.
	 * @throws IOException IOException is thrown when there is no
	 * file to load the image or the program is unauthorized to 
	 * access specified file.
	 */
	public static Texture loadTexture(File parFile) throws IOException {
		return new Texture(loadImage(parFile));
	}
	
	/**
	 * Loads an BufferedImage from a file.
	 * @param parFile File that texture loaded from.
	 * @return A new Texture object that holds the image.
	 * @throws IOException IOException is thrown when there is no
	 * file to load the image or the program is unauthorized to 
	 * access specified file.
	 */
	private static BufferedImage loadImage(File parFile) throws IOException
	{
		return ImageIO.read(parFile);
	}
	
	
	/**
	 * Loads an texture from a file.
	 * @param parFile File that texture loaded from.
	 * @return A new Texture object that holds the image.
	 * @throws IOException IOException is thrown when there is no
	 * file to load the image or the program is unauthorized to 
	 * access specified file.
	 */
	public static Texture loadTexture(String parFile) throws IOException{
		return loadTexture(new File(parFile));
	}
	
	/**
	 * Returns the dimensions of the texture.
	 */
	public Dimension getSize()
	{
		return new Dimension(image.getWidth(),image.getHeight());
	}
}