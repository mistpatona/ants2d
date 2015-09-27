package ants2d.map;

public class Rectangle implements AB {
	
	private Point p0,p1;
	
	public Rectangle(final Point _p0, final Point _p1) {
		p0 = _p0;
		p1 = _p1;
	}
	
	public Rectangle(final AB area) {
		p0 = area.getCorner(Quadrants.NW);
		p1 = area.getCorner(Quadrants.SE);
	}

	@Override
	public boolean contains(XY point) {
		double x = point.getX();
		double y = point.getY();
		 
		return (x>=p0.getX() && x <= p1.getX()) && (y >= p0.getY() && y <= p1.getY());
	}

	@Override
	public Offset dimentions() {
		return p1.sub(p0);
	}

	@Override
	public Point getCorner(Quadrants q) {
		switch (q) {
			case NW: return p0.create(p0); // to protect from accidental change
			case SE: return p0.create(p1);
			case SW: return p0.create(p0.getX(), p1.getY());
			case NE: return p0.create(p1.getX(), p0.getY());
		}
		return null;
	}
	
	public boolean belongsTo(AB r) {
		return r.contains(p0) && r.contains(p1); 
	}
	
	public boolean contains(Rectangle r) {
		return r.belongsTo(this);
	}
    
	public boolean containsCircle(Point p, double radius){
		Offset r = new Offset(radius,radius);
		Rectangle c = new Rectangle(new Point(p.sub(r)),new Point(p.sum(r)));
		return contains(c);
	}
}
