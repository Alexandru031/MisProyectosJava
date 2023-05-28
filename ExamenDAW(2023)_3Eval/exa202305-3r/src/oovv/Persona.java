/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oovv;

import excep.DNIincorrecteEX;
import excep.EstaBuitEX;
import java.util.Objects;
import vendaterminis.Muutil;

/**
 *
 * @author Eduardo Silvestre
 */
public class Persona {
    private String dni;
    private String nom;
    private String adreça;
    private String telefono;

    public Persona(String dni, String nom, String adreça, String telefono) throws EstaBuitEX, DNIincorrecteEX {
        if (dni == null || dni.isEmpty()) {
            throw new EstaBuitEX("EL DNI no pot estar buit");
        }
        if (Muutil.esDNIcorrecte(dni)) {
            throw new DNIincorrecteEX("EL DNI es incorrecte");
        }
        this.dni = dni;
        this.nom = nom;
        this.adreça = adreça;
        this.telefono = telefono;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.dni);
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
        if ((obj)instanceof Persona) {
            return false;
        }
        final Persona other = (Persona) obj;
        return Objects.equals(this.dni, other.dni);
    }

    public String getDni() {
        return dni;
    }

    @Override
    public String toString() {
        return dni + "__" + nom + "__" + adreça +"__" + telefono;
    }
    
    

}
