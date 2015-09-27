package ants2d.map;

public interface AB {
	boolean contains(XY point);
	Offset dimentions();
	Point getCorner(Quadrants q);
}
