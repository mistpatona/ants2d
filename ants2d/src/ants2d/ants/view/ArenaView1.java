package ants2d.ants.view;

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

import ants2d.ants.ArenaModel;
import ants2d.ants.OrdinaryAnt;
import ants2d.geometry.Offset;
import ants2d.geometry.Point;
import ants2d.geometry.Rectangle;
import ants2d.geometry.Shape;
import ants2d.mapabsrtactions.impl.MapObstacleObject;
import ants2d.mapabsrtactions.impl.MapObstacleRectangleObject;
import ants2d.mapabsrtactions.impl.MapPointObject;
import ants2d.mapabsrtactions.impl.MapQueryConstructor;
import ants2d.mapabstractions.ChangesWithTime;
import ants2d.mapabstractions.Clock;
import ants2d.mapabstractions.MapObject;
import ants2d.mapabstractions.MapObstacle;
import ants2d.mapabstractions.MapPayload;
import ants2d.mapabstractions.MapQuery;
import ants2d.mapabstractions.MapQueryFilter;

public class ArenaView1 extends JPanel implements ActionListener {

	public ArenaView1(ArenaModel am) {
		System.out.println("Arena view inited");
		arenaModel = am;
		initTimer();
		initLapTimer();
	}
	private ArenaModel arenaModel;
	private ViewPointTranfsormer viewTrans = new ViewPointTranfsormer(); //has reasonable defaults
	private Rectangle window = new Rectangle(new Point(0,0), new Offset(1000,1000)); 

	private final int DELAY = 50;
	private Timer timer;
	
	//System.currentTimeMillis()
	private long lastLapTimer;
	private long lastLap;
	private ChangesWithTime lapTimerHolder;
    public Timer getTimer() {
        return timer;
    }
	
    private void initTimer() {
        timer = new Timer(DELAY, this);
        timer.start();
    }
    
    private void initLapTimer(){
    	lastLapTimer=System.currentTimeMillis();
    	lastLap=-1;
		lapTimerHolder = 
				 new ChangesWithTime() {
					public void timeStep() {
					long newTime = System.currentTimeMillis();
					lastLap=newTime - lastLapTimer;
					if (lastLap <0 ) lastLap=0;
					lastLapTimer=newTime;
					}
				 };
				Clock.getClock().add(lapTimerHolder);
    }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		Clock.tick();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		/*System.out.println("ArenaView: start drawing arena.");
		int antscount = arenaModel.getAnts(window).size();
		System.out.println("ArenaView: ants:"+antscount);*/
		doDummyDrawing(g);
		drawRects(g);
		drawPoints(g);
		drawAnts(g);
	}
	
	private void drawRects(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		MapQuery q = new MapQuery() {
			public Shape lookupArea() {
				return window;
			}
		};
		List<MapObject> lst0 = arenaModel.getMapObjects(q);
		for (MapObject x : lst0) 
					(new RectangleView(x.enclosingRectangle(),viewTrans,Color.BLUE)).paint(g2d);
	}
	
	private void drawPoints(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		MapQuery q = new MapQuery() {
			public Shape lookupArea() {
				return window;
			}
			public Class<? extends MapObject> mapObjectNeeded() {
				return MapPointObject.class; 
			}

		};
		List<MapObject> lst0 = arenaModel.getMapObjects(q);
		for (MapObject x : lst0) 
					(new PointView(x.centrum(),viewTrans,Color.RED)).paint(g2d);
	}
	
	private void drawAnts(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		List<JComponent> animals = new ArrayList<JComponent>();
		for (OrdinaryAnt ant : arenaModel.getAnts(window))
			animals.add(new OrdinaryAntViewSimple(ant,viewTrans));
		for (JComponent x : animals)
			x.paint(g2d);
	}
	
	private void doDummyDrawing(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;
		//g2d.drawString("Points:" + arenaModel.getMapObjects(MapQueryConstructor.shape(window)).size(), 220, 20);
		//g2d.drawString("Clock clients:" + Clock.size(), 220, 40);
		//g2d.drawString("steps after cleanup:" + arenaModel.lastCleanup(), 20, 20);
		g2d.drawString("Last lap, ms:" + lastLap, 20, 40);

		// draw cross
		g2d.setColor(new Color(210, 210, 10));
		g2d.drawLine(100 - 5, 100, 100 + 5, 100);
		g2d.drawLine(100, 100 - 5, 100, 100 + 5);

	}

}
