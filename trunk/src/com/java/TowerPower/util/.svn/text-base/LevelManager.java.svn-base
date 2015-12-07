package com.java.TowerPower.util;

import java.util.ArrayList;
import java.util.List;

import com.java.TowerPower.Model.BackgroundId;
import com.java.TowerPower.Model.EnemyType;
import com.java.TowerPower.Model.EnemyWave;
import com.java.TowerPower.Model.Level;

public class LevelManager {

	private static LevelManager instance;

	private int lastLevelId;

	private LevelManager() {
		setLastLevelId(1);
	}

	public synchronized static LevelManager getInstance() {
		if (instance == null) {
			instance = new LevelManager();
		}

		return instance;
	}

	public Level getLevel(int levelId) {
		Level level;

		switch (levelId) {
		case 1:
			level = new Level(getFirstLevelCastleGrid(), getFirstLevelList());
			return level;
		case 2:
			level = new Level(getSecondLevelCastleGrid(), getSecondLevelList());
			return level;
		default:
			level = new Level(getSecondLevelCastleGrid(), getSecondLevelList());
			return level;
		}
	}

	public List<EnemyWave> getEnemyWaveList(int level) {

		List<EnemyWave> enemyWaves = new ArrayList<>();

		EnemyWave enemyWave;
		EnemyWave enemyWave1;
		EnemyWave enemyWave2;
		switch (level) {
		case 1:

			enemyWave = new EnemyWave(5, 2000, EnemyType.ELF);
			enemyWave1 = new EnemyWave(3, 4000, EnemyType.TROLL);
			enemyWave2 = new EnemyWave(2, 6000, EnemyType.GOBLIN);
			enemyWaves.add(enemyWave);
			enemyWaves.add(enemyWave1);
			enemyWaves.add(enemyWave2);
			break;

		case 2:

			enemyWave = new EnemyWave(5, 2000, EnemyType.ELF);
			enemyWave1 = new EnemyWave(5, 4000, EnemyType.TROLL);
			enemyWave2 = new EnemyWave(4, 3000, EnemyType.GOBLIN);
			enemyWaves.add(enemyWave);
			enemyWaves.add(enemyWave1);
			enemyWaves.add(enemyWave2);
			break;

		default:
			enemyWave = new EnemyWave(5, 2000, EnemyType.ELF);
			enemyWave1 = new EnemyWave(5, 4000, EnemyType.TROLL);
			enemyWave2 = new EnemyWave(4, 3000, EnemyType.GOBLIN);
			enemyWaves.add(enemyWave);
			enemyWaves.add(enemyWave1);
			enemyWaves.add(enemyWave2);
			break;
		}
		return enemyWaves;
	}

	public List<BackgroundId> getSecondLevelList() {
		List<BackgroundId> list = new ArrayList<>();

		list.add(new BackgroundId(4, 0));
		list.add(new BackgroundId(4, 1));
		list.add(new BackgroundId(4, 2));
		list.add(new BackgroundId(4, 3));
		list.add(new BackgroundId(4, 4));
		list.add(new BackgroundId(4, 5));
		list.add(new BackgroundId(5, 5));
		list.add(new BackgroundId(6, 5));
		list.add(new BackgroundId(7, 5));
		list.add(new BackgroundId(8, 5));
		list.add(new BackgroundId(9, 5));

		return list;
	}

	public List<BackgroundId> getFirstLevelList() {
		List<BackgroundId> list = new ArrayList<>();
		int y = 4;

		list.add(new BackgroundId(10, y));
		list.add(new BackgroundId(9, y));
		list.add(new BackgroundId(8, y));
		list.add(new BackgroundId(7, y));
		list.add(new BackgroundId(6, y));
		list.add(new BackgroundId(5, y));
		list.add(new BackgroundId(4, y));
		list.add(new BackgroundId(3, y));
		list.add(new BackgroundId(2, y));
		list.add(new BackgroundId(1, y));
		list.add(new BackgroundId(0, y));
		list.add(new BackgroundId(0, y + 1));
		list.add(new BackgroundId(0, y + 2));
		list.add(new BackgroundId(0, y + 3));

		return list;
	}

	public BackgroundId getFirstLevelCastleGrid() {
		return new BackgroundId(0, 6);
	}

	public BackgroundId getSecondLevelCastleGrid() {
		return new BackgroundId(9, 5);
	}

	public int getLastLevelId() {
		return lastLevelId;
	}

	public void setLastLevelId(int lastLevelId) {
		this.lastLevelId = lastLevelId;
	}

	public void onLevelCompleted() {
		this.lastLevelId++;
	}

}
