package ants2d.geometry;

import java.util.List;

public interface Polygonic extends Shape{
	List<Point> points();
	default public Polygon asPolygon() {
		return new Polygon(points());
	}
	default public Rectangle containingRectangle() {
		return this.asPolygon().containingRectangle();
	}
}
