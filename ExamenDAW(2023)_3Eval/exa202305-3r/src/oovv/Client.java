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
public class Client extends Persona{
    
    private String nomConcepte;

    public Client(String nomConcepte, String dni, String nom, String adreça, String telefono) throws EstaBuitEX, DNIincorrecteEX {
        super(dni, nom, adreça, telefono);
        if (nomConcepte == null || nomConcepte.isEmpty()) {
            throw new EstaBuitEX("El nombre de compte no pot estar buit");
        }
        this.nomConcepte = nomConcepte;
    }

    @Override
    public String toString() {
        return super.toString() + "___Nombre COncepte: " + nomConcepte;
    }
    
    
}
