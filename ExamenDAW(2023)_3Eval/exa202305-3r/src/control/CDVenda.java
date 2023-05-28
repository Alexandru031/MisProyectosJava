/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import oovv.Producte;
import oovv.Botiga;
import oovv.Client;
import oovv.Venedor;
import vista.DVenda;

/**
 *
 * @author Eduardo Silvestre
 */
public class CDVenda implements ActionListener{

    private DVenda finestra;
    private Botiga botiga;
    private Venedor venedor;
    private Producte producte;
    private Client client;

    public CDVenda(DVenda finestra, Botiga botiga) {
        this.finestra = finestra;
        this.botiga = botiga;
        this.venedor = null;
        this.producte = null;
        this.client = null;
    }
    
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "buscaVenedor":
                
                break;
            case "buscaProducte":

                break;
            case "buscaClient":

                break;
            case "validaVenta":

                break;
            case "validaVenDaTerminis":

                break;
            case "cancelaVenda":
                finestra.dispose();
                break;
        }
    }

}
