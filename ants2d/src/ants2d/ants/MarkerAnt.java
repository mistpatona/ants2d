package ants2d.ants;

import ants2d.geometry.Point;
import ants2d.mapabstractions.UserMapPart;

public class MarkerAnt extends OrdinaryAnt {
	FerromoneMarker marker;
	public MarkerAnt(Point pos) {
		super(null,pos);
		marker  = new FerromoneMarker(this);
	}
}
