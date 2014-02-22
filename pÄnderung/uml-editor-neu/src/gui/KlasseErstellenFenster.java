package gui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import fk.Attribut;
import fk.Klasse;
import fk.MyTableModel;


public class KlasseErstellenFenster extends Observable {

	JButton jb;
	static int countK = 0;
	static int countAtr = 0;
	KlasseEditfenster kled;
	
	public KlasseEditfenster getKled() {
		return kled;
	}
	
	public void init() {
		kled = new KlasseEditfenster();
		kled.init();
		jb = new JButton("Hinzufuegen");
		
		kled.getJp().add(jb,BorderLayout.PAGE_END);		
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String klassName = kled.getKlassenName().getText();
				//wenn klassename soll nicht leer sein
				if(!klassName.equals("")) {
					Klasse klasse = new Klasse(klassName);
					//fuege Atributen der Klasse hinzu
					MyTableModel tabelle =  (MyTableModel) kled.getAttributTable().getModel();
					for (int i = 0; i < tabelle.getRowCount(); i++) {
						//erstelle Attribut
						klasse.attributErstellen((String)tabelle.getValueAt(i, 0), (String)tabelle.getValueAt(i, 1));
					}
					setChanged();
					notifyObservers(klasse);
					countK++;
					kled.dispose();
				}else{
					JOptionPane.showMessageDialog(kled, "Geben Sie eine Klassenname ein!");
				}
				
				
			}
		});
		
	}
	

}
