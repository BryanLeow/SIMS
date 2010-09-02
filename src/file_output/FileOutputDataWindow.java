/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FileOutputData.java
 *
 * Created on Aug 24, 2010, 3:03:40 PM
 */

package file_output;

import java.awt.*;

/**
 * File Output GUI component.
 * Handles all GUI and eventlisteners.
 * @author 20378332
 */
public class FileOutputDataWindow extends javax.swing.JFrame {

    /** Creates new form FileOutputData */
    public FileOutputDataWindow() {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        d.setSize(d.getWidth()/2, d.getHeight()/2);
        initComponents();

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
        dataOutputArea = new javax.swing.JTextArea();

        setName("Form"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        dataOutputArea.setColumns(20);
        dataOutputArea.setEditable(false);
        dataOutputArea.setRows(5);
        dataOutputArea.setName("dataOutputArea"); // NOI18N
        jScrollPane1.setViewportView(dataOutputArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1120, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Display data in text area
     * @param text String to be displayed
     */
    protected void displayData(String text)   {
        dataOutputArea.setText(text);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea dataOutputArea;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
