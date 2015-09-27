package ants2d.treenode;

public abstract class AbstractTreeNode<T> implements TreeNode<T> {

	protected TreeNode<T> parent;
	protected T owner;

	@Override
	public TreeNode<T> getParent() {
		return parent;
	}

	@Override
	public void setParent(TreeNode<T> p) {
		parent = p;
	}

	@Override
	public void setOwner(T _owner) {
		owner = _owner;
	}

	@Override
	public T getOwner() {
		return owner;
	}

	@Override
	public void switchChild(TreeNode<T> _old, TreeNode<T> _new) {
		removeChild(_old);
		addChild(_new);

	}

	public boolean hasChildren() {
		return !hasNoChildren();
	}

}
