package ants2d.map;

public interface MapPart {
	MapPart findMap(Point p);
	boolean contains(Point p);
	//MapPart getParent(); //?
	void removeWanting();
	Iterable<MapObject> getNearbyObjects(Point p, double radius);
	Iterable<MapObject> getOwnNearbyObjects(Point p, double radius);//?
	void add(MapObject x);
	void trySplit(int threshold);
}
