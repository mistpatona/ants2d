package ants2d.mapabsrtactions.impl;

import java.util.List;

import ants2d.geometry.Point;
import ants2d.geometry.Shape;
import ants2d.mapabstractions.MapObject;
import ants2d.mapabstractions.MapQuery;
import ants2d.mapabstractions.UserMapPart;

public class MapEnvelope implements UserMapPart {
	
	public MapEnvelope(UserMapPart m) {
		innerMap = m;
	}
	
	public void updateInnerMap(UserMapPart m){
		innerMap = m;
	}
	
	public UserMapPart getInnerMap(){
		return innerMap;
	}

	private UserMapPart innerMap;
	@Override
	public UserMapPart getSpecificMap(Point p) {
		return innerMap.getSpecificMap(p); //TODO: don't know now
	}

	@Override
	public UserMapPart getSpecificMap(Shape s) {
		// TODO also don't know
		return innerMap.getSpecificMap(s);
	}

/*	@Override
	public List<MapObject> getObjects(Shape s) {
		return innerMap.getObjects(s);
	}*/

	@Override
	public void add(MapObject newObject) {
		innerMap.add(newObject);
	}

	@Override
	public void removeAllWanting() {
		innerMap.removeAllWanting();
	}

	@Override
	public List<MapObject> getObjects(MapQuery query) {
		return innerMap.getObjects(query);
	}

}
