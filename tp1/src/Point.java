class Point extends ElementRepere {

	int x;
	int y;

	Point() {
		super();
		this.x = 0;
		this.y = 0;
	}

	Point(String titre, Couleur couleur, int x, int y) {
		super(titre, couleur);
		this.x = x;
		this.y = y;
	}

	int getX() {
		return this.x;
	}

	int getY() {
		return this.y;
	}

	public boolean equals(Object o) {
		if (o == this)
			return true;
		else if (o instanceof Point == false)
			return false;
		else {
			Point p = (Point) o;
			return p.x == this.x && p.y == this.y;
		}
	}

	public String toString() {
		return "Point (" + this.x + "," + this.y + "), " + super.toString();
	}

}
