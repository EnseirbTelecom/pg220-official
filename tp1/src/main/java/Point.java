class Point extends ElementRepere {
	int x;
	int y;

	static int rameneDansDomaine(int x) {
		if (x < 0)
			return 0;
		return x;
	}
	
	Point() {
		this("Point", Couleur.noir(), 0, 0);
	}
	Point(String titre, Couleur couleur, int x, int y) {
		super(titre, couleur);
		setX(x);
		setY(y);
	}
	
	int getX() {
		return this.x;
	}
	void setX(int x) {
		this.x = rameneDansDomaine(x);
	}
	
	int getY() {
		return this.y;
	}
	void setY(int y) {
		this.y = rameneDansDomaine(y);
	}

	String description() {
		return "Point (" + this.getX() + "," + this.getY() + "), " + super.description();
	}
}
