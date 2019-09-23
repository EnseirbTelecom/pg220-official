class ElementAvecNom {
	String titre;
	
	ElementAvecNom(String titre) {
		this.titre = titre;
	}
	
	String getTitre() {
		return this.titre;
	}

	void setTitre(String titre) {
		this.titre = titre;
	}
	
	String description() {
		return "titre : " + this.getTitre();
	}
}