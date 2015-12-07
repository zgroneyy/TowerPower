package com.java.TowerPower.Controller;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import com.java.GameEngine.Controller.GameObjectController;
import com.java.GameEngine.Model.Texture;
import com.java.GameEngine.View.Display;
import com.java.TowerPower.TowerPowerConstants;
import com.java.TowerPower.Model.BackgroundId;
import com.java.TowerPower.Model.EnemyModel;
import com.java.TowerPower.Model.TileModel;
import com.java.TowerPower.util.PhysicsManager;
import com.java.TowerPower.util.TextureManager;

public class TileController extends GameObjectController<TileModel> {

	private List<BackgroundId> pathPoints;

	public TileController(List<BackgroundId> list) {
		this.pathPoints = list;
		initTileModels();
	}

	private void initTileModels() {
		for (BackgroundId id : pathPoints) {
			addModel(new TileModel(new Point(id.getX() * 64, id.getY() * 64),
					0, TextureManager.getTexture("tile")));
		}
	}

	public TileModel getModel(int parId) {
		return super.getModel(parId);
	}

	public void addModel(TileModel parModel) {
		super.addModel(parModel);
	}

	/*
	 * @Post getModel(parId) == null
	 */
	public void removeModel(int parId) {
		super.removeModel(parId);
	}

	public Set<Entry<Integer, TileModel>> getModelEntrySet() {
		return super.getModelEntrySet();
	}

	public void drawModels() {

		for (BackgroundId point : pathPoints) {
			Texture texture = TextureManager.getTexture("tile");
			Display.getInstance()
					.getCanvas()
					.drawTexture(texture,
							new Point(point.getX() * 64, point.getY() * 64), 0);
		}
	}

	public void onCollided(TileModel parT, EnemyModel parE) {
		throw new UnsupportedOperationException();
	}

	public boolean canTowerBuilt(TileModel parT) {
		throw new UnsupportedOperationException();
	}

	public boolean canTrapBuilt(TileModel parT) {
		throw new UnsupportedOperationException();
	}

	public void update() {
		super.update();
	}

	@Override
	public int getClicked(Point point) {
		// TODO Auto-generated method stub
		for (Entry<Integer, TileModel> entry : getModelEntrySet()) {
			if (entry.getValue().contains(point)) {
				return entry.getValue().getId();
			}
		}
		return -1;
	}

	public int getClickedWithTowerIntersect(Point point) {
		// TODO Auto-generated method stub
		for (Entry<Integer, TileModel> entry : getModelEntrySet()) {
			Rectangle rectangle = new Rectangle(point.x
					- (TowerPowerConstants.W_TOWER / 2), point.y
					- (TowerPowerConstants.H_TOWER / 2),
					TowerPowerConstants.W_TOWER, TowerPowerConstants.H_TOWER);
			if (entry.getValue().intersects(rectangle)) {
				return entry.getValue().getId();
			}
		}
		return -1;
	}

}