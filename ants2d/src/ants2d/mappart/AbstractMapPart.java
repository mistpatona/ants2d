package ants2d.mappart;

import java.util.ArrayList;
import java.util.List;

import ants2d.geometry.Point;
import ants2d.geometry.Rectangle;
import ants2d.mapobject.MapPoint;
import ants2d.treenode.TreeNode;

public abstract class AbstractMapPart implements MapPart {

	protected TreeNode<MapPart> treePlace;
	protected Rectangle rect;

	// @Override
	public MapPart getParent() {
		return treePlace.getParent().getOwner();
	}

	public boolean isRoot() {
		return treePlace.isRoot();
	}

	public List<MapPart> getChildren() {
		List<MapPart> ans = new ArrayList<MapPart>();
		for (TreeNode<MapPart> c : treePlace.getChildren()) {
			ans.add(c.getOwner());
		}
		return ans;
	}

	@Override
	public MapPart findMap(Point p) {
		if (rect.contains(p) || isRoot()) {
			return findMapLocally(p);
		} else {
			return getParent().findMap(p);
		}
	}

	public abstract MapPart findMapLocally(Point p);

	public boolean contains(Point p) {
		return rect.contains(p);
	}

	public List<MapPoint> getNearbyObjects(Point p, double radius) {
		if (rect.containsCircle(p, radius) || isRoot()) {
			return getOwnNearbyObjects(p, radius);
		} else {
			return getParent().getNearbyObjects(p, radius);
		}

	}
	
	public List<MapPoint> getNearbyObjects(Rectangle r) {
		if (rect.overlaps(r) || isRoot()) {
			return getOwnNearbyObjects(r);
		} else {
			return getParent().getNearbyObjects(r);
		}

	}

	public abstract List<MapPoint> getOwnNearbyObjects(Point p, double radius);

	@Override
	public void add(MapPoint x) {
		findMap(x.getCoords()).add(x);
	}
	
	public Rectangle getRectangle(){
		return new Rectangle(rect);
	}

}
