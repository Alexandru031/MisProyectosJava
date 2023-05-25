/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oovv;

import excep.EstaBuitEX;
import java.util.Objects;
import vendaterminis.DadesIni;

/**
 *
 * @author Eduardo Silvestre
 */
public class Producte {

    private String codi;
    private String marca;
    private String nom;
    private String categoria;
    private double preuCompra;
    private double preuVenda;

    public Producte(String codi, String marca, String nom, String categoria, double preuCompra, double preuVenda) throws EstaBuitEX {
        if (codi == null || codi.isEmpty()) {
            throw new EstaBuitEX("El codi no pot estar buit");
        }
        if (preuCompra < 0) {
            preuCompra = 0;
        }
        if (preuVenda < 0) {
            preuVenda = 0;
        }
        this.codi = codi;
        this.marca = marca;
        this.nom = nom;
        this.categoria = categoria;
        this.preuCompra = preuCompra;
        this.preuVenda = preuVenda;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.codi);
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
        final Producte other = (Producte) obj;
        return Objects.equals(this.codi, other.codi);
    }

    /**
     * @return el codi del producte
     */
    public String getCodi() {
        return codi;
    }

    /**
     * @return el preu de venda del producte
     */
    public double getPreuVenda() {
        return preuVenda;
    }

}
