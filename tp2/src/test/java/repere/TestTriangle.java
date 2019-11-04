package repere;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import repere.formes.Point;
import repere.formes.Triangle;

public class TestTriangle {
	@Test(expected=IllegalArgumentException.class)
	public void testTriangleInconsistent1() {
		new Triangle(Couleur.noir(), new Point(Couleur.noir(), 1 , 1), 
				new Point(Couleur.noir(), 1, 1), new Point(Couleur.noir(), 2, 2));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTriangleInconsistent2() {
		new Triangle(Couleur.noir(), new Point(Couleur.noir(), 1 , 1), 
				new Point(Couleur.noir(), 2, 2), new Point(Couleur.noir(), 2, 2));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTriangleInconsistent3() {
		new Triangle(Couleur.noir(), new Point(Couleur.noir(), 1 , 1), 
				new Point(Couleur.noir(), 2, 2), new Point(Couleur.noir(), 1, 1));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTriangleInconsistent4() {
		new Triangle(Couleur.noir(), new Point(Couleur.noir(), 1 , 1), 
				new Point(Couleur.noir(), 2, 2), new Point(Couleur.noir(), 3, 3));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTriangleInconsistent5() {
		new Triangle(Couleur.noir(), new Point(Couleur.noir(), 2 , 2), 
				new Point(Couleur.noir(), 4, 4), new Point(Couleur.noir(), 1, 1));
	}
	
	@Test
	public void testEquals() {
		Triangle t1 = new Triangle(Couleur.noir(), new Point(Couleur.noir(), 1, 0), 
				new Point(Couleur.noir(), 0, 1), new Point(Couleur.noir(), 1, 1));
		Triangle t5 = new Triangle(Couleur.noir(), new Point(Couleur.noir(), 1, 0),
				new Point(Couleur.noir(), 1, 1), new Point(Couleur.noir(), 0, 1));
		Triangle t2 = new Triangle(Couleur.noir(), new Point(Couleur.noir(), 0, 1), 
				new Point(Couleur.noir(), 1, 0), new Point(Couleur.noir(), 1, 1));
		Triangle t3 = new Triangle(Couleur.noir(), new Point(Couleur.noir(), 1, 1), 
				new Point(Couleur.noir(), 0, 1), new Point(Couleur.noir(), 1, 0));
		Triangle t4 = new Triangle(Couleur.noir(), new Point(Couleur.noir(), 2, 2), 
				new Point(Couleur.noir(), 0, 1), new Point(Couleur.noir(), 1, 0));
		assertEquals(t1, t2);
		assertEquals(t1, t5);
		assertEquals(t2, t3);
		assertEquals(t3, t1);
		assertNotEquals(t1, t4);
		assertNotEquals(t2, t4);
		assertNotEquals(t3, t4);
		assertNotEquals(t1, null);
		assertNotEquals(t3, "foo");
	}
	
	@Test
	public void testSerialisation() {
		Triangle t = new Triangle(Couleur.bleu(), new Point(Couleur.noir(), 1, 0), new Point(Couleur.noir(), 1, 1), new Point(Couleur.noir(), 2, 3));
		String expected = "Triangle [0,0,255] Point (1,0) [0,0,0] Point (1,1) [0,0,0] Point (2,3) [0,0,0]";
		assertEquals(expected, t.serialisation());
	}
	
	@Test
	public void testSvg() {
		Triangle t = new Triangle(Couleur.rouge(), new Point(Couleur.noir(), 5, 5), new Point(Couleur.noir(), 3, 5), new Point(Couleur.noir(), 2, 1));
		assertEquals("<line x1='50' y1='50' x2='30' y2='50' style='stroke:rgb(255,0,0)'/><line x1='30' y1='50' x2='20' y2='10' style='stroke:rgb(255,0,0)'/><line x1='20' y1='10' x2='50' y2='50' style='stroke:rgb(255,0,0)'/>", t.svg());
	}
}
