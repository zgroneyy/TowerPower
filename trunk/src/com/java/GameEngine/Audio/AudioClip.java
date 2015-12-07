package com.java.GameEngine.Audio;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * AudioClip class holds the data of the audio and
 * creates Clips that can be played concurrently.
 * @author Serkan Demirci
 */
public class AudioClip
{
	private byte[] audioData;
	private long length;
	private AudioFormat format;
	
	/**
	 * Loads an audio from a file.
	 * @param parSoundFile Audio file
	 * @throws UnsupportedAudioFileException
	 * @throws IOException
	 */
	public AudioClip(File parSoundFile) throws UnsupportedAudioFileException, IOException
	{
		//Creates the stream
	    AudioInputStream audioStream = AudioSystem.getAudioInputStream(parSoundFile);
	    
	    //Copies the property of the stream
	    this.length = audioStream.getFrameLength();
	    this.format = audioStream.getFormat();
	    
	    //Copies data to byte array.
	    int dataSize = audioStream.available();
	    audioData = new byte[dataSize];
	    audioStream.read(audioData, 0, dataSize); //Reads data to a byte array
	    
	    //Closes stream
	    audioStream.close();
	}
	
	/**
	 * Returns a new clip object that can be played.
	 * @see javax.sound.sampled.Clip
	 * @return Returns an open Clip.
	 * @throws LineUnavailableException
	 */
	public Clip getClip() throws LineUnavailableException
	{
		assert (audioData != null);
		
		//Creates a byte stream
		ByteArrayInputStream byteStream = new ByteArrayInputStream(audioData);
		
		//Creates an Audio stream using byte stream that created
		AudioInputStream audioStream = new AudioInputStream(byteStream, format, length);
		
		//Creates clip
		DataLine.Info info = new DataLine.Info(Clip.class, audioStream.getFormat());
		
	    Clip clip = (Clip) AudioSystem.getLine(info);
	    
	    //Since the source is known (byte stream) there is no need for IOException
	    try{
	    	clip.open(audioStream);
	    }
	    catch(IOException e)
	    {
	    	
	    }
	    
		return clip;
	}
	
	/**
	 * Disposes the AudiClip
	 */
	public void dispose()
	{
		audioData = null;
		System.gc();//Requests garbage collection to deallocate audio data
	}
}
