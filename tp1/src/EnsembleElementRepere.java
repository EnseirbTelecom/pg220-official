class EnsembleElementRepere {

	ElementRepere[] elements;

	int taille = 0;

	EnsembleElementRepere() {
		elements = new ElementRepere[10];
	}

	ElementRepere[] elements() {
		return elements;
	}

	void ajouter(ElementRepere element) {
		for (int i = 0; i < taille; i++) {
			if (elements[i].equals(element)) {
				return;
			}
		}
		if (taille == elements.length) {
			ElementRepere[] newElements = new ElementRepere[taille * 2];
			for (int i = 0; i < elements.length; i++) {
				newElements[i] = elements[i];
			}
			elements = newElements;
		}
		elements[taille] = element;
		taille++;
	}

	int taille() {
		return taille;
	}

}
