package ants2d.map;

public abstract class MapPartTraversalParams<X> 
		implements TraversalParams<MapPart, X> {

	@Override
	public Iterable<MapPart> getChildren(MapPart a) {
		return a.getChildren();
	}

	@Override
	public X f0(MapPart a) {
		// TODO Auto-generated method stub
		return null;
	}

	public X traverse(MapPart a) {
		return TraversalClass.traverseTree(a, this);
	}

}
