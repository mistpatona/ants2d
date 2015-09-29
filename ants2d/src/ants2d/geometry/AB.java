package ants2d.geometry;

public class AB {
	
	protected Point p0;
	protected Point p1;
	
	public AB(Point _p0,Point _p1) {
		p0 = _p0;
		p1 = _p1;
	}
	
	public Point getP0() {
		return p0;
	}
	
	public Point getP1() {
		return p1;
	}
	
	public Point centrum() {
		return p0.sum(p1.sub(p0).scaleBy(0.5));
	}

}
