package repere;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import repere.formes.Point;

public class TestPoint {
	@Test
	public void testPointInconsistent1() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Point(Couleur.noir(), -2, 0);
		});
	}
	
	@Test
	public void testPointInconsistent2() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Point(Couleur.noir(), 0, -1);
		});
	}
	
	@Test
	public void testPointInvalide1() {
		Repere r = new Repere("", new Axe(Couleur.noir(), "", 5), new Axe(Couleur.noir(), "", 5));
		Point p = new Point(Couleur.noir(), 6, 2);
		Assertions.assertFalse(p.validePour(r));
	}
	
	@Test
	public void testPointInvalide2() {
		Repere r = new Repere("", new Axe(Couleur.noir(), "", 5), new Axe(Couleur.noir(), "", 5));
		Point p = new Point(Couleur.noir(), 3, 6);
		Assertions.assertFalse(p.validePour(r));
	}
	
	@Test
	public void testEquals() {
		Point p1 = new Point(Couleur.noir(), 1, 6);
		Point p3 = new Point(Couleur.noir(), 1, 6);
		Assertions.assertEquals(p3, p1);
		Point p2 = new Point(Couleur.noir(), 6, 1);
		Assertions.assertNotEquals(p2, p1);
		Assertions.assertNotEquals(p1, null);
		Assertions.assertNotEquals(p1, "foo");
	}
	
	@Test
	public void testSerialisation() {
		Point p1 = new Point(Couleur.noir(), 1, 6);
		Assertions.assertEquals("Point (1,6) [0,0,0]", p1.serialisation());
	}
	
	@Test
	public void testSvg() {
		Point p1 = new Point(Couleur.noir(), 1, 6);
		Assertions.assertEquals("<circle cx='10' cy='60' r='2' style='fill:rgb(0,0,0)'/>", p1.svg());
	}
}
