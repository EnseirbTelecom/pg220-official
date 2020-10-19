package repere;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestAxe {
	@Test
	public void testAxeInconsistent1() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Axe(Couleur.noir(), "", 0);
		});
	}
	
	@Test
	public void testAxeInconsistent2() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Axe(Couleur.noir(), "", -1);
		});
	}
	
	@Test
	public void testSerialisation() {
		Axe a = new Axe(Couleur.noir(), "mon titre", 10);
		Assertions.assertEquals("Axe 10 [0,0,0] mon titre", a.serialisation());
	}
}
