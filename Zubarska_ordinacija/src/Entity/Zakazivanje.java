/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author HP Omen
 */
public class Zakazivanje {
    
    int idZakazivanje;
    String ime;
    String prezime;
    String brojTelefona1;
    String datumIVreme;
    Time vreme;
    String napomena;
    int dosao;
    int otkazao;
    String dosaoS;
    String otkazaoS;

    public Zakazivanje(int idZakazivanje, String ime, String prezime, String brojTelefona1, String datumIVreme, String napomena, int dosao, int otkazao, Time vreme) {
        this.idZakazivanje = idZakazivanje;
        this.ime = ime;
        this.prezime = prezime;
        this.brojTelefona1 = brojTelefona1;
        this.datumIVreme = datumIVreme;
        this.napomena = napomena;
        this.dosao = dosao;
        this.otkazao = otkazao;
        this.vreme = vreme;
    }

    public Time getVreme() {
        return vreme;
    }

    public void setVreme(Time vreme) {
        this.vreme = vreme;
    }
    
    public int getIdZakazivanje() {
        return idZakazivanje;
    }

    public void setIdZakazivanje(int idZakazivanje) {
        this.idZakazivanje = idZakazivanje;
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

    public void setBrojTelefona1(String brojTelefona) {
        this.brojTelefona1 = brojTelefona;
    }

    public String getDatumIVreme() {
        return datumIVreme;
    }

    public void setDatumIVreme(String datumIVreme) {
        this.datumIVreme = datumIVreme;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public int getDosao() {
        return dosao;
    }

    public void setDosao(int dosao) {
        this.dosao = dosao;
    }

    public int getOtkazao() {
        return otkazao;
    }

    public void setOtkazao(int otkazao) {
        this.otkazao = otkazao;
    }

    public String getDosaoS() {
        return dosaoS;
    }

    public void setDosaoS(String dosaoS) {
        this.dosaoS = dosaoS;
    }

    public String getOtkazaoS() {
        return otkazaoS;
    }

    public void setOtkazaoS(String otkazaoS) {
        this.otkazaoS = otkazaoS;
    }
    
    

    @Override
    public String toString() {
        return "Zakazivanje{" + '}';
    }
    
}
