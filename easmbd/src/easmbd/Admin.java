/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package easmbd;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
public class Admin extends javax.swing.JFrame {
     Connection con;
    Statement stat;
    PreparedStatement pstat;
    ResultSet rs;
    String sql;
    
    String hakAksesAdminSET = adminSession.getHAKAKSESADMIN();
    /**
     * Creates new form Admin
     */
    public Admin() {
        initComponents();
         setExtendedState(JFrame.MAXIMIZED_BOTH);
         nomoMerek.setVisible(false);
         
         if ("Super Admin".equals(hakAksesAdminSET) || "Admin".equals(hakAksesAdminSET)){
            tambah.setVisible(true);
            ubah.setVisible(true);
            hapus.setVisible(true);          
            laporanAdmin.setVisible(true);
            
        }
         else {
            tambah.setVisible(false);
            ubah.setVisible(false);
            laporanAdmin.setVisible(false);
            hapus.setVisible(false);
         }
        
        koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
        tampilAdmin();
        ubah.setEnabled(false);
        hapus.setEnabled(false);
        namaGajiBox();
    }
    
    public void namaGajiBox() {
      
        if ("Super Admin".equals(hakAksesAdminSET) || "Admin".equals(hakAksesAdminSET)) {
            try {
            String query = "{ call tampilGaji() }";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {                
                namaGaji.addItem(rs.getString("GAJIPOKOK"));
            }
            
            rs.last();
            int nomor = rs.getRow();
            rs.first();
           
        } catch (SQLException e) {
        }
        }
    }
        
    
    public void clear() {
            idAdmin.setText(null);
            namaGaji.setSelectedItem(this);
            namaAdmin.setText(null);
//            hargaBarang.setText(null);
//            jumlahBarang.setText(null);
            ubah.setEnabled(false);
            hapus.setEnabled(false);
            tambah.setEnabled(true);
            idAdmin.setEnabled(true);
    }
    
   
       
    
    public void tampilAdmin() {
        
        if ("Super Admin".equals(hakAksesAdminSET) || "Admin".equals(hakAksesAdminSET)){
            try {
            
            DefaultTableModel tblModel = new DefaultTableModel();
                tblModel.addColumn("ID Admin");
                tblModel.addColumn("Nama Admin");
                tblModel.addColumn("Gaji Admin");
                tblModel.addColumn("Hak Akses");
            //Tampil Data...
            String sql = "{ call tampilAdmin() }";
            
            stat = con.createStatement();
            ResultSet rs = stat.executeQuery(sql);
           
            while(rs.next()){
                tblModel.addRow(new Object[]
                            {
                                rs.getString(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getString(4)
                            }
                        );
                
            }
            tabelAdmin.setModel(tblModel);
        } catch (SQLException e) {   
                
        }
        }
        
    }
    
    public class MD5 {
    public String getMd5(String input)
    {
        try {
 
            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
 
            // digest() method is called to calculate message digest
            // of an input digest() return array of byte
            byte[] messageDigest = md.digest(input.getBytes());
 
            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);
 
            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
 
        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
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
        jButton7 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        idAdmin = new javax.swing.JTextField();
        namaAdmin = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tambah = new javax.swing.JButton();
        namaGaji = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        ubah = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelAdmin = new javax.swing.JTable();
        kembali = new javax.swing.JButton();
        nomoMerek = new javax.swing.JTextField();
        Gaji = new javax.swing.JLabel();
        Gaji1 = new javax.swing.JLabel();
        hakAkses = new javax.swing.JComboBox<>();
        laporanAdmin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(239, 239, 201));
        jPanel1.setPreferredSize(new java.awt.Dimension(1600, 900));

        jPanel2.setBackground(new java.awt.Color(20, 52, 75));
        jPanel2.setPreferredSize(new java.awt.Dimension(70, 64));

        jButton7.setText("Muat Ulang");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Tabel Admin");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(617, 617, 617)
                .addComponent(jButton7)
                .addGap(34, 34, 34))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jButton7))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jLabel1.setText("ID Admin");

        jLabel2.setText("Nama Admin");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/easmbd/utrrlobt-removebg-preview.png"))); // NOI18N

        tambah.setText("Tambah");
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });

        namaGaji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaGajiActionPerformed(evt);
            }
        });

        jButton4.setText("Bersihkan");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        hapus.setText("Hapus");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        ubah.setText("Ubah");
        ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahActionPerformed(evt);
            }
        });

        tabelAdmin.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        tabelAdmin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "null", "null", "null", "null"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelAdmin.setRowHeight(35);
        tabelAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelAdminMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelAdmin);

        kembali.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        kembali.setText("Kembali");
        kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembaliActionPerformed(evt);
            }
        });

        nomoMerek.setEditable(false);

        Gaji.setText("Gaji");

        Gaji1.setText("Hak Akses");

        hakAkses.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Super Admin", "Admin" }));
        hakAkses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hakAksesActionPerformed(evt);
            }
        });

        laporanAdmin.setText("Buat Laporan");
        laporanAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laporanAdminActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1600, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(idAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                            .addComponent(namaAdmin))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Gaji1)
                            .addComponent(Gaji)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(580, 580, 580)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nomoMerek, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tambah)
                        .addGap(30, 30, 30)
                        .addComponent(ubah))
                    .addComponent(namaGaji, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hakAkses, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(217, 286, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(laporanAdmin))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(hapus))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(kembali, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 928, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 290, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(namaGaji, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Gaji))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(Gaji1)
                            .addComponent(hakAkses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(namaAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(nomoMerek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tambah)
                                .addComponent(hapus)
                                .addComponent(ubah))
                            .addComponent(jButton4))))
                .addGap(22, 22, 22)
                .addComponent(laporanAdmin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kembali))
                .addContainerGap(127, Short.MAX_VALUE))
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

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        // TODO add your handling code here:
         ubah.setEnabled(false);
       hapus.setEnabled(false);
       
       String pass =  namaAdmin.getText().toLowerCase() +"123"; 
        MD5 md5 = new MD5();
        String pwAdmin = md5.getMd5(pass);
       
        try {
            stat = con.createStatement();
            String SQL = "INSERT INTO admin VALUES('"+idAdmin.getText()+"','"+nomoMerek.getText()+"','"+namaAdmin.getText()+"', '"+pwAdmin+"','"+hakAkses.getSelectedItem()+"')";
            stat.executeUpdate(SQL);
            tampilAdmin();
            clear();
            JOptionPane.showMessageDialog(null, "Berhasil disimpan");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_tambahActionPerformed

    private void namaGajiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaGajiActionPerformed
        // TODO add your handling code here:
         int nomor = namaGaji.getSelectedIndex();
            nomoMerek.setText(String.valueOf(1+nomor));
    }//GEN-LAST:event_namaGajiActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        // TODO add your handling code here:
        try {
            int selectedOption = JOptionPane.showConfirmDialog(null, 
                                  "Yakin ingin dihapus?", 
                                  "Hapus Data", 
                                  JOptionPane.YES_NO_OPTION); 
        if (selectedOption == JOptionPane.YES_OPTION) {
             String sql ="DELETE FROM admin WHERE IDADMIN = '"+idAdmin.getText()+"'";
             pstat = con.prepareStatement(sql);
             pstat.execute();
             JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
             tampilAdmin();
             clear();
        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Perubahan Data Gagal"+e.getMessage());
        }
    }//GEN-LAST:event_hapusActionPerformed

    private void ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahActionPerformed
        // TODO add your handling code here:
         String pass =  namaAdmin.getText().toLowerCase() +"123";
        MD5 md5 = new MD5();
        String pwAdmin = md5.getMd5(pass);
        try {
            String sql ="UPDATE admin SET IDADMIN = '"+idAdmin.getText()+"', IDGAJI = '"+nomoMerek.getText()+"', NAMAADMIN = '"+namaAdmin.getText()+"', PASSWORDADMIN = '"+pwAdmin+"', HAKAKSESADMIN = '"+hakAkses.getSelectedItem()+"' WHERE IDADMIN = '"+idAdmin.getText()+"'";
            pstat = con.prepareStatement(sql);
            pstat.execute();
            JOptionPane.showMessageDialog(null, "Data berhasil diubah");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Perubahan Data Gagal"+e.getMessage());
        }
        tampilAdmin();
        clear();
    }//GEN-LAST:event_ubahActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        new Admin().setVisible(true);
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

    private void tabelAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelAdminMouseClicked
        // TODO add your handling code here:
        tambah.setEnabled(false);
        ubah.setEnabled(true);
        hapus.setEnabled(true);
        idAdmin.setEnabled(false);
        try {
            int baris = tabelAdmin.rowAtPoint(evt.getPoint());
            String nama1 = tabelAdmin.getValueAt(baris, 0).toString();
            idAdmin.setText(nama1);
            String nama2 = tabelAdmin.getValueAt(baris, 2).toString();
            namaGaji.setSelectedItem(nama2);
            String nama3 = tabelAdmin.getValueAt(baris, 1).toString();
            namaAdmin.setText(nama3);
            String nama4 = tabelAdmin.getValueAt(baris, 3).toString();
            hakAkses.setSelectedItem(nama4);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tabelAdminMouseClicked

    private void hakAksesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hakAksesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hakAksesActionPerformed

    private void laporanAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laporanAdminActionPerformed
        // TODO add your handling code here:
        try {
        JasperDesign jasdi = JRXmlLoader.load("C:\\Users\\ASUS TUF\\Documents\\NetBeansProjects\\easmbd\\src\\easmbd\\tabelAdmin.jrxml");
        String sql = "{ call laporanAdmin() }";
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
    }//GEN-LAST:event_laporanAdminActionPerformed

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
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Gaji;
    private javax.swing.JLabel Gaji1;
    private javax.swing.JComboBox<String> hakAkses;
    private javax.swing.JButton hapus;
    private javax.swing.JTextField idAdmin;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton kembali;
    private javax.swing.JButton laporanAdmin;
    private javax.swing.JTextField namaAdmin;
    private javax.swing.JComboBox<String> namaGaji;
    private javax.swing.JTextField nomoMerek;
    private javax.swing.JTable tabelAdmin;
    private javax.swing.JButton tambah;
    private javax.swing.JButton ubah;
    // End of variables declaration//GEN-END:variables
}
