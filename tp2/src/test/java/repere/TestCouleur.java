package repere;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestCouleur {
	@Test
	public void testComposantesTropPetites() {
		Couleur c1 = new Couleur(-1, -1, -1);
		assertEquals(c1.getR(), 0);
		assertEquals(c1.getG(), 0);
		assertEquals(c1.getB(), 0);
	}

	@Test
	public void testComposantesTropGrandes() {
		Couleur c1 = new Couleur(256, 256, 256);
		assertEquals(c1.getR(), 255);
		assertEquals(c1.getG(), 255);
		assertEquals(c1.getB(), 255);
	}

	@Test
	public void testSerialisation() {
		Couleur c1 = new Couleur(1, 2, 3);
		assertEquals("[1,2,3]", c1.serialisation());
	}

		@Test
	public void testSvg() {
		Couleur c1 = new Couleur(1, 2, 3);
		assertEquals("rgb(1,2,3)", c1.svg());
	}
}
