package com.java.TowerPower.Model;

public class EnemyWave {
	
	private int numberOfEnemy;
	private int progress;
	private long lastTimeProduced;
	private int period;
	private EnemyType enemyType;
	
	public EnemyWave(int numberOfEnemy, int period, EnemyType enemyType) {
		setNumberOfEnemy(numberOfEnemy);
		setPeriod(period);
		progress = 0;
		lastTimeProduced = System.currentTimeMillis();
		this.setEnemyType(enemyType);
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public int getNumberOfEnemy() {
		return numberOfEnemy;
	}

	public void setNumberOfEnemy(int numberOfEnemy) {
		this.numberOfEnemy = numberOfEnemy;
	}

	public void increaseProgress() {
		progress++;
		lastTimeProduced = System.currentTimeMillis();
	}
	public boolean isCompleted() {
		return progress >= numberOfEnemy;
	}
	
	public boolean shouldProduceEnemy() {
		
		if(!isCompleted()) {
			if((System.currentTimeMillis() - lastTimeProduced) > period) {
				return true;
			} else {
				return false;
			}
		}
		return false;
		
	}

	public EnemyType getEnemyType() {
		return enemyType;
	}

	public void setEnemyType(EnemyType enemyType) {
		this.enemyType = enemyType;
	}

}
