package repere;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestCouleur {
	@Test
	public void testComposantesTropPetites() {
		Couleur c1 = new Couleur(-1, -1, -1);
		assertEquals(0, c1.getR());
		assertEquals(0, c1.getG());
		assertEquals(0, c1.getB());
	}

	@Test
	public void testComposantesTropGrandes() {
		Couleur c1 = new Couleur(256, 256, 256);
		assertEquals(255, c1.getR());
		assertEquals(255, c1.getG());
		assertEquals(255, c1.getB());
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
