package ants2d.mappart;

import java.util.ArrayList;
import java.util.List;

import ants2d.map.AB;
import ants2d.map.Point;
import ants2d.map.Rectangle;
import ants2d.mapobject.MapObject;
import ants2d.treenode.TreeNode;

public class MapBag extends AbstractMapPart {

	@Override
	public void removeWanting() {
		for (MapPart m : getChildren()) {
			m.removeWanting();
		}
	}

	public List<MapObject> getOwnNearbyObjects(Point p, double radius) {
		List<MapObject> ans = new ArrayList<MapObject>();
		for (MapPart m : getChildren()) {
			for (MapObject mo : m.getOwnNearbyObjects(p, radius)) {
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
	
	protected MapBag(AB area, TreeNode<MapPart> tn){
		rect=new Rectangle(area);
		treePlace=tn;
	}
	
	public void trySplit(int threshold) {
		for (MapPart m : getChildren()) 
			m.trySplit(threshold);
	}
}
