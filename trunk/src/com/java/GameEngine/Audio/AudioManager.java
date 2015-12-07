package com.java.GameEngine.Audio;

import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;

/**
 * AudioManager is an control class that plays sound clips.
 * @author Serkan Demirci
 */
public class AudioManager {
	/**
	* Plays an audio clip.
	* @param parAudioClip audio clip that will
	* be played.
	* @param parRepatCount Repeat count determines how many times
	* 	the clip will be played.
	* 	<br>
	* 	If repeat count equals 0, the clip will
	* 	be repeated until its stopped.
	* 
	* @param parVolume volume of the sound that will be played
	* <pre>
	* 	parRepatCount >= 0
	* </pre>
	 * @throws LineUnavailableException throws lineUnavailable exception if line limit
	 * is passed.
	*/
	public static void play(AudioClip parAudioClip, int parRepatCount,float parVolume) {
		assert(parRepatCount >= 0);
		Clip clip;
		try {
			clip = parAudioClip.getClip();
			
			//adds close listener
			clip.addLineListener(new ClipCloseListener(clip));
			
			//Sets repeat count
			if (parRepatCount == 0)
				clip.loop(Clip.LOOP_CONTINUOUSLY);
			else
				clip.loop(parRepatCount - 1);
			
			setVolume(clip,parVolume);
			
			//Plays clip
			clip.start();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/**
	 * Changes volume of an clip
	 * @param parClip Clip whose volume is changed
	 * @param parVolume volume level
	 */
	private static void setVolume(Clip parClip,float parVolume)
	{
		//Gets master gain control
		FloatControl gainControl = 
			    (FloatControl) parClip.getControl(FloatControl.Type.MASTER_GAIN);
		
		//parVolume = pow(10.0, gainDB/20.0) 
		gainControl.setValue((float) (Math.log(parVolume)*20));
	}
	
	/**
	 * A inner class that listens the clip and closes when 
	 * playing is finished.
	 * @author Serkan Demirci
	 */
	private static class ClipCloseListener implements LineListener
	{
		private Clip source;
		
		public ClipCloseListener(Clip parSource)
		{
			this.source = parSource;
		}
		
		@Override
		public void update(LineEvent parEvt)
		{
			//Closes clip when finished playing
			if (parEvt.getType() == LineEvent.Type.STOP){
		        source.close();
			}
		}
		
	}
}