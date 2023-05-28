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
public class Furgoneta extends Vehicle {

    private Conductor conductor;
    private List<Repostage> repostage;
    private double capMaximLitres;
    private double preuLitre;

    public Furgoneta(String matricula, String marca, double capMaximLitres, double preuLitre, Conductor conductor) throws MaEx {
        super(matricula, marca);
        if (capMaximLitres == 0.0) {
            throw new MaEx("Capacitat maxima no está asignat");
        }
        this.conductor = conductor;
        this.repostage = new ArrayList<>();
        this.capMaximLitres = capMaximLitres;
        this.preuLitre = preuLitre;
    }

    public Furgoneta(String matricula, String marca, double capMaximLitres) throws MaEx {
        super(matricula, marca);
        if (capMaximLitres == 0.0) {
            throw new MaEx("Capacitat maxima no está asignat");
        }
        this.repostage = new ArrayList<>();
        this.conductor = new Conductor();
        this.capMaximLitres = capMaximLitres;
        this.preuLitre = 0.0;
    }

    @Override
    public String llistatRepositoris() {
        String llistat = "";
        int cont = 0;
        if (repostage != null) {
            for (Repostage repos : repostage) {
                if (cont > 2) {
                    llistat += "\n";
                    cont = 0;
                }
                llistat += repos + " // ";
                cont++;
            }
        }
        llistat += "\n\n";
        return llistat;
    }

    @Override
    public void afegirRepostatges(List<Repostage> respos) {
        repostage = respos;
    }

    @Override
    public void afegirUnRepos(Repostage repos) {
        repostage.add(repos);
    }
    
    @Override
    public String llistatRuta() {
        return getMatricula() + "__" + getMarca() + "__" + conductor;
    }

    @Override
    public String toString() {
        return "Furgoneta> " + super.toString() + " amb " + capMaximLitres + " litres de capacitat a " + preuLitre + "€ el litre";
    }

    @Override
    public double getMaximKm() {
        double maxim = repostage.get(0).getKm();
        for (Repostage repos : repostage) {
            if (maxim <= repos.getKm()) {
                maxim = repos.getKm();
            }
        }
        return maxim;
    }
}
