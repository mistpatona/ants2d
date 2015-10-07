package ants2d.ants.view;

import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class AbstractCoordView extends JPanel {

	protected ViewPointTranfsormer tr;

	@Override
	public void paint(Graphics g) {
		doDrawing(g);
	}

	public abstract void doDrawing(Graphics g);
	
	protected ViewPointTranfsormer transformer() {
		return tr;
	}
	
	protected void setTransformer(ViewPointTranfsormer _tr) {
		tr = _tr;
	}

}