class Droite extends ElementRepere {

	Point origine;
	Point destination;

	Droite() {
		super();
		this.origine = new Point();
		this.destination = new Point("", new Couleur(), 1, 1);
	}

	Droite(String titre, Couleur couleur, Point origine, Point destination) {
		super(titre, couleur);
		this.origine = origine;
		this.destination = destination;
	}

	Point getOrigine() {
		return this.origine;
	}

	Point getDestination() {
		return this.destination;
	}

	public boolean equals(Object o) {
		if (o == this)
			return true;
		else if (o instanceof Droite == false)
			return false;
		else {
			Droite d = (Droite) o;
			return d.origine.equals(this.origine) && d.destination.equals(this.destination);
		}
	}

	public String toString() {
		return "Droite (" + this.origine.getX() + "," + this.origine.getY() + ") -> (" +
				this.destination.getX() + "," + this.destination.getY() + "), " + super.toString();
	}

	double getLongueur() {
		return Math.sqrt(Math.pow(Math.abs(origine.getX() - destination.getX()), 2) +
				Math.pow(Math.abs(origine.getY() - destination.getY()), 2));
	}
}
