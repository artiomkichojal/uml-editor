package gui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
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

import fk.MyTableModel;


public class KlasseEditfenster extends JFrame{
	
	JPanel jp;
	JPanel northJP;
	JPanel centerJP;
	JButton jb1;
	JButton jb2;
	private JTable attributTable;
	public KlasseEditfenster(String title){
		super(title);
		setResizable(false);
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((d.width- getSize().width)/2,(d.height- getSize().height)/2);		
	}
	public JTable getAttributTable() {
		return attributTable;
	}

	JTextField atrN;
	JTextField klassenName;
	
	JComboBox<String> datentypen;

	public JPanel getJp() {
		return jp;
	}

	public void init() {
		
		jp = new JPanel();
		northJP = new JPanel();
		centerJP = new JPanel();
		jp.setLayout(new BorderLayout(5,5));
		northJP.setLayout(new GridLayout(0,3,4,2));
		centerJP.setLayout(new GridLayout(0,3,4,2));
		centerJP.setBorder(BorderFactory.createTitledBorder("bar")); 
		JLabel jlA = new JLabel("Atrname");
		JLabel jlK = new JLabel("Klassenname");		
		klassenName = new JTextField();			
		atrN = new JTextField();		
		String [] dt = {"int","String"};
		datentypen = new JComboBox<>(dt);		
		final ArrayList<ArrayList<String>> data = new ArrayList<>();
		ArrayList<String> row = new ArrayList<String>();
		jb1 = new JButton("Atr hinz");
		jb2 = new JButton("Atr löschen");
		attributTable = new JTable(new MyTableModel(data));
		//Atribut button
				jb1.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						//kled.setVisible(false);
						ArrayList<String> row = new ArrayList<String>();					
						row.add(atrN.getText());
						row.add((String)datentypen.getSelectedItem());
						data.add(row);
						TableModel dm = attributTable.getModel();
						((AbstractTableModel) dm).fireTableDataChanged(); 						
					}
				});
		northJP.add(jlK);
		northJP.add(klassenName);
		northJP.add(new JLabel(""));
		northJP.add(jlA);
		northJP.add(atrN);
		northJP.add(jb1);
		northJP.add(new JLabel("Datentyp:"));
		northJP.add(datentypen);		
		northJP.add(jb2);
		
		jp.add(northJP,BorderLayout.PAGE_START);		
		jp.add(attributTable, BorderLayout.CENTER);	
		JScrollPane scrollPane = new JScrollPane(attributTable);
		jp.add(scrollPane);
		this.add(jp);

		this.setPreferredSize(new Dimension(400, 300));
		this.pack();
		this.setVisible(true);
	}

	public JTextField getAtrN() {
		return atrN;
	}

	public JTextField getKlassenName() {
		return klassenName;
	}

	public JButton getJb1() {
		return jb1;
	}

}
