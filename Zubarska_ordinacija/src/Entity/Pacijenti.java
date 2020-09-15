/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author HP Omen
 */
public class Pacijenti {
    
    int id;
    String ime;
    String prezime;
    String brojTelefona1;
    String brojTelefona2;
    String email;
    String imedrzave;
    String imegrada;
    int idDrzave;
    int idGrada;
    
    public Pacijenti(int id, String ime, String prezime, String brojTelefona1, String brojTelefona2, String email, String imedrzave, String imegrada){
    this.id=id;
    this.ime=ime;
    this.prezime=prezime;
    this.brojTelefona1=brojTelefona1;
    this.brojTelefona2=brojTelefona2;
    this.email=email;
    this.imedrzave=imedrzave;
    this.imegrada=imegrada;
    }

    public Pacijenti(int id, String ime, String prezime, String brojTelefona1, String brojTelefona2, String email, int idDrzave, int idGrada, String imedrzave, String imegrada) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.brojTelefona1 = brojTelefona1;
        this.brojTelefona2 = brojTelefona2;
        this.email = email;
        this.idDrzave = idDrzave;
        this.idGrada = idGrada;
        this.imedrzave = imedrzave;
        this.imegrada = imegrada;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getBrojTelefona1() {
        return brojTelefona1;
    }

    public void setBrojTelefona1(String brojTelefona1) {
        this.brojTelefona1 = brojTelefona1;
    }

    public String getBrojTelefona2() {
        return brojTelefona2;
    }

    public void setBrojTelefona2(String brojTelefona2) {
        this.brojTelefona2 = brojTelefona2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImedrzave() {
        return imedrzave;
    }

    public void setImedrzave(String imedrzave) {
        this.imedrzave = imedrzave;
    }

    public String getImegrada() {
        return imegrada;
    }

    public void setImegrada(String imegrada) {
        this.imegrada = imegrada;
    }

    public int getIdDrzave() {
        return idDrzave;
    }

    public void setIdDrzave(int idDrzave) {
        this.idDrzave = idDrzave;
    }

    public int getIdGrada() {
        return idGrada;
    }

    public void setIdGrada(int idGrada) {
        this.idGrada = idGrada;
    }
    
    
    


    @Override
    public String toString() {
        return "Pacijenti{" + '}';
    }
    
    
    
}
