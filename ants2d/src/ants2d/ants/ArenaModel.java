package ants2d.ants;

import java.util.ArrayList;
import java.util.List;

import ants2d.geometry.Point;
import ants2d.geometry.Shape;
import ants2d.mapabsrtactions.impl.SimpleUserMap;
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
		map = new SimpleUserMap();
		ants = new ArrayList<OrdinaryAnt>();
	}
	private List<OrdinaryAnt> ants;
	private UserMapPart map;
	
	public void addAnt(OrdinaryAnt ant) {
		ants.add(ant);
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
	List<MapObject> getMapObjects(Shape s){
		return map.getObjects(s);
	}
}
