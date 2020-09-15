/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Objects;

/**
 *
 * @author HP Omen
 */
public class Gradovi {
    
    int idGrada;
    String imeGrada;

    public Gradovi(int idGrada, String imeGrada) {
        this.idGrada = idGrada;
        this.imeGrada = imeGrada;
    }

    public int getIdGrada() {
        return idGrada;
    }

    public void setIdGrada(int idGrada) {
        this.idGrada = idGrada;
    }

    public String getImeGrada() {
        return imeGrada;
    }

    public void setImeGrada(String imeGrada) {
        this.imeGrada = imeGrada;
    }

    @Override
    public String toString() {
        return imeGrada;
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
        final Gradovi other = (Gradovi) obj;
        if (!Objects.equals(this.imeGrada, other.imeGrada)) {
            return false;
        }
        return true;
    }
    
    
    
}
