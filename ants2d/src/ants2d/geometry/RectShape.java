package ants2d.geometry;

import ants2d.map.Quadrants;

public interface RectShape extends ConvexShape{
	//boolean contains(XY point);
	Offset dimentions();
	Point getCorner(Quadrants q);
}
