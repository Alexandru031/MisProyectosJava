/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oovv;

import excepcion.MaEx;

/**
 *
 * @author Alexandru
 */
public class Repostage {
    
    private double km;
    private double litres;
    private double preuLitre;

    public Repostage(double km, double litres, double preuLitre) throws MaEx {
        if (km < 0 || litres < 0 || preuLitre < 0) {
            throw new MaEx("No s'accepten valors negatius");
        }
        this.km = km;
        this.litres = litres;
        this.preuLitre = preuLitre;
    }

    public double getKm() {
        return km;
    }

    @Override
    public String toString() {
        return km + "Km " + litres + " Litres a " + preuLitre + "€/L//";
    }
}
