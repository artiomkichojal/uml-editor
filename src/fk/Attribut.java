package fk;

import java.io.Serializable;

/**
 * Objekte der Klasse Attribut repraesentieren Attribute
 * <br/>
 * Attribute haben einen Namen "name" und
 * einen String "datentyp" = {int, double, long, float, String, char} 
 * 
 * @author Gruppe1
 * 
 */
public class Attribut implements Serializable{

	/**
	 * name, beinhaltet den Namen des Attributs
	 * 
	 */
	private String name;
	
	
	/**
	 * datentyp, ist das Attributentyp
	 * 
	 * @pre datentyp = {int, double, long, float, String, char}
	 * @post Vorbedingung erfuellt!
	 * 
	 */
	private String datentyp;

	/**
	 * Konstruktor
	 * 
	 * @param name Namen des Attributs
	 * @param datentyp Typ des Attributs 
	 */
	public Attribut(String name, String datentyp) throws IllegalArgumentException{
		if ((datentyp.equals("int")
				|| datentyp.equals("double") || datentyp.equals("long")
				|| datentyp.equals("float") || datentyp.equals("String")
				|| datentyp.equals("char")) 
				&& name.length() < 21 && name.length() > 0) {
			this.name = name;
			this.datentyp = datentyp;
		}else {
			throw new IllegalArgumentException("Keine Passende Argumente");
		}
		
	}

	/**
	 * Liefert den Namen des Attributs
	 * 
	 * @pre !null
	 * @return String name, Namen des Attributs
	 */
	public String getName() {
		return name;
	}

	/**
	 * Veraendert oder weist dem Attribut einen neuen name zu.
	 * 
	 * @param name Name des Attributs
	 * @post name ist der gewuenschte Attributname
	 * @modifies this
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Liefert den datentyp des Attributs 
	 * 
	 * @pre !null
	 * @return String datentyp, Typ des Attributs
	 */
	public String getDatentyp() {
		return datentyp;
	}

	/**
	 * Veraendert oder weist dem Attribut einen neuen Datentyp zu
	 * 
	 * @param datentyp Typ des Attributs
	 * @post datentyp ist der gewuenschte Attributtyp
	 * @modifies this
	 */
	public void setDatentyp(String datentyp) {
		this.datentyp = datentyp;
	}
	/**
	 * Repraesentationsinvariante
	 * @return true, falls alle bedingungen erfuellt sind
	 */
	public boolean isOk() {
		return name != null && datentyp != null && !name.equals("") && (datentyp.equals("int")
				|| datentyp.equals("double") || datentyp.equals("long")
				|| datentyp.equals("float") || datentyp.equals("String")
				|| datentyp.equals("char"));
	}
	/**
	 * Abstaktionsfunktion.
	 */
	public String toString() {
		if (isOk()) {
			return name + ": " + datentyp;
		}else {
			return "";
		}
	}

}
