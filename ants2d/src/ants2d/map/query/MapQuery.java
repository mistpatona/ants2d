package ants2d.map.query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ants2d.geometry.Rectangle;
import ants2d.geometry.Shape;
import ants2d.mapabstractions.MapObject;
import ants2d.mapabstractions.MapPayload;
import ants2d.mapabstractions.ShapeOverlap;

public interface MapQuery extends DumbMapQuery {
	Shape lookupArea(); // can be point which means "what do I belong to?"
	default boolean easyCheck(MapObject x) {
		return true; //easy one, to be done *before* other checks
	}
	default Class<? extends MapObject> mapObjectNeeded(){
		return MapObject.class; // as general as possible
	}
	default Class<? extends MapPayload> payloadNeeded(){
		return MapPayload.class; // as general as possible
	}
	default boolean hardCheck(MapObject x) {
		return true; //to be done *after* all other checks
	}
	default int lookupLimit() { return 0; } // 0 means unlimited
	
	/* (non-Javadoc)
	 * @see ants2d.map.query.DumbMapQuery#test(ants2d.mapabstractions.MapObject)
	 */
	@Override
	default boolean test(MapObject x) {
		MapQuery query = this;
		Rectangle r = query.lookupArea().containingRectangle();
		return ( 	query.easyCheck(x) &&
				query.payloadNeeded().isInstance(x.payload()) &&
				query.mapObjectNeeded().isInstance(x)  &&  
			    (x.overlapWith(r) != ShapeOverlap.None) &&
			    query.hardCheck(x)
			);
	}
	default List<MapObject> filter(Collection<MapObject> input) {
		List<MapObject> ans = new ArrayList<MapObject>();
		int count = this.lookupLimit();
		if (count<=0) count = Integer.MAX_VALUE;
		for(MapObject x : input) {
			if (this.test(x)) { 
				ans.add(x); 
				if (--count <= 0) return ans;   
		   }
		}
		return ans;
	}
	
	default boolean hasCommonWith(MapQuery other) {
		return this.lookupArea().containingRectangle().overlap(
				other.lookupArea().containingRectangle()
				) != ShapeOverlap.None ;
	/*	TODO: test also query classes: Map and Payload
	 * if they can theoretically have some common result 
	 */
	};

}
