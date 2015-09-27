package ants2d.map;

import java.util.ArrayList;
import java.util.List;

import ants2d.treenode.TreeNode;

public class MapObjectBag extends AbstractMapPart {

	List<MapObject> list;

	public static final int MaxObjects = 2; // TODO: this is a development value

	public void removeWanting() {
		for (MapObject x : list) {
			if (x.wantsToBeRemoved())
				list.remove(x);
		}
	}

	@Override
	public List<MapObject> getOwnNearbyObjects(Point p, double radius) {
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
		/*
		 * if (list.size() > MaxObjects) doSplit(); -- calling object will loose
		 * track of this MapPart
		 */
	}

	protected MapObjectBag(AB area, TreeNode<MapPart> tn) {
		rect = new Rectangle(area);
		treePlace = tn;
		list = new ArrayList<MapObject>();
	}

	public void trySplit(int threshold) {
		if (list.size() > threshold)
			doSplit();
	}

	public MapBag doSplit() { // replace ObjectBag with MapBag having 4
								// ObjectBag's in it
		List<Rectangle> nr = rect.split4();
		MapBag ans = new MapBag(rect, treePlace);
		treePlace.setOwner(ans);
		for (Rectangle r : nr) {
			ans.addBagChild(r);
		}
		for (MapObject x : list) {
			ans.add(x);
		}
		// treePlace.setOwner(ans);
		return ans;
	}
}
