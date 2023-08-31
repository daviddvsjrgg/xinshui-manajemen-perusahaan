/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easmbd;

/**
 *
 * @author ASUS TUF
 */
public class HargaSession {
    private static int harga;
    
    public static void setHARGA(int harga){
        HargaSession.harga = harga;
        
    }
    public static int getHARGA(){
        return harga;
    }
    
}
