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
import net.sf.jasperreports.charts.JRXAxisFormat;
import net.sf.jasperreports.charts.design.JRDesignAreaPlot;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
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
public class Karyawan extends javax.swing.JFrame {
    Connection con;
    Statement stat;
    PreparedStatement pstat;
    ResultSet rs;
    String sql;
    
     String hakAksesAdminSET = adminSession.getHAKAKSESADMIN();
    /**
     * Creates new form Pelanggan
     */
    public Karyawan() {
        initComponents();
         setExtendedState(JFrame.MAXIMIZED_BOTH);
         umurKaryawan.setVisible(false);
         uwuTD.setVisible(false);
         
         if ("Super Admin".equals(hakAksesAdminSET) || "Admin".equals(hakAksesAdminSET)){
            tambahData.setVisible(true);
            detailK.setVisible(true);
            laporan.setVisible(true);
            detailK.setVisible(true);
        }
         else {
            tambahData.setVisible(false);
            detailK.setVisible(false);
            laporan.setVisible(false);
            detailK.setVisible(false);
         }
        
        koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
        tampilKaryawan();
        detailK.setEnabled(false);
        namaKaryawan.setEditable(true);
//        ubah.setEnabled(false);
//        hapus.setEnabled(false);
//        namaMerekBox();
    }
    
//       public void namaMerekBox() {
//      
//        if ("Super Admin".equals(hakAksesAdminSET) || "Admin".equals(hakAksesAdminSET)) {
//            try {
//            String query = "SELECT * FROM detailmerek";
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery(query);
//            
//            while (rs.next()) {                
//                namaMerek.addItem(rs.getString("NAMAMEREK"));
//            }
//            
//            rs.last();
//            int nomor = rs.getRow();
//            rs.first();
//           
//        } catch (SQLException e) {
//        }
//        }
//    }
        
    
//    public void clear() {
//            idBarang.setText(null);
//            namaMerek.setSelectedItem(this);
//            namaBarang.setText(null);
//            hargaBarang.setText(null);
//            jumlahBarang.setText(null);
//            ubah.setEnabled(false);
//            hapus.setEnabled(false);
//            tambah.setEnabled(true);
//            idBarang.setEditable(true);
//    }
    
   
       
    
    public void tampilKaryawan() {
//        "Super Admin".equals(hakAksesAdminSET) || "Admin".equals(hakAksesAdminSET)
        if ("Super Admin".equals(hakAksesAdminSET) || "Admin".equals(hakAksesAdminSET)){
            try {
            
            DefaultTableModel tblModel = new DefaultTableModel();
                tblModel.addColumn("No");
                tblModel.addColumn("Nama Karyawan");
                tblModel.addColumn("Jabatan");
                tblModel.addColumn("Umur Karyawan");
                tblModel.addColumn("Alamat Karyawan");
                tblModel.addColumn("Tanggal Masuk");
            //Tampil Data...
            
            
//            String sql = "SELECT NAMAKARYAWAN, jabatan.NAMAJABATAN, UMURKARYAWAN, ALAMATKARYAWAN, TGLMASUK, IDKARYAWAN FROM karyawan INNER JOIN jabatan on karyawan.IDJABATAN = jabatan.IDJABATAN ORDER  BY IDKARYAWAN ASC;";
            String sql = "{ call tampilKaryawan() }";
            stat = con.createStatement();
            ResultSet rs = stat.executeQuery(sql);
           int i = 1;
            while(rs.next()){
                tblModel.addRow(new Object[]
                            {
                                i++,
                                rs.getString(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getString(4),
                                rs.getString(5),
                                rs.getString(6)
                                
                            }
                        );
                
            }
            tabelKaryawan.setModel(tblModel);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        uwuTD = new javax.swing.JLabel();
        namaKaryawan = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        umurKaryawan = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        kembali = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelKaryawan = new javax.swing.JTable();
        detailK = new javax.swing.JButton();
        tambahData = new javax.swing.JButton();
        laporan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(239, 239, 201));
        jPanel1.setPreferredSize(new java.awt.Dimension(1600, 900));

        jPanel2.setBackground(new java.awt.Color(20, 52, 75));
        jPanel2.setPreferredSize(new java.awt.Dimension(70, 128));

        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Tabel Karyawan");

        jButton7.setText("Muat Ulang");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(579, 579, 579)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jButton7))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jLabel1.setText("Nama Karyawan");

        uwuTD.setText("Umur");

        namaKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaKaryawanActionPerformed(evt);
            }
        });

        jButton1.setText("Bersihkan");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/easmbd/utrrlobt-removebg-preview.png"))); // NOI18N

        kembali.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        kembali.setText("Kembali");
        kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembaliActionPerformed(evt);
            }
        });

        tabelKaryawan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tabelKaryawan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "null", "null", "null", "null", "null", "null", "null"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelKaryawan.setRowHeight(30);
        tabelKaryawan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelKaryawanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelKaryawan);

        detailK.setText("Detail");
        detailK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailKActionPerformed(evt);
            }
        });

        tambahData.setText("Tambah Data");
        tambahData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahDataActionPerformed(evt);
            }
        });

        laporan.setText("Buat Laporan");
        laporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laporanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1600, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(laporan)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addComponent(kembali, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton1)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(namaKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(detailK)
                                .addGap(18, 18, 18)
                                .addComponent(tambahData)
                                .addGap(131, 131, 131)
                                .addComponent(uwuTD)
                                .addGap(31, 31, 31)
                                .addComponent(umurKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(157, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(namaKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(detailK)
                            .addComponent(umurKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(uwuTD)
                            .addComponent(tambahData)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(laporan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kembali, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(141, 141, 141))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        new Karyawan().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembaliActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        if ("Super Admin".equals(hakAksesAdminSET) || "Admin".equals(hakAksesAdminSET)) {
            new MenuKaryawan().setVisible(true);
            this.dispose();
        } else if (!"Super Admin".equals(hakAksesAdminSET) || !"Admin".equals(hakAksesAdminSET)) {
            new main().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_kembaliActionPerformed

    private void tabelKaryawanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelKaryawanMouseClicked
        // TODO add your handling code here:
//        tambah.setEnabled(false);
//        ubah.setEnabled(true);
//        hapus.setEnabled(true);
//        idBarang.setEditable(false);
          tambahData.setEnabled(false);
          detailK.setEnabled(true);
          namaKaryawan.setEditable(false);
        try {
            int baris = tabelKaryawan.rowAtPoint(evt.getPoint());
            String nama1 = tabelKaryawan.getValueAt(baris, 1).toString();
            namaKaryawan.setText(nama1);
            String nama2 = tabelKaryawan.getValueAt(baris, 3).toString();
            umurKaryawan.setText(nama2);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tabelKaryawanMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
//        clear();
        namaKaryawan.setText(null);
        umurKaryawan.setText(null);
        tambahData.setEnabled(true);
        detailK.setEnabled(false);
        namaKaryawan.setEditable(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void detailKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailKActionPerformed
        // TODO add your handling code here:
        String idKaryawan1 = null,
                idTim1 = null,
                namaKaryawan1 = null,
                alamatKaryawan1 = null,
                telpKaryawan1 = null,
                statusKaryawan1 = null,
                userKaryawan1 = null,
                hakAksesKaryawan1 = null,
                tglMasuk1 = null,
                idJabatan1 = null;
        
        int idGaji1 = 0,
            umurKaryawan1 = 0;
                
        try {
             pstat = con.prepareStatement("SELECT * FROM karyawan INNER JOIN jabatan ON karyawan.IDJABATAN = jabatan.IDJABATAN INNER JOIN gaji ON karyawan.IDGAJI = gaji.IDGAJI INNER JOIN namatim ON karyawan.IDTIM = namatim.IDTIM WHERE NAMAKARYAWAN=? AND UMURKARYAWAN=?;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             pstat.setString(1, namaKaryawan.getText());
             pstat.setString(2, umurKaryawan.getText());
             rs = pstat.executeQuery();
           while (rs.next()){
               idKaryawan1 = rs.getString("IDKARYAWAN");
               idTim1 = rs.getString("NAMATIM");
               namaKaryawan1 = rs.getString("NAMAKARYAWAN");
               telpKaryawan1 = rs.getString("TELPKARYAWAN");
               statusKaryawan1 = rs.getString("STATUSKARYAWAN");
               alamatKaryawan1 = rs.getString("ALAMATKARYAWAN");
               userKaryawan1 = rs.getString("USERKARYAWAN");
               hakAksesKaryawan1 = rs.getString("HAKAKSESKARYAWAN");
               tglMasuk1 = rs.getString("TGLMASUK");
               idGaji1 = rs.getInt("GAJIPOKOK");
               idJabatan1 = rs.getString("NAMAJABATAN");
               umurKaryawan1 = rs.getInt("UMURKARYAWAN");
               
            }
            rs.last();
            if (rs.getRow() == 1) {
                karyawanSession.setIDKARYAWAN(idKaryawan1);
                karyawanSession.setIDGAJI(idGaji1);
                karyawanSession.setIDJABATAN(idJabatan1);
                karyawanSession.setIDTIM(idTim1);
                karyawanSession.setNAMAKARYAWAN(namaKaryawan1);
                karyawanSession.setTELPKARYAWAN(telpKaryawan1);
                karyawanSession.setSTATUSKARYAWAN(statusKaryawan1);
                karyawanSession.setALAMATKARYAWAN(alamatKaryawan1);
                karyawanSession.setUSERKARYAWAN(userKaryawan1);
                karyawanSession.setHAKAKSESKARYAWAN(hakAksesKaryawan1);
                karyawanSession.setTGLMASUK(tglMasuk1);
                karyawanSession.setUMURKARYAWAN(umurKaryawan1);
                
                new TambahKaryawan().setVisible(true);
                this.dispose();
            } else {
                
            }
          } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
          }
    }//GEN-LAST:event_detailKActionPerformed

    private void tambahDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahDataActionPerformed
        // TODO add your handling code here:
        new TambahKaryawan().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_tambahDataActionPerformed

    private void namaKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaKaryawanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaKaryawanActionPerformed

    private void laporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laporanActionPerformed
        // TODO add your handling code here:  
        try {
        JasperDesign jasdi = JRXmlLoader.load("C:\\Users\\ASUS TUF\\Documents\\NetBeansProjects\\easmbd\\src\\easmbd\\report1.jrxml");
//        String sql = "SELECT IDKARYAWAN, NAMAKARYAWAN, jabatan.NAMAJABATAN, UMURKARYAWAN, ALAMATKARYAWAN, TGLMASUK FROM karyawan INNER JOIN jabatan on karyawan.IDJABATAN = jabatan.IDJABATAN ORDER BY IDKARYAWAN ASC";
        String sql = "{ call laporanKar() }";
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
        
        
    }//GEN-LAST:event_laporanActionPerformed

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
            java.util.logging.Logger.getLogger(Karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Karyawan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton detailK;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton kembali;
    private javax.swing.JButton laporan;
    private javax.swing.JTextField namaKaryawan;
    private javax.swing.JTable tabelKaryawan;
    private javax.swing.JButton tambahData;
    private javax.swing.JTextField umurKaryawan;
    private javax.swing.JLabel uwuTD;
    // End of variables declaration//GEN-END:variables
}
