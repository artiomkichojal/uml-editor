package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import fk.Attribut;
import fk.Klasse;

/**
 * KlComponent zeichnet eine Klasse mit allen Attributen. 
 * @author Gruppe 1
 *
 */
public class KlComponent extends JPanel {
	private Klasse klasse;
	private final int GAP = 2; // Zeilenabstand und Spaltenabstand

	public KlComponent(Klasse klasse) {
		this.klasse = klasse;
		//setBackground(Color.WHITE);
		
		Random r = new Random();
		int x = r.nextInt(600);
		int y = r.nextInt(500);
		//Positioniere die Klasse auf zufaelige Positionen 
		setBounds(x, y, berechneBreite(), berechneHoehe());
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
		addMouseMotionListener(new Drag());

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		FontMetrics metrics = g.getFontMetrics(getFont());
		// hoehe des Textes
		int hgt = metrics.getHeight();
		// Zeichne Klasen Name
		g.drawString(klasse.getName(), 0 + 2, 0 + hgt + 2);
		g.drawLine(0, 0 + hgt + GAP * 2, berechneBreite() + 0, 0 + hgt + GAP * 2);
		// zeichne Attribute
		if (atributeOk()) {
			int count = (hgt + GAP) * 2;
			for (Attribut atr : klasse.getAttribute()) {
				g.drawString(atr.getName() + ": " + atr.getDatentyp(), 2, count);
				count += hgt + GAP;
			}
		}
	}

	/**
	 * Berechnet Breite des KlComponent. Es wird maximale breite von Klassenname
	 * und Attributnameberechnet
	 * 
	 * @return breite
	 */
	public int berechneBreite() {
		Font f = getFont();
		FontMetrics metrics = getFontMetrics(f);
		// enthaelt breiten von jeden String
		ArrayList<Integer> breiten = new ArrayList<Integer>();
		breiten.add(metrics.stringWidth(klasse.getName()));
		
		if (atributeOk()) {			
			for (Attribut atr : klasse.getAttribute()) {
				breiten.add(metrics.stringWidth(atr.getName() + ": "
						+ atr.getDatentyp()));
			}
			//Sortiere breiten aufsteigend
			Collections.sort(breiten);
			return breiten.get(breiten.size() - 1) + GAP * 2;
		}
		return breiten.get(0) + GAP * 2;
	}

	/**
	 * Berechnet die Hoehe des KlComponent.
	 * Ergebnis ist hoehe einer Zeile(z.B Klassenname oder Attributname).
	 * mal Anzahl der Zeilen.
	 * 
	 * @return Hoehe
	 */
	public int berechneHoehe() {
		Font f = getFont();
		FontMetrics metrics = getFontMetrics(f);
		int maxHeight = (metrics.getHeight() + GAP);
		//multipliziere mit anzahl der attributen, falls nicht null oder 
		//anzahl ist gleich 0
		if (atributeOk()) {			
			maxHeight *= (klasse.getAttribute().size() + 1);
		}		
		return maxHeight + GAP*5;
	}
	
	/**
	 * Gibt Klasse zurueck.
	 * @return Klasse
	 */
	public Klasse getKlasse() {
		return klasse;
	}
	/**
	 * Pruefe ob Klassen attribute ungleich null und
	 * Anzahl groesser als 0
	 * @return true, falls wahr
	 */
	private boolean atributeOk() {
		return klasse.getAttribute() != null && klasse.getAttribute().size() > 0;
	}
	
	/**
	 * Damit die KlKomponentbewegung nach Deserialisierung(load) funktioniert.
	 * @author artjom
	 *
	 */
	private class Drag implements MouseMotionListener,Serializable{
		@Override
		public void mouseDragged(MouseEvent e) {
			e.translatePoint(e.getComponent().getLocation().x, e.getComponent().getLocation().y);
	        setLocation(e.getX(), e.getY());
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

	}

}
