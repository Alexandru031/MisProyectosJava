/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import oovv.Vehicle;
import vista.DAfegirVehicle;
import vista.FPrincipal;

/**
 *
 * @author Eduardo Silvestre
 */
public class LDAfegirVehicle implements ActionListener {

    public static Vehicle lligTemperatura(FPrincipal fp) {
        return (new LDAfegirVehicle(fp)).getVehicle();
    }
    
    private DAfegirVehicle finestra;
    private Vehicle vehicle;

    public LDAfegirVehicle(FPrincipal fp) {
        vehicle = null;
        finestra = new DAfegirVehicle(fp, true);
        finestra.setOidor(this);
        finestra.setVisible(true);
    }
    
    public LDAfegirVehicle(DAfegirVehicle finestra) {
        this.finestra = finestra;
        this.vehicle = null;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case "valida autobus":
                vehicle = finestra.getVehicle();
                break;
            case "valida furgoneta":

                break;
            case "cancela":
                
                break;
        }

    }

}
