package repere;

public abstract class ElementAvecCouleur {
	
	protected Couleur couleur;

	public ElementAvecCouleur(Couleur couleur) {
		this.couleur = couleur;
	}
	
	public Couleur getCouleur() {
		return couleur;
	}

	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}
	
}
