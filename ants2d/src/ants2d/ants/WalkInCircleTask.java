package ants2d.ants;
import ants2d.geometry.Offset;

public class WalkInCircleTask implements TrivialAntTask {
	private OrdinaryAnt ant;
	private double step;
	
	public WalkInCircleTask(OrdinaryAnt a, double stepAngle) {
		ant = a;
		step = stepAngle;
	}
	
	@Override
	public TrivialAntTask nextTask() {
		return this;
	}
	/** turn speed vector on "step" angle*/
	@Override
	public Offset newDirection() {
		Offset dir = ant.getDirection();
		double angle = dir.polarAngle() + step;
		double l = dir.length();
		return dir.create(l*Math.cos(angle),l*Math.sin(angle));
	}

}
