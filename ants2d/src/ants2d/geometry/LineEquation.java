package ants2d.geometry;

public class LineEquation {
	private double a, b, c;

	public double f(Point p) {
		return getA() * p.getX() + getB() * p.getY() + c;
	}

	public LineEquation(Point p0, Point p1) {

		this(	p1.getY() - p0.getY(), 
				p0.getX() - p1.getX(),
				p1.getX() * p0.getY() - p0.getX() * p1.getY());

		if (p0 == p1)
			throw new Error("cannot construct line by equal points");
	}

	public LineEquation(Double _a, Double _b, Double _c) {
		a = _a;
		b = _b;
		c = _c;
		if (Math.abs(a) + Math.abs(b) < Math.abs(c) * 10000) { // (c!=0) for
																// floating
																// point
			a = a / c;
			b = b / c;
			c = 1;
		}
	}

	public LineEquation perpendicularLine(Point p) {
		double d = getA() * p.getY() - getB() * p.getX();
		return new LineEquation(b, -a, d);
	}

	public boolean isParallelTo(LineEquation other, double eps) {
		return Math.abs(this.getA() * other.getB() - this.getB() * other.getA()) < eps;
	}

	public LineEquation parallelShifted(double dc) {
		return new LineEquation(a, b, c + dc);
	}

	public boolean crossesSegment(Segment s) {
		return f(s.getP0()) * f(s.getP1()) < 0;
		// segment's ends are on different sides of line
	}

	public Point projection(Point p) { // projection of point p onto this line
		double k = 1 / (a * a + b * b);
		double d = a * p.getY() - b * p.getX();
		double x = k * (-a * c - b * d);
		double y = k * (a * d - b * c);
		return new Point(x, y);
	}

	public Offset directionVector() {
		double k = 1 / Math.hypot(a, b); // to normalize length
		return new Offset(a * k, b * k);
	}

	public boolean isNormalized() {
		return (overhelmsByAbs(Math.abs(a) + Math.abs(b), c, 0.0001) // i.e. c=0
				|| (overhelmsByAbs(1, Math.abs(c) - 1, 0.0001))); // c=1
	}

	public boolean overhelmsByAbs(double big, double small, double eps) {
		return Math.abs(big) * eps > Math.abs(small);
	}

	protected double getA() {
		return a;
	}

	protected double getB() {
		return b;
	}

	protected double getC() {
		return c;
	}
}
