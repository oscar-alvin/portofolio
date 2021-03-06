/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disperindag.panel;

import com.disperindag.dao.daoKabupaten;
import com.disperindag.dao.daoPropinsi;
import com.disperindag.model.Data_KagegoriP;
import com.disperindag.model.kabupaten;
import com.disperindag.model.propinsi;
import com.disperindag.sql.PERUSAHAAN;
import com.disperindag.tableModel.TabelModel_Kategori;
import java.sql.Connection;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author oscar
 */
public class Panel_KategoriP extends javax.swing.JPanel {

    private Connection con = null;
    private TabelModel_Kategori tmk = null;
    private List<propinsi> lp = new daoPropinsi().getPropinsi();
    private List<kabupaten> lkab = null;
    private int id, row, kategori;
    private String prop;
    private String kab;

    /**
     * Creates new form Panel_KategoriP
     */
    public Panel_KategoriP(Connection con, String jp) {
        initComponents();
        this.con = con;
        clear();
        cekStatus(jp);
        init_combo_propinsi();
    }

    private void init_combo_propinsi() {
        combo_prop.removeAllItems();
        for (propinsi p : lp) {
            combo_prop.addItem(p.getNama_prop());
        }
    }

    private void init_combo_kabupaten(List<kabupaten> kab) {
        combo_kab.removeAllItems();
        for (kabupaten k : kab) {
            combo_kab.addItem(k.getNama_kabupaten());
        }
    }

    public void setId(int id) {
        this.id = id;
        tmk = new TabelModel_Kategori(con, id);
        jTable1.setModel(tmk);
    }

    private Data_KagegoriP GETKATEGORI(boolean edit) {
        Data_KagegoriP kp = null;
        try {
            kp = new Data_KagegoriP();
            kp.setId_master(id);
            if (edit == true) {
                kp.setId_kategori(kategori);
            }
            kp.setNama_perusahaan(txt_namaPerush.getText());
            kp.setNo_tdp(txt_noTdp.getText());
            kp.setAlamat(txt_alamat.getText());
            kp.setKabupaten(combo_kab.getSelectedItem().toString());
            kp.setPropinsi(combo_prop.getSelectedItem().toString());
            kp.setKode_pos(txt_kodePos.getText());
            kp.setNotlp(txt_noTlp.getText());
            kp.setStatusP(txt_statusP.getText());
            kp.setJenisKegUsaha(txt_jenisKU.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kp;
    }

    private void SAVE() {
        try {
            JOptionPane.showMessageDialog(null, tmk.addKategori(GETKATEGORI(false)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void UPDATE() {
        try {
            JOptionPane.showMessageDialog(null, tmk.updateKategori(GETKATEGORI(true), row));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setKategori(Data_KagegoriP kp) {
        try {
            this.id = kp.getId_master();
            this.kategori = kp.getId_kategori();
            txt_namaPerush.setText(kp.getNama_perusahaan());
            txt_noTdp.setText(kp.getNo_tdp());
            txt_alamat.setText(kp.getAlamat());
            combo_prop.setSelectedItem(kp.getPropinsi());
            combo_kab.setSelectedItem(kp.getKabupaten());
            txt_kodePos.setText(kp.getKode_pos());
            txt_noTlp.setText(kp.getNotlp());
            txt_statusP.setText(kp.getStatusP());
            txt_jenisKU.setText(kp.getJenisKegUsaha());
        } catch (Exception e) {
            e.printStackTrace();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btn_tambah = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_namaPerush = new javax.swing.JTextField();
        txt_kodePos = new javax.swing.JTextField();
        txt_noTdp = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_alamat = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        combo_kab = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        combo_prop = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_noTlp = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_statusP = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_jenisKU = new javax.swing.JTextField();
        lbl_ket2 = new javax.swing.JLabel();
        lbl_ket1 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btn_tambah.setText("TAMBAH");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });

        btn_hapus.setText("HAPUS");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        btn_edit.setText("EDIT");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        btn_clear.setText("BERSIHKAN");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_tambah)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_edit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_clear)
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_clear, btn_edit, btn_hapus, btn_tambah});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_edit)
                    .addComponent(btn_hapus)
                    .addComponent(btn_clear))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_clear, btn_edit, btn_hapus, btn_tambah});

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Kategori Perusahaan", 0, 0, new java.awt.Font("Arial", 1, 12))); // NOI18N

        jLabel1.setText("Nama Perusahaan");

        txt_namaPerush.setText("jTextField2");

        txt_kodePos.setText("jTextField3");

        try{
            txt_noTdp.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.##.#.##.#####")));
        }catch(java.text.ParseException ex){
            ex.printStackTrace();
        }

        jLabel3.setText("No TDP");

        jLabel4.setText("Alamat Perusahaan");

        txt_alamat.setColumns(20);
        txt_alamat.setRows(5);
        jScrollPane2.setViewportView(txt_alamat);

        jLabel5.setText("Kabupaten");

        combo_kab.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo_kab.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_kabItemStateChanged(evt);
            }
        });

        jLabel6.setText("Propinsi");

        combo_prop.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo_prop.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_propItemStateChanged(evt);
            }
        });

        jLabel7.setText("Kode Pos");

        jLabel8.setText("No.Tlp");

        txt_noTlp.setText("jTextField4");

        jLabel9.setText("Status Perusahaan");

        txt_statusP.setText("jTextField5");

        jLabel10.setText("Jenis Kegiatan Usaha");

        txt_jenisKU.setText("jTextField6");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(combo_prop, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_kodePos)
                                .addComponent(txt_namaPerush)
                                .addComponent(txt_noTdp)
                                .addComponent(jScrollPane2)
                                .addComponent(combo_kab, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_noTlp)
                                .addComponent(txt_statusP)
                                .addComponent(txt_jenisKU, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_namaPerush, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_noTdp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_prop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_kab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_kodePos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_noTlp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_statusP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_jenisKU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        lbl_ket2.setForeground(new java.awt.Color(255, 0, 0));
        lbl_ket2.setText("jLabel11");

        lbl_ket1.setForeground(new java.awt.Color(255, 0, 0));
        lbl_ket1.setText("jLabel11");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_ket2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lbl_ket1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_ket1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_ket2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        // TODO add your handling code here:
        SAVE();
        clear();
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        // TODO add your handling code here:
        if (row > -1) {
            tmk.deleteKategori(row);
        }
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        // TODO add your handling code here:
        if (row > -1) {
            UPDATE();
            clear();
        }
    }//GEN-LAST:event_btn_editActionPerformed

    private void combo_kabItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_kabItemStateChanged
        // TODO add your handling code here:
        if (combo_prop.getSelectedIndex() > -1) {
            prop = combo_prop.getSelectedItem().toString();
        }
    }//GEN-LAST:event_combo_kabItemStateChanged

    private void combo_propItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_propItemStateChanged
        // TODO add your handling code here:
        if (combo_prop.getSelectedIndex() > -1) {
            int kode = lp.get((combo_prop.getSelectedIndex())).getId_prop();
            lkab = new daoKabupaten().getKabupatenByid(kode);
            init_combo_kabupaten(lkab);
            prop = combo_prop.getSelectedItem().toString();
        } else {
            combo_kab.removeAllItems();
        }
    }//GEN-LAST:event_combo_propItemStateChanged

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        try {
            row = jTable1.convertRowIndexToModel(jTable1.getSelectedRow());
            setKategori(tmk.getKategori(jTable1.getSelectedRow()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_btn_clearActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JComboBox combo_kab;
    private javax.swing.JComboBox combo_prop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbl_ket1;
    private javax.swing.JLabel lbl_ket2;
    private javax.swing.JTextArea txt_alamat;
    private javax.swing.JTextField txt_jenisKU;
    private javax.swing.JTextField txt_kodePos;
    private javax.swing.JTextField txt_namaPerush;
    private javax.swing.JFormattedTextField txt_noTdp;
    private javax.swing.JTextField txt_noTlp;
    private javax.swing.JTextField txt_statusP;
    // End of variables declaration//GEN-END:variables

    private void clear() {
        txt_namaPerush.setText("");
        txt_noTdp.setText("");
        txt_alamat.setText("");
        txt_jenisKU.setText("");
        txt_kodePos.setText("");
        txt_statusP.setText("");
        txt_noTlp.setText("");
        combo_kab.setSelectedIndex(-1);
        combo_prop.setSelectedIndex(-1);
    }

    private void cekStatus(String jp) {
        String ket = "Apabila pendaftaran dilakukan oleh Kantor Pusat/Induk, agar disebutkan Setiap Kantor Cabang/Kantor Pembantu/Perwakilan";
        if (jp.equalsIgnoreCase(PERUSAHAAN.CV)) {
            lbl_ket2.setText(ket);
        } else if (jp.equalsIgnoreCase(PERUSAHAAN.PT) || jp.equalsIgnoreCase(PERUSAHAAN.UL)
                || jp.equalsIgnoreCase(PERUSAHAAN.PO)) {
            lbl_ket1.setText("Kantor tunggal tidak perlu mengisi");
            lbl_ket2.setText(ket);
        }
    }
}
