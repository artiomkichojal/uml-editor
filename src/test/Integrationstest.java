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
public class Integrationstest {

	// Liste leer ok
	@Test
	public void testAttributErstellen() {
		Klasse kl = new Klasse("A");
		// dt laenge = 19
		kl.attributErstellen("name", "datentyp");
		Attribut atr = new Attribut("name", "datentyp");
		assertEquals(atr.getName(), kl.getAttribute().get(0).getName());
	}

	//Liste nicht leer ok
	@Test
	public void testAttributErstellen2() {
		Klasse kl = new Klasse("A");
		kl.attributErstellen("name", "datentyp");
		kl.attributErstellen("name2", "datentyp");
		assertEquals(2, kl.getAttribute().size());
	}

	// Attribut schon vorhanden ok?
	@Test
	public void testAttributErstellen3() {
		Klasse kl = new Klasse("A");		
		kl.attributErstellen("name", "datentyp");
		kl.attributErstellen("name", "datentyp");
		assertEquals(1, kl.getAttribute().size());
	}

	// liste leer
	@Test
	public void testAttributLoeschen1() {
		Klasse kl = new Klasse("A");		
		kl.attributLoeschen("name", "String");
		assertEquals(0, kl.getAttribute().size());		
	}

	//attribut vorhanden
	@Test
	public void testAttributLoeschen2() {
		Klasse kl = new Klasse("A");
		kl.attributErstellen("name", "String");	
		kl.attributLoeschen("name", "String");
		assertEquals(0,kl.getAttribute().size() );
	}

	// liste nicht leer attribut nicht vorhanden
	@Test
	public void testAttributLoeschen3() {
		Klasse kl = new Klasse("A");
		kl.attributErstellen("name", "String");
		kl.attributLoeschen("n", "String");
		assertEquals(1, kl.getAttribute().size());
	}
}

