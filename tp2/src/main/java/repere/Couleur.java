package repere;

public class Couleur {
	private int r, g, b;
	
	public static Couleur noir() {
		return new Couleur(0, 0, 0);
	}
	public static Couleur blanc() {
		return new Couleur(255, 255, 255);
	}
	public static Couleur rouge() {
		return new Couleur(255, 0, 0);
	}
	public static Couleur vert() {
		return new Couleur(0, 255, 0);
	}
	public static Couleur bleu() {
		return new Couleur(0, 0, 255);
	}
	
	public static Couleur auHasard() {
		return new Couleur((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255));
	}
	
	public Couleur(int r, int g, int b) {
		super();
		setR(r);
		setG(g);
		setB(b);
	}

	public int getR() {
		return r;
	}
	private void setR(int r) {
		this.r = dansDomaine(r);
	}	
	
	public int getG() {
		return g;
	}
	private void setG(int g) {
		this.g = dansDomaine(g);
	}
	
	public int getB() {
		return b;
	}
	private void setB(int b) {	
		this.b = dansDomaine(b);
	}
	
	private int dansDomaine(int composante) {
		if ( composante < 0 )
			return 0;
		if ( composante > 255)
			return 255;

		return composante;
	}
	
	public String serialisation() {
		return String.format("[%d,%d,%d]", r, g ,b);
	}
	public String svg() {
		return String.format("rgb(%d,%d,%d)", r, g, b);
	}
}
