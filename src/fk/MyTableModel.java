package fk;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 * Modell fuer Attribut Tabelle.
 * @author artjom
 *
 */
public class MyTableModel extends AbstractTableModel{
	private ArrayList<ArrayList<String>> attributes;
	
	public MyTableModel(ArrayList<ArrayList<String>> data) {
		this.attributes = data;
	}

	@Override
	public int getRowCount() {
		return attributes.size();
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Object res = null;
			ArrayList<String> row = attributes.get(rowIndex);
			res = row.get(columnIndex);
	
    return res;
	}
	public String getColumnName(int column) {
		if (column == 1) {
			return "Typ";
		}else{
			return "Name";
		}
			
    }
	public void removeRow(int row) {
		attributes.remove(row);
    }


}
