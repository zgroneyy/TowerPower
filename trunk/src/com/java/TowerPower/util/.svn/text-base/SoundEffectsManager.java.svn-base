package com.java.TowerPower.util;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.sound.sampled.UnsupportedAudioFileException;

import com.java.GameEngine.Audio.AudioClip;
import com.java.GameEngine.log.LogManager;
import com.java.TowerPower.Controller.TowerPowerController;

public class SoundEffectsManager {
	
	private static SoundEffectsManager instance;
	
	private Map<String, File> soundFiles;
	private static final String PATH_TO_SOUNDS = "assets/sounds/";
	
	private SoundEffectsManager() {
		soundFiles = new HashMap<String, File>();
		
		soundFiles.put("upgrade", new File(PATH_TO_SOUNDS + "power_up.wav"));
		soundFiles.put("fire", new File(PATH_TO_SOUNDS + "pistol.wav"));
	}
	
	public static SoundEffectsManager getInstance() {
		if(instance == null) {
			instance = new SoundEffectsManager();
		}
		return instance;
	}
	
	public AudioClip getAudioClip(String path) {
		
		if(!soundFiles.containsKey(path)) {
			throw new IllegalArgumentException(path + " path couldn't find");
		}
		
		try {
			AudioClip clip = new AudioClip(soundFiles.get(path));
			
			return clip;
		} catch (Exception e)
		{
			TowerPowerController.throwException(e);
		}
		return null;
		
	}
}
