package ants2d.map;

import ants2d.treenode.RootTreeNode;
import ants2d.treenode.TreeNode;

public class MapFactory {
	
	public static MapPart newMap(Rectangle r) {
		TreeNode<MapPart> n = new RootTreeNode<MapPart>(null);
		MapPart m = new MapObjectBag(r,n);
		n.setOwner(m);
		return m;
	}

}
