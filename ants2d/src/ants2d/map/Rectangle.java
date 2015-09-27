package ants2d.map;

import java.util.ArrayList;
import java.util.List;

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
	
	public List<Rectangle> split4() {
		List<Rectangle> ans = new ArrayList<Rectangle>();
		//Offset diag = dimentions();//p1.sub(p0);
		//Offset d2 = new Offset(diag.scaleBy(0.5));
		Point p = new Point(p0.sum(dimentions().scaleBy(0.5))); // center point
		ans.add(new Rectangle(p0,p));
		ans.add(new Rectangle(new Point(p.getX(),p0.getY()),new Point(p1.getX(),p.getY())));
		ans.add(new Rectangle(new Point(p0.getX(),p.getY()),new Point(p.getX(),p1.getY())));
		ans.add(new Rectangle(p,p1));
		return ans;
	}
	
	protected List<Rectangle> split2(Offset d) {
		List<Rectangle> ans = new ArrayList<Rectangle>(2);
		ans.add(new Rectangle(p0,new Point(p1.sub(d))));
		ans.add(new Rectangle(new Point(p0.sum(d)),p1));
		return ans;
	}
	
	public List<Rectangle> split2h() {  // like in Need for Speed double-player
		return split2(new Offset(0,dimentions().scaleBy(0.5).getY()));
	}
	public List<Rectangle> split2v() { // like in Norton Commander
		return split2(new Offset(dimentions().scaleBy(0.5).getX(),0));
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
