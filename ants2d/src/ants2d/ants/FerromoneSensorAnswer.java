package ants2d.ants;

public class FerromoneSensorAnswer {
	private double l,r;
	public FerromoneSensorAnswer(double _l,double _r){
		l=Math.abs(_l);
		r=Math.abs(_r); // just in case, to prevent catastrophe if negative
	}
	public double getL() {return l;}
	public double getR() {return r;}
	
	public boolean something() {
		return (!nothing());
	}
	public boolean nothing() {
		return zero(l+r);
	}
	
	public double angle() {
		if (nothing()) return 0;
		if (zero(l)) return 0.15;
		if (zero(r)) return -0.25; // some faster rotation left, for research purpose
		double s = Math.signum(r-l); 
		double k = 0.5*Math.abs(r-l)/(r+l); // TODO:need some more coefficient
		return s*k*k;
	}
	
	private boolean zero(double x) {
		return Math.abs(x) < 1.0e-5;
	}
}
