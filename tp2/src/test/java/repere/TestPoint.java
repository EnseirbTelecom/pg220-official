package repere;

import org.junit.Test;
import static org.junit.Assert.*;

import repere.formes.Point;

public class TestPoint {
	
	@Test(expected=ElementInconsistent.class)
	public void testPointInconsistent1() {
		new Point(Couleur.noir(), -2, 0);
	}
	
	@Test(expected=ElementInconsistent.class)
	public void testPointInconsistent2() {
		new Point(Couleur.noir(), 0, -1);
	}
	
	@Test(expected=ElementInvalide.class)
	public void testPointInvalide1() throws ElementInvalide {
		Repere r = new Repere("", new Axe(Couleur.noir(), "", 5), new Axe(Couleur.noir(), "", 5));
		Point p = new Point(Couleur.noir(), 6, 2);
		p.validePour(r);
	}
	
	@Test(expected=ElementInvalide.class)
	public void testPointInvalide2() throws ElementInvalide {
		Repere r = new Repere("", new Axe(Couleur.noir(), "", 5), new Axe(Couleur.noir(), "", 5));
		Point p = new Point(Couleur.noir(), 3, 6);
		p.validePour(r);
	}
	
	@Test
	public void testPointEquals() {
		Point p1 = new Point(Couleur.noir(), 1, 6);
		Point p2 = new Point(Couleur.noir(), 6, 1);
		Point p3 = new Point(Couleur.noir(), 1, 6);
		assertEquals(p1, p3);
		assertNotEquals(p1, p2);
	}
	
	@Test
	public void testSerialisation() {
		Point p1 = new Point(Couleur.noir(), 1, 6);
		assertEquals("Point (1,6) [0,0,0]", p1.serialisation());
	}
	
	@Test
	public void testSvg() {
		Point p1 = new Point(Couleur.noir(), 1, 6);
		assertEquals("<circle cx='10' cy='60' r='2' style='fill:rgb(0,0,0)'/>", p1.svg());
	}

}
