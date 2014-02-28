package fk;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * Klasse besteht aus Menge von Attributen.(Keine Duplikate)
 * @author Gruppe1
 *
 */
public class Klasse implements Serializable{
	ArrayList<Attribut> attribute;
	private String name;	
	/**
	 * Konstruktor
	 * @param name Klassenname
	 */
	public Klasse(String name) {
		this.name = name;
		attribute = new ArrayList<Attribut>();
	}
	/**
	 * Gibt Klassenname zurueck.
	 * @return Klassenname
	 */
	public String getName() {
		return name;
	}
	/**
	 * Setzt Klassenname.
	 * @param Klassenname
	 * @modifies this
	 */
	public void klassenNameAendern(String klName) {
		name = klName;
	}
	/**
	 * Fuegt neuen erstellten Attribut hinzu.
	 * @param name
	 * @param datentyp
	 */
	public void attributErstellen(String name, String datentyp) {
		attribute.add(new Attribut(name, datentyp));
	}
	/**
	 * Loescht Attribut.
	 * @param name
	 * @param datentyp
	 */
	public void attributLoeschen(String name, String datentyp) {
		Attribut atr = new Attribut(name, datentyp);
		int count= 0;
		for (Attribut actAtr : attribute) {
			if (actAtr.getName().equals(atr.getName())
					&& actAtr.getDatentyp().equals(atr.getDatentyp())) {
				System.out.println("Contains");
				attribute.remove(count);
				break;
			}
			count++;
		}
	}
	/**
	 * Gibt die Attribute zurueck.
	 * @return attribute
	 */
	public ArrayList<Attribut> getAttribute() {
		return attribute;
	}

}
