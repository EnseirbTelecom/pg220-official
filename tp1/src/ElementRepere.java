class ElementRepere extends ElementAvecNom {
	
	Couleur couleur;
	
	ElementRepere() {
		super();
		this.couleur = Couleur.NOIR;
	}
	
	ElementRepere(Couleur couleur) {
		super();
		this.couleur = couleur;
	}
	
	ElementRepere(String titre, Couleur couleur) {
		super(titre);
		this.couleur = couleur;
	}
	
	Couleur getCouleur() {
		return this.couleur;
	}

	void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}

	public String toString() {
		return this.couleur + ", " + super.toString();
	}
	
}
