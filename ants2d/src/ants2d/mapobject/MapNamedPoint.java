package ants2d.mapobject;

import ants2d.geometry.Point;
import ants2d.geometry.XY;

public class MapNamedPoint implements MapPoint {

	private Point point;
	private String name;
	
	public MapNamedPoint(XY p, String _name) {
		point = new Point(p);
		name = _name;
	}
	
	public String toString() {
		return name + point.toString();
	}
	
	@Override
	public Point getCoords() {
		return point;
	}

	@Override
	public boolean wantsToBeRemoved() {
		return false;
	}

}
