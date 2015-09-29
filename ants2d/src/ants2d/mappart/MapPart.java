package ants2d.mappart;

import java.util.List;

import ants2d.geometry.Point;
import ants2d.geometry.Rectangle;
import ants2d.mapobject.MapPoint;

public interface MapPart {
	MapPart findMap(Point p);
	boolean contains(Point p);
	void removeWanting();
	List<MapPoint> getNearbyObjects(Point p, double radius);
	List<MapPoint> getNearbyObjects(Rectangle r);
	List<MapPoint> getOwnNearbyObjects(Point p, double radius);//?
	List<MapPoint> getOwnNearbyObjects(Rectangle r);
	void add(MapPoint x);
	void trySplit(int threshold);
	Rectangle getRectangle();
	List<MapPart> getChildren();
}
