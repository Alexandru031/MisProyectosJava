/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oovv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import vendaterminis.Muutil;

/**
 *
 * @author Eduardo Silvestre
 */
public class Botiga {

    private Map<String, Producte> productes;
    private Map<String, Venedor> venedors;
    private List<Client> clients;
    private List<Venda> vendes;

    public Botiga() {
        this.productes = new HashMap<>();
        this.venedors = new HashMap<>();
        this.clients = new ArrayList<>();
        this.vendes = new ArrayList<>();
    }

    public void afegir(Map<String, Venedor> mapVenedor) {
        venedors = mapVenedor;
    }

    public void afegirProducte(Map<String, Producte> mapProducte) {
        productes = mapProducte;
    }

    public Producte getAleatoriProducte() {
        int numKey = Muutil.getAleatori(0, productes.size());
        return productes.get("Producte_"+numKey);
    }

    public Venedor getAleatoriVenedor() {
        int numKey = Muutil.getAleatori(0, venedors.size());
        return venedors.get("Venedor_" + numKey);
    }

    public double getPreuPublic() {
        double media = 0;
        for (Map.Entry<String, Producte> entry : productes.entrySet()) {
            Producte val = entry.getValue();
            media += val.getPreuVenda();
        }
        double mediaAnterior = media / productes.size();
        media = (media / productes.size()) * 0.9;
        return mediaAnterior - media;
    }

    public void afegirVenda(List<Venda> vendaTermi) {
        vendes = vendaTermi;
    }

    public String llistarVendes(String codi) {
        String llistar = "Vendes de \n------------------\n";
        for (Map.Entry<String, Venedor> entry : venedors.entrySet()) {
            Object key = entry.getKey();
            Object val = entry.getValue();
        }
        return llistar;
    }

    public boolean teDNIRepetitVendaTerm(String dni) {
        for (Iterator<Venda> iterator = vendes.iterator(); iterator.hasNext();) {
            VendaTermini next = (VendaTermini) iterator.next();
            if (next.client.getDni().equals(dni)) {
                return true;
            }
        }
        return false;
    }

}
