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


import fk.Klasse;
import fk.Klassendiagramm;


public class Hauptfenster extends JFrame implements Observer{
	private static Hauptfenster hauptfenster;
	Klassendiagramm klD;
	JFrame jf;
	private JPanel mainpanel;
	private JMenu menu;
	JButton jb;
	JPanel kC;
	/**Enthaelt nur KlKomponent*/
	JPanel workBench;
	
	KlasseErstellenFenster kef;
	
	
	private Hauptfenster(String title) {
		super(title);
		setJMenuBar(generateMenu());
		klD = new Klassendiagramm();
		kef = new KlasseErstellenFenster();
		Observable ob = kef;
		ob.addObserver(this);

		mainpanel = new JPanel();
		jb = new JButton("Klasse Erstellen");
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {				
				kef.init();					
			}
		});
		mainpanel.add(jb);
		this.add(mainpanel,BorderLayout.NORTH);
		workBench = new JPanel();
		workBench.setLayout(null);
		workBench.setBackground(Color.WHITE);

		add(workBench,BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(800, 600));
		pack();
		setVisible(true);
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((d.width- getSize().width)/2,(d.height- getSize().height)/2);
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {

		if (arg1 instanceof Klasse) {
			KlComponent kc1 = new KlComponent((Klasse)arg1);
			kC = kc1;
			workBench.add(kC);	
			workBench.repaint();
			revalidate();
			handleDrag(kC);
		}		
	}
	
	public static Hauptfenster getInstance() {
		if (hauptfenster == null) {
			hauptfenster = new Hauptfenster("Hauptfenster");
			return hauptfenster;
		}
		return null;
		
	}
	/**
	 * Methode zum Bewegen von Komponenten
	 * @param panel
	 */
	public void handleDrag(JPanel panel){
	        kC.addMouseMotionListener(new MouseMotionAdapter() {

	            @Override
	            public void mouseDragged(MouseEvent me) {
	                me.translatePoint(me.getComponent().getLocation().x, me.getComponent().getLocation().y);
	                kC.setLocation(me.getX(), me.getY());
	            }

	        });
	}
	
	private JMenuBar generateMenu() {
		JMenuBar menubar = new JMenuBar();
		JMenu menu = new JMenu("File");
		JMenuItem loadItem = new JMenuItem("Load");
		JMenuItem saveItem = new JMenuItem("Save");
		menu.add(loadItem);
		loadItem.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fileChooser = new JFileChooser();
				int returnVal = fileChooser.showOpenDialog(Hauptfenster.this);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
		            File file = fileChooser.getSelectedFile();
//		            try {
//						contr.setAgenda(contr.getAgenda().load(file.getAbsolutePath()));
//		            } catch (IOException e) {
//						e.printStackTrace();
//					}
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
//		            try {
//						//contr.getAgenda().save(file.getAbsolutePath());
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
				} else {

		        }
			}
		});

		
		menu.add(saveItem);

		menubar.add(menu);

		return menubar;
	}
	public void save(String fileName) throws IOException {
		OutputStream fos = null;
		try {
			fos = new FileOutputStream(new File(fileName));
			ObjectOutputStream o = new ObjectOutputStream(fos);
			o.writeObject(this);
		} catch (IOException e) {
			System.err.println(e);
		} finally {
			try {
				fos.close();
			} catch (Exception e) {
			}
		}

	}

	public Hauptfenster load(String fileName) throws IOException {
		InputStream fis = null;
		Hauptfenster agenda = null;
		try {
			fis = new FileInputStream(fileName);
			ObjectInputStream o = new ObjectInputStream(fis);
			agenda = (Hauptfenster) o.readObject();
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
		return agenda;
	}
	
	public static void main(String[] args) {
		Hauptfenster.getInstance();
	}

	

}
