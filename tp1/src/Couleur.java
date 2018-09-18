class Couleur {

	int r;
	int g;
	int b;

	static Couleur NOIR = new Couleur(0,0,0);
	static Couleur BLANC = new Couleur(255,255,255);
	static Couleur ROUGE = new Couleur(255,0,0);
	static Couleur VERT = new Couleur(0,255,0);
	static Couleur BLEU = new Couleur(0,0,255);

	static Couleur auHasard() {
		return new Couleur((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255));
	}

	Couleur() {
		this.r = 0;
		this.g = 0;
		this.b = 0;
	}

	Couleur(int r, int g, int b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}

	int getR() {
		return r;
	}

	int getG() {
		return g;
	}

	int getB() {
		return b;
	}

	public String toString() {
		return "couleur : (" + this.r + "," + this.g + "," + this.b + ")";
	}

}
