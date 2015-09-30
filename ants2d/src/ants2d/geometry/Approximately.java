package ants2d.geometry;

public class Approximately {
	public static final double epsilon = 0.0001;
	public static final double bigEnough = 1/epsilon;
	public static boolean equalNZ(double p, double q) {
		return Math.abs(p-q) * bigEnough < Math.abs(p)+Math.abs(q);
	}
	/*
	 * this is used to test y's proximity to zero, by comparing it to x
	 * */
	public static boolean overhelmsByAbs(double x, double y){
		return Math.abs(x)*epsilon > Math.abs(y);
	}

}
