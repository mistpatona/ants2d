package ants2d.mapabstractions;

//import java.lang.reflect.Type;
import java.util.List;

import ants2d.geometry.Point;
import ants2d.geometry.Shape;

public interface UserMapPart {
	UserMapPart getSpecificMap(Point p);
	UserMapPart getSpecificMap(Shape s); // or from something more abstract than Shape
	
	//List<MapObject> getObjects(Shape s); // objects intersecting s or close to that
	
/*	default List<MapObject> getObjectsByPayload(Class<? extends MapPayload> c,Shape s){
		List<MapObject> objs = getObjects(s);
		List<MapObject> ans = objs.subList(0, 0);
		ans.clear(); // a dumb way to get new list, not importing ArrayList or something
		for (MapObject obj : objs)
			if (obj.payload().getClass().isInstance(c)) 
				ans.add(obj);
		return ans;		
	}*/
	
	void add(MapObject newObject);
	void removeAllWanting();
	List<MapObject> getObjects(MapQuery query);
	
}
