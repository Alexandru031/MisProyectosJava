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
public class VendaTermini extends Venda{
    
    protected Client client;
    private int nomTerminisPend;
    private double quantia;

    public VendaTermini(Client client, int nomTerminisPend, double quantia, Producte producte, Venedor venedor, LocalDate data, double preuVendaPublic) {
        super(producte, venedor, data, preuVendaPublic);
        this.client = client;
        this.nomTerminisPend = nomTerminisPend;
        this.quantia = quantia;
    }

    @Override
    public String toString() {
        return super.toString() + "___client " + client +  "___nombre Terminis:" + nomTerminisPend + "___Quantia: " + quantia;
    }

    public int getNomTerminisPend() {
        return nomTerminisPend;
    }

    public double getQuantia() {
        return quantia;
    }
    
    
    
}
