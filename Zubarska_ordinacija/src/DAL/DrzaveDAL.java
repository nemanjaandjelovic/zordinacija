/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.Drzave;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author HP Omen
 */
public class DrzaveDAL {
    
      public ArrayList <Drzave> dajSveDrzave() throws SQLException{
          
        ArrayList<Drzave> listaDrzava=new ArrayList<>();
        Konekcija con=new Konekcija();
        Connection conn=con.otvoriKonekciju();
        String upit="{call zubarska_ordinacija.dajSveDrzave()}";
        PreparedStatement ps=conn.prepareStatement(upit);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            int idDrzave=rs.getInt("iddrzava");
            String imeDrzave=rs.getString("imedrzave");
            Drzave d=new Drzave (idDrzave, imeDrzave);
            listaDrzava.add(d);
        }
        return listaDrzava;
    }
    
}
