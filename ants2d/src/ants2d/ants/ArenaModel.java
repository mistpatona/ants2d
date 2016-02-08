package ants2d.ants;

import java.util.ArrayList;
import java.util.List;

import ants2d.geometry.Point;
import ants2d.geometry.Shape;
import ants2d.map.query.MapQuery;
import ants2d.mapabsrtactions.impl.MapEnvelope;
import ants2d.mapabsrtactions.impl.SimpleUserMap;
import ants2d.mapabstractions.ChangesWithTime;
import ants2d.mapabstractions.Clock;
import ants2d.mapabstractions.MapObject;
import ants2d.mapabstractions.UserMapPart;

/**
 * The whole model of MVC pattern
 * @author sergey
 *
 */
public class ArenaModel {
	
	public ArenaModel() {
		map = new MapEnvelope(new SimpleUserMap());
		ants = new ArrayList<OrdinaryAnt>();
		//System.out.println("Arena model inited");
		cleanupHolder = 
		 new ChangesWithTime() {
			public void timeStep() {
				float x = (float)Math.random();
				if (x < 0.05) {
					map.removeAllWanting();
					lastCleanup=0;
				}
				else {lastCleanup++;}
			}
		 };
		Clock.getClock().add(cleanupHolder);
	}
	private final List<OrdinaryAnt> ants;
	private final UserMapPart map;
	private Integer lastCleanup = 0;
	private ChangesWithTime cleanupHolder;  //otherwise, the cleaner will be GC'ed
	                                        // from weak collection

	public int lastCleanup() {
		return lastCleanup;
	}
	
	public void addAnt(OrdinaryAnt ant) {
		ants.add(ant);
		ant.setMap(map);
		Clock.getClock().add(ant);
	}
	
	public void addMapObject(MapObject x){
		map.add(x);
	}
	
	public OrdinaryAnt addOrdinaryAnt(Point p) {
		OrdinaryAnt ant = new OrdinaryAnt(map,p);
		addAnt(ant);
		return ant;
	}
	
	/**
	 * wrapper around map
	 * @param s - shape
	 */
	public List<MapObject> getMapObjects(MapQuery q){
		return map.getObjects(q);
	}
	public List<OrdinaryAnt> getAnts(Shape s){
		return ants;
	}
}
