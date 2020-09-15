/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.Zakazivanje;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author HP Omen
 */
public class ZakazivanjeDAL {
    
    public ArrayList <Zakazivanje> dajSvaZakazivanja() throws SQLException{
        
        ArrayList<Zakazivanje> listaZakazivanja =new ArrayList<>();
        Konekcija con=new Konekcija();
        Connection conn=con.otvoriKonekciju();
        String upit="{call zubarska_ordinacija.dajSvaZakazivanja()}";
        PreparedStatement ps=conn.prepareStatement(upit);
        ResultSet rs=ps.executeQuery();
        
        while(rs.next()){
            int id =rs.getInt("idzakazivanje");
            String ime=rs.getString("ime");
            String prezime=rs.getString("prezime");
            String brojTelefona1=rs.getString("brojtelefona1");
            String datumIVreme=rs.getString("datumivreme");
            String napomena=rs.getString("napomena");
            int dosao=rs.getInt("dosao");
            int otkazao=rs.getInt("otkazao");
            java.sql.Time vreme=rs.getTime("vreme");
            
//            java.util.Date vremeUtil = new java.util.Date(datumIVreme.getTime());
//            SimpleDateFormat format = new SimpleDateFormat("HH:mm");
//            String vremes = format.format(vremeUtil);
            
            Zakazivanje z=new Zakazivanje(id, ime, prezime, brojTelefona1, datumIVreme, napomena, dosao, otkazao, vreme);
                   if(dosao==0){
                z.setDosaoS("Ne");
            }
                   else{
                 z.setDosaoS("Da");
            }
                   if(otkazao==0){
                 z.setOtkazaoS("Ne");
        }
                   else{
                   z.setOtkazaoS("Da");
                   }
            listaZakazivanja.add(z);
        }
        return listaZakazivanja;
    }
    
    public void dosao(int idZakazivanja) throws SQLException{
        
        Konekcija con=new Konekcija();
        Connection conn=con.otvoriKonekciju();
        String upit="{call zubarska_ordinacija.dosao(?)}";
        PreparedStatement ps=conn.prepareStatement(upit);
        ps.setInt(1, idZakazivanja);
        ps.executeUpdate();
        conn.close();
    }
    
    public void otkazao(int idZakazivanja) throws SQLException{
        
        Konekcija con=new Konekcija();
        Connection conn=con.otvoriKonekciju();
        String upit="{call zubarska_ordinacija.otkazao(?)}";
        PreparedStatement ps=conn.prepareStatement(upit);
        ps.setInt(1, idZakazivanja);
        ps.executeUpdate();
        conn.close();
    }
    
    public void dodajZakazivanje(int idPacijenta, String napomena, java.sql.Date datum, java.sql.Time vreme) throws SQLException{
        
        Konekcija con=new Konekcija();
        Connection conn=con.otvoriKonekciju();
        String upit="{call zubarska_ordinacija.dodajZakazivanje(?,?,?,?)}";
        PreparedStatement ps=conn.prepareStatement(upit);
        ps.setInt(1, idPacijenta);
        ps.setString(2, napomena);
        ps.setDate(3, datum);
        ps.setTime(4, vreme);
        ps.executeUpdate();
        conn.close();
    }
    
    public ArrayList dajZakazanePoDatumu(Date datum) throws SQLException{
        ArrayList<Zakazivanje> listaZakazivanja =new ArrayList<>();
        Konekcija con=new Konekcija();
        Connection conn=con.otvoriKonekciju();
        String upit="{call zubarska_ordinacija.dajZakazanePoDatumu(?)}";
        PreparedStatement ps=conn.prepareStatement(upit);
        ps.setDate(1, datum);
        ResultSet rs=ps.executeQuery();
        
        while(rs.next()){
            int id =rs.getInt("idzakazivanje");
            String ime=rs.getString("ime");
            String prezime=rs.getString("prezime");
            String brojTelefona1=rs.getString("brojtelefona1");
            String datumIVreme=rs.getString("datumivreme");
            String napomena=rs.getString("napomena");
            int dosao=rs.getInt("dosao");
            int otkazao=rs.getInt("otkazao");
            java.sql.Time vreme=rs.getTime("vreme");
            
            Zakazivanje z=new Zakazivanje(id, ime, prezime, brojTelefona1, datumIVreme, napomena, dosao, otkazao, vreme);
                   if(dosao==0){
                z.setDosaoS("Ne");
            }
                   else{
                 z.setDosaoS("Da");
            }
                   if(otkazao==0){
                 z.setOtkazaoS("Ne");
        }
                   else{
                   z.setOtkazaoS("Da");
                   }
            listaZakazivanja.add(z);
        }
        return listaZakazivanja;
    }
    
}
