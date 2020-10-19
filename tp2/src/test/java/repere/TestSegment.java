package repere;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import repere.formes.Point;
import repere.formes.Segment;

public class TestSegment {
	@Test
	public void testSegmentInconsistent() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Segment(Couleur.noir(), new Point(Couleur.noir(), 2, 2), new Point(Couleur.noir(), 2, 2));
		});
	}
	
	@Test
	public void testSegmentInvalide1() {
		Repere r = new Repere("", new Axe(Couleur.noir(), "", 5), new Axe(Couleur.noir(), "", 5));
		Point p1 = new Point(Couleur.noir(), 6, 2);
		Point p2 = new Point(Couleur.noir(), 2, 2);
		Segment s = new Segment(Couleur.noir(), p1, p2);
		Assertions.assertFalse(s.validePour(r));
	}
	
	@Test
	public void testSegmentInvalide2() {
		Repere r = new Repere("", new Axe(Couleur.noir(), "", 5), new Axe(Couleur.noir(), "", 5));
		Point p1 = new Point(Couleur.noir(), 3, 2);
		Point p2 = new Point(Couleur.noir(), 2, 8);
		Segment s = new Segment(Couleur.noir(), p1, p2);
		Assertions.assertFalse(s.validePour(r));
	}
	
	@Test
	public void testEquals() {
		Segment s1 = new Segment(Couleur.noir(), new Point(Couleur.noir(), 1, 0), new Point(Couleur.noir(), 0, 1));
		Segment s2 = new Segment(Couleur.noir(), new Point(Couleur.noir(), 1, 0), new Point(Couleur.noir(), 0, 1));
		Assertions.assertEquals(s1, s2);
		Segment s3 = new Segment(Couleur.noir(), new Point(Couleur.noir(), 0, 1), new Point(Couleur.noir(), 1, 0));
		Assertions.assertEquals(s3, s1);
		Assertions.assertEquals(s3, s2);
		Segment s4 = new Segment(Couleur.noir(), new Point(Couleur.noir(), 0, 1), new Point(Couleur.noir(), 2, 0));
		Assertions.assertNotEquals(s4, s1);
		Assertions.assertNotEquals(s4, s2);
		Assertions.assertNotEquals(s4, s3);
		Assertions.assertNotEquals(null, s1);
		Assertions.assertNotEquals("foo", s1);
	}
	
	@Test
	public void testSerialisation() {
		Segment s1 = new Segment(Couleur.noir(), new Point(Couleur.blanc(), 1, 0), new Point(Couleur.rouge(), 0, 1));
		Assertions.assertEquals("Segment [0,0,0] Point (1,0) [255,255,255] Point (0,1) [255,0,0]", s1.serialisation());
	}
	
	@Test
	public void testSvg() {
		Segment s1 = new Segment(Couleur.noir(), new Point(Couleur.blanc(), 1, 0), new Point(Couleur.rouge(), 0, 1));
		Assertions.assertEquals("<line x1='10' y1='0' x2='0' y2='10' style='stroke:rgb(0,0,0)'/>", s1.svg());
	}
}
