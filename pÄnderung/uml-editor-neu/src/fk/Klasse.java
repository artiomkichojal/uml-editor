package fk;

import java.util.ArrayList;

public class Klasse {
	ArrayList<Attribut> attribute;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	private String name;
	
	public Klasse(String name) {
		this.name = name;
		attribute = new ArrayList<Attribut>();
	}
	
	public void klassenNameAendern() {
		
	}
	public void attributErstellen(String name, String datentyp) {
		attribute.add(new Attribut(name, datentyp));
	}
	public void attributLoeschen(String name, String datentyp) {
		
	}
	public ArrayList<Attribut> getAttribute() {
		return attribute;
	}

}
