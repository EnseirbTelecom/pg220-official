class EnsembleElementRepere {
	
	ElementRepere[] elements;
	
	int taille = 10;
	
	int current_size = 0;
	
	EnsembleElementRepere() {
		elements = new ElementRepere[taille];
	}
	
	ElementRepere[] elements() {
		return elements;
	}
	
	void ajouter(ElementRepere element) {
		if (current_size == taille) {
			taille = taille * 2;
			ElementRepere[] tmp = elements.clone();
			elements = new ElementRepere[taille];
			for (int i = 0; i < current_size; i++)
				elements[i] = tmp[i];
		}
		elements[current_size] = element;
		current_size++;
	}
	
	int nombrePoints() {
		int cpt = 0;
		for (ElementRepere elt : elements)
			if(elt instanceof Point)
				cpt++;
		return cpt;
	}
	
	int nombreDroites() {
		int cpt = 0;
		for (ElementRepere elt : elements)
			if (elt instanceof Droite)
				cpt++;
		return cpt;
	}
	
	int taille() {
		return current_size;
	}

}
