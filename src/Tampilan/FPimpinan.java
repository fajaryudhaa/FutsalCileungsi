/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tampilan;

import Koneksi.KoneksiDB;
import Logic.pimpinan;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC-USER
 */
public class FPimpinan extends javax.swing.JFrame {
private ResultSet RsLpg;
private String trans;
    /**
     * Creates new form FPimpinan
     */
    public FPimpinan() {
        initComponents();
        isiGrid();
    }
    
    void emptyText(){
        TKode.setText("");
        txtalamat.setText("");
        THarga.setText("");
        }
        
    private void isiGrid() {
        delGrid(TTable);
        DefaultTableModel defGrid = (DefaultTableModel) TTable.getModel();
        RsLpg = KoneksiDB.getRS("select * from pimpinan");
        try {
            while (RsLpg.next()) {
                String[] data = {RsLpg.getString("nama"), RsLpg.getString("alamat"),
                                 RsLpg.getString("notlp")};
                defGrid.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FPimpinan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void delGrid(JTable gg) {
        DefaultTableModel defGrid = (DefaultTableModel) gg.getModel();
        int brs = gg.getRowCount();
        for(int i=0;i<brs;i++) {
            defGrid.removeRow(0);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        rSButtonHover1 = new rojerusan.RSButtonHover();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TKode = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        THarga = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtalamat = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TTable = new javax.swing.JTable();
        BSimpan = new rojerusan.RSButtonHover();
        BUbah = new rojerusan.RSButtonHover();
        Bhapus = new rojerusan.RSButtonHover();
        BBatal = new rojerusan.RSButtonHover();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(204, 0, 0));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Manager_40px.png"))); // NOI18N
        jLabel4.setText("Pimpinan");

        rSButtonHover1.setBackground(new java.awt.Color(204, 0, 0));
        rSButtonHover1.setBorder(null);
        rSButtonHover1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Multiply_16px.png"))); // NOI18N
        rSButtonHover1.setColorHover(new java.awt.Color(153, 0, 0));
        rSButtonHover1.setFocusPainted(false);
        rSButtonHover1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rSButtonHover1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonHover1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 773, Short.MAX_VALUE)
                .addComponent(rSButtonHover1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(rSButtonHover1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("Nama");

        TKode.setForeground(new java.awt.Color(204, 0, 0));
        TKode.setBorder(null);
        TKode.setCaretColor(new java.awt.Color(204, 0, 0));
        TKode.setDisabledTextColor(new java.awt.Color(255, 255, 255));

        jLabel2.setForeground(new java.awt.Color(204, 0, 0));
        jLabel2.setText("Alamat");

        jLabel3.setForeground(new java.awt.Color(204, 0, 0));
        jLabel3.setText("No telepon");

        THarga.setForeground(new java.awt.Color(204, 0, 0));
        THarga.setBorder(null);
        THarga.setCaretColor(new java.awt.Color(204, 0, 0));

        jSeparator2.setForeground(new java.awt.Color(204, 51, 0));

        jSeparator4.setForeground(new java.awt.Color(204, 51, 0));

        txtalamat.setColumns(20);
        txtalamat.setForeground(new java.awt.Color(204, 0, 0));
        txtalamat.setRows(5);
        txtalamat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        txtalamat.setCaretColor(new java.awt.Color(204, 0, 0));
        jScrollPane2.setViewportView(txtalamat);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(37, 37, 37)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TKode)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(THarga)
                    .addComponent(jSeparator4))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(86, 86, 86))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(THarga, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(0, 0, 0)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        TTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama", "Alamat", "No Telepon"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TTable);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addContainerGap())
        );

        BSimpan.setBackground(new java.awt.Color(204, 0, 0));
        BSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Save_16px.png"))); // NOI18N
        BSimpan.setText("Simpan");
        BSimpan.setColorHover(new java.awt.Color(255, 51, 0));
        BSimpan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        BSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BSimpanActionPerformed(evt);
            }
        });

        BUbah.setBackground(new java.awt.Color(204, 0, 0));
        BUbah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Renew Subscription_16px.png"))); // NOI18N
        BUbah.setText("Ubah");
        BUbah.setColorHover(new java.awt.Color(255, 51, 0));
        BUbah.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        BUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUbahActionPerformed(evt);
            }
        });

        Bhapus.setBackground(new java.awt.Color(204, 0, 0));
        Bhapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Delete_16px.png"))); // NOI18N
        Bhapus.setText("Hapus");
        Bhapus.setColorHover(new java.awt.Color(255, 51, 0));
        Bhapus.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Bhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BhapusActionPerformed(evt);
            }
        });

        BBatal.setBackground(new java.awt.Color(204, 0, 0));
        BBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Cancel_16px.png"))); // NOI18N
        BBatal.setText("Batal");
        BBatal.setColorHover(new java.awt.Color(255, 51, 0));
        BBatal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        BBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BBatalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(BUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(Bhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(BBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Bhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(102, 102, 102)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TTableMouseClicked
        // TODO add your handling code here:
        if (pimpinan.caripetugas(TTable.getValueAt
            (TTable.getSelectedRow(),0).toString())==true) {
        TKode.setText(pimpinan.getNama());
        txtalamat.setText(pimpinan.getAlamat());
        THarga.setText(pimpinan.getNotlp());
        }
    }//GEN-LAST:event_TTableMouseClicked

    private void BSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BSimpanActionPerformed
        trans="tambah";
        String[] plg={TKode.getText(),txtalamat.getText(),THarga.getText()};
        if (pimpinan.updatepetugas(trans,plg)>0){
            javax.swing.JOptionPane.showMessageDialog(this, "Data Pimpinan Telah Disimpan");
            emptyText();
            isiGrid();
        }
        else{javax.swing.JOptionPane.showMessageDialog(this,
            "Terjadi kesalahan, Silahkan coba lagi", "Kesalahan",
            javax.swing.JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_BSimpanActionPerformed

    private void BUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUbahActionPerformed
        trans="ubah";
        String[] plg={TKode.getText(),txtalamat.getText(),THarga.getText()};
        if (pimpinan.updatepetugas(trans,plg)>0){
            javax.swing.JOptionPane.showMessageDialog(this, "Data Pimpinan Telah Diubah");
            emptyText();
            isiGrid();
        }
        else{javax.swing.JOptionPane.showMessageDialog(this,
            "Terjadi kesalahan, Silahkan coba lagi", "Kesalahan",
            javax.swing.JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_BUbahActionPerformed

    private void BhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BhapusActionPerformed
        trans = "hapus";
        String[] plg = {TKode.getText()};
        if(javax.swing.JOptionPane.showConfirmDialog(this,
            "Anda yakin akan menghapus data ini ?", "Hati-hati !",
            javax.swing.JOptionPane.YES_NO_OPTION)==0) {
        if(pimpinan.updatepetugas(trans, plg)>0) {
            javax.swing.JOptionPane.showMessageDialog(this, "Data Pimpinan Telah Terhapus");
            emptyText();
            isiGrid();
        } else {
            javax.swing.JOptionPane.showMessageDialog(this,
                "Terjadi kesalahan, Silahkan coba lagi", "Kesalahan",
                javax.swing.JOptionPane.ERROR_MESSAGE);
        }
      }
    }//GEN-LAST:event_BhapusActionPerformed

    private void BBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BBatalActionPerformed
        emptyText();
    }//GEN-LAST:event_BBatalActionPerformed

    private void rSButtonHover1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover1ActionPerformed
        dispose();
    }//GEN-LAST:event_rSButtonHover1ActionPerformed

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
            java.util.logging.Logger.getLogger(FPimpinan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FPimpinan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FPimpinan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FPimpinan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FPimpinan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSButtonHover BBatal;
    private rojerusan.RSButtonHover BSimpan;
    private rojerusan.RSButtonHover BUbah;
    private rojerusan.RSButtonHover Bhapus;
    private javax.swing.JTextField THarga;
    private javax.swing.JTextField TKode;
    private javax.swing.JTable TTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private rojerusan.RSButtonHover rSButtonHover1;
    private javax.swing.JTextArea txtalamat;
    // End of variables declaration//GEN-END:variables
}
