/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package easmbd;

/**
 *
 * @author ASUS TUF
 */
public class adminSession {
    private static String namaAdmin, hakAksesAdmin;
    
    public static void setNAMAADMIN(String namaAdmin){
        adminSession.namaAdmin = namaAdmin;
        
    }
    public static String getNAMAADMIN(){
        return namaAdmin;
    }
    
    public static void setHAKAKSESADMIN(String hakAksesAdmin){
        adminSession.hakAksesAdmin = hakAksesAdmin;
        
    }
    public static String getHAKAKSESADMIN(){
        return hakAksesAdmin;
    }
    
 
}
