class Couleur {
	int r;
	int g;
	int b;
	
	static Couleur noir() {
		return new Couleur(0, 0, 0);
	} 
	static Couleur blanc() {
		return new Couleur(255, 255, 255);
	}
	static Couleur rouge() {
		return new Couleur(255, 0, 0);
	} 
	static Couleur vert() {
		return new Couleur(0, 255, 0);
	}
	static Couleur bleu() {
		return new Couleur(0, 0, 255);
	} 

	static Couleur auHasard() {
		return new Couleur((int) (Math.random() * 255),
			(int) (Math.random() * 255), (int) (Math.random() * 255));
	}

	static int rameneDansDomaine(int x) {
		if (x < 0)
			return 0;
		if (x > 255)
			return 255;
		return x;
	}
	
	Couleur() {
		this(0, 0, 0);
	}
	Couleur(int r, int g, int b) {
		setR(r);
		setG(g);
		setB(b);
	}
	
	int getR() {
		return r;
	}
	void setR(int r) {
		this.r = rameneDansDomaine(r);
	}
	
	int getG() {
		return g;
	}
	void setG(int g) {
		this.g = rameneDansDomaine(g);
	}
	
	int getB() {
		return b;
	}
	void setB(int b) {
		this.b = rameneDansDomaine(b);
	}

	String description() {
		return "couleur : (" + this.getR() + "," + this.getG() + "," + this.getB() + ")";
	}
}
