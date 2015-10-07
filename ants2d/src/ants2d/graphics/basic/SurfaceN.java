package ants2d.graphics.basic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.Timer;

import ants2d.ants.ArenaBuilder;
import ants2d.ants.ArenaModel;
import ants2d.ants.OrdinaryAnt;
import ants2d.ants.WanderingTask;
import ants2d.ants.view.ArenaView1;
import ants2d.ants.view.FilledRectangleView;
import ants2d.ants.view.OrdinaryAntViewSimple;
import ants2d.geometry.Point;
import ants2d.geometry.Rectangle;
import ants2d.mapabsrtactions.impl.MapObstacleObject;
import ants2d.mapabsrtactions.impl.SimpleUserMap;
import ants2d.mapabstractions.Clock;
import ants2d.mapabstractions.UserMapPart;

@SuppressWarnings("serial")
class SurfaceN extends JPanel implements ActionListener {

	public SurfaceN() {
		super();
		arena = new ArenaBuilder().build0();
		view = new ArenaView1(arena);
		
		initTimer();
	}
	private ArenaModel arena;
	private ArenaView1 view;
	
	private void doDrawing(Graphics g) {
		//System.out.println("Surface: started drawing");
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawString("Java 2D", 150, 50);
		
		view.paintComponent(g2d);

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		doDrawing(g);
	}
	private final int DELAY = 50;
	private Timer timer;
	
    public Timer getTimer() {
        return timer;
    }
	
    private void initTimer() {
        timer = new Timer(DELAY, this);
        timer.start();
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		Clock.tick();
	}

}
