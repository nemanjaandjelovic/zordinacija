/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP Omen
 */
public class Konekcija {
    
    Connection con=null;
    
    public Konekcija(){
        
    }
    
    public Connection otvoriKonekciju(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Drajver ne postoji");
            Logger.getLogger(Konekcija.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/zubarska_ordinacija", "root", "");
        } catch (SQLException ex) {
            System.out.println("Neuspela konekcija");
            Logger.getLogger(Konekcija.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    public void zatvoriKonekciju(){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Konekcija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
