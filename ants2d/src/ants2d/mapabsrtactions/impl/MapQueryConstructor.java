package ants2d.mapabsrtactions.impl;

import ants2d.geometry.Shape;
import ants2d.mapabstractions.MapObject;
import ants2d.mapabstractions.MapQuery;

public class MapQueryConstructor {
/*	public static MapQuery empty(){
		return new MapQuery() {};
	}*/
	public static MapQuery shape(Shape s){
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
