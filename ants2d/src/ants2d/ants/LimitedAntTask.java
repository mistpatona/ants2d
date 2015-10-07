package ants2d.ants;


import ants2d.geometry.Offset;

public class LimitedAntTask implements TrivialAntTask {
	
	public LimitedAntTask(TrivialAntTask t0, int count, TrivialAntTask tnext) {
		counter = count;
		innerTask = t0;
		nextInner = tnext;
	}
	private int counter;
	private TrivialAntTask innerTask, nextInner;

	@Override
	public TrivialAntTask nextTask() {
		counter--;
		if (counter>0) return this;
		else return new LimitedAntTask(nextInner,(int)(Math.random()*400)+100, innerTask);
	}

	@Override
	public Offset newDirection() {
		return innerTask.newDirection();
	}

}
