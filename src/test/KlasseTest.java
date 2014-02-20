package test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import fk.Attribut;
import fk.Klasse;

/**
 * Test fuer {@link Klasse}
 * 
 * @author Gruppe1
 * 
 */

@RunWith(JUnit4.class)
public class KlasseTest {

	// (z1,r1)
	@Test
	public void testAttributErstellen() {
		Klasse kl = new Klasse("A");
		// dt laenge = 19
		kl.attributErstellen("name", "Stringggggggggggggg");
		Attribut atr = new Attribut("name", "Stringggggggggggggg");
		assertEquals(atr, kl.getAttribute().get(0));
	}

	// (z1,k1)
	@Test
	public void testAttributErstellenZ1K1() {
		Klasse kl = new Klasse("A");
		// dt laenge 20
		kl.attributErstellen("name", "Stringgggggggggggggg");
		assertEquals(0, kl.getAttribute().size());
	}

	// (z1,k3)
	@Test
	public void testAttributErstellenZ1K3() {
		Klasse kl = new Klasse("A");
		// namen laenge 0
		kl.attributErstellen("", "String");
		assertEquals(0, kl.getAttribute().size());
	}

	// (z1,k4)
	@Test
	public void testAttributErstellenZ1K4() {
		Klasse kl = new Klasse("A");
		// namen laenge 0
		kl.attributErstellen("", "String");
		assertEquals(0, kl.getAttribute().size());
	}

	// (z2,k2)
	@Test
	public void testAttributLoeschen() {
		Klasse kl = new Klasse("A");
		kl.attributErstellen("name", "Strig");
		kl.attributLoeschen("name", "String");
		assertTrue(kl.getAttribute().size() == 0);
	}

	// (z3,r2)
	public void testAttributLoeschenZ3R2() {
		Klasse kl = new Klasse("A");
		kl.attributLoeschen("n", "String");
		assertEquals(0, kl.getAttribute().size());
	}

	// (z4,r1)
	@Test
	public void testAttributErstellenZ4R1() {
		Klasse kl = new Klasse("A");
		// dt laenge = 19
		kl.attributErstellen("x", "int");
		// laenge 19
		kl.attributErstellen("xyz", "Stringggggggggggggg");
		assertEquals(2, kl.getAttribute().size());
	}
}
