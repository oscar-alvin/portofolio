/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disperindag.PanelReport;

import com.disperindag.Util.comboKec_model;
import com.disperindag.sql.PERUSAHAAN;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author oscar
 */
public class pnl_kecamatan extends javax.swing.JPanel {

    /**
     * Creates new form pnl_kecamatan
     */
    public pnl_kecamatan() {
        initComponents();
        setComboModel();
        clear();
    }
    
    private void setComboModel(){
        DefaultComboBoxModel bentukUSH = new DefaultComboBoxModel();
        bentukUSH.addElement(PERUSAHAAN.KOPERASI);
        bentukUSH.addElement(PERUSAHAAN.PT);
        bentukUSH.addElement(PERUSAHAAN.CV);
        bentukUSH.addElement(PERUSAHAAN.PO);
        bentukUSH.addElement(PERUSAHAAN.UL);
        
        combo_kec.setModel(new comboKec_model());
        combo_bentukUsaha.setModel(bentukUSH);
    }
    
    public void addActionListenerBENTUKKECAMATAN (ActionListener l) {
        btn_ok.addActionListener(l);
    }
    
    public String[] getBENTUKKECAMATAN(){
        String[] a = null;
        try {
            String kec = combo_kec.getSelectedItem().toString();
            String bentukUsaha = combo_bentukUsaha.getSelectedItem().toString();
            
            if(!kec.equals("") && !bentukUsaha.equals("") ){
                a = new String[2];
                a[0] = kec;
                a[1] = bentukUsaha;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
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
        jLabel3 = new javax.swing.JLabel();
        combo_kec = new javax.swing.JComboBox();
        combo_bentukUsaha = new javax.swing.JComboBox();
        btn_ok = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("KECAMATAN");

        jLabel3.setText("BENTUK USAHA");

        combo_kec.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        combo_bentukUsaha.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btn_ok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/disperindag/img/printer.png"))); // NOI18N
        btn_ok.setText("CETAK");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_ok)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(32, 32, 32)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(combo_kec, 0, 176, Short.MAX_VALUE)
                            .addComponent(combo_bentukUsaha, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {combo_bentukUsaha, combo_kec});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(combo_kec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(combo_bentukUsaha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_ok)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ok;
    private javax.swing.JComboBox combo_bentukUsaha;
    private javax.swing.JComboBox combo_kec;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
    public void clear(){
        combo_kec.setSelectedIndex(-1);
        combo_bentukUsaha.setSelectedIndex(-1);
    }
}
