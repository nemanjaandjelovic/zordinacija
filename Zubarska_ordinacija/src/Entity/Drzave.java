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
public class Drzave {
    
    int idDrzave;
    String imeDrzave;

    public Drzave(int idDrzave, String imeDrzave) {
        this.idDrzave = idDrzave;
        this.imeDrzave = imeDrzave;
    }

    public int getIdDrzave() {
        return idDrzave;
    }

    public void setIdDrzave(int idDrzave) {
        this.idDrzave = idDrzave;
    }

    public String getImeDrzave() {
        return imeDrzave;
    }

    public void setImeDrzave(String imeDrzave) {
        this.imeDrzave = imeDrzave;
    }

    @Override
    public String toString() {
        return idDrzave + " " + imeDrzave;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Drzave other = (Drzave) obj;
        if (this.idDrzave != other.idDrzave) {
            return false;
        }
        return true;
    }
    
    
    
}
