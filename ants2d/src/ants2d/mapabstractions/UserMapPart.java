package ants2d.mapabstractions;

import java.util.List;

import ants2d.geometry.Point;
import ants2d.geometry.Shape;

public interface UserMapPart {
	UserMapPart getSpecificMap(Point p);
	UserMapPart getSpecificMap(Shape s); // or from something more abstract than Shape
	
	List<MapObject> getObjects(Shape s); // objects intersecting s or close to that
	
	void add(MapObject newObject);
	void removeAllWanting();
	
}
