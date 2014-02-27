package test;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import fk.Attribut;

/**
 * Test fuer {@link Attribut}
 * 
 * @author Gruppe1
 * 
 */

@RunWith(JUnit4.class)
public class Modultest {

	@Test
	public void testKonstruktor() {
		// 001
		Attribut atr = new Attribut("a", "int");
		assertEquals("a", atr.getName());
		assertEquals("int", atr.getDatentyp());
		// 002
		Attribut atr1 = new Attribut("", "int");
		assertEquals(null, atr1.getName());
		assertEquals(null, atr1.getDatentyp());
		// 003
		Attribut atr2 = new Attribut("Stringgggggggggggggggg", "int");
		assertEquals(null, atr2.getName());
		assertEquals(null, atr2.getDatentyp());
		// 004
		Attribut atr3 = new Attribut("a", "foo");
		assertEquals(null, atr3.getName());
		assertEquals(null, atr3.getDatentyp());
	}
	@Test
	public void testTostring() {
		//z2
		Attribut atr = new Attribut("a", "char");
		assertEquals("a: char", atr.toString());
		//z3
		Attribut atr1 = new Attribut("", "");
		System.out.println("sys " + atr1.toString());
		assertEquals("", atr1.toString());
	}

}
