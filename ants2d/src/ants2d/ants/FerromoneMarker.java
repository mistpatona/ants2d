package ants2d.ants;

import ants2d.geometry.Point;
import ants2d.mapabsrtactions.impl.MapShapeObject;
import ants2d.mapabstractions.ChangesWithTime;
import ants2d.mapabstractions.Clock;
import ants2d.mapabstractions.Constants;

public class FerromoneMarker implements ChangesWithTime {
	public static double markerStep = Constants.FerroMarkerStep;
	private Point previousMarkPosition;
	private OrdinaryAnt ant;
	public FerromoneMarker(OrdinaryAnt a) {
		ant=a;
		previousMarkPosition = ant.getPosition();
		//Clock.getClock().add(this);
	}
	@Override
	public void timeStep() {
		Point newPos = ant.getPosition();
		if (newPos.distanceTo(previousMarkPosition) > markerStep) {
			FerromoneMark m = new FerromoneMark();
			ant.getCurrentMap().add(new MapShapeObject(newPos,m));
		}
	}

}
