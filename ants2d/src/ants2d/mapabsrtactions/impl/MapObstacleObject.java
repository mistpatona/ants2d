package ants2d.mapabsrtactions.impl;

import ants2d.geometry.Shape;
import ants2d.mapabstractions.MapObstacle;

public class MapObstacleObject extends MapShapeObject {
	public MapObstacleObject(Shape s) {
		super (s,new MapObstacle(){});
	}

}
