package ants2d.mapabsrtactions.impl;

import java.util.ArrayList;
import java.util.List;

import ants2d.geometry.Point;
import ants2d.geometry.Rectangle;
import ants2d.geometry.Shape;
import ants2d.mapabstractions.MapObject;
import ants2d.mapabstractions.MapPayload;
import ants2d.mapabstractions.MapQuery;
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
	public List<MapObject> getObjects(MapQuery query) {
		List<MapObject> ans = new ArrayList<MapObject>();
		Rectangle r = query.lookupArea().containingRectangle();
		int count = query.lookupLimit();
		if (count<=0) count = Integer.MAX_VALUE;
		for(MapObject x : objs){
			if ( 	query.payloadNeeded().isInstance(x.payload()) &&
					query.mapObjectNeeded().isInstance(x)  &&  
				    (x.overlapWith(r) != ShapeOverlap.None)
				)
				   { ans.add(x); 
				     if (--count <= 0) return ans;   
				   } 
		}
		return ans;
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
