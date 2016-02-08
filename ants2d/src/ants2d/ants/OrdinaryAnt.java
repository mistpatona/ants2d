package ants2d.ants;

import java.util.List;

import ants2d.geometry.Offset;
import ants2d.geometry.Point;
import ants2d.geometry.Shape;
import ants2d.map.query.MapQuery;
import ants2d.mapabsrtactions.impl.MapObstacleObject;
import ants2d.mapabsrtactions.impl.MapShapeObject;
import ants2d.mapabstractions.ChangesWithTime;
import ants2d.mapabstractions.Constants;
import ants2d.mapabstractions.MapObject;
import ants2d.mapabstractions.MapObstacle;
import ants2d.mapabstractions.MapPayload;
import ants2d.mapabstractions.UserMapPart;

public class OrdinaryAnt implements ChangesWithTime {
	public OrdinaryAnt(Point pos) {
		position = pos;
		direction = new Offset(0,Constants.AntSpeed).rotateBy(Math.random()*Math.PI*2);
		task = new WalkInCircleTask(this,0.01);
		ferromoneSensor = new MobileFerromoneSensor(this);
	}
	public OrdinaryAnt(UserMapPart map,Point pos) {
		this(pos);
		currentMap = map;
	}
	
	private Point position;
	private Offset direction;//speed vector
	private UserMapPart currentMap;
	private TrivialAntTask task;
	private MobileFerromoneSensor ferromoneSensor;
	@Override
	public void timeStep() {
		// TODO Auto-generated method stub
		direction = task.newDirection();
		task = task.nextTask();
		Point pos = position.sum(direction);
		if (isPointAvailable(pos)) { position = pos;
		}
		else {direction = direction.scaleBy(-1.0); // turn around 
		}
	}
	public Point getPosition() {
		return position;
	}
	public Offset getDirection() {
		return direction;
	}
	public void setDirection(Offset d) {
		direction = d;
	}
	public void setTask(TrivialAntTask t) {
		task = t;
	}
	public void setMap(UserMapPart currentMap) {
		this.currentMap = currentMap;
	}
	public UserMapPart getCurrentMap() {
		return currentMap;
	}
	public FerromoneSensorAnswer senseFerromone() {
		return ferromoneSensor.sense();
	}
/*	public boolean isPointAvailableOld(Point p) {
		List<MapObject> lst0 = currentMap.getObjects(p);
		for (MapObject x : lst0) {
			if ((x.payload() instanceof MapObstacle)
					|| x.containsPoint(p)  ) return false;
		}
		return true;
	}*/
	public boolean isPointAvailable(Point p) {
		MapQuery qq = new MapQuery() {
			public Shape lookupArea() {
				return p;
			}
			public Class<? extends MapObject> mapObjectNeeded() {
				return MapShapeObject.class; // was MapObstacleObject
			}

			public Class<? extends MapPayload> payloadNeeded() {
				return MapObstacle.class;
			}
			
			public int lookupLimit() {
				return 1;
			}
		};
		return currentMap.getObjects(qq).isEmpty();
		
	}
	
	

}
