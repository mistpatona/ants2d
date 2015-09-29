package ants2d.geometry;

import java.util.ArrayList;
import java.util.List;

public class Polygon implements Polygonic {
	private List<Point> points;
	public Polygon (List<Point> ps) {
		points = new ArrayList<Point>();
		points.addAll(ps);
	}
	public List<Point> getPoints() {
		return points;
	}
	public Point lastPoint(){
		return points.get(points.size()-1);
	}
	public int intersectionsWith(Segment s) {
		int count = 0;
		for (Segment x : segments()) 
			if (x.intersectsSegment(s)) count++;
		return count;
	}
	public List<Segment> segments(){
		List<Segment> ans = new ArrayList<Segment>();
		Point pold=this.lastPoint();
		for (Point p : getPoints()){ 
			ans.add(new Segment(p,pold));
			pold = p;
		}
		return ans;
	}
		
	@Override
	public double area() {
		Point centrum = Rectangle.enclosing(this.getPoints()).centrum();
		double ans = 0;
		for (Segment s : this.segments()) {
			ans += s.getP0().sub(centrum).cartesianProduct(s.getP1().sub(centrum));
		}
		return 0.5*Math.abs(ans);
	}
	@Override
	public List<Point> points() {
		return getPoints();
	}
}
