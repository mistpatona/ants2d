package ants2d.mapobject;

import ants2d.map.Point;
import ants2d.map.XY;

public class MapPoint implements MapObject {

	private Point point;
	private String name;
	
	public MapPoint(XY p, String _name) {
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
