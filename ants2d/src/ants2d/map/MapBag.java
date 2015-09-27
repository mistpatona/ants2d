package ants2d.map;

import java.util.ArrayList;
import java.util.List;

public class MapBag extends AbstractMapPart {

	@Override
	public void removeWanting() {
		for (MapPart m : getChildren()) {
			m.removeWanting();
		}
	}

	public Iterable<MapObject> getOwnNearbyObjects(Point p, double radius) {
		List<MapObject> ans = new ArrayList<MapObject>();
		for (AbstractMapPart m : getChildren()) {
			for (MapObject mo : m.getOwnNearbyObjects(p, radius)) {
				ans.add(mo);
			}
		}
		return ans;

	}

	@Override
	public MapPart findMapLocally(Point p) {
		for (MapPart m : getChildren()) {
			if (m.contains(p))
				return m.findMap(p);
		}
		throw new Error("Point belongs to no map");
	}
}
