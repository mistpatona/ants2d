package ants2d.ants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ants2d.geometry.Offset;
import ants2d.geometry.Point;
import ants2d.geometry.Polygon;
import ants2d.geometry.Shape;
import ants2d.mapabsrtactions.impl.MapPointObject;
import ants2d.mapabstractions.Constants;
import ants2d.mapabstractions.MapObject;
import ants2d.mapabstractions.MapPayload;
import ants2d.mapabstractions.MapQuery;

public class FerromoneSensor {
	public Polygon getSensorShape(OrdinaryAnt ant) {
		Point p0 = 
				ant.getPosition().sum(ant.getDirection().scaleBy(Constants.FerroSensorForwardLook)); 
		Offset v = ant.getDirection().scaleBy(Constants.FerroSenseRadius);
		Offset vl = v.rotateBy(Constants.FerroSensorSideAngle);
		Offset vr = v.rotateBy(-Constants.FerroSensorSideAngle);
		return new Polygon(Arrays.asList(p0,p0.sum(vl),p0.sum(v),p0.sum(vr)));
	}
	
	public List<MapObject> availablePointsOld(OrdinaryAnt ant) {
		Polygon p = getSensorShape(ant);
		List<MapObject> ans = new ArrayList<MapObject>();
		for (MapObject x : ant.getCurrentMap().getObjects(p)) 
			if (x.payload() instanceof FerromoneMark && p.containsPoint(x.centrum())) 
				ans.add(x);
		return ans;
	}
	public List<MapObject> availablePoints(OrdinaryAnt ant) {
		Polygon p = getSensorShape(ant);
		MapQuery qq = new MapQuery() {
			public java.lang.Class<? extends MapObject> shapeNeeded() {//TODO:rename method
				return MapPointObject.class;
			}

			public Shape lookupArea() {
				return p;
			}

			public Class<? extends MapPayload> payloadNeeded() {
				return FerromoneMark.class;
			}
		};
		return ant.getCurrentMap().getObjects(qq);
	}
	
	public FerromoneSensorAnswer answer(OrdinaryAnt ant) {
		Point p0 = ant.getPosition();
		double left = 0;
		double right = 0;
		for (MapObject x : availablePoints(ant)) {
			Offset dx = x.centrum().sub(p0);
			double l = dx.length();
			FerromoneMark thismark = (FerromoneMark)x.payload();
			double scent = thismark.getStrength()*(l>1.0?1:1/l);
			double product = ant.getDirection().cartesianProduct(dx);// ~~ sin(alpha)
			if (product >0) {right +=scent;}
			else {left += scent;}
		}
		return new FerromoneSensorAnswer(left,right);
			
	}

}
