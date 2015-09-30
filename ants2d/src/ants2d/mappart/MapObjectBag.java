package ants2d.mappart;

import java.util.ArrayList;
import java.util.List;

import ants2d.geometry.Point;
import ants2d.geometry.RectShape;
import ants2d.geometry.Rectangle;
import ants2d.mapobject.MapPoint;
import ants2d.treenode.TreeNode;

public class MapObjectBag extends AbstractMapPart {

	List<MapPoint> list;

	public static final int MaxObjects = 2; // TODO: this is a development value

	public void removeWanting() {
		for (MapPoint x : list) {
			if (x.wantsToBeRemoved())
				list.remove(x);
		}
	}

	@Override
	public List<MapPoint> getOwnNearbyObjects(Point p, double radius) {
		List<MapPoint> ans = new ArrayList<MapPoint>();
		for (MapPoint x : list) {
			if (p.distanceTo(x.getCoords()) <= radius)
				ans.add(x);
		}
		return ans;
	}
	@Override
	public List<MapPoint> getOwnNearbyObjects(Rectangle r) {
		List<MapPoint> ans = new ArrayList<MapPoint>();
		for (MapPoint x : list) {
			if (r.contains(x.getCoords()))
				ans.add(x);
		}
		return ans;
	}

	@Override
	public MapPart findMapLocally(Point p) {
		return this;
	}

	@Override
	public void add(MapPoint x) {
		list.add(x);
		/*
		 * if (list.size() > MaxObjects) doSplit(); -- calling object will loose
		 * track of this MapPart
		 */
	}

	protected MapObjectBag(RectShape area, TreeNode<MapPart> tn) {
		rect = new Rectangle(area);
		treePlace = tn;
		list = new ArrayList<MapPoint>();
	}

	public void trySplit(int threshold) {
		if (list.size() > threshold)
			doSplit();
	}

	public MapBag doSplit() { // replace ObjectBag with MapBag having 2
								// ObjectBag's in it
		List<Rectangle> nr = rect.split2();
		MapBag ans = new MapBag(rect, treePlace);
		treePlace.setOwner(ans);
		for (Rectangle r : nr) {
			ans.addBagChild(r);
		}
		for (MapPoint x : list) {
			ans.add(x);
		}
		// treePlace.setOwner(ans);
		return ans;
	}
}
