package gui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import fk.Attribut;
import fk.Klasse;


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
		
		kled.getJp().add(jb,BorderLayout.WEST);		
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				setChanged();
				notifyObservers(new Klasse(getKled().getKlassenName().getText()));
				countK++;
				kled.dispose();
				
			}
		});
		
	}
	

}
