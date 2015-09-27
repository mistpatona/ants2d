package ants2d.map;

import java.util.ArrayList;
import java.util.List;

public class MapObjectBag extends AbstractMapPart {

	List<MapObject> list;

	public void removeWanting() {
		for (MapObject x : list) {
			if (x.wantsToBeRemoved())
				list.remove(x);
		}
	}

	@Override
	public Iterable<MapObject> getOwnNearbyObjects(Point p, double radius) {
		List<MapObject> ans = new ArrayList<MapObject>();
		for (MapObject x : list) {
			if (p.distanceTo(x.getCoords()) <= radius)
				ans.add(x);
		}
		return ans;
	}

	@Override
	public MapPart findMapLocally(Point p) {
		return this;
	}
	@Override
	public void add(MapObject x) {
		list.add(x);
	}
	
	protected MapObjectBag(AB area) {
		list = new ArrayList<MapObject>();
		rect = new Rectangle(area);
	}

}
