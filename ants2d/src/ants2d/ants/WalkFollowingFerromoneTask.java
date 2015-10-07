package ants2d.ants;
import ants2d.geometry.Offset;

public class WalkFollowingFerromoneTask implements TrivialAntTask {
	private OrdinaryAnt ant;
	
	public WalkFollowingFerromoneTask(OrdinaryAnt a) {
		ant = a;
	}
	
	@Override
	public TrivialAntTask nextTask() {
		return this;
	}
	/** turn speed vector on "step" angle*/
	@Override
	public Offset newDirection() {
		double alpha = ant.senseFerromone().angle();
		return ant.getDirection().rotateBy(alpha);
	}

}
