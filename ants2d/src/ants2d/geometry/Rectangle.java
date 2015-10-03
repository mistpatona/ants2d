package ants2d.geometry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ants2d.map.Quadrants;
import ants2d.mapabstractions.ShapeOverlap;

public class Rectangle extends AB implements RectShape, Polygonic {

	public Rectangle(final Point _p0, final Point _p1) {
		super(_p0, _p1);
	}

	public Rectangle(final Point p, final Offset s) {
		super(p, p.sum(s));
	}

	public Rectangle(final RectShape area) {
		super(area.getCorner(Quadrants.NW), area.getCorner(Quadrants.SE));
	}

	private static Point pointNW(AB s) {
		double x0 = s.getP0().getX();
		double x1 = s.getP1().getX();
		double y0 = s.getP0().getY();
		double y1 = s.getP1().getY();
		double rx0 = Math.min(x1, x0);
		double ry0 = Math.min(y0, y1);
		return new Point(rx0, ry0);
	}

	private static Point pointSE(AB s) {
		double x0 = s.getP0().getX();
		double x1 = s.getP1().getX();
		double y0 = s.getP0().getY();
		double y1 = s.getP1().getY();
		double rx1 = Math.max(x0, x1);
		double ry1 = Math.max(y0, y1);
		return new Point(rx1, ry1);
	}

	public Rectangle(AB s) {
		super(pointNW(s), pointSE(s));
		// TODO: this is ugly code in pointNW and pointSE
	}

	public Rectangle(Rectangle r) {
		super(r.getP0(), r.getP1());
	}

	public static Rectangle enclosing(Iterable<Point> ps) {
		Double minx = Double.MAX_VALUE, miny = Double.MAX_VALUE;
		Double maxx = -Double.MAX_VALUE, maxy = -Double.MAX_VALUE;
		int c = 0;
		for (Point p : ps) {
			minx = Math.min(minx, p.getX());
			miny = Math.min(miny, p.getY());
			maxx = Math.max(maxx, p.getX());
			maxy = Math.max(maxy, p.getY());
			c++;
		}
		if (c > 0)
			return new Rectangle(new Point(minx, miny), new Point(maxx, maxy));
		else
			return new Rectangle(new Point(0, 0), new Point(0, 0));
	}

	public static Rectangle enclosing(Rectangle r, Offset b) {
		return new Rectangle(r.getP0().sub(b), r.getP1().sum(b));
	}

	public static Rectangle enclosing(Rectangle r, double e) {
		return Rectangle.enclosing(r, new Offset(e, e));
	}
	@Deprecated //too complex . better use two split2's
	public List<Rectangle> split4() {
		List<Rectangle> ans = new ArrayList<Rectangle>();
		Point p = p0.sum(dimentions().scaleBy(0.5)); // center point
		ans.add(new Rectangle(p0, p));
		ans.add(new Rectangle(new Point(p.getX(), p0.getY()), new Point(p1.getX(), p.getY())));
		ans.add(new Rectangle(new Point(p0.getX(), p.getY()), new Point(p.getX(), p1.getY())));
		ans.add(new Rectangle(p, p1));
		return ans;
	}

	protected List<Rectangle> split2(Offset d) {
		List<Rectangle> ans = new ArrayList<Rectangle>(2);
		ans.add(new Rectangle(p0, p1.sub(d)));
		ans.add(new Rectangle(p0.sum(d), p1));
		return ans;
	}

	public List<Rectangle> split2h() { // like in Need for Speed double-player
		return split2(new Offset(0, dimentions().scaleBy(0.5).getY()));
	}

	public List<Rectangle> split2v() { // like in Norton Commander
		return split2(new Offset(dimentions().scaleBy(0.5).getX(), 0));
	}
	
	public List<Rectangle> split2() { // on longer dimention
		Offset t = this.dimentions();
		return (t.getX() > t.getY()) ? this.split2h() : this.split2v();  
	}
	

	@Override
	public boolean contains(XY point) {
		double x = point.getX();
		double y = point.getY();

		return (x >= p0.getX() && x <= p1.getX()) && (y >= p0.getY() && y <= p1.getY());
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
		case NW:
			return p0;
		case SE:
			return p1;
		case SW:
			return p0.create(p0.getX(), p1.getY());
		case NE:
			return p0.create(p1.getX(), p0.getY());
		}
		return null;
	}

	public boolean belongsTo(RectShape r) {
		return r.contains(p0) && r.contains(p1);
	}

	public boolean contains(Rectangle r) {
		return r.belongsTo(this);
	}

	public boolean containsCircle(Point p, double radius) {
		Offset r = new Offset(radius, radius);
		Rectangle c = new Rectangle(new Point(p.sub(r)), new Point(p.sum(r)));
		return contains(c);
	}

	public boolean overlaps(Rectangle other) {
		return contains(other) || belongsTo(other) || partlyOverlaps(other);
	}
	
	public ShapeOverlap overlap(Rectangle other) {
		if (contains(other) || belongsTo(other)) return ShapeOverlap.Fully;
		if (partlyOverlaps(other)) return ShapeOverlap.ProbableOrPartly;
		return ShapeOverlap.None;
	}

	public boolean partlyOverlaps(Rectangle other) {
		/*
		 * this is when at least one of 1's ribs intersects with 2's rib there
		 * is an even count of such intersections but we will look for just
		 * first one
		 */
		for (Segment s : this.segments())
			for (Segment q : other.segments())
				if (s.intersectsSegment(q))
					return true;
		return false;
	}
	
	

	/* --! segments in clock-wise order */
	public List<Segment> segments() {
		List<Segment> ans = new ArrayList<Segment>(4);
		Point pne = getCorner(Quadrants.NE);
		Point psw = getCorner(Quadrants.SW);
		ans.add(new Segment(p0, pne));
		ans.add(new Segment(pne, p1));
		ans.add(new Segment(p1, psw));
		ans.add(new Segment(psw, p0));
		return ans;
	}

	/* --! points in clock-wise order */
	public List<Point> points() {
		// List<Point> ans = new ArrayList<Point>(4);
		Point pne = getCorner(Quadrants.NE);
		Point psw = getCorner(Quadrants.SW);
		/*
		 * ans.add(p0); ans.add(pne); ans.add(p1); ans.add(psw); return ans;
		 */
		return Arrays.asList(p0, pne, p1, psw);
	}

	@Override
	public double area() {
		Offset d = this.dimentions();
		return d.getX() * d.getY();
	}

	@Override
	public Rectangle containingRectangle() {
		return this;
	}
	
	public Circle containingCircle() {
		return new Circle(this.centrum(), this.dimentions().length()/2.0);
	}
	

}
