package ants2d.ants.view;

import java.awt.Graphics;
import java.awt.Graphics2D;

import ants2d.geometry.Offset;
import ants2d.geometry.Point;
import ants2d.geometry.Segment;

public class ViewPointTranfsormer {
	
	public ViewPointTranfsormer(){
	}
	// will add more sophisticated constructor
	// when map scrolling or scaling appears
	
	Point p0 = new Point(0,0);
	double scale = 1;
	
	public Pixel trans(Point p){
		return new Pixel(p.sub(p0).scaleBy(scale));
	}
	public Point backTrans(Pixel pix){
		Offset x = new Offset((double)pix.getX(),(double)pix.getY());
		return p0.sum(x.scaleBy(1/scale)); 
	}
	public double getScale(){
		return scale;
	}
	public Pixel scale(Offset v){
		return new Pixel(v.scaleBy(scale));
	}

	public void drawLine(Graphics gr,Point a0,Point a1) {
		Graphics2D g = (Graphics2D) gr;
		Pixel p0 = this.trans(a0);
		Pixel p1 = this.trans(a1);
		g.drawLine(p0.getX(), p0.getY(), p1.getX(), p1.getY());
	}
	
	public void drawCircle(Graphics gr,Point a0,double d0) {
		Graphics2D g = (Graphics2D) gr;
		double d = d0*this.getScale();
		double r  = d/2;
		Pixel p = this.trans(a0.sub(new Offset(r,r)));
		g.drawOval(p.getX(), p.getY(), (int)d, (int)d);
	}
}
