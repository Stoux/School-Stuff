/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import control.VormControle;
import java.awt.BorderLayout;

/**
 * Frame voor het toevoegen van een Form
 * Module: VH5I
 * Datum: 10-2013
 * @author Leon Stam
 */
public class VormFrame extends javax.swing.JFrame {

    private VormPanel vormPanel;
    private HoofdFrame hoofdFrame;
    
    /**
     * Creates new form VormFrame
     */
    public VormFrame(HoofdFrame hoofdFrame, VormControle vormControle, String type) {
        this.hoofdFrame = hoofdFrame;
        initComponents();
        
        //Maak het correcte panel aan
        switch(type.toLowerCase()) {
            case "blok":
                vormPanel = new BlokPanel(vormControle);
                setVormLabelText("Blok");
                
                break;
            case "bol": 
                vormPanel = new BolPanel(vormControle);
                setVormLabelText("Bol");
                break;
            case "cilinder":
                vormPanel = new CilinderPanel(vormControle);
                setVormLabelText("Cilinder");
                break;
        }
        
        //Voeg de panel toe & Repaint
        vormPanelHolder.removeAll();
        vormPanelHolder.setLayout(new BorderLayout());
        vormPanelHolder.add(vormPanel);
        revalidate();
        repaint();
        
        //Zet scherm in het midden
        setLocationRelativeTo(null);
        
        //Switch naar nieuwe frame
        hoofdFrame.setEnabled(false);
        setVisible(true);
    }
    
    /**
     * Set de vorm label text
     * @param vorm de vorm
     */
    private void setVormLabelText(String vorm) {
        vormLabel.setText("Vorm: " + vorm);
    }
    
    /**
     * Keer terug naar het hoofdframe
     */
    private void terugNaarHoofdFrame() {
        hoofdFrame.verversScherm();
        hoofdFrame.setEnabled(true);
        setVisible(false);
        dispose();
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
        voegToe = new javax.swing.JButton();
        annuleerKnop = new javax.swing.JButton();
        vormLabel = new javax.swing.JLabel();
        vormPanelHolder = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Leon Stam, 2058473, 10-2013");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 0, 0)));

        voegToe.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        voegToe.setText("Voeg Toe!");
        voegToe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voegToeActionPerformed(evt);
            }
        });

        annuleerKnop.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        annuleerKnop.setText("Annuleer!");
        annuleerKnop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                annuleerKnopActionPerformed(evt);
            }
        });

        vormLabel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        vormLabel.setText("Vorm: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(voegToe, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                    .addComponent(annuleerKnop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(vormLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(vormLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addComponent(voegToe)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(annuleerKnop)
                .addContainerGap())
        );

        vormPanelHolder.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.GroupLayout vormPanelHolderLayout = new javax.swing.GroupLayout(vormPanelHolder);
        vormPanelHolder.setLayout(vormPanelHolderLayout);
        vormPanelHolderLayout.setHorizontalGroup(
            vormPanelHolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 275, Short.MAX_VALUE)
        );
        vormPanelHolderLayout.setVerticalGroup(
            vormPanelHolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(vormPanelHolder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(vormPanelHolder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void voegToeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voegToeActionPerformed
        if (vormPanel.voegToe()) {
            terugNaarHoofdFrame();
        }
    }//GEN-LAST:event_voegToeActionPerformed

    private void annuleerKnopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_annuleerKnopActionPerformed
        terugNaarHoofdFrame();
    }//GEN-LAST:event_annuleerKnopActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton annuleerKnop;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton voegToe;
    private javax.swing.JLabel vormLabel;
    private javax.swing.JPanel vormPanelHolder;
    // End of variables declaration//GEN-END:variables
}
