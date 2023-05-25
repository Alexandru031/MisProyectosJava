/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oovv;

import java.time.LocalDate;


/**
 *
 * @author Eduardo Silvestre
 */
public class Venda implements Comparable<Venda>{
    private Producte producte;
    private Venedor venedor;
    private LocalDate data;
    private double preuVendaPublic;

    public Venda(Producte producte, Venedor venedor, LocalDate data, double preuVendaPublic) {
        this.producte = producte;
        this.venedor = venedor;
        this.data = data;
        this.preuVendaPublic = preuVendaPublic;
    }
    
    @Override
    public int compareTo(Venda o) {
        return data.compareTo(o.getData());
    }

    public LocalDate getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Productes: " + producte + "Venedors: " + venedor + " Data: " + data + "___PreuVendaPublic" + preuVendaPublic;
    }
    
    
    
}
