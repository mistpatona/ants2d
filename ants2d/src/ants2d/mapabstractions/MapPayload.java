package ants2d.mapabstractions;

public interface MapPayload {
	default boolean wantsToBeRemoved(){
		return false;
	}
}
