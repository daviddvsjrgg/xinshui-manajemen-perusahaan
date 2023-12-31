/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package easmbd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author zary cecelya
 */
public class Jabatan extends javax.swing.JFrame {
    Connection con;
    Statement stat;
    PreparedStatement pstat;
    ResultSet rs;
    String sql;
    
    String hakAksesAdminSET = adminSession.getHAKAKSESADMIN();
    /**
     * Creates new form Absensi
     */
    public Jabatan() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
         if ("Super Admin".equals(hakAksesAdminSET) || "Admin".equals(hakAksesAdminSET)){
            tambah.setVisible(true);
            ubah.setVisible(true);
            hapus.setVisible(true);  
            laporanJab.setVisible(true);
        }
         else {
            tambah.setVisible(false);
            laporanJab.setVisible(false);
            ubah.setVisible(false);
            hapus.setVisible(false);
         }
        
        koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
        tampilJabatan();
        ubah.setEnabled(false);
        hapus.setEnabled(false);
        
    }
        public void clear() {
            idJabatan.setText(null);
            namaJabatan.setText(null);
            tunjanganJabatan.setText(null);
            ubah.setEnabled(false);
            hapus.setEnabled(false);
            tambah.setEnabled(true);
            idJabatan.setEnabled(true);
    }
        
    public void tampilJabatan() {
        
        if ("Super Admin".equals(hakAksesAdminSET) || "Admin".equals(hakAksesAdminSET)){
            try {
            
            DefaultTableModel tblModel = new DefaultTableModel();
                tblModel.addColumn("ID Jabatan");
                tblModel.addColumn("Nama Jabatan");
                tblModel.addColumn("Tunjangan Jabatan");
            //Tampil Data...
            String sql = "{ call tampilJabatan() }";
            
            stat = con.createStatement();
            ResultSet rs = stat.executeQuery(sql);
           
            while(rs.next()){
                tblModel.addRow(new Object[]
                            {
                                rs.getString(1),
                                rs.getString(2),
                                rs.getString(3)
                            }
                        );
                
            }
            tabelJabatan.setModel(tblModel);
        } catch (SQLException e) {   
                
        }
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
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        refresh = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        idJabatan = new javax.swing.JTextField();
        namaJabatan = new javax.swing.JTextField();
        tunjanganJabatan = new javax.swing.JTextField();
        tambah = new javax.swing.JButton();
        ubah = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelJabatan = new javax.swing.JTable();
        bersih = new javax.swing.JButton();
        kembali = new javax.swing.JButton();
        laporanJab = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(239, 239, 201));
        jPanel1.setPreferredSize(new java.awt.Dimension(1600, 900));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/easmbd/utrrlobt-removebg-preview.png"))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(20, 52, 75));
        jPanel2.setPreferredSize(new java.awt.Dimension(70, 64));

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Tabel Jabatan");

        refresh.setText("Muat Ulang");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(726, 726, 726)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(refresh)
                .addGap(27, 27, 27))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(refresh))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jLabel1.setText("ID Jabatan");

        jLabel2.setText("Nama Jabatan");

        jLabel3.setText("Tunjangan Jabatan");

        idJabatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idJabatanActionPerformed(evt);
            }
        });

        tunjanganJabatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tunjanganJabatanActionPerformed(evt);
            }
        });

        tambah.setText("Tambah");
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });

        ubah.setText("Ubah");
        ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahActionPerformed(evt);
            }
        });

        hapus.setText("Hapus");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        tabelJabatan.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tabelJabatan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "null", "null", "null"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelJabatan.setRowHeight(40);
        tabelJabatan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelJabatanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelJabatan);

        bersih.setText("Bersihkan");
        bersih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bersihActionPerformed(evt);
            }
        });

        kembali.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        kembali.setText("Kembali");
        kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembaliActionPerformed(evt);
            }
        });

        laporanJab.setText("Buat Laporan");
        laporanJab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laporanJabActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1600, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(laporanJab)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kembali, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(bersih)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3))
                                        .addGap(40, 40, 40)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(idJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(namaJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tunjanganJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(83, 83, 83)
                                .addComponent(tambah)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ubah)
                                .addGap(46, 46, 46)
                                .addComponent(hapus))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 939, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(329, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(idJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(namaJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tunjanganJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tambah)
                            .addComponent(ubah)
                            .addComponent(hapus))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bersih)))
                .addGap(5, 5, 5)
                .addComponent(laporanJab)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kembali))
                .addGap(0, 141, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembaliActionPerformed
        // TODO add your handling code here:
          if ("Super Admin".equals(hakAksesAdminSET) || "Admin".equals(hakAksesAdminSET)) {
            new MenuKaryawan().setVisible(true);
            this.dispose();
        } else if (!"Super Admin".equals(hakAksesAdminSET) || !"Admin".equals(hakAksesAdminSET)) {
            new main().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_kembaliActionPerformed

    private void tunjanganJabatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tunjanganJabatanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tunjanganJabatanActionPerformed

    private void idJabatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idJabatanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idJabatanActionPerformed

    private void bersihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bersihActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_bersihActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        // TODO add your handling code here:
        new Jabatan().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_refreshActionPerformed

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        // TODO add your handling code here:
       ubah.setEnabled(false);
       hapus.setEnabled(false);
        try {
            stat = con.createStatement();
            String SQL = "INSERT INTO jabatan VALUES('"+idJabatan.getText()+"','"+namaJabatan.getText()+"', '"+tunjanganJabatan.getText()+"')";
            stat.executeUpdate(SQL);
            tampilJabatan();
            clear();
            JOptionPane.showMessageDialog(null, "Berhasil disimpan");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data gagal dimasukkan");
        }
    }//GEN-LAST:event_tambahActionPerformed

    private void tabelJabatanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelJabatanMouseClicked
        // TODO add your handling code here:
        tambah.setEnabled(false);
        ubah.setEnabled(true);
        hapus.setEnabled(true);
        idJabatan.setEnabled(false);
        try {
            int baris = tabelJabatan.rowAtPoint(evt.getPoint());
            String nama1 = tabelJabatan.getValueAt(baris, 0).toString();
            idJabatan.setText(nama1);
            String nama2 = tabelJabatan.getValueAt(baris, 1).toString();
            namaJabatan.setText(nama2);
            String nama3 = tabelJabatan.getValueAt(baris, 2).toString();
            tunjanganJabatan.setText(nama3);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tabelJabatanMouseClicked

    private void ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahActionPerformed
        // TODO add your handling code here:
        try {
            String sql ="UPDATE jabatan SET IDJABATAN = '"+idJabatan.getText()+"', NAMAJABATAN = '"+namaJabatan.getText()+"', TUNJANGANJABATAN = '"+tunjanganJabatan.getText()+"' WHERE IDJABATAN = '"+idJabatan.getText()+"'";
            pstat = con.prepareStatement(sql);
            pstat.execute();
            JOptionPane.showMessageDialog(null, "Data berhasil diubah");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Perubahan Data Gagal"+e.getMessage());
        }
        tampilJabatan();
        clear();
    }//GEN-LAST:event_ubahActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        // TODO add your handling code here:
         try {
            int selectedOption = JOptionPane.showConfirmDialog(null, 
                                  "Yakin ingin dihapus?", 
                                  "Hapus Data", 
                                  JOptionPane.YES_NO_OPTION); 
        if (selectedOption == JOptionPane.YES_OPTION) {
             String sql ="DELETE FROM jabatan WHERE IDJABATAN = '"+idJabatan.getText()+"'";
             pstat = con.prepareStatement(sql);
             pstat.execute();
             JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
             tampilJabatan();
             clear();
        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Perubahan Data Gagal"+e.getMessage());
        }
    }//GEN-LAST:event_hapusActionPerformed

    private void laporanJabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laporanJabActionPerformed
        // TODO add your handling code here:
        try {
        JasperDesign jasdi = JRXmlLoader.load("C:\\Users\\ASUS TUF\\Documents\\NetBeansProjects\\easmbd\\src\\easmbd\\tabelJabatan.jrxml");
        String sql = "{ call tampilJabatan() }";
        JRDesignQuery newQuery = new JRDesignQuery();
        newQuery.setText(sql);
        jasdi.setQuery(newQuery);
        JasperReport js = JasperCompileManager.compileReport(jasdi);
        JasperPrint jp = JasperFillManager.fillReport(js, null, con);
//        JasperExportManager.exportReportToHtmlFile(jp, ore);
        JasperViewer.viewReport(jp);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_laporanJabActionPerformed

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
            java.util.logging.Logger.getLogger(Jabatan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jabatan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jabatan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jabatan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Jabatan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bersih;
    private javax.swing.JButton hapus;
    private javax.swing.JTextField idJabatan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton kembali;
    private javax.swing.JButton laporanJab;
    private javax.swing.JTextField namaJabatan;
    private javax.swing.JButton refresh;
    private javax.swing.JTable tabelJabatan;
    private javax.swing.JButton tambah;
    private javax.swing.JTextField tunjanganJabatan;
    private javax.swing.JButton ubah;
    // End of variables declaration//GEN-END:variables
}
