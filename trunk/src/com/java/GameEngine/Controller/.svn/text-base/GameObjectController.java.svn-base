package com.java.GameEngine.Controller;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import com.java.GameEngine.Model.GameObjectModel;
import com.java.GameEngine.Model.Texture;

/**
 * GameObjectController controls one type of GameObjectModel entities
 * and regulates their entities
 * @author Serkan Demirci
 * @param <E> GameObjectModel that is to be regulated.
 * @see com.java.GameEngine.Model.GameObjectModel
 */
public abstract class GameObjectController<E extends GameObjectModel> {
	protected ConcurrentHashMap<Integer, E> models;
	protected List<E> oldModelList;
	protected Texture[] textures;
	
	/**
	 * Constructor for the GameObjecController.
	 */
	public GameObjectController(){
		models = new ConcurrentHashMap<Integer, E>();
		oldModelList = new ArrayList<>();
	}
	
	public E getOldNextModel() {
		if(!oldModelList.isEmpty()) {
			E e = oldModelList.get(0);
			oldModelList.remove(0);
			return e;
		}
		return null;
	}
	
	/**
	 * Returns the model that GameObjectController regulates
	 * @param parId The unique id of the object
	 * @return Model that will be returned.
	 */
	public E getModel(int parId) {
		return models.get(parId);
	}

	/**
	 * Adds a new model to make the object is controlled by GameObjectController
	 * <br><strong>Precondition : </strong> parModel != null
	 * <br><strong>Postcondition : </strong> getModel(parId) != Null
	 * @param parModel 
	 */
	public void addModel(E parModel) {
		assert(parModel != null);
		
		models.put(parModel.getId(), parModel);
	}

	/**
	 * Removes the model.
	 * <br><strong>Precondition : </strong> parId >= 0
	 * <br><strong>Postcondition : </strong> getModel(parId) = Null
	 * @param parId Unique id of the model.
	 */
	public void removeModel(int parId) {
		assert(parId >= 0);
		E e = models.get(parId);
		oldModelList.add(e);
		models.remove(parId);
	}

	/**
	 * Returns an Unmodifiable Set that contains the models that
	 * GameObjectController regulates.
	 * @return A unmodifiable set.
	 */
	public Set<Entry<Integer, E>> getModelEntrySet() {
		return Collections.unmodifiableSet(models.entrySet());
	}

	/**
	 * Draws the models
	 */
	public abstract void drawModels();
	
	/**
	 * Updates the models.
	 */
	public void update() {

	}
	
	public abstract int getClicked(Point point);
}