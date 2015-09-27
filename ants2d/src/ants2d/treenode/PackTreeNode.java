package ants2d.treenode;

import java.util.ArrayList;
import java.util.List;

public class PackTreeNode<T> extends AbstractTreeNode<T> {
	
	List<TreeNode<T>> children;
	
	public PackTreeNode(TreeNode<T> _parent, T _owner) {
		parent = _parent;
		owner = _owner;
		children = new ArrayList<TreeNode<T>>();
	}

	@Override
	public List<TreeNode<T>> getChildren() {
		// return copy
		return new ArrayList<TreeNode<T>>(children);
	}

	@Override
	public void addChild(TreeNode<T> c) {
		//  TODO: make a copy of c ??
		c.setParent(this);
		children.add(c);
	}

	@Override
	public void removeChild(TreeNode<T> c) {
		children.remove(c);
	}

	@Override
	public boolean isRoot() {
		return false;
	}

	@Override
	public boolean hasNoChildren() {
		return children.isEmpty();
	}


}
