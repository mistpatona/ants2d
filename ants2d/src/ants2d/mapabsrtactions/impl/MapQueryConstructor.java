package ants2d.mapabsrtactions.impl;

import ants2d.geometry.Shape;
import ants2d.map.query.DumbMapQuery;
import ants2d.map.query.MapQuery;
import ants2d.mapabstractions.MapObject;

public class MapQueryConstructor {
/*	public static MapQuery empty(){
		return new MapQuery() {};
	}*/
	public static DumbMapQuery shape(Shape s){
		return new MapQuery() {
			public Shape lookupArea() {
				return s;
			}
		};
	}
	/*public static MapQuery withObject(MapQuery m, Class<? extends MapObject> m){
		return new MapQuery() {
			public Shape lookupArea() {
				return s;
			}
			public Class<? extends MapObject> mapObjectNeeded() {
				return m; 
			}
		};
	}*/

}
