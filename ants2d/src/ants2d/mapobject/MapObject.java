package ants2d.mapobject;

import ants2d.map.Point;

public interface MapObject {
	Point getCoords();
	boolean wantsToBeRemoved();
}
