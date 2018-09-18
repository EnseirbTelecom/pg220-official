class ElementAvecNom {
	
	String titre;

	ElementAvecNom() {
		this.titre = "";
	}
	
	ElementAvecNom(String titre) {
		this.titre = titre;
	}
	
	String getTitre() {
		return this.titre;
	}

	void setTitre(String titre) {
		this.titre = titre;
	}
	
	public String toString() {
		return "titre : " + this.titre;
	}
	
}