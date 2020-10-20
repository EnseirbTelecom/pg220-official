package repere.formes;

import java.util.HashSet;
import java.util.Set;

import repere.Couleur;
import repere.ElementRepere;
import repere.Repere;

public class Segment extends ElementRepere {

	private Point origine;

	private Point destination;

	public Segment(Couleur couleur, Point origine, Point destination) {
		super(couleur);
		if (origine.equals(destination))
			throw new IllegalArgumentException("Les deux points d'un segment doivent être distincts.");

		this.origine = origine;
		this.destination = destination;
	}

	public Point getOrigine() {
		return origine;
	}

	public Point getDestination() {
		return destination;
	}
	
	@Override
	public int hashCode() {
		return origine.hashCode() + 2 * destination.hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Segment))
			return false;

		Segment d = (Segment) o;
		Set<Point> points = new HashSet<Point>();
		points.add(d.getOrigine());
		points.add(d.getDestination());
		points.add(this.getOrigine());
		points.add(this.getDestination());
		return points.size() == 2;
	}

	@Override
	public boolean validePour(Repere r) {
		return origine.validePour(r) && destination.validePour(r);
	}

	@Override
	public String svg() {
		return String.format("<line x1='%d' y1='%d' x2='%d' y2='%d' style='stroke:%s'/>", origine.getX() * 10, origine.getY() * 10,
				destination.getX() * 10, destination.getY() * 10, couleur.svg());
	}

	@Override
	public String serialisation() {
		return String.format("Segment %s %s %s", couleur.serialisation(), origine.serialisation(), destination.serialisation());
	}

}
