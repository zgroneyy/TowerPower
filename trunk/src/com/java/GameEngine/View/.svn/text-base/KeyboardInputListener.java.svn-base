package com.java.GameEngine.View;

import java.awt.event.KeyEvent;
import java.util.Queue;

import javax.swing.text.View;

import com.java.GameEngine.GameEngineConstants;

import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 *  KeyboardInputListener class records mouse events into a history
 *  that can be requested later.<br>
 *  History has a limited size so that when new event added
 *  the oldest event might be discarded.
 *  @see java.awt.event.KeyEvent
 * @author Serkan Demirci
 */
public class KeyboardInputListener
{
	private Queue<KeyEvent> eventQueue;

	/**
	 * Constructor for the class.
	 */
	public KeyboardInputListener()
	{
		eventQueue = new LinkedList<KeyEvent>();
	}

	/**
	 * Returns the next key event throws exception when user request
	 * next event when there is no key events.
	 * @return KeyEvent Returns key event that is requested
	 * @throws NoSuchElementException
	 */
	public KeyEvent getNextEvent()
	{
		KeyEvent event = eventQueue.poll();
		
		if (event == null)
			throw new NoSuchElementException();
		
		return event;
	}

	/**
	 * Checks whether the history has events.
	 * @return True if history is not empty
	 */
	public boolean hasNextEvent()
	{
		return eventQueue.size() > 0;
	}
	
	/**
	 * Adds new event into history.
	 * @param parE Event to be added.
	 */
	public void addNewEvent(KeyEvent parE)
	{
		if (eventQueue.size() == GameEngineConstants.View.EVENT_QUEUE_SIZE)
			eventQueue.poll();

		eventQueue.add(parE);
	}
}