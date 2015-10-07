package ants2d.ants;

import ants2d.geometry.Point;

public class MobileFerromoneSensor extends FerromoneSensor {
	private OrdinaryAnt ant;
	private Point previousPos;
	private FerromoneSensorAnswer lastResult;
	
	public MobileFerromoneSensor(OrdinaryAnt _ant) {
		ant = _ant;
	}
	/**
	 * Run sensor lazily, only if position changed.
	 * as ant always moves, cached answer will not get old.
	 * Sensing imposes load on map,
	 * so with caching it can be cheaply quiered several times in one time cycle
	 */
	public FerromoneSensorAnswer sense() {
		if (ant.getPosition() != previousPos) {
			lastResult = this.answer(ant);
			previousPos = ant.getPosition();
		}
		return lastResult;
	}

}
