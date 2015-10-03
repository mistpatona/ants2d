package ants2d.mapabstractions;

public interface ChangesWithTime {
	 void timeStep();
	 default boolean isOver() {
		 return false;
	 }

}
