package ants2d.mapabsrtactions.impl;

import java.util.ArrayList;
import java.util.List;

import ants2d.geometry.Point;
import ants2d.geometry.Rectangle;
import ants2d.geometry.Shape;
import ants2d.map.query.MapQuery;
import ants2d.mapabstractions.MapObject;
import ants2d.mapabstractions.MapPayload;
import ants2d.mapabstractions.MapQueryFilter;
import ants2d.mapabstractions.ShapeOverlap;
import ants2d.mapabstractions.UserMapPart;

/**
 * a simplistic map implementation, of a single one part.
 * all objects are in one list.
*/
public class SimpleUserMap implements UserMapPart {
	
	List<MapObject> objs = new ArrayList<MapObject>();

/*	@Override
	public UserMapPart getSpecificMap(Point p) {
		return this;
	}

	@Override
	public UserMapPart getSpecificMap(Shape s) {
		return this;
	}*/

	public List<MapObject> getObjects(MapQuery qf) {
		return qf.filter(objs);
	}

	@Override
	public void add(MapObject newObject) {
		objs.add(newObject);
	}

	@Override
	public void removeAllWanting() {
		for(MapObject x : new ArrayList<MapObject>(objs)) 
			if (x.wantsToBeRemoved()) objs.remove(x);
	}

}
