package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import fk.Attribut;
import fk.MyTableModel;

/**
 * Klasse zur Darstellung Eingabemaske und Erstellen von Attributen.
 * @author Gruppe 1
 * 
 */
public class KlasseEditfenster extends JFrame {
	/** Hauptpanel */
	private JPanel panelEditKl;

	private JTextField nameAttr;
	private JTextField nameKl;
	private JLabel nameAttrLabel;
	private JLabel nameKlLabel;

	private JButton attrHinzB;
	private JButton attrLeoschenB;

	private final String[] dt = { "int", "double", "long", "float", "String",
			"char" };
	private final JComboBox<String> datentypenList = new JComboBox<>(dt);

	private ArrayList<ArrayList<String>> attributData;
	private JTable attrTable;
	
	/**
	 * Konstruktor zum setzen der Name von Fenster und Position.
	 * @param title
	 */
	public KlasseEditfenster(String title) {
		super(title);
		setResizable(false);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((d.width - getSize().width) / 2,
				(d.height - getSize().height) / 2);
	}
	
	/**
	 * Initialisiert alle Attribute.
	 */
	public void init() {

		panelEditKl = new JPanel();
		JPanel northJP = new JPanel();
		JPanel centerJP = new JPanel();

		panelEditKl.setLayout(new BorderLayout(5, 5));
		northJP.setLayout(new GridLayout(0, 3, 4, 2));
		centerJP.setLayout(new GridLayout(0, 3, 4, 2));

		nameAttrLabel = new JLabel("Atrname:");
		nameKlLabel = new JLabel("Klassenname:");

		nameKl = new JTextField();
		nameAttr = new JTextField();

		attrHinzB = new JButton("Atr hinz");
		attrLeoschenB = new JButton("Atr löschen");
		
		attributData = new ArrayList<>();
		attrTable = new JTable(new MyTableModel(attributData));
		
		attrLeoschenB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				attributLoeschen();					
			}
		});
		// Atribut hinzufuegen button
		attrHinzB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				attributHinzufuegen();				
			}
		});
		
		//fuege Komponente hinzu
		northJP.add(nameKlLabel);
		northJP.add(nameKl);
		northJP.add(new JLabel(""));
		northJP.add(nameAttrLabel);
		northJP.add(nameAttr);
		northJP.add(attrHinzB);
		northJP.add(new JLabel("Datentyp:"));
		northJP.add(datentypenList);
		northJP.add(attrLeoschenB);

		panelEditKl.add(northJP, BorderLayout.PAGE_START);
		panelEditKl.add(attrTable, BorderLayout.CENTER);
		JScrollPane scrollPane = new JScrollPane(attrTable);
		panelEditKl.add(scrollPane);
		this.add(panelEditKl);

		this.setPreferredSize(new Dimension(400, 300));
		this.pack();
		this.setVisible(true);
	}
	
	/**
	 * Fuegt Attribut in die Tabelle hinzu. 
	 */
	public void attributHinzufuegen() {
		ArrayList<String> row = new ArrayList<String>();
		row.add(nameAttr.getText());
		row.add((String) datentypenList.getSelectedItem());
		//nur leerzeichen ? 3b
		if (nameAttr.getText().matches("\\s*")) {
			JOptionPane.showMessageDialog(this,
					"Geben Sie sinvolle Attributname ein!");
		}
		
		else if(attributData.contains(row)){
			JOptionPane.showMessageDialog(this,
					"Attribut ist schon vorhanden");
		}
		else{
			attributData.add(row);
			MyTableModel dm = (MyTableModel) attrTable.getModel();
			dm.fireTableDataChanged();
		}
		
	}
	
	/**
	 * Loescht Attribut aus der Tabelle.
	 */
	public void attributLoeschen() {
		//wenn zeile ausgewaelt -> loesche
		if (attrTable.getSelectedRow() >=0) {
			MyTableModel dm = (MyTableModel) attrTable.getModel();
			dm.removeRow(attrTable.getSelectedRow());
			((MyTableModel) dm).fireTableDataChanged();
		}else{
			JOptionPane.showMessageDialog(this,	"Kein Attribut ausgewaelt!");
		}
	}

	/**
	 * @return the panelEditKl
	 */
	public JPanel getPanelEditKl() {
		return panelEditKl;
	}

	/**
	 * @return the attrHinzB
	 */
	public JButton getAttrHinzB() {
		return attrHinzB;
	}

	/**
	 * @return the attrLeoschenB
	 */
	public JButton getAttrLeoschenB() {
		return attrLeoschenB;
	}

	/**
	 * @return the attrTable
	 */
	public JTable getAttrTable() {
		return attrTable;
	}

	/**
	 * @return the klassenName
	 */
	public JTextField getKlassenName() {
		return nameKl;
	}

}
