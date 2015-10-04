package ants2d.mapabstractions;

import ants2d.geometry.Circle;
import ants2d.geometry.Point;
import ants2d.geometry.Rectangle;

public interface MapObject {
	default Circle outerCircle(){
		return enclosingRectangle().containingCircle();
	}
	default Point centrum(){
		return outerCircle().center();
	}
	default double radius(){
		return outerCircle().getRadius();
	} 
	Rectangle enclosingRectangle();
	
	default ShapeOverlap overlapWith(Rectangle r) {
		return enclosingRectangle().overlap(r);
	}
	//boolean belongsTo(Rectangle r);//even if partly
	//boolean fullyBelongsTo(Rectangle r); // TODO: not the best names
	boolean containsPoint(Point p);
	
	MapPayload payload();
	//Object payloadType(); // maybe something better in future
	
	default boolean wantsToBeRemoved(){
		return false;
	}
}
