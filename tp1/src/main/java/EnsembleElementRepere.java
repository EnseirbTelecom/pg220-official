class EnsembleElementRepere {
	ElementRepere[] elements;
	int tailleMaximale = 10;
	int tailleCourante = 0;
	
	EnsembleElementRepere() {
		elements = new ElementRepere[tailleMaximale];
	}
	
	ElementRepere recuperer(int index) {
		return elements[index];
	}
	
	void ajouterElement(ElementRepere element) {
		if (tailleCourante == tailleMaximale) {
			tailleMaximale = tailleMaximale * 2;
			ElementRepere[] tmp = elements.clone();
			elements = new ElementRepere[tailleMaximale];
			for (int i = 0; i < tailleCourante; i++)
				elements[i] = tmp[i];
		}
		elements[tailleCourante] = element;
		tailleCourante++;
	}

	int getTailleCourante() {
		return this.tailleCourante;
	}
}
