class Axe extends ElementAvecNom {
	
	int taille;
	
	Axe() {
		super();
		this.taille = 10;
	}
	
	Axe(int taille) {
		super();
		this.taille = taille;
	}
	
	Axe(String titre, int taille) {
		setTitre(titre);
		this.taille = taille;
	}
	
	@Override
	void setTitre(String titre) {
		this.titre = titre.toUpperCase();
	}
	
	int getTaille() {
		return this.taille;
	}

	void setTaille(int taille) {
		this.taille = taille;
	}
	
	public String toString() {
		return "Axe taille : " + this.taille + ", " + super.toString();
	}
}
