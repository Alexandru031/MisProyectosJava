/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oovv;

import excepcion.MaEx;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexandru
 */
public class Autobus extends Vehicle{
    private Conductor conductor;
    private List<Repostage> respotatge;
    private int seients;
    private double preuLloguer;

    public Autobus(String matricula, String marca, int seients, double preuLloguer, Conductor conductor) throws MaEx {
        super(matricula, marca);
        if (seients == 0.0) {
            throw new MaEx("Seients no está asignat");
        }
        this.conductor = conductor;
        this.respotatge = new ArrayList<>();
        this.seients = seients;
        this.preuLloguer = preuLloguer;
    }

    public Autobus(String matricula, String marca, int seients) throws MaEx {
        super(matricula, marca);
        if (seients == 0) {
            throw new MaEx("Seients no está asignat");
        }
        this.conductor = new Conductor();
        this.seients = seients;
        this.preuLloguer = 0.0;
    }

    @Override
    public void afegirRepostatge(List<Repostage> repos) {
        respotatge = repos;
    }
    
    @Override
    public String llistatRepositoris(){
        String llistat = "";
        int cont = 0;
        for (Repostage repos : respotatge) {
            if (cont > 2) {
                llistat += "\n";
                cont = 0;
            }
            llistat += repos +" // ";
            cont++;
        }
        llistat += "\n\n";
        return llistat;
    }

    @Override
    public String toString() {
        return "Autobus> " + super.toString() + " amb " + seients + " seients lloguer " + preuLloguer;
    }
    
    
}
