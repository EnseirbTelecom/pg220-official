package repere;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCouleur {
	@Test
	public void testComposantesTropPetites() {
		Couleur c1 = new Couleur(-1, -1, -1);
		Assertions.assertEquals(0, c1.getR());
		Assertions.assertEquals(0, c1.getG());
		Assertions.assertEquals(0, c1.getB());
	}

	@Test
	public void testComposantesTropGrandes() {
		Couleur c1 = new Couleur(256, 256, 256);
		Assertions.assertEquals(255, c1.getR());
		Assertions.assertEquals(255, c1.getG());
		Assertions.assertEquals(255, c1.getB());
	}

	@Test
	public void testSerialisation() {
		Couleur c1 = new Couleur(1, 2, 3);
		Assertions.assertEquals("[1,2,3]", c1.serialisation());
	}

		@Test
	public void testSvg() {
		Couleur c1 = new Couleur(1, 2, 3);
		Assertions.assertEquals("rgb(1,2,3)", c1.svg());
	}
}
