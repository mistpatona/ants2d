package ants2d.map;

public interface TraversalParams<A, X> {
  X coalesce(Iterable<X> xs);
  Iterable<A> getChildren(A a);
  X f0(A a);
}
