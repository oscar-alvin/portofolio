/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disperindag.PanelReport;

import com.disperindag.Util.comboKab_model;
import com.disperindag.sql.PERUSAHAAN;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author oscar
 */
public class pnl_sektorUsaha extends javax.swing.JPanel {

    private String[] sektorUsaha = {"Pertanian, Peternakan, Kehutanan, Perkebunan dan Perikanan",
        "Pertambangan dan Penggalian", "Industri Pengolahan", "Listrik, Gas dan Air",
        "Bangunan/Konstruksi", "Perdagangan Besar, Eceran dan Rumah Makan serta Hotel",
        "Angkutan, Penggudangan dan Komunikasi", "Keuangan, Asuransi, Usaha Persewaan Bangunan, Tanah dan Jasa Perusahaan",
        "Jasa Kemasyarakatan, Sosial dan Perorangan", "Kegiatan Yang Belum Jelas Batasannya"
    };
    private String kdSektor;

    /**
     * Creates new form pnl_sektorUsaha
     */
    public pnl_sektorUsaha() {
        initComponents();
        setComboModel();
        clear();
    }

    private void setComboModel() {
        DefaultComboBoxModel bentukUSH = new DefaultComboBoxModel();
        bentukUSH.addElement(PERUSAHAAN.KOPERASI);
        bentukUSH.addElement(PERUSAHAAN.PT);
        bentukUSH.addElement(PERUSAHAAN.CV);
        bentukUSH.addElement(PERUSAHAAN.PO);
        bentukUSH.addElement(PERUSAHAAN.UL);

        DefaultComboBoxModel sektor = new DefaultComboBoxModel();
        for (String s : sektorUsaha) {
            sektor.addElement(s);
        }

        combo_kab.setModel(new comboKab_model());
        combo_bentukUsaha.setModel(bentukUSH);
        combo_sektor.setModel(sektor);
    }

    public void addActionListenerSEKTORUSAHA(ActionListener l) {
        btn_ok.addActionListener(l);
    }

    public String[] getSektorUsaha() {
        String[] a = null;
        try {
            String kab = combo_kab.getSelectedItem().toString();
            String bentukUsaha = combo_bentukUsaha.getSelectedItem().toString();
            String sektorUsaha = combo_sektor.getSelectedItem().toString();

            if (!kab.equals("") && !bentukUsaha.equals("") && !sektorUsaha.equals("")) {
                a = new String[4];
                a[0] = kab;
                a[1] = bentukUsaha;
                a[2] = kdSektor;
                a[3] = sektorUsaha;
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
        combo_kab = new javax.swing.JComboBox();
        combo_bentukUsaha = new javax.swing.JComboBox();
        btn_ok = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        combo_sektor = new javax.swing.JComboBox();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("WILAYAH");

        jLabel3.setText("BENTUK USAHA");

        combo_kab.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        combo_bentukUsaha.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btn_ok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/disperindag/img/printer.png"))); // NOI18N
        btn_ok.setText("CETAK");

        jLabel2.setText("SEKTOR USAHA");

        combo_sektor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo_sektor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_sektorItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_ok))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(combo_sektor, 0, 377, Short.MAX_VALUE)
                            .addComponent(combo_bentukUsaha, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(combo_kab, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(combo_kab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_bentukUsaha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(combo_sektor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_ok)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void combo_sektorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_sektorItemStateChanged
        // TODO add your handling code here:
        if(combo_sektor.getSelectedIndex() < 9 && combo_sektor.getSelectedIndex() > -1){
            kdSektor = ""+(combo_sektor.getSelectedIndex()+1);
        }else {
            kdSektor = "10";
        }
    }//GEN-LAST:event_combo_sektorItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ok;
    private javax.swing.JComboBox combo_bentukUsaha;
    private javax.swing.JComboBox combo_kab;
    private javax.swing.JComboBox combo_sektor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
    public void clear() {
        combo_kab.setSelectedIndex(-1);
        combo_bentukUsaha.setSelectedIndex(-1);
        combo_sektor.setSelectedIndex(-1);
    }
}
