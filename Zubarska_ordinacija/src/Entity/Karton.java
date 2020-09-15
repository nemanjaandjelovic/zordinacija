/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.Date;

/**
 *
 * @author HP Omen
 */
public class Karton {
    
    public int idintervencije;
    public int idZaposleni;
    public String imePrezimeZaposlenog;
    public String naslovIntervencije;
    public Date datumVremeIntervencije;
    public String opisIntervencije;

    public Karton(int idintervencije, int idZaposleni, String imePrezimeZaposlenog, String naslovIntervencije, Date datumVremeIntervencije, String opisIntervencije) {
        this.idintervencije = idintervencije;
        this.idZaposleni = idZaposleni;
        this.imePrezimeZaposlenog = imePrezimeZaposlenog;
        this.naslovIntervencije = naslovIntervencije;
        this.datumVremeIntervencije = datumVremeIntervencije;
        this.opisIntervencije = opisIntervencije;
    }

    public int getIdintervencije() {
        return idintervencije;
    }

    public void setIdintervencije(int idintervencije) {
        this.idintervencije = idintervencije;
    }

    public int getIdZaposleni() {
        return idZaposleni;
    }

    public void setIdZaposleni(int idZaposleni) {
        this.idZaposleni = idZaposleni;
    }

    public String getImePrezimeZaposlenog() {
        return imePrezimeZaposlenog;
    }

    public void setImePrezimeZaposlenog(String imePrezimeZaposlenog) {
        this.imePrezimeZaposlenog = imePrezimeZaposlenog;
    }

    public String getNaslovIntervencije() {
        return naslovIntervencije;
    }

    public void setNaslovIntervencije(String naslovIntervencije) {
        this.naslovIntervencije = naslovIntervencije;
    }

    public Date getDatumVremeIntervencije() {
        return datumVremeIntervencije;
    }

    public void setDatumVremeIntervencije(Date datumVremeIntervencije) {
        this.datumVremeIntervencije = datumVremeIntervencije;
    }

    public String getOpisIntervencije() {
        return opisIntervencije;
    }

    public void setOpisIntervencije(String opisIntervencije) {
        this.opisIntervencije = opisIntervencije;
    }
}
