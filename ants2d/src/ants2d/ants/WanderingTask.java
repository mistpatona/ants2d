package ants2d.ants;
import java.util.Random;

import ants2d.geometry.Offset;

public class WanderingTask implements TrivialAntTask {
	private OrdinaryAnt ant;
	private Random rnd = new Random();
	
	public WanderingTask(OrdinaryAnt a) {
		ant = a;
	}
	
	@Override
	public TrivialAntTask nextTask() {
		return this;
	}
	@Override
	public Offset newDirection() {
		return (rnd.nextInt(5)==0) ? changedDirection() : ant.getDirection();
	}
	/** turn speed vector on random angle */
	public Offset changedDirection() {
		double step = (rnd.nextDouble()-0.5)*rnd.nextDouble();
		Offset dir = ant.getDirection();
		return dir.rotateBy(step);
	}

}
