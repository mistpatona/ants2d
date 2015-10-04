package ants2d.mapabsrtactions.impl;

import java.util.ArrayList;
import java.util.List;

import ants2d.geometry.Point;
import ants2d.geometry.Rectangle;
import ants2d.geometry.Shape;
import ants2d.mapabstractions.MapObject;
import ants2d.mapabstractions.ShapeOverlap;
import ants2d.mapabstractions.UserMapPart;

/**
 * a simplistic map implementation, of a single one part.
 * all objects are in one list.
*/
public class SimpleUserMap implements UserMapPart {
	
	List<MapObject> objs = new ArrayList<MapObject>();

	@Override
	public UserMapPart getSpecificMap(Point p) {
		return this;
	}

	@Override
	public UserMapPart getSpecificMap(Shape s) {
		return this;
	}

	@Override
	public List<MapObject> getObjects(Shape s) {
		return getObjects(s.containingRectangle());
	}
	
/** some extra objects can slip in */	
	public List<MapObject> getObjects(Rectangle r) {
		List<MapObject> ans = new ArrayList<MapObject>();
		for(MapObject x : objs) 
			if (x.overlapWith(r) != ShapeOverlap.None) ans.add(x);
		return ans; // more testing will be needed on caller side
	}	

	@Override
	public void add(MapObject newObject) {
		objs.add(newObject);
	}

	@Override
	public void removeAllWanting() {
		for(MapObject x : objs) 
			if (x.wantsToBeRemoved()) objs.remove(x);
	}

}
