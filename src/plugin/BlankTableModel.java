/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package plugin;

import java.text.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ragil
 */
public class BlankTableModel extends DefaultTableModel  {

    private ArrayList<String> title;
    private ArrayList<ArrayList<String>> content;

    public BlankTableModel(String[] colTitle)    {
        title = new ArrayList<String> ();

        for (int i = 0; i < colTitle.length; i++)
            title.add(colTitle[i]);

        content = new ArrayList<ArrayList<String>> ();
    }

    public void addRow(Object[] row)    {
        System.err.println("Adding " + row.length);

        NumberFormat formatter = new DecimalFormat("0.######E0");
        
        content.add(new ArrayList<String> ());
        for (int i = 0; i < row.length; i++)    {

            if (row[i] instanceof Double)
                content.get(content.size() - 1).add(formatter.format(row[i]));
            else
                content.get(content.size() - 1).add(row[i].toString());
        }

        for (int i = row.length; i < title.size(); i++)
            content.get(content.size() - 1).add("0");

    }

    public Object getValueAt(int r, int c)   {
        return content.get(r).get(c);
    }

    public void setValueAt(Object value, int row, int col)  {
        content.get(row).set(col, (String) value);
    }

    public int getColumnCount() {
        if (title == null)
            return 0;
        return title.size();
    }

    public int getRowCount()    {
        if (content == null)
            return 0;
        return content.size();
    }

    public Class getColumnClass(int columnIndex) {
        return String.class;
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public String getColumnName(int col)    {
        return title.get(col);
    }

}
