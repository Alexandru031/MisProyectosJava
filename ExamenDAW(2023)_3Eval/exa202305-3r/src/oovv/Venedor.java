/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oovv;

import excep.DNIincorrecteEX;
import excep.EstaBuitEX;

/**
 *
 * @author Eduardo Silvestre
 */
public class Venedor extends Persona {
    
    private String codi;

    public Venedor(String codi, String dni, String nom, String adreça, String telefono) throws EstaBuitEX, DNIincorrecteEX {
        super(dni, nom, adreça, telefono);
        if (codi == null ||codi.isEmpty()) {
            throw new EstaBuitEX("El codi no pot estar buit");
        }
        this.codi = codi;
    }

    @Override
    public String toString() {
        return super.toString() + "___codi: " + codi; 
    }
    
    
}
