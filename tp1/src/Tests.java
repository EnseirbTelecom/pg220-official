// Classe qui permet de vérifier le code produit dans le TP.
class Tests {
	// Point d'entrée qui permet de lancer tous les tests. Au début du TP
	// certaines lignes de compileront pas (par exemple les lignes relatives
	// à Droite tant que vous n'avez pas introduit cette class). N'hésitez pas
	// à les commenter.
	// L'exécution des tests se base sur un méthode statique verifie qui est
	// données à la suite de la méthode main.
	public static void main(String[] args) {
		// Tests relatifs à la classe Couleur
		Couleur c = new Couleur(-12, 258, 13);
		verifie("composante r négative", c.getR() == 0);
		verifie("composante g supérieure à 255", c.getG() == 255);
		verifie("composante b normale", c.getB() == 13);
		Couleur n = c.noir();
		verifie("couleur noire", n.getR() == 0 && n.getG() == 0 && n.getB() == 0);
		Couleur w = c.blanc();
		verifie("couleur blanche", w.getR() == 255 && w.getG() == 255 && w.getB() == 255);
		Couleur b = c.bleu();
		verifie("couleur bleue", b.getR() == 0 && b.getG() == 0 && b.getB() == 255);
		Couleur r = c.rouge();
		verifie("couleur rouge", r.getR() == 255 && r.getG() == 0 && r.getB() == 0);
		Couleur v = c.vert();
		verifie("couleur verte", v.getR() == 0 && v.getG() == 255 && v.getB() == 0);

		// Tests relatifs à la classe Axe
		Axe x = new Axe("Axe x", -5);
		Axe y = new Axe("Axe y", 10);
		verifie("titre axe en minuscules", x.getTitre().equals("AXE X"));
		verifie("taille axe négative", x.getTaille() == 0);
		verifie("taille axe normale", y.getTaille() == 10);
		verifie("description axe", y.description().equals("Axe taille : 10, titre : AXE Y"));

		Point p1 = new Point("p1", Couleur.noir(), -10, -3);
		Point p2 = new Point("p2", Couleur.blanc(), 0, 5);
		verifie("coordonnée point x négative", p1.getX() == 0);
		verifie("coordonnée point y négative", p1.getY() == 0);
		verifie("coordonnée point x normale", p2.getX() == 0);
		verifie("coordonnée point y normale", p2.getY() == 5);
		verifie("description point", p2.description().equals("Point (0,5) couleur : (255,255,255), titre : p2"));

		Droite d1 = new Droite("d1", Couleur.blanc(), p1, p2);
		verifie("longueur droite", d1.getLongueur() == 5D);
		verifie("description droite", d1.description().equals("Droite (0,0) -> (0,5), couleur : (255,255,255)"));

		EnsembleElementRepere e = new EnsembleElementRepere();
		verifie("ensemble vide", e.getTailleCourante() == 0);
		e.ajouterElement(p1);
		verifie("taille après ajout du point", e.getTailleCourante() == 1);
		verifie("récupération du point", e.recuperer(0) == p1);
		e.ajouterElement(d1);
		verifie("taille après ajout de la droite", e.getTailleCourante() == 2);
		verifie("récupération de la droite", e.recuperer(1) == d1);
	}

	public static void verifie(String message, boolean condition) {
		if (condition)
			System.out.println("CONFORME: " + message);
		else
			System.out.println("NON CONFORME: " + message);
	}
}
