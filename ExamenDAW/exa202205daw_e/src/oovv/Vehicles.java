/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oovv;

import excepcion.MaEx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Alexandru
 */
public class Vehicles {
    
     private List<Vehicle> vehicles;

    public Vehicles() {
        this.vehicles = new ArrayList<>();
    }
    
    public Vehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
    
    public void afegeix(Vehicle vehicle) {
        if (vehicle == null) {
            return;
        }
        this.vehicles.add(vehicle);
    }

    public String llistatComplet() {
        String llistat = "Llistat Complet\n-----------------------\n";
        for (Vehicle veh : vehicles) {
            llistat+= veh + "\n" + veh.llistatRepositoris();
        }
        return llistat;
    }

    public void afegirRespotage(String clauRepostage, Repostage repos) {
        for (Iterator<Vehicle> iterator = vehicles.iterator(); iterator.hasNext();) {
            Vehicle next = iterator.next();
            if (clauRepostage.equals(next.getMatricula())) {
                next.afegirUnRepos(repos);
            }
        }
    }

    public int getVehiclesSize() {
        return vehicles.size();
    }

    public String[] getMatricules() {
        String[] matricules = new String[vehicles.size()];
        for (int i = 0; i < matricules.length; i++) {
            matricules[i] = vehicles.get(i).getMatricula();
        }
        return matricules;
    }

    public String llistatRuta() {
        String llistat = "Llistat dels vehicles en ruta\n--------------------------------\n";
        for (Vehicle vehicle : vehicles) {
            llistat += vehicle.llistatRuta() + "\n";
        }
        llistat += "\n";
        return llistat;
    }

    public boolean getMaximReposKm(double km) throws MaEx {
        double maxim = vehicles.get(0).getMaximKm();
         for (Vehicle next : vehicles) {
             if (next.getMaximKm() > maxim) {
                 throw new MaEx("Els quilometres son inferios a l'ultima repostage: " + maxim);
             }
         }
        return true;
    }
}
