package repere;

public class Axe extends ElementAvecCouleur {
	private String titre;
	private int taille;

	public Axe(Couleur couleur, String titre, int taille) {
		super(couleur);
		this.titre = titre;
		if (taille < 1)
			throw new IllegalArgumentException("Une taille d'axe doit être supérieure à 0.");
		else
			this.taille = taille;
	}

	public String getTitre() {
		return titre;
	}

	public int getTaille() {
		return taille;
	}
	
	public String serialisation() {
		return String.format("Axe %d %s %s", taille, couleur.serialisation(), titre);
	}
}
