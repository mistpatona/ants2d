package ants2d.treenode;

import java.util.ArrayList;
import java.util.List;

public class LeafTreeNode<T> extends AbstractTreeNode<T> {
	
	public LeafTreeNode(TreeNode<T> _parent, T _owner) {
		parent = _parent;
		owner = _owner;
	}

	@Override
	public List<TreeNode<T>> getChildren() {
		return new ArrayList<TreeNode<T>>();
	}

	@Override
	public void addChild(TreeNode<T> c) {
		throw new Error("Leaf cannot add child");
	}

	@Override
	public void removeChild(TreeNode<T> c) {
		throw new Error("Leaf cannot delete child");
	}

	@Override
	public boolean isRoot() {
		return false;
	}

	@Override
	public boolean isLeaf() {
		return true;
	}

	@Override
	public boolean isPack() {
		return false;
	}

}
