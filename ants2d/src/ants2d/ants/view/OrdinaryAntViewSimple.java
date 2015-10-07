package ants2d.ants.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import ants2d.ants.FerromoneSensorAnswer;
import ants2d.ants.OrdinaryAnt;
import ants2d.geometry.Offset;
import ants2d.geometry.Point;

@SuppressWarnings("serial")
public class OrdinaryAntViewSimple extends AbstractCoordView{
	public OrdinaryAntViewSimple(OrdinaryAnt a,ViewPointTranfsormer _tr) {
		super();
		ant = a;
		tr = _tr;
	}
	OrdinaryAnt ant;

	public void doDrawing(Graphics gr) {
	    Graphics2D g = (Graphics2D) gr;
	    Point p = ant.getPosition();
	    //System.out.println("Drawing ant:"+p);
	    Offset v = ant.getDirection().scaleBy(4); // mark will depend on speed
	    Point p0 = p.sum(v);// head
	    Point p1 = p.sub(v);// tail
	    g.setColor(Color.BLACK);
	    tr.drawLine(gr, p0, p1);
	    double r=4;
	    tr.drawCircle(gr, p0, r);
	   /* FerromoneSensorAnswer smell = ant.senseFerromone();
	    if (smell.something()) {
	       g.drawString(""+smell.angle(),(float)p1.getX(),(float) p1.getY());
	    }*/
	}

}
