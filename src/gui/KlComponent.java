package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;

import fk.Attribut;
import fk.Klasse;

public class KlComponent extends JPanel {
	Klasse klasse;
	Rectangle rechteck;
	private final int GAP = 2; // Zeilenabstand und Spaltenabstand

	public KlComponent(Klasse klasse) {
		this.klasse = klasse;
		rechteck = new Rectangle();
		setBackground(Color.WHITE);
		Random r = new Random();
		int x = r.nextInt(600);
		int y = r.nextInt(500);
		setBounds(x, y, berechneBreite(), berechneHoehe());

		rechteck = new Rectangle(0, 0, berechneBreite() - 2, berechneHoehe());
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

	}

	public Klasse getKlasse() {
		return klasse;
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
		if (klasse.getAttribute() != null && klasse.getAttribute().size() != 0) {
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
		if (klasse.getAttribute() != null && klasse.getAttribute().size() != 0) {
			Font f = getFont();
			FontMetrics metrics = getFontMetrics(f);
			// enthaelt breiten von jeden String
			ArrayList<Integer> breiten = new ArrayList<Integer>();
			breiten.add(metrics.stringWidth(klasse.getName()));
			for (Attribut atr : klasse.getAttribute()) {
				breiten.add(metrics.stringWidth(atr.getName() + ": "
						+ atr.getDatentyp()));
			}
			Collections.sort(breiten);
			return breiten.get(breiten.size() - 1) + GAP * 2;
		}
		return 0;
	}

	/**
	 * Berechnet Hoehe des KlComponent
	 * 
	 * @return Hoehe
	 */
	public int berechneHoehe() {
		Font f = getFont();
		FontMetrics metrics = getFontMetrics(f);
		int maxHeight = (metrics.getHeight() + GAP)
				* (klasse.getAttribute().size() + 2);
		return maxHeight;
	}

}
