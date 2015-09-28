package ants2d.map;

public interface RectShape {
	boolean contains(XY point);
	Offset dimentions();
	Point getCorner(Quadrants q);
}
