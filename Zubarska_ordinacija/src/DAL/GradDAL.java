/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.Gradovi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author HP Omen
 */
public class GradDAL {
    
    public ArrayList <Gradovi> dajSveGradove() throws SQLException{
                  
        ArrayList<Gradovi> listaDrzava=new ArrayList<>();
        Konekcija con=new Konekcija();
        Connection conn=con.otvoriKonekciju();
        String upit="{call zubarska_ordinacija.dajSveGradove()}";
        PreparedStatement ps=conn.prepareStatement(upit);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            int idGrada=rs.getInt("idgrad");
            String imeGrada=rs.getString("imegrada");
            Gradovi g=new Gradovi (idGrada, imeGrada);
            listaDrzava.add(g);
        }
        return listaDrzava;
    }
    
}
