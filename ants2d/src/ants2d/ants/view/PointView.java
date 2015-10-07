package ants2d.ants.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import ants2d.geometry.AB;
import ants2d.geometry.Point;
import ants2d.geometry.Rectangle;
import ants2d.geometry.XY;

@SuppressWarnings("serial")
public class PointView extends AbstractCoordView {

	private Point point;
	private Color c = Color.PINK;

	public PointView(XY a, ViewPointTranfsormer _tr, Color color) {
		super();
		point = new Point(a);
		c = color;
		setTransformer(_tr);
	}

	public void doDrawing(Graphics gr) {
		Graphics2D g = (Graphics2D) gr;
		g.setColor(c);
		int x0, y0;
		Pixel p = transformer().trans(point);
		x0 = p.getX();
		y0 = p.getY();
		g.drawRect(x0, y0, 0, 0);
	}

}
