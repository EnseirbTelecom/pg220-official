package repere;

public class Couleur {
	
	private int r;
	
	private int g;	
	
	private int b;
	
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
	
	public int getG() {
		return g;
	}
	
	public int getB() {
		return b;
	}

	public void setR(int r) {
		this.r = set(r);
	}

	public void setG(int g) {
		this.g = set(g);
	}

	public void setB(int b) {	
		this.b = set(b);
	}
	
	public String svg() {
		return String.format("rgb(%d,%d,%d)", r, g, b);
	}
	
	@Override
	public int hashCode() {
		return r + 10 * g + 100 * b;
	}
	
	@Override
	public boolean equals(Object o) {
		if ( !(o instanceof Couleur) )
			return false;
		else {
			Couleur c = (Couleur) o;
			return c.r == r && c.g == g && c.b == b;
		}
	}
	
	private int set(int composante) {
		if ( composante < 0 )
			composante = 0;
		else if ( composante > 255 )
			composante = 255;
		return composante;
	}
	
	public String serialisation() {
		return String.format("[%d,%d,%d]", r, g ,b);
	}

}
