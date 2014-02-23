package fk;
import gui.KlComponent;

import java.io.Serializable;
import java.util.ArrayList;


public class Klassendiagramm implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<KlComponent> klassen;
	private String name;
	
	public Klassendiagramm(String name) {
		this.name = name;
		klassen = new ArrayList<>();
	}

	/**
	 * @return the klassen
	 */
	public ArrayList<KlComponent> getKlassen() {
		return klassen;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

}
