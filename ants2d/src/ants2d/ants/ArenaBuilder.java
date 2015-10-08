package ants2d.ants;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ants2d.geometry.Offset;
import ants2d.geometry.Point;
import ants2d.geometry.Rectangle;
import ants2d.mapabsrtactions.impl.MapObstacleRectangleObject;
import ants2d.mapabstractions.Clock;

public class ArenaBuilder {
	public  List<Rectangle>
			rectangularPit(	Point p0, // NW corner inside 
							double t, // thickness
							Offset d // internal dimentions
							){
		List<Rectangle> ans = new ArrayList<Rectangle>();
		Offset tt = new Offset(t,t);
		Offset w = new Offset(d.getX(),0);
		Offset h = new Offset(0,d.getY());
		Offset tw = new Offset(t,0);
		ans.add(new Rectangle(p0.sub(tt), p0.sum(w)));
		ans.add(new Rectangle(p0.sum(w).sum(tw).sub(tt),p0.sum(d).sum(tt)));
		ans.add(new Rectangle(p0.sub(tt), p0.sum(h)));
		ans.add(new Rectangle(p0.sum(h).sub(tw),p0.sum(d).sum(tt)));
		return ans;
	}
	
	public  List<Rectangle>
	rectangularPit(Rectangle r, double t) {
		return rectangularPit(r.getP0(),t,r.dimentions());
	}
	Random rnd = new Random();
	public ArenaModel build0() {
		
		ArenaModel ans = new ArenaModel();
		
		Point pit0 = new Point(100,100);
		Offset pitSize = new Offset(600,500);
		OrdinaryAnt ant; // = new MarkerAnt(pit0.sum(randomOffset(pitSize)));
/*		ant.setTask(new WanderingTask(ant));
		ans.addAnt(ant);
		ant.setDirection(ant.getDirection().scaleBy(2));*/
		
		
		
		 ant = new MarkerAnt(pit0.sum(randomOffset(pitSize)));
			ant.setTask(new WalkFollowingFerromoneTask(ant));
			ans.addAnt(ant);
			
			for(int i=0;i<17;i++)
			{
			ant = new MarkerAnt(pit0.sum(randomOffset(pitSize)));
			ant.setTask(new WalkFollowingFerromoneTask(ant));
			ans.addAnt(ant);
			}
			for(int i=0;i<4;i++)
			{
				ant = new MarkerAnt(pit0.sum(randomOffset(pitSize)));
			ant.setTask(new LimitedAntTask( new WalkFollowingFerromoneTask(ant),rnd.nextInt(100),
					    					new WanderingTask(ant)));
			ant.setDirection(ant.getDirection().scaleBy(2));
			ans.addAnt(ant);
			}
		for(Rectangle r: rectangularPit(pit0, 10, pitSize))
			ans.addMapObject(new MapObstacleRectangleObject(r));
		return ans;
	}
	
	private Offset randomOffset(Offset limit) {
		return limit.create(rnd.nextDouble()*limit.getX(), rnd.nextDouble()*limit.getY());
	}
			
			
}
