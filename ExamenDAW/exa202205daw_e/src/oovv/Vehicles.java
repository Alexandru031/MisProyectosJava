/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oovv;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexandru
 */
public class Vehicles {
    
     private List<Vehicle> vehicle;

    public Vehicles() {
        this.vehicle = new ArrayList<>();
    }
    
    public Vehicles(List<Vehicle> vehicles) {
        this.vehicle = vehicles;
    }
    
    public void afegeix(Vehicle vehicle) {
        if (vehicle == null) {
            return;
        }
        this.vehicle.add(vehicle);
    }

    public String llistatComplet() {
        String llistat = "Llistat Complet\n-----------------------\n";
        for (Vehicle veh : vehicle) {
            llistat+= veh + "\n" + veh.llistatRepositoris();
        }
        return llistat;
    }
}
