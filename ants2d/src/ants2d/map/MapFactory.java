package ants2d.map;

import ants2d.treenode.RootTreeNode;
import ants2d.treenode.TreeNode;

public class MapFactory {
	
	public static MapPart newMap(Rectangle r) {
		TreeNode<MapPart> n = new RootTreeNode<MapPart>(null);
		MapPart b = new MapBag(r,n);
		n.setOwner(b);
		TreeNode<MapPart> nc = n.makeChild(); // n's child
		MapPart m = new MapObjectBag(r,nc);
		nc.setOwner(m);
		return b;
	}

}
