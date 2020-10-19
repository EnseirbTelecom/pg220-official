package repere.formes;

import java.util.HashSet;
import java.util.Set;

import repere.Couleur;
import repere.ElementRepere;
import repere.Repere;

public class Triangle extends ElementRepere {
	
	private Point p1;
	private Point p2;
	private Point p3;
		
	public Triangle(Couleur couleur, Point p1,  Point p2,  Point p3) {
		super(couleur);
		if ((p1.equals(p2) || p1.equals(p3) || p2.equals(p3)) || aligned(p1, p2, p3))
			throw new IllegalArgumentException("Les trois points d'un triangle doivent être distincts et non alignés.");

		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}
	
	private boolean aligned(Point p1, Point p2, Point p3) {
		int absV1 = p2.getX() - p1.getX();
		int ordV1 = p2.getY() - p1.getY();
		int absV2 = p3.getX() - p2.getX();
		int ordV2 = p3.getY() - p2.getY();
		int pv = absV1 * ordV2 - absV2 * ordV1; 
		return pv == 0;
	}
	
	@Override
	public int hashCode() {
		return p1.hashCode() + p2.hashCode() + p3.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		if ( !(o instanceof Triangle) )
			return false;

		Triangle t = (Triangle) o;
		Set<Point> points = new HashSet<Point>();
		points.add(t.p1);
		points.add(t.p2);
		points.add(t.p3);
		points.add(p1);
		points.add(p2);
		points.add(p3);
		return points.size() == 3;
	}

	@Override
	public boolean validePour(Repere r) {
		return p1.validePour(r) && p2.validePour(r) && p3.validePour(r);
	}

	@Override
	public String svg() {
		Segment s1 = new Segment(couleur, p1, p2);
		Segment s2 = new Segment(couleur, p2, p3);
		Segment s3 = new Segment(couleur, p3, p1);
		return s1.svg() + s2.svg() + s3.svg();
	}

	@Override
	public String serialisation() {
		return String.format("Triangle %s %s %s %s", couleur.serialisation(), p1.serialisation(), p2.serialisation(), p3.serialisation());
	}
	
}
