package repere.formes;

import repere.Couleur;
import repere.ElementInconsistent;
import repere.ElementInvalide;
import repere.ElementRepere;
import repere.Repere;

public class Cercle extends ElementRepere {
	
	private Point centre;
	private int rayon;
		
	public Cercle(Couleur couleur, Point centre, int rayon) throws ElementInconsistent {
		super(couleur);
		if (rayon <= 0)
			throw new ElementInconsistent();
		else {
			new Point(couleur, centre.getX() - rayon, centre.getY() - rayon);
			this.centre = centre;
			this.rayon = rayon;
		}
	}
	
	@Override
	public int hashCode() {
		return rayon + 2 * centre.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		if ( !(o instanceof Cercle) )
			return false;
		else {
			Cercle c = (Cercle) o;
			return c.rayon == this.rayon && c.centre.equals(this.centre);
		}
	}

	@Override
	public boolean validePour(Repere r) throws ElementInvalide {
		Point p = new Point(couleur, centre.getX() + rayon, centre.getY() + rayon);
		return p.validePour(r);
	}

	@Override
	public String svg() {
		return String.format("<circle cx='%d' cy='%d' r='%d' style='fill:%s'/>", centre.getX() * 10, 
				centre.getY() * 10, rayon * 10, couleur.svg());
	}

	@Override
	public String serialisation() {
		return String.format("Cercle %d %s %s", rayon, couleur.serialisation(), centre.serialisation());
	}
	
}
