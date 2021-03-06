/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DataSummary.java
 *
 * Created on Aug 24, 2010, 3:04:49 PM
 */

package data_summary;
import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 * GUI component for data summary subsystem. This handles
 * all gui components and event listeners.
 * @author 20378332
 */
public class DSWindow extends javax.swing.JFrame {

    private DefaultTableModel stm;

    /** Creates new form DataSummary */
    public DSWindow() {
        stm = DSFrontEnd.tableModel;
        initComponents();
        this.setTitle("Summary Window");
    }

    public DSWindow(DefaultTableModel stm, String title)    {
        this.stm = stm;

        if (this.stm == null)
            this.stm = new DefaultTableModel();
        
        initComponents();
        this.setTitle(title);
        jButton1.setEnabled(false);

        this.dispose();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        summaryTable = new javax.swing.JTable();
        graphButton = new javax.swing.JButton();
        variableSelectionList = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        exportMenu = new javax.swing.JMenuItem();

        setName(""); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        summaryTable.setModel(this.stm);
        summaryTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        summaryTable.setName("summaryTable"); // NOI18N
        jScrollPane1.setViewportView(summaryTable);

        graphButton.setText("Graph");
        graphButton.setName("graphButton"); // NOI18N
        graphButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graphButtonActionPerformed(evt);
            }
        });

        variableSelectionList.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        variableSelectionList.setName("variableSelectionList"); // NOI18N

        jButton1.setText("Calculate");
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jMenuBar1.setBorder(null);
        jMenuBar1.setName("jMenuBar1"); // NOI18N

        jMenu1.setName("jMenu1"); // NOI18N

        exportMenu.setName("exportMenu"); // NOI18N
        jMenu1.add(exportMenu);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1063, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 749, Short.MAX_VALUE)
                        .addComponent(variableSelectionList, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(graphButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(graphButton, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(variableSelectionList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void graphButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graphButtonActionPerformed
        int[] tableEntries = getAllSelectedRow();

        if (tableEntries == null)   {
            javax.swing.JOptionPane.showMessageDialog(null, "You must select atleast 1 input file to plot.\n" +
                    "Select by checking the checkboxes\n",
                    "No files selected", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        int Rvalue = variableSelectionList.getSelectedIndex();
        DSFunctions.generateGraph(tableEntries, Rvalue);
    }//GEN-LAST:event_graphButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int[] rows = getAllSelectedRow();

        DSFunctions.calcUsingFormula(null, rows, new int[0]);
    }//GEN-LAST:event_jButton1ActionPerformed

    private int[] getAllSelectedRow()    {
        int numRow = summaryTable.getRowCount();
        int total = 0;

        // counter the number of selected Row;
        for (int i = 0; i < numRow; i++)    {
            if ((Boolean)summaryTable.getValueAt(i, 2))
                total++;
        }

        if (total == 0)
            return null;

        int[] result = new int[total];
        int counter = 0;

        // insert the rows that are selected
        for (int i = 0; i < numRow; i++)    {
            if ((Boolean)summaryTable.getValueAt(i, 2))
                result[counter++] = i;
        }

        return result;
    }

    protected void extendComboList(int Rn)  {
        variableSelectionList.removeAllItems();
        for (int i = 0; i < Rn; i++)
            variableSelectionList.addItem("R" + i);
    }

    /**
     * Resets the width of each column to default values.
     */
    protected void resetColWidth()    {
        setDefaultTableColumnSize();
        setR0ColumnSize();
    }

    private void setDefaultTableColumnSize() {
        TableColumn column = null;
        for (int i = 0; i < 8; i++) {
            column = summaryTable.getColumnModel().getColumn(i);
            column.setPreferredWidth(defaultColWidth[i]);
        }
    }

    private void setR0ColumnSize()  {
        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
        TableColumn column = null;
        dtcr.setHorizontalAlignment(JLabel.RIGHT);
        int size = summaryTable.getColumnCount();

        for (int i = 8; i < size; i++) {
            column = summaryTable.getColumnModel().getColumn(i);
            column.setPreferredWidth(r0Size);
            summaryTable.setDefaultRenderer(summaryTable.getColumnClass(i), dtcr);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem exportMenu;
    private javax.swing.JButton graphButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable summaryTable;
    private javax.swing.JComboBox variableSelectionList;
    // End of variables declaration//GEN-END:variables

    private int[] defaultColWidth = {40,30,30,100,100,100,120,120};
    private final int r0Size = 120;
}
