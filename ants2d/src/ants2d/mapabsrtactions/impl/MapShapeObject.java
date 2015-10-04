package ants2d.mapabsrtactions.impl;

import ants2d.geometry.Point;
import ants2d.geometry.Rectangle;
import ants2d.geometry.Shape;
import ants2d.mapabstractions.MapObject;
import ants2d.mapabstractions.MapPayload;

public class MapShapeObject implements MapObject {

	public MapShapeObject(Shape s, MapPayload p) {
		shape = s;
		payload = p;
	}
	
	private Shape shape;
	private MapPayload payload;
	@Override
	public Rectangle enclosingRectangle() {
		return shape.containingRectangle();
	}

	@Override
	public boolean containsPoint(Point p) {
		return shape.contains(p);
	}

	@Override
	public MapPayload payload() {
		return payload;
	}
	
	public boolean wantsToBeRemoved(){
		return payload.wantsToBeRemoved();
	}
	
	public String toString() {
		return payload.toString() + "!@!<" + shape.toString() +">";
	}

}
