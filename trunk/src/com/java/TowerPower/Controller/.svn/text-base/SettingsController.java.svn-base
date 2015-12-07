package com.java.TowerPower.Controller;

import com.java.TowerPower.Model.Settings;

public class SettingsController {
	public static final float HIGH = 1F;
	public static final float MID = 0.8F;
	public static final float LOW = 0.4F;
	public static final float DEFAULT = MID;
	
	private static SettingsController instance;
	private Settings settings;
	
	private SettingsController(){
		settings = Settings.load();
	}
	
	public synchronized static SettingsController getInstance() {
		if(instance == null) {
			instance = new SettingsController();
		}
		
		return instance;
	}
	
	public void setVolume(float volume) {
		settings.setVolume(volume);
		settings.save();
	}
	
	public float getVolume() {
		return settings.getVolume();
	}
}
