package ants2d.map.query;

import ants2d.geometry.Rectangle;
//import ants2d.geometry.Shape;

public class GeometricQuery //implements GenericQuery 
{

	private Rectangle rectangle;
	public GeometricQuery(Rectangle r) {
		rectangle = r;
	}
	
	public GeometricQuery intersect(GeometricQuery other) {
		Rectangle thisR = this.getShape().containingRectangle();
		Rectangle thatR = other.getShape().containingRectangle();
		if (thisR.contains(thatR)) {
			return other;
		}
		if (thatR.contains(thisR)) {
			return this;
		}
		return new GeometricQuery(thisR.intersectionWith(thatR));
		
		
	}
	
	public Rectangle getShape() {
		return rectangle;
	}
	
	public boolean isNull(){
		return null == rectangle;
	}

	
	

}
