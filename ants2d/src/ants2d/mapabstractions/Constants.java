package ants2d.mapabstractions;

public class Constants {
	/** how much ant runs in one clock tick */
	public static final double AntSpeed=1; 
	/** how far to look for sensed ferromone points*/
	public static final double FerroSenseRadius = AntSpeed * 3;
	/** angle in radians */
	public static final double FerroSensorSideAngle = 15 * Math.PI / 180.0;
	/** in what distance to lay next marker*/
	public static final double FerroMarkerStep =5*AntSpeed;
	public static final int FerroMarkerStepCount = 5;
	
	public static final double FerroMarkInitialStrength = 100;
	public static final double FerroMarkFadeMutiplier = 0.85;	
	public static final double FerroMarkFadeAway = 0.01;
}