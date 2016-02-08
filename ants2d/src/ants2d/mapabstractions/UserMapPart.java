package ants2d.mapabstractions;

//import java.lang.reflect.Type;
import java.util.List;

import ants2d.geometry.Point;
import ants2d.geometry.Shape;
import ants2d.map.query.MapQuery;

public interface UserMapPart {
	//UserMapPart getSpecificMap(Point p);
	//UserMapPart getSpecificMap(Shape s); // or from something more abstract than Shape
	
	void add(MapObject newObject);
	void removeAllWanting();
	List<MapObject> getObjects(MapQuery query);
	
}
