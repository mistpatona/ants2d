package ants2d.mappart;

import java.util.List;

import ants2d.map.MapObject;
import ants2d.map.Point;
import ants2d.map.Rectangle;

public interface MapPart {
	MapPart findMap(Point p);
	boolean contains(Point p);
	//MapPart getParent(); //?
	void removeWanting();
	List<MapObject> getNearbyObjects(Point p, double radius);
	List<MapObject> getOwnNearbyObjects(Point p, double radius);//?
	void add(MapObject x);
	void trySplit(int threshold);
	Rectangle getRectangle();
	List<MapPart> getChildren();
}
