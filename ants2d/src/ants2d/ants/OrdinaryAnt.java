package ants2d.ants;

import ants2d.geometry.Offset;
import ants2d.geometry.Point;
import ants2d.mapabstractions.ChangesWithTime;
import ants2d.mapabstractions.UserMapPart;

public class OrdinaryAnt implements ChangesWithTime {
	private Point position;
	private Offset direction;
	private UserMapPart currentMap;
	@Override
	public void timeStep() {
		// TODO Auto-generated method stub

	}
	public Point getPosition() {
		return position;
	}
	public UserMapPart getCurrentMap() {
		return currentMap;
	}
	

}
