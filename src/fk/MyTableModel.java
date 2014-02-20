package fk;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel{
	ArrayList<ArrayList<String>> data;
	
	public MyTableModel(ArrayList<ArrayList<String>> data) {
		this.data = data;
	}

	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Object res = null;
			ArrayList<String> row = data.get(rowIndex);
			res = row.get(columnIndex);
	
    return res;
	}
	public String getColumnName(int column) {
//        switch (column) {
//        case 1:
//            return "Typ";
//        default: return "Name";   
//        }
		if (column == 1) {
			return "Typ";
		}else{
			return "Name";
		}
			
    }

}
