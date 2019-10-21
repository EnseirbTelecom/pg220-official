package repere;

public class Axe extends ElementAvecCouleur {
	private String titre;
	private int taille;

	public Axe(Couleur couleur, String titre, int taille) throws AxeInconsistent {
		super(couleur);
		this.titre = titre;
		if (taille < 1)
			throw new AxeInconsistent();
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
