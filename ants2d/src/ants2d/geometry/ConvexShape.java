package ants2d.geometry;

public interface ConvexShape extends Shape {
	
	default boolean contains(Polygonic p){
		for (Point x:p.points()){
			if (!this.contains(x)) return false;
		}
		return true;
	}

}
