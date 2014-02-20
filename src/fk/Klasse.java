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
		attribute = new ArrayList<>();
	}
	
	public void klassenNameAendern() {
		
	}
	public void attributErstellen(String name, String datentyp) {
		
	}
	public void attributLoeschen(String name, String datentyp) {
		
	}
	public ArrayList<Attribut> getAttribute() {
		return attribute;
	}

}
