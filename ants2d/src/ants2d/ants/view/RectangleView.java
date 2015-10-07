package ants2d.ants.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import ants2d.geometry.AB;
import ants2d.geometry.Rectangle;

@SuppressWarnings("serial")
public class RectangleView extends AbstractCoordView {

	private Rectangle rectangle;
	private Color c = Color.RED;

	public RectangleView(AB a, ViewPointTranfsormer _tr, Color color) {
		super();
		rectangle = new Rectangle(a);
		c = color;
		setTransformer(_tr);
	}

	public void doDrawing(Graphics gr) {
		Graphics2D g = (Graphics2D) gr;
		g.setColor(c);
		int x0, y0, xs, ys;
		Pixel s = transformer().scale(rectangle.getP1().sub(rectangle.getP0()));
		xs = s.getX();
		ys = s.getY();
		Pixel p = transformer().trans(rectangle.getP0());
		x0 = p.getX();
		y0 = p.getY();
		g.drawRect(x0, y0, xs, ys);
	}

}
