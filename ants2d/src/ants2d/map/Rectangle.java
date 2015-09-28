package ants2d.map;

import java.util.ArrayList;
import java.util.List;

import ants2d.geometry.AB;

public class Rectangle extends AB implements RectShape {
	
	//private Point p0,p1;
	
	public Rectangle(final Point _p0, final Point _p1) {
		super(_p0,_p1);
	}
	
	public Rectangle(final RectShape area) {
		super(area.getCorner(Quadrants.NW),area.getCorner(Quadrants.SE));
	}
	
	private static Point pointNW(AB s) {
		double x0 = s.getP0().getX();
		double x1 = s.getP1().getX();
		double y0 = s.getP0().getY();
		double y1 = s.getP1().getY();
		double rx0 = Math.min(x1, x0);
		double ry0 = Math.min(y0, y1);
		return new Point(rx0,ry0);
	}
	
	private static Point pointSE(AB s) {
		double x0 = s.getP0().getX();
		double x1 = s.getP1().getX();
		double y0 = s.getP0().getY();
		double y1 = s.getP1().getY();
		double rx1 = Math.max(x0, x1);
		double ry1 = Math.max(y0, y1);
		return new Point(rx1,ry1);
	}
	
	public Rectangle(AB s) {
		super(pointNW(s),pointSE(s));
		//TODO: this is ugly code in pointNW and pointSE
/*		double x0 = s.getP0().getX();
		double x1 = s.getP1().getX();
		double y0 = s.getP0().getY();
		double y1 = s.getP1().getY();
		double rx0 = Math.min(x1, x0);
		double rx1 = Math.max(x0, x1);
		double ry0 = Math.min(y0, y1);
		double ry1 = Math.max(y0, y1);
		super( new Point(rx0,ry0),new Point(rx1,ry1));*/
	}
	
	public Rectangle(Rectangle r) {
		super(r.getP0(),r.getP1());
	}
	
	public List<Rectangle> split4() {
		List<Rectangle> ans = new ArrayList<Rectangle>();
		Point p = p0.sum(dimentions().scaleBy(0.5)); // center point
		ans.add(new Rectangle(p0,p));
		ans.add(new Rectangle(new Point(p.getX(),p0.getY()),new Point(p1.getX(),p.getY())));
		ans.add(new Rectangle(new Point(p0.getX(),p.getY()),new Point(p.getX(),p1.getY())));
		ans.add(new Rectangle(p,p1));
		return ans;
	}
	
	protected List<Rectangle> split2(Offset d) {
		List<Rectangle> ans = new ArrayList<Rectangle>(2);
		ans.add(new Rectangle(p0,p1.sub(d)));
		ans.add(new Rectangle(p0.sum(d),p1));
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
		return p1.sub(getP0());
	}

	@Override
	public Point getCorner(Quadrants q) {
		Point p0 = getP0();
		Point p1 = getP1();
		switch (q) {
			case NW: return p0.create(p0); // to protect from accidental change
			case SE: return p0.create(p1);
			case SW: return p0.create(p0.getX(), p1.getY());
			case NE: return p0.create(p1.getX(), p0.getY());
		}
		return null;
	}
	
	public boolean belongsTo(RectShape r) {
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
