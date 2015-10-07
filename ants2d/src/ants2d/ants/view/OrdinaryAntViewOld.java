package ants2d.ants.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import ants2d.ants.OrdinaryAnt;
import ants2d.geometry.Offset;
import ants2d.geometry.Point;

@SuppressWarnings("serial")
public class OrdinaryAntViewOld extends JPanel{
	public OrdinaryAntViewOld(OrdinaryAnt a) {
		super();
		ant = a;
	}
	private OrdinaryAnt ant;
	private void doDrawing(Graphics gr) {
        Graphics2D g = (Graphics2D) gr;
        Point p = ant.getPosition();
        Offset v = ant.getDirection().scaleBy(8); // mark will depend on speed
        Point p0 = p.sum(v);// head
        Point p1 = p.sub(v);// tail
        g.setColor(Color.BLACK);
        g.drawLine((int)p0.getX(), (int)p0.getY(), (int)p1.getX(), (int)p1.getY());
        double r=4;
        p1=p0.sum(new Offset(-r/2,-r/2));
        g.drawOval((int)p1.getX(), (int)p1.getY(), (int)r, (int)r);
    }
    
    @Override
    public void paint(Graphics g) {
        //super.paintComponent(g);
        //ant.timeStep();
        doDrawing(g);
    }

}
