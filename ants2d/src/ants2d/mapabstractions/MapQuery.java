package ants2d.mapabstractions;

import ants2d.geometry.Shape;

public interface MapQuery {
	Shape lookupArea(); // can be point which means "what do I belong to?"
	Class<? extends MapObject> shapeNeeded();
	Class<? extends MapPayload> payloadNeeded();
	default int lookupLimit() { return 0; } // 0 means unlimited
}
