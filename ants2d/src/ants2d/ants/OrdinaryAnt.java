package ants2d.ants;

import ants2d.geometry.Offset;
import ants2d.geometry.Point;
import ants2d.mapabstractions.ChangesWithTime;
import ants2d.mapabstractions.Constants;
import ants2d.mapabstractions.UserMapPart;

public class OrdinaryAnt implements ChangesWithTime {
	public OrdinaryAnt(UserMapPart map,Point pos) {
		currentMap = map;
		position = pos;
		direction = new Offset(0,Constants.AntSpeed);
		task = new WalkInCircleTask(this,0.01);
	}
	
	private Point position;
	private Offset direction;//speed vector
	private UserMapPart currentMap;
	private TrivialAntTask task;
	@Override
	public void timeStep() {
		// TODO Auto-generated method stub
		direction = task.newDirection();
		task = task.nextTask();
		position = position.sum(direction);
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
	public UserMapPart getCurrentMap() {
		return currentMap;
	}
	

}
