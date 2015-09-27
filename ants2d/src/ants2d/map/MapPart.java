package ants2d.map;

import java.util.List;

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
}
