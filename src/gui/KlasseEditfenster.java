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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import fk.Attribut;
import fk.MyTableModel;

/**
 * 
 * @author Gruppe 1
 * 
 */
public class KlasseEditfenster extends JFrame {
	/** Hauptpanel */
	private JPanel panelEditKl;

	private JPanel northJP;
	private JPanel centerJP;

	private JTextField nameAttr;
	private JTextField nameKl;
	private JLabel nameAttrLabel;
	private JLabel nameKlLabel;

	private JButton attrHinzB;
	private JButton attrLeoschenB;

	private final String[] dt = { "int", "double", "long", "float", "String",
			"char" };
	private final JComboBox<String> datentypen = new JComboBox<>(dt);

	private ArrayList<ArrayList<String>> attributData;
	private JTable attrTable;

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
		northJP = new JPanel();
		centerJP = new JPanel();

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
		// Atribut button
		attrHinzB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				attributHinzufuegen();
				TableModel dm = attrTable.getModel();
				((AbstractTableModel) dm).fireTableDataChanged();
			}
		});
		northJP.add(nameKlLabel);
		northJP.add(nameKl);
		northJP.add(new JLabel(""));
		northJP.add(nameAttrLabel);
		northJP.add(nameAttr);
		northJP.add(attrHinzB);
		northJP.add(new JLabel("Datentyp:"));
		northJP.add(datentypen);
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

	public void attributHinzufuegen() {
		ArrayList<String> row = new ArrayList<String>();
		row.add(nameAttr.getText());
		row.add((String) datentypen.getSelectedItem());
		attributData.add(row);
	}

	public void attributLoeschen(Attribut atr) {
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
