package ants2d.mapobject;

import ants2d.geometry.Point;

public interface MapObject {
	Point getCoords();
	boolean wantsToBeRemoved();
}
