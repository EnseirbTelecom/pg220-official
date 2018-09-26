package repere;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestAxe {
	
	@Test(expected=AxeInconsistent.class)
	public void testAxeInconsistent1() {
		new Axe(Couleur.noir(), "", 0);
	}
	
	@Test(expected=AxeInconsistent.class)
	public void testAxeInconsistent2() {
		new Axe(Couleur.noir(), "", -1);
	}
	
	@Test
	public void testSerialisation() {
		Axe a = new Axe(Couleur.noir(), "mon titre", 10);
		assertEquals("Axe 10 [0,0,0] mon titre", a.serialisation());
	}

}
