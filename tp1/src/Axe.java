class Axe extends ElementAvecNom {
	int taille;

	static int rameneDansDomaine(int x) {
		if (x < 0)
			return 0;
		return x;
	}
	
	Axe() {
		this("AXE", 0);
	}
	
	Axe(int taille) {
		this("AXE", taille);
	}
	
	Axe(String titre, int taille) {
		super(titre.toUpperCase());
		setTaille(taille);
	}
	
	@Override
	void setTitre(String titre) {
		this.titre = titre.toUpperCase();
	}
	
	int getTaille() {
		return this.taille;
	}

	void setTaille(int taille) {
		this.taille = rameneDansDomaine(taille);
	}
	
	String description() {
		return "Axe taille : " + this.getTaille() + ", " + super.description();
	}
}
