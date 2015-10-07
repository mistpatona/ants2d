package ants2d.ants.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import ants2d.geometry.AB;

@SuppressWarnings("serial")
public class FilledRectangleView extends AbstractCoordView{
	public FilledRectangleView(AB a) {
		super();
		x0 = (int) a.getP0().getX();
		y0 = (int) a.getP0().getY();
		xs = (int) a.getP1().getX() - x0;
		ys = (int) a.getP1().getY() - y0;
	}
	public FilledRectangleView(AB a,Color color) {
		this(a);
		c = color;
	}
	private int x0,y0,xs,ys;
	private Color c = Color.RED;
	
	public void doDrawing(Graphics gr) {
        Graphics2D g = (Graphics2D) gr;
        g.setColor(c);
        g.drawRect(x0, y0, xs, ys);
    }
    


}
