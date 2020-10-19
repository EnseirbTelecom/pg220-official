package repere;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import repere.formes.Cercle;
import repere.formes.Point;

public class TestCercle {
	@Test
	public void testCercleInconsistent1() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Cercle(Couleur.noir(), new Point(Couleur.noir(), 2, 2), -10);
		});
	}
	
	@Test
	public void testCercleInconsistent2() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Cercle(Couleur.noir(), new Point(Couleur.noir(), 2, 2), 0);
		});
	}
	
	@Test
	public void testCercleInconsistent3() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Cercle(Couleur.noir(), new Point(Couleur.noir(), 2, 3), 3);
		});
	}
	
	@Test
	public void testCercleInconsistent4() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Cercle(Couleur.noir(), new Point(Couleur.noir(), 3, 2), 3);
		});
	}
	
	@Test
	public void testCercleInvalide1() {
		Repere r = new Repere("", new Axe(Couleur.noir(), "", 5), new Axe(Couleur.noir(), "", 5));
		Point centre = new Point(Couleur.noir(), 6, 2);
		Cercle c = new Cercle(Couleur.noir(), centre, 1);
		Assertions.assertFalse(c.validePour(r));
	}
	
	@Test
	public void testCercleInvalide2() {
		Repere r = new Repere("", new Axe(Couleur.noir(), "", 10), new Axe(Couleur.noir(), "", 10));
		Point centre = new Point(Couleur.noir(), 6, 6);
		Cercle c = new Cercle(Couleur.noir(), centre, 5);
		Assertions.assertFalse(c.validePour(r));
	}
	
	@Test
	public void testCercleEquals() {
		Cercle c1 = new Cercle(Couleur.noir(), new Point(Couleur.noir(), 5, 5), 1);
		Cercle c2 = new Cercle(Couleur.noir(), new Point(Couleur.noir(), 5, 5), 1);
		Assertions.assertEquals(c2, c1);
		Cercle c3 = new Cercle(Couleur.noir(), new Point(Couleur.noir(), 5, 5), 4);
		Assertions.assertNotEquals(c3, c1);
		Assertions.assertNotEquals(null, c1);
		Assertions.assertNotEquals("foo", c1);
	}
	
	@Test
	public void testSerialisation() {
		Cercle c = new Cercle(Couleur.bleu(), new Point(Couleur.noir(), 5, 5), 2);
		Assertions.assertEquals("Cercle 2 [0,0,255] Point (5,5) [0,0,0]", c.serialisation());
	}
	
	@Test
	public void testSvg() {
		Cercle c = new Cercle(Couleur.rouge(), new Point(Couleur.noir(), 15, 15), 3);
		Assertions.assertEquals("<circle cx='150' cy='150' r='30' style='fill:rgb(255,0,0)'/>", c.svg());
	}
}
