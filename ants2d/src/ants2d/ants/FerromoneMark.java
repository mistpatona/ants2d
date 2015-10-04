package ants2d.ants;

import ants2d.mapabstractions.ChangesWithTime;
import ants2d.mapabstractions.Clock;
import ants2d.mapabstractions.MapPayload;

public class FerromoneMark implements MapPayload,ChangesWithTime {
	private float strength  = 100;
	
	public FerromoneMark() {
		Clock.getClock().add(this);
	}
	
	public double getStrength() {
		return strength;
	}
	public void timeStep() {
		strength *= 0.75;
	}
	public boolean wantsToBeRemoved(){
		return isOver();
	}
	public boolean isOver() {
		return strength<0.01;
	}
	public String toString(){
		return "Ferromone="+strength;
	}
	

}
