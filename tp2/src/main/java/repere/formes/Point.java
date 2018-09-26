package repere.formes;

import repere.Couleur;
import repere.ElementInconsistent;
import repere.ElementInvalide;
import repere.ElementRepere;
import repere.Repere;

public class Point extends ElementRepere {
	
	private int x;
	
	private int y;
	
	public Point(Couleur couleur, int x, int y) throws ElementInconsistent{
		super(couleur);
		if (x < 0 || y < 0)
			throw new ElementInconsistent();
		else {
			this.x = x;
			this.y = y;
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	@Override
	public int hashCode() {
		return x + 10 * y;
	}

	@Override
	public boolean equals(Object o) {
		if ( !(o instanceof Point) )
			return false;
		else {
			Point p = (Point) o;
			return p.x == x && p.y == y;
		}
	}

	@Override
	public boolean validePour(Repere r) throws ElementInvalide {
		if (x <= r.getX().getTaille() && y <= r.getY().getTaille())
			return true;
		else
			throw new ElementInvalide();
	}

	@Override
	public String svg() {
		return String.format("<circle cx='%d' cy='%d' r='2' style='fill:%s'/>", x * 10, y * 10, couleur.svg());
	}

	@Override
	public String serialisation() {
		return String.format("Point (%d,%d) %s", x, y, couleur.serialisation());
	}
	
}
