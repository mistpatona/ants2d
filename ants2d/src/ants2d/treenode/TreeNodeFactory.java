package ants2d.treenode;

public class TreeNodeFactory {
	public static <T> TreeNode<T> withParent(TreeNode<T> p) {
		 return new PackTreeNode<T>(p,null);
	}
	public static <T> TreeNode<T> withOwner(T owner) {
		 return new PackTreeNode<T>(null,owner);
	}
	public static <T> TreeNode<T> withParentAndOwner(TreeNode<T> p, T ow) {
		 return new PackTreeNode<T>(p,ow);
	}

}
