package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import fk.Klasse;
import fk.MyTableModel;

/**
 * Fenster zum Erstellen von einer Klasse mit Attributen.
 * Enthaelt Schaltflaeche zum Erstellen.
 * @author Gruppe1
 *
 */
public class KlasseErstellenFenster extends Observable {
	
	private JButton erstellenB;
	private KlasseEditfenster klErstellFenster;

	public KlasseEditfenster getKled() {
		return klErstellFenster;
	}

	public void init() {
		klErstellFenster = new KlasseEditfenster("Klasse erstellen");
		klErstellFenster.init();
		erstellenB = new JButton("Erstellen");

		klErstellFenster.getPanelEditKl().add(erstellenB, BorderLayout.PAGE_END);
		erstellenB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String klassName = klErstellFenster.getKlassenName().getText();
				// klassename soll nicht leer sein
				if (!klassName.equals("")) {
					Klasse klasse = new Klasse(klassName);
					// fuege Atributen der Klasse hinzu
					MyTableModel tabelle = (MyTableModel) klErstellFenster
							.getAttrTable().getModel();
					for (int i = 0; i < tabelle.getRowCount(); i++) {
						// erstelle Attribut
						klasse.attributErstellen(
								(String) tabelle.getValueAt(i, 0),
								(String) tabelle.getValueAt(i, 1));
					}
					// Observer wird informiert und neue Klasse uebergeben
					setChanged();
					notifyObservers(klasse);
					// Fenster schliesen
					klErstellFenster.dispose();
				} else {
					JOptionPane.showMessageDialog(klErstellFenster,
							"Geben Sie eine Klassenname ein!");
				}

			}
		});

	}

	/**
	 * @return klErstellFenster
	 */
	public KlasseEditfenster getKlErstellFenster() {
		return klErstellFenster;
	}

}
