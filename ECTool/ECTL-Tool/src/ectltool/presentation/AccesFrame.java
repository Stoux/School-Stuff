/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ectltool.presentation;

import com.healthmarketscience.jackcess.Column;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.Table;
import ectltool.reader.AccesFileReader;
import ectltool.reader.FileReader;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Leon
 */
public class AccesFrame extends javax.swing.JFrame {

    private DefaultTableModel model;

    /**
     * Creates new form AccesFrame
     */
    public AccesFrame() {
        initComponents();
        model = (DefaultTableModel) colomTable.getModel();
        loadColoms();
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                _.getMF().setEnabled(true);
            }
        });
    }
    
    private void loadColoms() {
        try {
            Database db = DatabaseBuilder.open(_.getMF().getSelectedFile());
            Table t = db.getTable(db.getTableNames().iterator().next());
            int x = 1;
            for (Column colom : t.getColumns()) {
                model.addRow(new Object[]{x, colom.getName()});
                x++;
            }
            
        } catch (IOException e) {
            error("This file is most likely corrupt.");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        colomTable = new javax.swing.JTable();
        addRijButton = new javax.swing.JButton();
        omhoogButton = new javax.swing.JButton();
        omlaagButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        startButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Tables");

        colomTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Colom", "Colom Naam"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        colomTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(colomTable);
        colomTable.getColumnModel().getColumn(0).setMinWidth(50);
        colomTable.getColumnModel().getColumn(0).setPreferredWidth(50);
        colomTable.getColumnModel().getColumn(0).setMaxWidth(200);

        addRijButton.setText("Voeg rij toe");
        addRijButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRijButtonActionPerformed(evt);
            }
        });

        omhoogButton.setText("Verplaats omhoog");
        omhoogButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                omhoogButtonActionPerformed(evt);
            }
        });

        omlaagButton.setText("Verplaats omlaag");
        omlaagButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                omlaagButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(addRijButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(omlaagButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(omhoogButton)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addRijButton)
                    .addComponent(omhoogButton)
                    .addComponent(omlaagButton))
                .addContainerGap())
        );

        startButton.setText("Start ECTL");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(startButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(startButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addRijButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRijButtonActionPerformed
        model.addRow(new Object[]{model.getRowCount() + 1, ""});
    }//GEN-LAST:event_addRijButtonActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        ArrayList<String> coloms = new ArrayList<>();
        for (int x = 0; x < model.getRowCount(); x++) {
            String colom = (String) model.getValueAt(x, 1);
            if (colom.isEmpty()) {
                error("Elke colom moet een naam hebben!");
                return;
            }
            if (coloms.contains(colom)) {
                error("Deze colom naam staat er dubbel in: " + colom);
                return;
            }
            coloms.add(colom);
        }

        if (coloms.isEmpty()) {
            error("Een table kan niet leeg zijn.");
            return;
        }

        MainFrame mf = _.getMF();
        FileReader fr = new AccesFileReader(mf.getSelectedFile(), mf.getCurrentOpdracht(), coloms);
        mf.parseFile(fr);
        dispose();
    }//GEN-LAST:event_startButtonActionPerformed

    private void error(String error) {
        JOptionPane.showMessageDialog(this, error, "Fout!", JOptionPane.ERROR_MESSAGE);
    }

    private void omlaagButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_omlaagButtonActionPerformed
        moveRow(false);
    }//GEN-LAST:event_omlaagButtonActionPerformed

    private void omhoogButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_omhoogButtonActionPerformed
        moveRow(true);
    }//GEN-LAST:event_omhoogButtonActionPerformed

    private void moveRow(boolean up) {
        int row = colomTable.getSelectedRow();
        if (row != -1 && up ? row != model.getRowCount() - 1 : row != 0) {
            String info = (String) model.getValueAt(row, 1);
            model.removeRow(row);
            int selectedRow = (up ? row + 1 : row - 1);
            model.insertRow(selectedRow, new Object[]{0, info});
            updateColomNumbers();
            colomTable.setRowSelectionInterval(selectedRow, selectedRow);
        }
    }

    private void updateColomNumbers() {
        for (int x = 0; x < model.getRowCount(); x++) {
            model.setValueAt((x + 1), x, 0);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AccesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AccesFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addRijButton;
    private javax.swing.JTable colomTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton omhoogButton;
    private javax.swing.JButton omlaagButton;
    private javax.swing.JButton startButton;
    // End of variables declaration//GEN-END:variables
}