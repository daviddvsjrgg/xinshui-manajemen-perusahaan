package easmbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class koneksi {
  Connection con;
  Statement stm;
  public void config() {
    try {
      con = DriverManager.getConnection("jdbc:mysql://localhost/xinshui_db", "root", "");
      stm = con.createStatement();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "koneksi gagal " + e.getMessage());
    }
  }

}