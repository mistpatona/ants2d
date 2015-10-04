package ants2d.ants;

import ants2d.mapabstractions.ChangesWithTime;
import ants2d.mapabstractions.Clock;
import ants2d.mapabstractions.Constants;
import ants2d.mapabstractions.MapPayload;

public class FerromoneMark implements MapPayload,ChangesWithTime {
	private double strength  = Constants.FerroMarkInitialStrength;
	
	public FerromoneMark() {
		Clock.getClock().add(this);
	}
	
	public double getStrength() {
		return strength;
	}
	public void timeStep() {
		strength *= Constants.FerroMarkFadeMutiplier;
	}
	public boolean wantsToBeRemoved(){
		return isOver();
	}
	public boolean isOver() {
		return strength<Constants.FerroMarkFadeAway;
	}
	public String toString(){
		return "Ferromone="+strength;
	}
	

}
