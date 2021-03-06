package ants2d.map;

public class Offset extends XY {

	public Offset(double _x, double _y) {
		x = _x;
		y = _y;
	}

	public Offset(final XY xy) {
		x = xy.getX();
		y = xy.getY();
	}

	@Override
	public Offset create(double x, double y) {
		return new Offset(x, y);
	}
	
	@Override
	public Offset create(final XY that){
		return new Offset(that);
	}

	public boolean isAbs() {
		return false;
	}

	public boolean isOffs() {
		return true;
	}

}
