package gui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.FormLayout;

import fk.Attribut;
import fk.MyTableModel;


public class KlasseEditfenster extends JFrame{
	
	JPanel jp;
	JButton jb1;
	JTable jt;
	JTextField atrN;
	JTextField klassenName;
	
	JComboBox<String> datentypen;

	public JPanel getJp() {
		return jp;
	}

	public void init() {
		jp = new JPanel(new GridLayout(0,2));
		JLabel jlA = new JLabel("Atrname");
		JLabel jlK = new JLabel("Klassenname");
		jp.add(jlK);
		klassenName = new JTextField();
		jp.add(klassenName);
		jp.add(jlA);
		atrN = new JTextField();
		jp.add(atrN);
		String [] dt = {"int","String"};
		datentypen = new JComboBox<>(dt);
		jp.add(datentypen);
		
		final ArrayList<ArrayList<String>> data = new ArrayList<>();
		ArrayList<String> row = new ArrayList<String>();
////		row.add("name");
////		row.add("Typ");
//		data.add(row);
		jb1 = new JButton("Atr hinz");
		jt = new JTable(new MyTableModel(data));
		//Atribut button
				jb1.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						//kled.setVisible(false);
						ArrayList<String> row = new ArrayList<String>();
						row.add(atrN.getText());
						row.add((String)datentypen.getSelectedItem());
						data.add(row);
						TableModel dm = jt.getModel();
						((AbstractTableModel) dm).fireTableDataChanged(); 
						
					}
				});
		
		
		jp.add(jt);
		jp.add(jb1);
		JScrollPane scrollPane = new JScrollPane(jt);
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
