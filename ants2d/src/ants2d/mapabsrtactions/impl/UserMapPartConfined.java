package ants2d.mapabsrtactions.impl;

import java.util.Collections;
import java.util.List;

import ants2d.geometry.Rectangle;
import ants2d.map.query.MapQuery;
import ants2d.mapabstractions.MapObject;
import ants2d.mapabstractions.ShapeOverlap;
import ants2d.mapabstractions.UserMapPart;
import ants2d.mapabstractions.UserMapPartAbstractDecorator;

public class UserMapPartConfined extends UserMapPartAbstractDecorator {

	public UserMapPartConfined(UserMapPart m,Rectangle r) {
		super(m);
		rectangle = r;
		
	}
	private Rectangle rectangle;
	
	@Override
	public void add(MapObject newObject) {
		if (newObject.overlapWith(rectangle) != ShapeOverlap.None ) 
			innerMap().add(newObject);
	}
	
	@Override
	public List<MapObject> getObjects(MapQuery query) {
		if (query.lookupArea().containingRectangle().overlap(rectangle) != ShapeOverlap.None )
			return innerMap().getObjects(query);
			else {return Collections.<MapObject>emptyList();}		
	}

}
