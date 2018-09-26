package repere;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import repere.formes.Cercle;
import repere.formes.Point;

public class TestCercle {
	
	@Test(expected=ElementInconsistent.class)
	public void testCercleInconsistent1() {
		new Cercle(Couleur.noir(), new Point(Couleur.noir(), 2, 2), -10);
	}
	
	@Test(expected=ElementInconsistent.class)
	public void testCercleInconsistent2() {
		new Cercle(Couleur.noir(), new Point(Couleur.noir(), 2, 2), 0);
	}
	
	@Test(expected=ElementInconsistent.class)
	public void testCercleInconsistent3() {
		new Cercle(Couleur.noir(), new Point(Couleur.noir(), 2, 3), 3);
	}
	
	@Test(expected=ElementInconsistent.class)
	public void testCercleInconsistent4() {
		new Cercle(Couleur.noir(), new Point(Couleur.noir(), 3, 2), 3);
	}
	
	@Test(expected=ElementInvalide.class)
	public void testCercleInvalide1() throws ElementInvalide {
		Repere r = new Repere("", new Axe(Couleur.noir(), "", 5), new Axe(Couleur.noir(), "", 5));
		Point centre = new Point(Couleur.noir(), 6, 2);
		Cercle c = new Cercle(Couleur.noir(), centre, 1);
		c.validePour(r);
	}
	
	@Test(expected=ElementInvalide.class)
	public void testCercleInvalide2() throws ElementInvalide {
		Repere r = new Repere("", new Axe(Couleur.noir(), "", 10), new Axe(Couleur.noir(), "", 10));
		Point centre = new Point(Couleur.noir(), 6, 6);
		Cercle c = new Cercle(Couleur.noir(), centre, 5);
		c.validePour(r);
	}
	
	@Test
	public void testCercleEquals() throws ElementInvalide {
		Cercle c1 = new Cercle(Couleur.noir(), new Point(Couleur.noir(), 5, 5), 1);
		Cercle c2 = new Cercle(Couleur.noir(), new Point(Couleur.noir(), 5, 5), 1);
		Cercle c3 = new Cercle(Couleur.noir(), new Point(Couleur.noir(), 5, 5), 4);
		
		assertEquals(c1, c2);
		assertNotEquals(c1, c3);
	}
	
	@Test
	public void testSerialisation() throws ElementInvalide {
		Cercle c = new Cercle(Couleur.bleu(), new Point(Couleur.noir(), 5, 5), 2);
		String expected = "Cercle 2 [0,0,255] Point (5,5) [0,0,0]";
		assertEquals(expected, c.serialisation());
	}
	
	@Test
	public void testSvg() {
		Cercle c = new Cercle(Couleur.rouge(), new Point(Couleur.noir(), 15, 15), 3);
		assertEquals("<circle cx='150' cy='150' r='30' style='fill:rgb(255,0,0)'/>", c.svg());
	}
	
}
