package ants2d.mappart;

import java.util.List;

import ants2d.geometry.Point;
import ants2d.geometry.Rectangle;
import ants2d.mapobject.MapObject;

public interface MapPart {
	MapPart findMap(Point p);
	boolean contains(Point p);
	void removeWanting();
	List<MapObject> getNearbyObjects(Point p, double radius);
	List<MapObject> getNearbyObjects(Rectangle r);
	List<MapObject> getOwnNearbyObjects(Point p, double radius);//?
	List<MapObject> getOwnNearbyObjects(Rectangle r);
	void add(MapObject x);
	void trySplit(int threshold);
	Rectangle getRectangle();
	List<MapPart> getChildren();
}
