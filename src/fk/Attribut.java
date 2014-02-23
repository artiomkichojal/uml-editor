package fk;

import java.io.Serializable;

/**
 * Objekte der Klasse Attribut repr�sentieren Attribute
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
	 * @post Vorbedingung erf�llt!
	 * 
	 */
	private String datentyp;

	/**
	 * Konstruktor
	 * 
	 * @param name Namen des Attributs
	 * @param datentyp Typ des Attributs 
	 */
	public Attribut(String name, String datentyp) {
		this.name = name;
		this.datentyp = datentyp;
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
	 * Ver�ndert oder weist dem Attribut einen neuen name zu.
	 * 
	 * @param name Name des Attributs
	 * @post name ist der gew�nschte Attributname
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
	 * Ver�ndert oder weist dem Attribut einen neuen Datentyp zu
	 * 
	 * @param datentyp Typ des Attributs
	 * @post datentyp ist der gew�nschte Attributtyp
	 * @modifies this
	 */
	public void setDatentyp(String datentyp) {
		this.datentyp = datentyp;
	}

}
