package repere;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import repere.formes.*;

public class TestRepere {
	@Test
	public void testAjouter() throws HorsRepereException {
		Repere r = new Repere("", new Axe(Couleur.noir(), "", 20), new Axe(Couleur.noir(), "", 20));
		Point p1 = new Point(Couleur.noir(), 5, 5);
		Point p2 = new Point(Couleur.noir(), 7, 5);
		Point p3 = new Point(Couleur.noir(), 7, 5);
		r.ajouter(p1);
		r.ajouter(p2);
		r.ajouter(p3);
		Assertions.assertEquals(2, r.getElements().size());
	}

	@Test
	public void testAjouterPointHorsRepere() throws HorsRepereException {
		Repere r = new Repere("", new Axe(Couleur.noir(), "", 20), new Axe(Couleur.noir(), "", 20));
		Point p1 = new Point(Couleur.noir(), 21, 20);
		Assertions.assertThrows(HorsRepereException.class, () -> {
			r.ajouter(p1);
		});
		Point p2 = new Point(Couleur.noir(), 20, 20);
		r.ajouter(p2);
		Assertions.assertEquals(1, r.getElements().size());
	}

	@Test
	public void testAjouterTriangleHorsRepere() throws HorsRepereException {
		Repere r = new Repere("", new Axe(Couleur.noir(), "", 20), new Axe(Couleur.noir(), "", 20));
		Triangle t = new Triangle(Couleur.noir(), new Point(Couleur.noir(), 21, 20), new Point(Couleur.noir(), 0, 0), new Point(Couleur.noir(), 1, 1));
		Assertions.assertThrows(HorsRepereException.class, () -> {
			r.ajouter(t);
		});
	}

	@Test
	public void testAjouterCercleHorsRepere() throws HorsRepereException {
		Repere r = new Repere("", new Axe(Couleur.noir(), "", 5), new Axe(Couleur.noir(), "", 5));
		Cercle c1 = new Cercle(Couleur.noir(), new Point(Couleur.noir(), 1, 1), 1);
		r.ajouter(c1);
		Assertions.assertEquals(1, r.getElements().size());
		Cercle c2 = new Cercle(Couleur.noir(), new Point(Couleur.noir(), 3, 4), 2);
		Assertions.assertThrows(HorsRepereException.class, () -> {
			r.ajouter(c2);
		});
		Cercle c3 = new Cercle(Couleur.noir(), new Point(Couleur.noir(), 4, 3), 2);
		Assertions.assertThrows(HorsRepereException.class, () -> {
			r.ajouter(c3);
		});
	}

	@Test
	public void testSerialisation() throws HorsRepereException, IOException {
		String def = "Repere titre\n" +
				"Axe 10 [255,255,255] titre\n" +
				"Axe 10 [255,255,255] titre\n" +
				"Point (0,0) [0,255,0]\n" +
				"Point (3,6) [0,255,0]\n" +
				"Point (2,2) [0,255,0]\n" +
				"Segment [0,255,0] Point (3,3) [0,255,0] Point (6,6) [0,255,0]\n" +
				"Segment [0,255,0] Point (1,1) [0,255,0] Point (5,5) [0,255,0]\n" + 
				"Cercle 2 [0,0,255] Point (2,2) [0,0,255]\n" +
				"Triangle [0,0,255] Point (1,1) [0,0,255] Point (2,1) [0,0,255] Point (2,2) [0,0,255]\n";
		
		Repere r = Repere.charger(new StringReader(def));
		Assertions.assertEquals("titre", r.getTitre());
		Assertions.assertEquals("titre", r.getX().getTitre());
		Assertions.assertEquals("titre", r.getY().getTitre());
		Assertions.assertEquals(10, r.getX().getTaille());
		Assertions.assertEquals(10, r.getY().getTaille());
		Assertions.assertTrue(r.getElements().contains(new Point(Couleur.vert(), 0, 0)));
		Assertions.assertTrue(r.getElements().contains(new Point(Couleur.vert(), 3, 6)));
		Assertions.assertTrue(r.getElements().contains(new Point(Couleur.vert(), 2, 2)));
		Assertions.assertTrue(r.getElements().contains(new Segment(Couleur.vert(), new Point(Couleur.vert(), 3, 3), new Point(Couleur.vert(), 6, 6))));
		Assertions.assertTrue(r.getElements().contains(new Segment(Couleur.vert(), new Point(Couleur.vert(), 1, 1), new Point(Couleur.vert(), 5, 5))));
		Assertions.assertTrue(r.getElements().contains(new Cercle(Couleur.bleu(), new Point(Couleur.bleu(), 2, 2), 2)));
		Assertions.assertTrue(r.getElements().contains(new Triangle(Couleur.bleu(), new Point(Couleur.bleu(), 1, 1), 
				new Point(Couleur.bleu(), 2, 1), new Point(Couleur.bleu(), 2, 2))));
				Assertions.assertEquals(7, r.getElements().size());
		
		StringWriter w = new StringWriter();
		r.sauvegarder(w);
		
		Set<String> linesDef = new HashSet<String>(Arrays.asList(def.split("\\n")));
		Set<String> lines = new HashSet<String>(Arrays.asList(w.toString().split("\\n")));
		Assertions.assertEquals(linesDef, lines);
	}
	
	@Test
	public void testDessiner() throws IOException, HorsRepereException {
		String def = "<?xml version='1.0' encoding='utf-8'?>\n" +
				"<svg xmlns='http://www.w3.org/2000/svg' version='1.1' width='200' height='200'>\n" +
				"<line x1='0' y1='0' x2='200' y2='0' style='stroke:rgb(0,0,0);stroke-width:3' />\n" +
				"<line x1='0' y1='0' y2='200' x2='0' style='stroke:rgb(0,0,0);stroke-width:3' />\n" +
				"<line x1='10' y1='20' x2='30' y2='90' style='stroke:rgb(0,0,0)'/>\n" +
				"<line x1='50' y1='50' x2='30' y2='50' style='stroke:rgb(255,0,0)'/><line x1='30' y1='50' x2='20' y2='10' style='stroke:rgb(255,0,0)'/><line x1='20' y1='10' x2='50' y2='50' style='stroke:rgb(255,0,0)'/>\n" +
				"<circle cx='10' cy='10' r='2' style='fill:rgb(0,255,0)'/>\n" +
				"<circle cx='150' cy='150' r='30' style='fill:rgb(255,0,0)'/>\n" +
				"</svg>";
		
		Repere r = new Repere("Exemple", new Axe(Couleur.noir(), "X", 20), new Axe(Couleur.noir(), "Y", 20));
		Point p = new Point(Couleur.vert(), 1, 1);
		Segment d = new Segment(Couleur.noir(), new Point(Couleur.noir(), 1, 2), new Point(Couleur.noir(), 3, 9));
		Cercle c = new Cercle(Couleur.rouge(), new Point(Couleur.noir(), 15, 15), 3);
		Triangle t = new Triangle(Couleur.rouge(), new Point(Couleur.noir(), 5, 5), new Point(Couleur.noir(), 3, 5), new Point(Couleur.noir(), 2, 1));

		r.ajouter(p);
		r.ajouter(d);
		r.ajouter(c);
		r.ajouter(t);
		
		StringWriter w = new StringWriter();
		r.dessiner(w);
		
		Set<String> linesDef = new HashSet<String>(Arrays.asList(def.split("\\n")));
		Set<String> lines = new HashSet<String>(Arrays.asList(w.toString().split("\\n")));
		Assertions.assertEquals(linesDef, lines);
	}
}
