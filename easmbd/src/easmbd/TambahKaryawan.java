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
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.swing.JFrame;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;

/**
 *
 * @author zary cecelya
 */
public class TambahKaryawan extends javax.swing.JFrame {
String idKaryawanSET = karyawanSession.getIDKARYAWAN();
    int idGajiSET = karyawanSession.getIDGAJI();
    String idJabatanSET = karyawanSession.getIDJABATAN();
    String idTimSet = karyawanSession.getIDTIM();
    String namaKaryawanSET = karyawanSession.getNAMAKARYAWAN();
    int umurKaryawanSET = karyawanSession.getUMURKARYAWAN();
    String alamatKaryawanSET = karyawanSession.getALAMATKARYAWAN();
    String telpKaryawanSET = karyawanSession.getTELPKARYAWAN();
    String statusKaryawanSET = karyawanSession.getSTATUSKARYAWAN();
    String userKaryawanSET = karyawanSession.getUSERKARYAWAN();
    String hakAksesKaryawan = karyawanSession.getHAKAKSESKARYAWAN();
    String tglMasukSET = karyawanSession.getTGLMASUK();
    
     Connection con;
    Statement stat;
    PreparedStatement pstat;
    ResultSet rs;
    String sql;
    
    String hakAksesAdminSET = adminSession.getHAKAKSESADMIN();
    /**
     * Creates new form DataKaryawan
     */
    public TambahKaryawan() {
        initComponents();
        
        
        if ("Super Admin".equals(hakAksesAdminSET) || "Admin".equals(hakAksesAdminSET)) {
            tambahkanK.setVisible(true);
            dirubah.setText("Pilih Beberapa");
            ambilGaji.setEnabled(false);
            ambilNamatim.setEnabled(false);
            ambiJabatan.setEnabled(false);
            idK.setEnabled(true);
            
            
        } else {
            tambahkanK.setVisible(false);
        }
        
        tglK.setVisible(true);
        tglnof.setVisible(false);
        
        ubah.setVisible(false);
        hapus.setVisible(false);
        
        if("Karyawan Tetap".equals(hakAksesKaryawan) || "Magang".equals(hakAksesKaryawan)) {
            tambahkanK.setVisible(false);
            idK.setEditable(false);
            tglK.setVisible(false);
            tglnof.setVisible(true);
            ubah.setVisible(true);
            hapus.setVisible(true);
            ambilGaji.setEnabled(true);
            ambilNamatim.setEnabled(true);
            ambiJabatan.setEnabled(true);
            idK.setEnabled(false);
            dirubah.setText("Dirubah Ke");
        }
        
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        
        nomorGaji.setVisible(false);
        nomorTim.setVisible(false);
        nomorjabatan.setVisible(false);
      
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        namaK.setText(namaKaryawanSET);
        statusK.setSelectedItem(statusKaryawanSET);
        umurK.setText(String.valueOf(umurKaryawanSET));
        alamatK.setText(alamatKaryawanSET);
        telpK.setText(telpKaryawanSET);
//        tglK.setDate(tglMasukSET);
        idK.setText(idKaryawanSET);
        timK.setSelectedItem(idJabatanSET);
        gajiK.setSelectedItem(idGajiSET);
        timK.setSelectedItem(idTimSet);  
        userK.setText(userKaryawanSET);
        tglnof.setText(tglMasukSET);
        ambilGaji.setText(String.valueOf(formatRupiah.format(idGajiSET)));
        ambiJabatan.setText(idJabatanSET);
        ambilNamatim.setText(idTimSet);
        
         koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
        namaGajiBox();
        namaJabatanBox();
        namaTimBox();
        
    }
    
    public void namaGajiBox() {
        
        if ("Super Admin".equals(hakAksesAdminSET) || "Admin".equals(hakAksesAdminSET)) {
            try {
            String query = "SELECT * FROM gaji";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {                
                gajiK.addItem(rs.getString("GAJIPOKOK"));
            }
            
            rs.last();
            int nomor = rs.getRow();
            rs.first();
           
        } catch (SQLException e) {
        }
        }
    }
    
    public void namaJabatanBox() {
//        "Super Admin".equals(hakAksesAdminSET) || "Admin".equals(hakAksesAdminSET)
        if ("Super Admin".equals(hakAksesAdminSET) || "Admin".equals(hakAksesAdminSET)) {
            try {
            String query = "SELECT * FROM jabatan";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {                
                jabatanK.addItem(rs.getString("NAMAJABATAN"));
            }
            
            rs.last();
            int nomor = rs.getRow();
            rs.first();
           
        } catch (SQLException e) {
        }
        }
    }
    
    public void namaTimBox() {
//        "Super Admin".equals(hakAksesAdminSET) || "Admin".equals(hakAksesAdminSET)
        if ("Super Admin".equals(hakAksesAdminSET) || "Admin".equals(hakAksesAdminSET)) {
            try {
            String query = "SELECT * FROM namatim";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {                
                timK.addItem(rs.getString("NAMATIM"));
            }
            
            rs.last();
            int nomor = rs.getRow();
            rs.first();
           
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
        jLabel1 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        nn = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        idK = new javax.swing.JTextField();
        umurK = new javax.swing.JTextField();
        alamatK = new javax.swing.JTextField();
        telpK = new javax.swing.JTextField();
        namaK = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tambahkanK = new javax.swing.JButton();
        userK = new javax.swing.JTextField();
        gajiK = new javax.swing.JComboBox<>();
        timK = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jabatanK = new javax.swing.JComboBox<>();
        kembali1 = new javax.swing.JButton();
        hakAksesK = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        nomorGaji = new javax.swing.JTextField();
        nomorjabatan = new javax.swing.JTextField();
        nomorTim = new javax.swing.JTextField();
        tglK = new com.toedter.calendar.JDateChooser();
        statusK = new javax.swing.JComboBox<>();
        ubah = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        tglnof = new javax.swing.JTextField();
        ambilNamatim = new javax.swing.JTextField();
        ambilGaji = new javax.swing.JTextField();
        ambiJabatan = new javax.swing.JTextField();
        dirubah = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(239, 239, 201));
        jPanel1.setPreferredSize(new java.awt.Dimension(1450, 740));

        jPanel2.setBackground(new java.awt.Color(20, 52, 75));
        jPanel2.setPreferredSize(new java.awt.Dimension(70, 128));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tambah Data Karyawan");

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
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton7)
                .addGap(39, 39, 39))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton7))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jLabel2.setText("No. ID");

        nn.setText("Nama");

        jLabel4.setText("Umur");

        jLabel5.setText("Alamat");

        jLabel6.setText("No.Telp");

        jLabel7.setText("Tanggal Masuk");

        jLabel11.setText("Status");

        idK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idKActionPerformed(evt);
            }
        });

        umurK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                umurKActionPerformed(evt);
            }
        });

        namaK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaKActionPerformed(evt);
            }
        });

        jLabel12.setText("Gaji Pokok");

        jLabel9.setText("Jabatan");

        jLabel10.setText("Nama User");

        tambahkanK.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tambahkanK.setText("Tambahkan");
        tambahkanK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahkanKActionPerformed(evt);
            }
        });

        userK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userKActionPerformed(evt);
            }
        });

        gajiK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gajiKActionPerformed(evt);
            }
        });

        timK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timKActionPerformed(evt);
            }
        });

        jLabel13.setText("Nama Tim");

        jabatanK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jabatanKActionPerformed(evt);
            }
        });

        kembali1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        kembali1.setText("Kembali");
        kembali1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembali1ActionPerformed(evt);
            }
        });

        hakAksesK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Karyawan Tetap", "Magang" }));
        hakAksesK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hakAksesKActionPerformed(evt);
            }
        });

        jLabel14.setText("Hak Akses");

        statusK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aktif", "Tidak Aktif" }));
        statusK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusKActionPerformed(evt);
            }
        });

        ubah.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ubah.setText("Ubah");
        ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahActionPerformed(evt);
            }
        });

        hapus.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        hapus.setText("Hapus");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        ambilNamatim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ambilNamatimActionPerformed(evt);
            }
        });

        ambilGaji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ambilGajiActionPerformed(evt);
            }
        });

        ambiJabatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ambiJabatanActionPerformed(evt);
            }
        });

        dirubah.setText("Dirubah ke");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1600, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING))
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(nn)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(50, 50, 50)))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ubah)
                        .addGap(18, 18, 18)
                        .addComponent(hapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tambahkanK, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(634, 634, 634))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(telpK, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
                            .addComponent(umurK, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
                            .addComponent(alamatK, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tglK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tglnof, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE))
                            .addComponent(statusK, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(namaK))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(jLabel2)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addGap(53, 53, 53)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(idK)
                                    .addComponent(userK)
                                    .addComponent(hakAksesK, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ambilNamatim, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(timK, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ambilGaji, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                                    .addComponent(ambiJabatan))
                                .addGap(50, 50, 50)
                                .addComponent(jabatanK, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(441, 441, 441)
                                .addComponent(gajiK, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(nomorGaji, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(nomorTim, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(nomorjabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(83, 83, 83))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(kembali1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 1394, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dirubah)
                .addGap(388, 388, 388))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namaK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(idK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nn))
                .addGap(43, 43, 43)
                .addComponent(dirubah)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nomorGaji, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(statusK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ambilGaji, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gajiK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(nomorjabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ambiJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jabatanK, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(timK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(nomorTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ambilNamatim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hakAksesK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(97, 97, 97)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tambahkanK, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ubah)
                            .addComponent(hapus))
                        .addGap(271, 271, 271))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(umurK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(alamatK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(telpK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(userK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10)
                                .addComponent(tglnof, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tglK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(351, 351, 351)))
                .addComponent(kembali1)
                .addGap(137, 137, 137))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void umurKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_umurKActionPerformed
        // TODO add your handling code here:
        umurK.setText(String.valueOf(umurKaryawanSET));
    }//GEN-LAST:event_umurKActionPerformed

    private void namaKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaKActionPerformed

    private void tambahkanKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahkanKActionPerformed
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(tglK.getDate());
        String pass = userK.getText();
        idK.setEnabled(false);
        
        MD5 md5 = new MD5();
        String uwu = md5.getMd5(pass);
try {
            stat = con.createStatement();
            String SQL = "INSERT INTO karyawan VALUES('" + idK.getText() + "','" + nomorGaji.getText() + "','" + nomorjabatan.getText() + "','" + nomorTim.getText() + "', '" + namaK.getText() + "', '" + umurK.getText() + "', '" + alamatK.getText() + "', '" + telpK.getText() + "', '" + statusK.getSelectedItem()+ "', '" + userK.getText() + "', '" + uwu + "', '" + hakAksesK.getSelectedItem()+ "', '" + date + "')";
            stat.executeUpdate(SQL);
            JOptionPane.showMessageDialog(null, "Berhasil disimpan");
            new Karyawan().setVisible(true);
            this.dispose();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }//GEN-LAST:event_tambahkanKActionPerformed

    private void userKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userKActionPerformed

    private void jabatanKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jabatanKActionPerformed
        // TODO add your handling code here:
         int nomor = jabatanK.getSelectedIndex();
            nomorjabatan.setText(String.valueOf(1+nomor));
    }//GEN-LAST:event_jabatanKActionPerformed

    private void kembali1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembali1ActionPerformed
        // TODO add your handling code here:
         //Hapus Session Karyawan
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
         if ("Super Admin".equals(hakAksesAdminSET) || "Admin".equals(hakAksesAdminSET)) {
            new Karyawan().setVisible(true);
            this.dispose();
        } else if (!"Super Admin".equals(hakAksesAdminSET) || !"Admin".equals(hakAksesAdminSET)) {
            new main().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_kembali1ActionPerformed

    private void timKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timKActionPerformed
        // TODO add your handling code here:
        int nomor = timK.getSelectedIndex();
            nomorTim.setText(String.valueOf(nomor));
    }//GEN-LAST:event_timKActionPerformed

    private void hakAksesKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hakAksesKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hakAksesKActionPerformed

    private void gajiKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gajiKActionPerformed
        // TODO add your handling code here:
        int nomor = gajiK.getSelectedIndex();
            nomorGaji.setText(String.valueOf(1+nomor));
    }//GEN-LAST:event_gajiKActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        new TambahKaryawan().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void idKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idKActionPerformed

    private void statusKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusKActionPerformed

    private void ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahActionPerformed
        // TODO add your handling code here:
        
        String pass = userK.getText();
        MD5 md5 = new MD5();
        String uwu = md5.getMd5(pass);
        try {
            String sql ="UPDATE karyawan SET "
                    + "IDKARYAWAN = '"+idK.getText()+"',"
                    + " NAMAKARYAWAN = '"+namaK.getText()+"',"
                    + " STATUSKARYAWAN = '"+statusK.getSelectedItem()+"',"
                    + " UMURKARYAWAN = '"+umurK.getText()+"',"
                    + " ALAMATKARYAWAN = '"+alamatK.getText()+"',"
                    + " IDGAJI = '"+nomorGaji.getText()+"',"
                    + " IDTIM = '"+nomorTim.getText()+"',"
                    + " IDJABATAN = '"+nomorjabatan.getText()+"',"
                    + " USERKARYAWAN = '"+userK.getText()+"',"
                    + " PASSWORDKARYAWAN = '"+ uwu +"' WHERE IDKARYAWAN = '"+idK.getText()+"'";
                    
            pstat = con.prepareStatement(sql);
            pstat.execute();
            JOptionPane.showMessageDialog(null, "Data berhasil diubah");
            new Karyawan().setVisible(true);
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Perubahan Data Gagal"+e.getMessage());
        }
        
         //Hapus Session Karyawan
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
         if ("Super Admin".equals(hakAksesAdminSET) || "Admin".equals(hakAksesAdminSET)) {
            new Karyawan().setVisible(true);
            this.dispose();
        } else if (!"Super Admin".equals(hakAksesAdminSET) || !"Admin".equals(hakAksesAdminSET)) {
            new main().setVisible(true);
            this.dispose();
        }
        
    }//GEN-LAST:event_ubahActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        // TODO add your handling code here:
         try {
            int selectedOption = JOptionPane.showConfirmDialog(null, 
                                  "Yakin ingin dihapus?", 
                                  "Hapus Data", 
                                  JOptionPane.YES_NO_OPTION); 
        if (selectedOption == JOptionPane.YES_OPTION) {
             String sql ="DELETE FROM karyawan WHERE IDKARYAWAN = '"+idK.getText()+"'";
             pstat = con.prepareStatement(sql);
             pstat.execute();
             JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
             new Karyawan().setVisible(true);
             this.dispose();

        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Perubahan Data Gagal"+e.getMessage());
        }
         
          //Hapus Session Karyawan
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
         if ("Super Admin".equals(hakAksesAdminSET) || "Admin".equals(hakAksesAdminSET)) {
            new Karyawan().setVisible(true);
            this.dispose();
        } else if (!"Super Admin".equals(hakAksesAdminSET) || !"Admin".equals(hakAksesAdminSET)) {
            new main().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_hapusActionPerformed

    private void ambilNamatimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ambilNamatimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ambilNamatimActionPerformed

    private void ambilGajiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ambilGajiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ambilGajiActionPerformed

    private void ambiJabatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ambiJabatanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ambiJabatanActionPerformed

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
            java.util.logging.Logger.getLogger(TambahKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TambahKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TambahKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TambahKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TambahKaryawan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alamatK;
    private javax.swing.JTextField ambiJabatan;
    private javax.swing.JTextField ambilGaji;
    private javax.swing.JTextField ambilNamatim;
    private javax.swing.JLabel dirubah;
    private javax.swing.JComboBox<String> gajiK;
    private javax.swing.JComboBox<String> hakAksesK;
    private javax.swing.JButton hapus;
    private javax.swing.JTextField idK;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JComboBox<String> jabatanK;
    private javax.swing.JButton kembali1;
    private javax.swing.JTextField namaK;
    private javax.swing.JLabel nn;
    private javax.swing.JTextField nomorGaji;
    private javax.swing.JTextField nomorTim;
    private javax.swing.JTextField nomorjabatan;
    private javax.swing.JComboBox<String> statusK;
    private javax.swing.JButton tambahkanK;
    private javax.swing.JTextField telpK;
    private com.toedter.calendar.JDateChooser tglK;
    private javax.swing.JTextField tglnof;
    private javax.swing.JComboBox<String> timK;
    private javax.swing.JButton ubah;
    private javax.swing.JTextField umurK;
    private javax.swing.JTextField userK;
    // End of variables declaration//GEN-END:variables
}
