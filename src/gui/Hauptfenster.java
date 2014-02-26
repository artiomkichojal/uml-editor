package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import fk.Klasse;
import fk.Klassendiagramm;

/**
 * Huptfenster zur Darstellung aller Komponenten.
 * Die Klasse kann nur ein mal instanziert werden(durch Singelton-Musster) 
 * @author Gruppe1
 *
 */
public class Hauptfenster extends JFrame implements Observer{
	private static Hauptfenster hauptfenster;
	private Klassendiagramm klDia;
	private JPanel mainpanel;
	private JMenu menu;
	private JButton klasseB;
	private JButton assozB;
	
	/**Enthaelt nur KlKomponent*/
	private JPanel workBench;
	
	private KlasseErstellenFenster klErstellFenster;
	private KlasseErstellenFenster assozFenster;
	
	private Hauptfenster(String title, String klName) {
		super(title);
		setJMenuBar(generateMenu());
		klDia = new Klassendiagramm(klName);
		klErstellFenster = new KlasseErstellenFenster();
		Observable ob = klErstellFenster;
		ob.addObserver(this);

		mainpanel = new JPanel();
		klasseB = new JButton("Neue Klasse");
		assozB = new JButton("Assoziation");
		klasseB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {				
				klErstellFenster.init();					
			}
		});
		mainpanel.add(klasseB);
		mainpanel.add(assozB);
		this.add(mainpanel,BorderLayout.NORTH);
		workBench = new JPanel();
		workBench.setLayout(null);
		workBench.setBackground(Color.WHITE);
		setPreferredSize(new Dimension(800, 600));
		add(workBench, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((d.width- getSize().width)/2,0);
		pack();
		setVisible(true);
		
	}
	//wird aufgerufen wenn Observable(z.B KlErstellFenster) sich aendert
	@Override
	public void update(Observable arg0, Object arg1) {

		if (arg1 instanceof Klasse) {
			KlComponent kC= new KlComponent((Klasse)arg1);			
			klDia.getKlassen().add(kC);
			zeichneKlassen();			
		}		
	}
	/**
	 * Gibt neue Instanz von Hauptfenster zurueck.
	 * @param klName
	 * @return Hauptfenster
	 */
	public static Hauptfenster getInstance(String klName) {
		if (hauptfenster == null) {
			hauptfenster = new Hauptfenster("Hauptfenster", klName);
			return hauptfenster;
		}
		return null;
		
	}
	/**
	 * Generiert Menu.
	 * @return
	 */
	private JMenuBar generateMenu() {
		JMenuBar menubar = new JMenuBar();
		menu = new JMenu("File");
		JMenuItem neuItem = new JMenuItem("Neu");
		JMenuItem loadItem = new JMenuItem("Load");
		JMenuItem saveItem = new JMenuItem("Save");
		
		menu.add(neuItem);
		menu.add(new JSeparator());
		neuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {			
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogType(JFileChooser.SAVE_DIALOG);
				int returnVal = fileChooser.showSaveDialog(Hauptfenster.this);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
		            File file = fileChooser.getSelectedFile();
		            neu(file.getName());
					try {
						save(file.getAbsolutePath());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} 
			}
			
		});
		menu.add(loadItem);
		loadItem.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fileChooser = new JFileChooser();
				int returnVal = fileChooser.showOpenDialog(Hauptfenster.this);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
		            File file = fileChooser.getSelectedFile();
		            try {
						Klassendiagramm kd = load(file.getAbsolutePath());
						klDia= kd;
						//entferne alles aus workbench
						clearJPanel(workBench);
						//zeichne Klassenkomponenten neue
						zeichneKlassen();
		            } catch (IOException e) {
						e.printStackTrace();
					}
				} else {

		        }
			}
		});
		
		saveItem.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogType(JFileChooser.SAVE_DIALOG);
				int returnVal = fileChooser.showSaveDialog(Hauptfenster.this);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
		            File file = fileChooser.getSelectedFile();
		            try {
						save(file.getAbsolutePath());
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {

		        }
			}
		});

		
		menu.add(saveItem);

		menubar.add(menu);

		return menubar;
	}
	/**
	 * Methode zum Speichern des Klassendiagramms.
	 * @param fileName
	 * @throws IOException
	 */
	public void save(String fileName) throws IOException {
		OutputStream fos = null;
		try {
			fos = new FileOutputStream(new File(fileName));
			ObjectOutputStream o = new ObjectOutputStream(fos);
			o.writeObject(klDia);
		} catch (IOException e) {
			System.err.println(e);
		} finally {
			try {
				fos.close();
			} catch (Exception e) {
			}
		}

	}
	/**
	 * Methode zum Laden des Klassendiagrams.
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public Klassendiagramm load(String fileName) throws IOException {
		InputStream fis = null;
		Klassendiagramm kld = null;
		try {
			fis = new FileInputStream(fileName);
			ObjectInputStream o = new ObjectInputStream(fis);
			kld = (Klassendiagramm) o.readObject();
		} catch (IOException e) {
			System.err.println(e);
		} catch (ClassNotFoundException e) {
			System.err.println(e);
		} finally {
			try {
				fis.close();
			} catch (Exception e) {
			}
		}
		return kld;
	}
	/**
	 * Methode zum Erstellem des neuen Klassendiagramms.
	 * @param klDName
	 */
	public void neu(String klDName) {
		if (klDia != null && (klDName != null || klDName.isEmpty())) {
			klDia = new Klassendiagramm(klDName);
			clearJPanel(workBench);
		}else {
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	/**
	 * Zeichnet die Klasse auf dem workbench.
	 */
	public void zeichneKlassen() {
		for (KlComponent klComp : klDia.getKlassen()) {
			workBench.add(klComp);	
			workBench.repaint();
			revalidate();
		}
		
	}
	/**
	 * Entferne alles aus JPanel.
	 * @param jp zu veraendern
	 * @modifies jp
	 */
	public void clearJPanel(JPanel jp) {
		jp.removeAll();
		revalidate();
		repaint();
	}
	
	public static void main(String[] args) {
		Hauptfenster.getInstance("D1");
	}

	

}
