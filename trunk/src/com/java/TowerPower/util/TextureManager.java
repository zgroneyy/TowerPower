package com.java.TowerPower.util;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

import com.java.GameEngine.Model.Texture;
import com.java.GameEngine.log.LogManager;
import com.java.TowerPower.Controller.TowerPowerController;

public class TextureManager {
	public static final String TEXTURE_PATH = "assets/IMG/";
	public static final String HELP_TEXURE_PATH = "assets/IMG/help/";
	private static HashMap<String, Texture> textureMap = null;

	public static Texture getTexture(String textureName) {
		if (textureMap == null)
			TowerPowerController.throwException(new IOException(
					"Textures are not loaded"));
		Texture texture = textureMap.get(textureName);

		if (texture == null)
			TowerPowerController.throwException(new Exception("Texture "
					+ textureName + " does not exist."));

		return texture;
	}

	public static void loadTextures() {
		if (textureMap == null)
			textureMap = new HashMap<>();
		else {
			disposeTextures();
			textureMap = new HashMap<>();
		}

		addTextures();
	}

	public static Texture loadHelpImage(int id) {
		String helpPath = HELP_TEXURE_PATH + "help_";

		try {
			Texture t = Texture.loadTexture(helpPath + id + ".png");
			LogManager.getInstance().logInfo("Help image " + id + " loaded.");

			return t;
		} catch (Exception e) {
			LogManager.getInstance().logWarning(
					"Help image " + id + " cannot be loaded.");
			TowerPowerController.throwException(e);
		}
		return null;
	}

	private static void addTextures() {
		// Populate textures
		addTexture("menu_button", "button.png");
		addTexture("menu_button_pressed", "button2.png");
		addTexture("menu_button_locked", "button2.png");

		addTexture("level_button", "button.png");
		addTexture("level_button_pressed", "button2.png");
		addTexture("level_button_locked", "button2.png");

		addTexture("next_button", "next.png");
		addTexture("next_button_pressed", "next_pressed.png");

		addTexture("prev_button", "prev.png");
		addTexture("prev_button_pressed", "prev_pressed.png");

		addTexture("tower_barad", "TowerBarad.png");
		addTexture("tower_bronze", "TowerBronze.png");
		addTexture("tower_gold", "TowerGold.png");
		addTexture("tower_silver", "TowerSilver.png");
		addTexture("tower_diamond", "TowerDiamond.png");

		addTexture("enemy_elf", "EnemyElf.png");
		addTexture("enemy_orc", "EnemyTroll.png");
		addTexture("enemy_goblin", "EnemyElf.png");
		addTexture("enemy_troll", "EnemyTroll.png");

		addTexture("projectile", "bullet_black.png");

		addTexture("tile", "road.jpg");
		addTexture("castle", "castle.png");

		addTexture("background_about", "AboutArka.png");
		addTexture("background_settings", "AraMenuArka.png");
		addTexture("background_main", "ArkaPlan.png");
		addTexture("background_game", "background.jpg");

		addTexture("player_profile", "player_profile.png");
	}

	private static void addTexture(String name, String path) {
		try {
			Texture texture = Texture.loadTexture(TEXTURE_PATH + path);

			textureMap.put(name, texture);
		} catch (Exception e) {
			LogManager.getInstance().logWarning(
					name + " texture cannot be found in " + path);
			TowerPowerController.throwException(e);
		}
		LogManager.getInstance().logInfo("Texture " + name + " loaded!");
	}

	public static void disposeTextures() {
		textureMap = null;
		System.gc();
	}

	public static Texture getTextureFromShape(Rectangle r) {
		return new Texture(makeImage(r));
	}

	private static BufferedImage makeImage(Shape s) {
		Rectangle r = s.getBounds();
		BufferedImage image = new BufferedImage(r.width, r.height,
				BufferedImage.TYPE_BYTE_BINARY);
		Graphics2D gr = image.createGraphics();
		// move the shape in the region of the image
		gr.translate(-r.x, -r.y);
		gr.draw(s);
		gr.dispose();
		return image;
	}
}
