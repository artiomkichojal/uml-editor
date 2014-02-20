package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.LinkedList;

import javax.swing.JComponent;
import javax.swing.JPanel;

import fk.Klasse;

public class KlComponent extends JPanel{
	Klasse klasse;

	public KlComponent() {
		this.setPreferredSize(new Dimension(100	, 100));
		setOpaque(true);
		setBackground(Color.GREEN);
		
	}
	

	public Klasse getKlasse() {
		return klasse;
	}

	public void setKlasse(Klasse klasse) {
		this.klasse = klasse;
	}


	private static class Rechteck {
		final int x;
		final int y;
		final int width;
		final int height;
		final Color color;

		public Rechteck(int x, int y, int width, int height, Color color) {
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
			this.color = color;
		}
	}

	private final LinkedList<Rechteck> rechtecke = new LinkedList<Rechteck>();

	public void addLine(int x, int y, int width, int height) {
		addRechteck(x, y, width, height, Color.black);
	}

	public void addRechteck(int x, int y, int width, int height, Color color) {
		rechtecke.add(new Rechteck(x, y, width, height, color));
		repaint();
	}

	public void clearLines() {
		rechtecke.clear();
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (Rechteck re : rechtecke) {
			g.setColor(re.color);
			Klasse kl = klasse;
			String strText = kl.getName();
			Font f = getFont();
			FontMetrics metrics = g.getFontMetrics(f);
			// get the height of a line of text in this
			// font and render context
			int hgt = metrics.getHeight();
			// get the advance of my text in this font
			// and render context
			int adv = metrics.stringWidth(strText);
			// calculate the size of a box to hold the
			// text with some padding.
			char[] txt = strText.toCharArray();
			g.drawChars(txt, 0, strText.length(), re.x + 2, re.y + hgt + 2);
			g.drawRect(re.x, re.y, re.width, re.height);
		}
	}

}