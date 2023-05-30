/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oovv;

import excep.EstaBuitEX;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import vendaterminis.CONST;
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
        int numKey = Muutil.getAleatori(1, productes.size());
        return productes.get("Producte_" + numKey);
    }

    public Venedor getAleatoriVenedor() {
        int numKey = Muutil.getAleatori(1, venedors.size());
        return venedors.get("Venedor_" + numKey);
    }

//    public void afegirVenda(List<Venda> vendaTermi) {
//        vendes = vendaTermi;
//    }
//    public String llistarVendes(String codi) {
//        String llistar = "Vendes de \n------------------\n";
//        for (Map.Entry<String, Venedor> entry : venedors.entrySet()) {
//            Object key = entry.getKey();
//            Object val = entry.getValue();
//        }
//        return llistar;
//    }
//    public void afegirClients(List<Client> client) {
//        clients = client;
//    }
    public Producte getCodiProducte(String codi) {
        for (Map.Entry<String, Producte> entry : productes.entrySet()) {
            String key = entry.getKey();
            Producte val = entry.getValue();
            if (val.getCodi().equals(codi)) {
                return productes.get(key);
            }
        }
        return null;
    }

    public boolean teVenedor(String codi) {
        for (Venda venda : vendes) {
            if (venda.getVenedor().getCodi().equals(codi) || venda instanceof VendaTermini) {
                return true;
            }
        }
//        for (Map.Entry<String, Venedor> entry : venedors.entrySet()) {
//            Venedor val = entry.getValue();
//            if (val.getCodi().equals(codi)) {
//                return true;
//            }
//        }
        return false;
    }

    public String llistarVendes(String codi) {
        String llistat = "";
        if (!teCodi(codi)) {
            return "no has seleccionat el Venedor";
        }
        llistat += "Vendes de " + getNomVenedor(codi) + "\n------------------------------\n";
        int contVendes = 0;
        double importTotal = 0;
        Collections.sort(vendes);
        for (Venda vende : vendes) {
            if (vende.getVenedor().getCodi().equals(codi)) {
                llistat += CONST.DTF.format(vende.getData()) + " > " + vende.getProducte().llistatVendaProducte() + " > " + vende.getPreuVendaPublic();
                importTotal += vende.getPreuVendaPublic();
                if (vende instanceof VendaTermini) {
                    llistat += " > " + ((VendaTermini) vende).getNomTerminisPend() + " > " + ((VendaTermini) vende).getQuantia() + "\n";
                } else {
                    llistat += "\n";
                }
                contVendes++;
            }
        }
        llistat += "-----------------------------------------------------\n" + "Nombre de vendes: " + contVendes + String.format(" Import Total: %.2f", importTotal);
        return llistat;
    }

    public void afegirUnaVenda(Venda venda) {
        vendes.add(venda);
    }

    public void afegirUnaVendaTermini(VendaTermini vendaTermini) {
        vendes.add(vendaTermini);
    }

    public void afegirUnClient(Client client) {
        clients.add(client);
    }

    public boolean getTeDNIRepetit(String dni) {
        boolean estaRepetit = false;
        for (Iterator<Venda> iterator = vendes.iterator(); iterator.hasNext();) {
            Venda next = iterator.next();
            if (next.getVenedor().getDni().equals(dni)) {
                estaRepetit = true;
            }
        }

        for (Iterator<Client> iterator = clients.iterator(); iterator.hasNext();) {
            Client next = iterator.next();
            String[] separaDNI = dni.split("-");
            String otroDNI = next.getDni();
            String[] separaOtro = otroDNI.split("-");
            if (separaDNI[0].equals(separaOtro[0])) {
                estaRepetit = true;
            }
        }
        return estaRepetit;
    }

    private String getNomVenedor(String codi) {
        for (Venda venda : vendes) {
            if (venda.getVenedor().getCodi().equals(codi)) {
                return venda.getVenedor().getNom();
            }
        }
//        for (Iterator<Venda> iterator = vendes.iterator(); iterator.hasNext();) {
//            Venda next = iterator.next();
//            if (next.getVenedor().getCodi().equals(codi)) {
//                return next.getVenedor().getNom();
//            }
//        }
        return null;
    }

    private boolean teCodi(String codi) {
        for (Venda venda : vendes) {
            if (venda.getVenedor().getCodi().equals(codi)) {
                return true;
            }
        }
        return false;
    }
}
