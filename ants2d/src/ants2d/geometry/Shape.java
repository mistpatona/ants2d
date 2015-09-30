package ants2d.geometry;

public interface Shape {
	double area();
	boolean contains(XY point);
	Rectangle containingRectangle();
	default public Circle containingCircle() {
		return containingRectangle().containingCircle();
	}
	default Point center() {
		return containingRectangle().centrum();
	}
}
