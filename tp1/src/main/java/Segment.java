class Segment extends ElementRepere {
	Point origine;
	Point destination;
	
	Segment() {
		this("Segment", Couleur.noir(), new Point(), new Point());
	}
	Segment(String titre, Couleur couleur, Point origine, Point destination) {
		super(titre, couleur);
		setOrigine(origine);
		setDestination(destination);
	}
	
	Point getOrigine() {
		return this.origine;
	}
	void setOrigine(Point origine) {
		this.origine = origine;
	}
	
	Point getDestination() {
		return this.destination;
	}
	void setDestination(Point destination) {
		this.destination = destination;
	}

	String description() {
		return "Segment (" + this.getOrigine().getX() + "," + this.getOrigine().getY() + ") -> (" +
				this.getDestination().getX() + "," + this.getDestination().getY() + "), " + this.getCouleur().description() + ", titre : " + this.getTitre();
	}
	
	double getLongueur() {
		return Math.sqrt(Math.pow(Math.abs(this.getOrigine().getX() - this.getDestination().getX()), 2) +
				Math.pow(Math.abs(this.getOrigine().getY() - this.getDestination().getY()), 2));
	}
}
