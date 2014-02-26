package fk;
import gui.KlComponent;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * Besteht aus einer Menge von Klassen und Assoziationen.
 * @author Gruppe1
 *
 */
public class Klassendiagramm implements Serializable{

	private static final long serialVersionUID = 1L;
	private ArrayList<KlComponent> klassen;
	private ArrayList<Assoziation> assoziationen;
	private String name;
	
	/**
	 * Konstuktor.Zum initialisieren der Atributen
	 * und Setzen der Name.
	 * @param name
	 */
	public Klassendiagramm(String name) {
		this.name = name;
		klassen = new ArrayList<>();
		assoziationen = new ArrayList<>();
	}
	/**
	 * Loescht eine Klasse mit Name name.
	 * @pre klassen darf nicht null sein
	 * @param name
	 */
	public void klasseLoeschen(String name) {
		Klasse kl = new Klasse(name);
		KlComponent klComponent = new KlComponent(kl);
		if (klassen.contains(klComponent)) {
			klassen.remove(kl);
		}
	}

	/**
	 * @return klassen
	 */
	public ArrayList<KlComponent> getKlassen() {
		return klassen;
	}

	/**
	 * @return diagrammname
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setzt Klassen.
	 * @param klassen
	 */
	public void setKlassen(ArrayList<KlComponent> klassen) {
		this.klassen = klassen;
	}

	/**
	 * Setzt diagrammname.
	 * @param diagrammname
	 */
	public void setName(String name) {
		this.name = name;
	}

}
