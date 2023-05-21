/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import excepcion.MaEx;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import oovv.Dades;
import oovv.Vehicles;
import vista.DAfegirVehicle;
import vista.FPrincipal;

/**
 *
 * @author Eduardo Silvestre
 */
public class LFPrincipal implements ActionListener {

    private FPrincipal finestra;
    private Vehicles model;

    public LFPrincipal(FPrincipal finestra){
        try {
            this.finestra = finestra;
            this.model = new Vehicles(Dades.getVehicles());
        } catch (MaEx ex) {
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "afegir vehicle" ->       afegirUnVehicle();
            case "afegir repostage" ->     afegirUnRepostatge();
            case "llistat complet" ->      llistatcomplet();
            case "llistat en ruta" ->      llistatEnruta();
            case "Eixir" ->                System.exit(0);
        }
    }

    private void llistatEnruta() {
        
    }

    private void llistatcomplet() {
        finestra.mostra(model.llistatComplet());
    }

    private void afegirUnRepostatge() {
        
    }

    private void afegirUnVehicle() {
        DAfegirVehicle f = new DAfegirVehicle(finestra, true);
        LDAfegirVehicle c = new LDAfegirVehicle(f);
        f.setOidor(c);
        f.setVisible(true);
    }

}
