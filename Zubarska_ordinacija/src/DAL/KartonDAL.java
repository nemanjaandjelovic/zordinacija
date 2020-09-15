/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.Karton;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author HP Omen
 */
public class KartonDAL {
    
    public ArrayList <Karton> dajKartonZaPacijenta(int idPacijenta) throws SQLException{
        
        ArrayList<Karton> listaKartona =new ArrayList<>();
        Konekcija con=new Konekcija();
        Connection conn=con.otvoriKonekciju();
        String upit="{call zubarska_ordinacija.dajKartonPacijenta(?)}";
        PreparedStatement ps=conn.prepareStatement(upit);
        ps.setInt(1, idPacijenta);
        ResultSet rs=ps.executeQuery();
        
        while(rs.next()){
            int idintervencije=rs.getInt("idintervencija");
            int idZaposleni=rs.getInt("idzaposleni");
            String imePrezimeZaposlenog=rs.getString("imeiprezime");
            String naslovIntervencije=rs.getString("naslovintervencije");
            Date datumVremeIntervencije=rs.getDate("datumivremeintervencije");
            String opisIntervencije=rs.getString("opisintervencije");
            
            Karton k=new Karton (idintervencije, idZaposleni, imePrezimeZaposlenog, naslovIntervencije, datumVremeIntervencije, opisIntervencije);
            listaKartona.add(k);
        }
        return listaKartona;
    }
    
    public Karton dajIntervenciju(int idIntervencije) throws SQLException{
        
        Karton k=null;
        Konekcija con=new Konekcija();
        Connection conn=con.otvoriKonekciju();
        String upit="{call zubarska_ordinacija.dajIntervencijuPoId(?)}";
        PreparedStatement ps=conn.prepareStatement(upit);
        ps.setInt(1, idIntervencije);
        ResultSet rs=ps.executeQuery();
        
        while(rs.next()){
            int idintervencije=rs.getInt("idintervencija");
            String naslovIntervencije=rs.getString("naslovintervencije");
            String opisIntervencije=rs.getString("opisintervencije");
            
            k=new Karton (idintervencije,0,"", naslovIntervencije,null, opisIntervencije);
        }
        return k;
}
    
    public ArrayList<Integer> dajZubePoIntervenciji(int idIntervencija) throws SQLException{
        
        ArrayList<Integer> listaZuba=new ArrayList<>();
        Konekcija con=new Konekcija();
        Connection conn=con.otvoriKonekciju();
        String upit="{call zubarska_ordinacija.dajZubePoIntervenciji(?)}";
        PreparedStatement ps=conn.prepareStatement(upit);
        ps.setInt(1, idIntervencija);
        ResultSet rs=ps.executeQuery();
        
        while(rs.next()){
            int idZuba=rs.getInt("idzubi");
            listaZuba.add(idZuba);
        }
        return listaZuba;
    } 
    
    public int dodajIntervenciju(int idzaposlenia,int idpacijentia,String naslovintervencijea,String opisintervencijea,int idzakazivanjea) throws SQLException{
        Konekcija con=new Konekcija();
        Connection conn=con.otvoriKonekciju();
        String upit="{call zubarska_ordinacija.dodajIntervenciju(?,?,?,?,?)}";
        PreparedStatement ps=conn.prepareStatement(upit);
        ps.setInt(1, idzaposlenia);
        ps.setInt(2, idpacijentia);
        ps.setString(3, naslovintervencijea);
        ps.setString(4, opisintervencijea);
        ps.setInt(5, idzakazivanjea);
        ResultSet rs=ps.executeQuery();
        int poslednjiid=0;
        while(rs.next()){
            poslednjiid=rs.getInt("poslednjiid");
        }
        return poslednjiid;
    }
    
    public void dodajZubZaIntervenciju(int idIntervencije, int idZuba) throws SQLException{
        
        Konekcija con=new Konekcija();
        Connection conn=con.otvoriKonekciju();
        String upit="{call zubarska_ordinacija.dodajZubZaIntervenciju(?,?)}";
        PreparedStatement ps=conn.prepareStatement(upit);
        ps.setInt(1, idIntervencije);
        ps.setInt(2, idZuba);
        ps.executeUpdate();
        conn.close();
    }
}