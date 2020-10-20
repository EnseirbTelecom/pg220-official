package repere;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import repere.formes.Point;
import repere.formes.Triangle;

public class TestTriangle {
	@Test
	public void testTriangleInconsistent1() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Triangle(Couleur.noir(), new Point(Couleur.noir(), 1 , 1), 
					new Point(Couleur.noir(), 1, 1), new Point(Couleur.noir(), 2, 2));
		});
	}
	
	@Test
	public void testTriangleInconsistent2() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Triangle(Couleur.noir(), new Point(Couleur.noir(), 1 , 1), 
					new Point(Couleur.noir(), 2, 2), new Point(Couleur.noir(), 2, 2));
		});
	}
	
	@Test
	public void testTriangleInconsistent3() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Triangle(Couleur.noir(), new Point(Couleur.noir(), 1 , 1), 
					new Point(Couleur.noir(), 2, 2), new Point(Couleur.noir(), 1, 1));
		});
	}
	
	@Test
	public void testTriangleInconsistent4() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Triangle(Couleur.noir(), new Point(Couleur.noir(), 1 , 1), 
					new Point(Couleur.noir(), 2, 2), new Point(Couleur.noir(), 3, 3));
		});
	}
	
	@Test
	public void testTriangleInconsistent5() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Triangle(Couleur.noir(), new Point(Couleur.noir(), 2 , 2), 
					new Point(Couleur.noir(), 4, 4), new Point(Couleur.noir(), 1, 1));
		});
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
		Assertions.assertEquals(t2, t1);
		Assertions.assertEquals(t3, t1);
		Assertions.assertEquals(t5, t1);
		Assertions.assertEquals(t3, t2);
		
		Assertions.assertNotEquals(t4, t1);
		Assertions.assertNotEquals(t4, t2);
		Assertions.assertNotEquals(t4, t3);
		Assertions.assertNotEquals(t1, null);
		Assertions.assertNotEquals(t3, "foo");
	}
	
	@Test
	public void testSerialisation() {
		Triangle t = new Triangle(Couleur.bleu(), new Point(Couleur.noir(), 1, 0), new Point(Couleur.noir(), 1, 1), new Point(Couleur.noir(), 2, 3));
		Assertions.assertEquals("Triangle [0,0,255] Point (1,0) [0,0,0] Point (1,1) [0,0,0] Point (2,3) [0,0,0]", t.serialisation());
	}
	
	@Test
	public void testSvg() {
		Triangle t = new Triangle(Couleur.rouge(), new Point(Couleur.noir(), 5, 5), new Point(Couleur.noir(), 3, 5), new Point(Couleur.noir(), 2, 1));
		Assertions.assertEquals("<line x1='50' y1='50' x2='30' y2='50' style='stroke:rgb(255,0,0)'/><line x1='30' y1='50' x2='20' y2='10' style='stroke:rgb(255,0,0)'/><line x1='20' y1='10' x2='50' y2='50' style='stroke:rgb(255,0,0)'/>", t.svg());
	}
}
