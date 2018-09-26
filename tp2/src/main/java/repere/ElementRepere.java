package repere;

public abstract class ElementRepere extends ElementAvecCouleur {

	public ElementRepere(Couleur couleur) {
		super(couleur);
	}
	
	public abstract boolean validePour(Repere r) throws ElementInvalide;
	
	public abstract String svg();
	
	public abstract String serialisation();
	
}
