package com.java.GameEngine.View;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.java.GameEngine.GameEngineConstants;

/**
 *  MouseInputListener class records mouse events into a history
 *  that can be requested later.<br>
 *  History has a limited size so that when new event added
 *  the oldest event might be discarded.
 *  @see java.awt.event.MouseEvent
 * @author Serkan Demirci
 */
public class MouseInputListener
{
	private ConcurrentLinkedQueue<MouseEvent> eventQueue;

	/**
	 * Constructor for the class.
	 */
	public MouseInputListener()
	{
		eventQueue = new ConcurrentLinkedQueue();
	}

	/**
	 * Returns the next mouse event in the history<br>
	 * Throws NoSuchElementException when user request next element
	 * and history is empty.
	 * @return MouseEvent Returns mouse event that is requested
	 * @throws NoSuchElementException
	 */
	public MouseEvent getNextEvent()
	{
		MouseEvent event = eventQueue.poll();
		
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
	public void addNewEvent(MouseEvent parE)
	{
		if (eventQueue.size() == GameEngineConstants.View.EVENT_QUEUE_SIZE)
			eventQueue.poll();

		eventQueue.add(parE);
	}
}