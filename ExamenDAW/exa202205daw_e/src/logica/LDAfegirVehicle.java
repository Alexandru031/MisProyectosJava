/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import excepcion.MaEx;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import oovv.Vehicle;
import vista.DAfegirVehicle;
import vista.FPrincipal;

/**
 *
 * @author Eduardo Silvestre
 */
public class LDAfegirVehicle implements ActionListener {

    public static Vehicle lligVehicle(FPrincipal fp) {
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
            {
                try {
                    vehicle = finestra.getVehicle();
                    finestra.dispose();
                } catch (NumberFormatException | MaEx ex) {
                    JOptionPane.showMessageDialog(finestra, ex.getMessage());
                }
            }
                break;
            case "valida furgoneta":
                try {
                    vehicle = finestra.getVehicle();
                    finestra.dispose();
                } catch (MaEx ex) {
                    JOptionPane.showMessageDialog(finestra, ex.getMessage());
                }  catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(finestra, "El formato es incorrecto");
                }
                break;
            case "cancela":
                finestra.dispose();
                break;
        }

    }

}
