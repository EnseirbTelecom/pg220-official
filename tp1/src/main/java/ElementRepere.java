class ElementRepere extends ElementAvecNom {
	Couleur couleur;
	
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

	String description() {
		return this.getCouleur().description() + ", " + super.description();
	}
}
