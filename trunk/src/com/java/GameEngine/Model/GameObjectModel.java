package com.java.GameEngine.Model;

import java.io.Serializable;

/**
 * GameObjectModel class represents model data in the game.<br>
 * Developer can easily create a new class that inherits this class
 * to store specific model data.<br>
 * Since the class implements Serializable interface it can be
 * serialized into a string.
 * @see java.io.Serializable
 * @author Serkan Demirci
 */
public abstract class GameObjectModel implements Serializable{

	/**
	 * Unique object id that can be used to identify the object.
	 */
	protected int id;
	private static int nextId = 1;

	/**
	 * Constructs the object and gives it a new unique object id.
	 */
	public GameObjectModel() {
		this.id = nextId++;
	}

	/**
	 * Returns the unique id of the object.
	 * @return The unique id of the object.
	 */
	public int getId() {
		return this.id;
	}
}