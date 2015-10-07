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
		return ant.getDirection().rotateBy(step);
	}

}