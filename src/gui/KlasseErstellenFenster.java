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
	private KlasseEditfenster klEditFenster;

	

	public void init() {
		klEditFenster = new KlasseEditfenster("Klasse erstellen");
		klEditFenster.init();
		erstellenB = new JButton("Erstellen");

		klEditFenster.getPanelEditKl().add(erstellenB, BorderLayout.PAGE_END);
		erstellenB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String klassName = klEditFenster.getKlassenName().getText();
				// klassename soll nicht leer sein 3a
				if (klassName.equals("")) {
					JOptionPane.showMessageDialog(klEditFenster,
							"Geben Sie eine Klassenname ein!");
					
				}else {
					Klasse klasse = new Klasse(klassName);
					// fuege Atributen der Klasse hinzu
					MyTableModel tabelle = (MyTableModel) klEditFenster
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
					klEditFenster.dispose();
				}

			}
		});

	}

	/**
	 * @return klEditFenster
	 */
	public KlasseEditfenster getKlEditFenster() {
		return klEditFenster;
	}

}
