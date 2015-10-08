package ants2d.mapabstractions;

import java.util.List;

public abstract class UserMapPartAbstractDecorator implements UserMapPart {
	
	public UserMapPartAbstractDecorator(UserMapPart m) {
		innerMap = m;
	}
	
	private UserMapPart innerMap;

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
