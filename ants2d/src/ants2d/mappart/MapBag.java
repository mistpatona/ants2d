package ants2d.mappart;

import java.util.ArrayList;
import java.util.List;

import ants2d.geometry.Point;
import ants2d.geometry.RectShape;
import ants2d.geometry.Rectangle;
import ants2d.mapobject.MapPoint;
import ants2d.treenode.TreeNode;

public class MapBag extends AbstractMapPart {

	@Override
	public void removeWanting() {
		for (MapPart m : getChildren()) {
			m.removeWanting();
		}
	}

	public List<MapPoint> getOwnNearbyObjects(Point p, double radius) {
		List<MapPoint> ans = new ArrayList<MapPoint>();
		for (MapPart m : getChildren()) {
			for (MapPoint mo : m.getOwnNearbyObjects(p, radius)) {
				ans.add(mo);
			}
		}
		return ans;
	}
	public List<MapPoint> getOwnNearbyObjects(Rectangle r) {
		List<MapPoint> ans = new ArrayList<MapPoint>();
		for (MapPart m : getChildren()) {
			for (MapPoint mo : m.getOwnNearbyObjects(r)) {
				ans.add(mo);
			}
		}
		return ans;
	}

	public void addBagChild(Rectangle r) {
		 TreeNode<MapPart> c = treePlace.makeChild();
		 MapPart m = new MapObjectBag(r,c);
		 c.setOwner(m);
	}
	
	@Override
	public MapPart findMapLocally(Point p) {
		for (MapPart m : getChildren()) {
			if (m.contains(p))
				return m.findMap(p);
		}
		throw new Error("Point belongs to no map");
	}
	
	protected MapBag(RectShape area, TreeNode<MapPart> tn){
		rect=new Rectangle(area);
		treePlace=tn;
	}
	
	public void trySplit(int threshold) {
		for (MapPart m : getChildren()) 
			m.trySplit(threshold);
	}
}
