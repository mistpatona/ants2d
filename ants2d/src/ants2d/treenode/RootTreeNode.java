package ants2d.treenode;

public class RootTreeNode<T> extends PackTreeNode<T> {

	public RootTreeNode(T _owner) {
		super(null, _owner);
	}

	@Override
	public boolean isRoot() {
		return true;
	}

	@Override
	public TreeNode<T> getParent() {
		throw new Error("root has no parent");
	}

}
