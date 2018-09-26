package repere;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestCouleur {
	
	@Test
	public void testCouleurOverflow() {
		Couleur c1 = Couleur.noir();
		Couleur c2 = new Couleur(-1, -1, -1);
		assertEquals(c1, c2);
		Couleur c3 = Couleur.blanc();
		Couleur c4 = new Couleur(256, 256, 256);
		assertEquals(c3, c4);
	}

}
