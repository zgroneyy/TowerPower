package com.java.TowerPower.Controller;

import java.awt.Point;
import java.util.Map.Entry;
import java.util.Set;

import com.java.GameEngine.Controller.GameObjectController;
import com.java.GameEngine.View.Display;
import com.java.TowerPower.Model.EnemyModel;
import com.java.TowerPower.Model.ProjectileModel;
import com.java.TowerPower.util.PhysicsManager;
import com.java.TowerPower.util.TextureManager;

public class ProjectileController extends GameObjectController<ProjectileModel> {


	public ProjectileModel getModel(int parId) {
		return super.getModel(parId);
	}

	/**
	* @Pre parModel != null
	* @Post getModel(parModel.id) =! null
	*
	*/
	public void addModel(ProjectileModel parModel) {
		super.addModel(parModel);
	}
	
	/**
	* @Post getModel(parId) == null
	*
	*/
	public void removeModel(int parId) {
		super.removeModel(parId);
	}

	public Set<Entry<Integer, ProjectileModel>> getModelEntrySet() {
		return super.getModelEntrySet();
	}

	public void drawModels() {
		for(Entry<Integer, ProjectileModel> entry : getModelEntrySet()) {
			Display.getInstance().getCanvas().drawTexture(entry.getValue().getTexture(), entry.getValue().getPosition(), 0);
		}
	}

	/*
	* Create projectile for specific enemy
	*
	*/
	public void createProjectile(EnemyModel parTarget, Point parPos, int parDamage) {
		throw new UnsupportedOperationException();
	}

	/*
	* Detect if projectile is collide
	*/
	public void onHit(ProjectileModel parProjectileModel) {
		parProjectileModel.getTarget().damageBy(parProjectileModel.getDamage());
		removeModel(parProjectileModel.getId());
	}

	public void update() {
		super.update();
		detectOutOfScreenProjectile();
		moveProjectiles();
	}
	
	private void detectOutOfScreenProjectile() {
		for(Entry<Integer, ProjectileModel> entry: getModelEntrySet()) {
			ProjectileModel projectileModel = entry.getValue();
			//This control will be carried to physic manager
			if(projectileModel.getCenterPosition().x < 0 ||
					projectileModel.getCenterPosition().x > 640 ||
					projectileModel.getCenterPosition().y < 0 ||
					projectileModel.getCenterPosition().y > 480)
				removeModel(projectileModel.getId());
					
		}
	}
	
	private void moveProjectiles() {
		for(Entry<Integer, ProjectileModel> entry: getModelEntrySet()) {
			ProjectileModel projectileModel = entry.getValue();
				if(projectileModel.intersects(projectileModel.getTarget()))
					onHit(projectileModel);
				else
					moveProjectile(projectileModel);
		}
	}
	
	/**
	 * This method will be update in order to send projectiles correctly
	 * @param projectileModel
	 */
	private void moveProjectile(ProjectileModel projectileModel) {
		if (!projectileModel.getTarget().isDead())
			PhysicsManager.moveTo(projectileModel, projectileModel.getTarget());
		else 
			PhysicsManager.move(projectileModel);
	}
	
	public static ProjectileModel createProjectile(Point point,EnemyModel target)
	{	
		ProjectileModel projectile = new ProjectileModel(point, 0, TextureManager.getTexture("projectile"));	
		projectile.setTarget(target);
		
		float angle = PhysicsManager.getAngle(projectile.getCenterPosition(), projectile.getTarget().getCenterPosition());
		projectile.setAngle(angle);
		
		return projectile;
	}
	
	public static ProjectileModel createProjectileFromExisting(ProjectileModel model, Point point, EnemyModel target)
	{	
		model.clear();
		model.setCenterPosition(point);
		model.setTarget(target);
		
		float angle = PhysicsManager.getAngle(model.getCenterPosition(), model.getTarget().getCenterPosition());
		model.setAngle(angle);
		
		return model;
	}
	
	@Override
	public int getClicked(Point point) {
		for(Entry<Integer, ProjectileModel> entry : getModelEntrySet()) {
			if(entry.getValue().contains(point)) {
				return entry.getValue().getId();
			}
		}
		return -1;
	}
	
}