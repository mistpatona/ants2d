package ants2d.mapobject;

import ants2d.geometry.Point;

public interface MapPoint {
	Point getCoords();
	boolean wantsToBeRemoved();
}
