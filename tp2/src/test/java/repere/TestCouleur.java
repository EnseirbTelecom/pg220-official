package repere;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCouleur {
	@Test
	public void testCouleurNormale() {
		Couleur c1 = new Couleur(1, 2, 3);
		Assertions.assertEquals(1, c1.getR());
		Assertions.assertEquals(2, c1.getG());
		Assertions.assertEquals(3, c1.getB());
	}

	@Test
	public void testCouleurAuHasard() {
		for (int i = 0; i < 100; i++) {
			Couleur c = Couleur.auHasard();
			Assertions.assertTrue(c.getR() >= 0 && c.getR() <= 255);
			Assertions.assertTrue(c.getG() >= 0 && c.getG() <= 255);
			Assertions.assertTrue(c.getB() >= 0 && c.getB() <= 255);
		}
	}

	@Test
	public void testCouleurNoire() {
		Couleur c1 = Couleur.noir();
		Assertions.assertEquals(0, c1.getR());
		Assertions.assertEquals(0, c1.getG());
		Assertions.assertEquals(0, c1.getB());

		Couleur c2 = Couleur.noir();
		Assertions.assertTrue(c1 != c2);
	}

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
