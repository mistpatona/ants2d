package ants2d.mapabstractions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ants2d.geometry.Rectangle;

public interface MapQueryFilter extends MapQuery {
/*	default List<MapObject> filter(Collection<MapObject> input) {
		MapQuery query = this;
		List<MapObject> ans = new ArrayList<MapObject>();
		Rectangle r = query.lookupArea().containingRectangle();
		int count = query.lookupLimit();
		if (count<=0) count = Integer.MAX_VALUE;
		for(MapObject x : input){
			if ( 	query.easyCheck(x) &&
					query.payloadNeeded().isInstance(x.payload()) &&
					query.mapObjectNeeded().isInstance(x)  &&  
				    (x.overlapWith(r) != ShapeOverlap.None) &&
				    query.hardCheck(x)
				)
				   { ans.add(x); 
				     if (--count <= 0) return ans;   
				   } 
		}
		return ans;
	}*/

}
