package ants2d.treenode;

import java.util.List;

public interface TreeNode<T> {
	TreeNode<T> getParent();
	void setParent(TreeNode<T> p); // is it needed here?
	List<TreeNode<T>> getChildren();
	void  addChild(TreeNode<T> c);
	void  removeChild(TreeNode<T> c);
	void  switchChild(TreeNode<T> _old, TreeNode<T> _new);
	boolean isRoot();
	boolean hasChildren();
	boolean hasNoChildren();
	T getOwner();
	void setOwner(T _owner);
}
