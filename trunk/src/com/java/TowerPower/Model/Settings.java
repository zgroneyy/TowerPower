package com.java.TowerPower.Model;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import com.java.GameEngine.Model.ModelIO;
import com.java.TowerPower.TowerPowerConstants;
import com.java.TowerPower.Controller.SettingsController;

public class Settings implements Serializable{
	private float volume;
	
	public Settings() {
		volume = SettingsController.MID;
	}
	
	public float getVolume() {
		return volume;
	}
	
	public void setVolume(float volume) {
		this.volume = volume;
	}
	
	public void save()
	{
		try
		{
			ModelIO.saveModel(new File(TowerPowerConstants.SETTINGS_FILE), this);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static Settings load()
	{
		try
		{
			return (Settings) ModelIO.loadModel(new File(TowerPowerConstants.SETTINGS_FILE));
		} catch (Exception e)
		{
			return new Settings();
		}
	}
}
