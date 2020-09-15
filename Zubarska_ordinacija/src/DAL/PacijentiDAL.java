/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.Pacijenti;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author HP Omen
 */
public class PacijentiDAL {
    
    public ArrayList <Pacijenti> dajSvePacijente() throws SQLException{
        
        ArrayList<Pacijenti> listaPacijenata =new ArrayList<>();
        Konekcija con=new Konekcija();
        Connection conn=con.otvoriKonekciju();
        String upit="{call zubarska_ordinacija.dajSvePacijente()}";
        PreparedStatement ps=conn.prepareStatement(upit);
        ResultSet rs=ps.executeQuery();
        
        while(rs.next()){
            int id =rs.getInt("idpacijenti");
            String ime=rs.getString("ime");
            String prezime=rs.getString("prezime");
            String brojTelefona1=rs.getString("brojTelefona1");
            String brojTelefona2=rs.getString("brojTelefona2");
            String email=rs.getString("email");
            String imedrzave=rs.getString("imedrzave");
            String imegrada=rs.getString("imegrada");
            
            Pacijenti k=new Pacijenti(id, ime, prezime, brojTelefona1, brojTelefona2, email, imedrzave, imegrada);
            listaPacijenata.add(k);
        }
        return listaPacijenata;
    }
    
    
    public ArrayList <Pacijenti> pretraziPacijenta(String parametar) throws SQLException{
        
        ArrayList<Pacijenti> listaPacijenata =new ArrayList<>();
        Konekcija con=new Konekcija();
        Connection conn=con.otvoriKonekciju();
        String upit="{call zubarska_ordinacija.pretraziPacijente(?)}";
        PreparedStatement ps=conn.prepareStatement(upit);
        ps.setString(1, parametar);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            
            int id =rs.getInt("idpacijenti");
            String ime=rs.getString("ime");
            String prezime=rs.getString("prezime");
            String brojTelefona1=rs.getString("brojTelefona1");
            String brojTelefona2=rs.getString("brojTelefona2");
            String email=rs.getString("email");
            String imedrzave=rs.getString("imedrzave");
            String imegrada=rs.getString("imegrada");
            
            Pacijenti k=new Pacijenti(id, ime, prezime, brojTelefona1, brojTelefona2, email, imedrzave, imegrada);
            listaPacijenata.add(k);
        }
        return listaPacijenata;
    }
    
    public void obrisiPacijenta(int idpacijenta) throws SQLException{
        
        Konekcija con=new Konekcija();
        Connection conn=con.otvoriKonekciju();
        String upit="{call zubarska_ordinacija.obrisiPacijenta(?)}";
        PreparedStatement ps=conn.prepareStatement(upit);
        ps.setInt(1, idpacijenta);
        ps.executeUpdate();
        conn.close();
    }
    
    public void dodajPacijenta(String ime, String prezime, String brojTelefona1, String brojTelefona2, String email, int idgrad, int iddrzava) throws SQLException{
    
      String upit="{call zubarska_ordinacija.dodajPacijenta(?,?,?,?,?,?,?)}";
        Konekcija con=new Konekcija();
        Connection conn=con.otvoriKonekciju();
        PreparedStatement ps=conn.prepareStatement(upit);
        ps.setString(1, ime);
        ps.setString(2, prezime);
        ps.setString(3, brojTelefona1);
        ps.setString(4, brojTelefona2);
        ps.setString(5, email);
        ps.setInt(6, idgrad);
        ps.setInt(7, iddrzava);

        ps.executeUpdate();
    }
    
    
    public Pacijenti dajPacijentaPoId(int idPacijenta) throws SQLException{
        Pacijenti p=null;
        String upit="{call zubarska_ordinacija.dajPacijentaPoId(?)}";
        Konekcija con=new Konekcija();
        Connection conn=con.otvoriKonekciju();
        PreparedStatement ps=conn.prepareStatement(upit);
        ps.setInt(1, idPacijenta);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            int id =rs.getInt("idpacijenti");
            String ime=rs.getString("ime");
            String prezime=rs.getString("prezime");
            String brojTelefona1=rs.getString("brojtelefona1");
            String brojTelefona2=rs.getString("brojtelefona2");
            String email=rs.getString("email");
            int idgrad=rs.getInt("idgrad");
            int iddrzava=rs.getInt("iddrzava");
            String imegrada=rs.getString("imegrada");
            String imedrzave=rs.getString("imedrzave");
            
         p=new Pacijenti(id, ime, prezime, brojTelefona1, brojTelefona2, email, iddrzava, idgrad, imedrzave, imegrada);
        }
        
        return p;
    } 
    
    public void izmeniPacijenta(String imea, String prezimea, String brojtelefona1a, String brojtelefona2a, String emaila, int idgradaa, int iddrzavea, int idpacijenta) throws SQLException{
        String upit="{call zubarska_ordinacija.izmeniPacijenta(?,?,?,?,?,?,?,?)}";
        Konekcija con=new Konekcija();
        Connection conn=con.otvoriKonekciju();
        PreparedStatement ps=conn.prepareStatement(upit);
        ps.setString(1, imea);
        ps.setString(2, prezimea);
        ps.setString(3, brojtelefona1a);
        ps.setString(4, brojtelefona2a);
        ps.setString(5, emaila);
        ps.setInt(6, iddrzavea);
        ps.setInt(7, idgradaa);
        ps.setInt(8, idpacijenta);
        ps.executeUpdate();
        conn.close();
        
    }
    
 
    
}
