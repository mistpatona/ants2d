package ants2d.map;

import java.util.ArrayList;
import java.util.List;

public class TraversalClass {
	public static <A,X> X traverseTree(A a, TraversalParams<A, X> p ) {
		Iterable<A> children = p.getChildren(a);
		List<X> xs = new ArrayList<X>();
		xs.add(p.f0(a));
		for (A c : children) xs.add(traverseTree(c,p));
		return p.coalesce(xs);
	}

}
