package ants2d.ants.view;

import ants2d.geometry.XY;

public class Pixel {
	private int x,y;
	public Pixel(XY p) {
		x = (int)p.getX();
		y = (int)p.getY();
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
