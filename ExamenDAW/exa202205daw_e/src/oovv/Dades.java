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
 * @author Eduardo Silvestre
 */
public class Dades {

    public static final String NO_ASSIGNAT = "_NA_";

    private static String[] dadesConductors = {
        "Luis Martínez",
        "Ana Mena",
        "Fernando Lahoz",
        NO_ASSIGNAT,
        NO_ASSIGNAT,
        "Maria Pombo",
        "Antoni Saura",
        "Matias Perrello",
        NO_ASSIGNAT,
        NO_ASSIGNAT,
        "Carlos Gutierres",
        NO_ASSIGNAT
    };

    /**
     * la “A” a l’inici indica que són dades d’un autobús, la matrícula, la
     * marca, el nombre de seients i el preu de lloguer<br>
     * la “F” a l’inici indica que són dades d’una furgoneta: la matrícula, la
     * marca, la capacitat màxima i preu del litre de capacitat
     */
    private static String[] dadesVehicles = {
        "A/4544 LMX/Irizar/50/400",
        "A/4500 LMX/Irizar/50/400",
        "F/9748 LMB/Volkswagen/3500/0.155",
        "A/0120 LHS/Volvo/12/250",
        "F/9748 LCD/Nissan/8000/0.89",
        "A/3400 LBB/Iveco/15/300",
        "A/0004 KZZ/Irizar/30/400",
        "F/0220 KHH/Citroën/5300/0.137",
        "A/9348 KLM/Iveco/15/300",
        "A/8884 KLM/Iveco/15/300",
        "F/9748 KLM/Mercedes/5200/0.132",
        "A/4500 KLL/Irizar/50/400"
    };

    /**
     * un repostatge té els quilòmetres, els litres de carburant repostats i el
     * preu del litre, aquestes tres dades es repeteixen per a cada repostage.
     */
    private static String[] dadesRepostatges = {
        "12/328/122.2/1129/84.2/124.1/1485/201.4/112.5",
        "15/328/122.2/1075/184.2/124.1/1715/201.4/112.5",
        "15/128/122.2/475/82/124.1/915/90.1/112.5/1355/90.1/112.5/1852/90.1/112.5",
        "21/150/122.2/578/182/124.1/1115/90.1/112.5/1455/90.1/112.5/1782/90.1/112.5/2011/90.1/112.5",
        "21/150/122.2/578/182/124.1/1115/90.1/112.5/1455/90.1/112.5/1782/90.1/112.5/2011/90.1/112.5/2311/90.1/112.5",
        "11/200/122.2/758/182/124.1/1315/120.1/112.5/1755/145.1/112.5/2382/111.1/112.5/2711/176.3/112.5/3411/90.1/112.5",
        "11/200/122.2/758/182/124.1/1315/120.1/112.5/1755/145.1/112.5/2382/111.1/112.5/2711/176.3/112.5/3411/90.1/112.5",
        "15/128/122.2/475/82/124.1/915/90.1/112.5/1355/90.1/112.5/1852/90.1/112.5/2182/111.1/112.5/2511/176.3/112.5/3211/90.1/112.5",
        "11/200/122.2/758/182/124.1/1315/120.1/112.5/1755/145.1/112.5/2382/111.1/112.5/2711/176.3/112.5/3411/90.1/112.5/4111/90.1/112.5/4811/90.1/112.5/5511/90.1/112.5",
        "11/200/122.2/758/182/124.1/1315/120.1/112.5/1755/145.1/112.5/2382/111.1/112.5/2711/176.3/112.5/3411/90.1/112.5/4111/90.1/112.5/4811/90.1/112.5/5511/90.1/112.5",
        "15/128/122.2/475/82/124.1/915/90.1/112.5/1355/90.1/112.5/1852/90.1/112.5/2182/111.1/112.5/2511/176.3/112.5/3211/90.1/112.5",
        "11/300/122.2/1108/282/124.1/1655/220.1/112.5/2155/145.1/212.5/2912/211.1/112.5/3711/176.3/112.5/4311/190.1/112.5/5111/201.1/112.5/5811/190.1/112.5/6571/201.1/112.5"
    };

    /**
     * torna els vehicles.
     *
     * @return els vehicles
     */
    public static List<Vehicle> getVehicles() throws MaEx {
        List<Vehicle> llistat = new ArrayList<>();
            for (int i = 0; i < dadesVehicles.length; i++) {
                String[] separa = dadesVehicles[i].split("/");
                if (separa[0].equals("A")) {
                    Autobus bus = new Autobus(separa[1], separa[2], Integer.parseInt(separa[3]), Double.parseDouble(separa[4]), new Conductor(dadesConductors[i]));
                    bus.afegirRepostatges(getRepostatge(i));
                    llistat.add(bus);
                } else {
                    Furgoneta furgoneta = new Furgoneta(separa[1], separa[2], Double.parseDouble(separa[3]), Double.parseDouble(separa[4]), new Conductor(dadesConductors[i]));
                    furgoneta.afegirRepostatges(getRepostatge(i));
                    llistat.add(furgoneta);
                }
            }
        return llistat;
    }

    public static int getAleatori(int inf, int sup) {
        if (inf > sup) {
            return getAleatori(sup, inf);
        }
        return inf + (int) (Math.random() * (sup - inf + 1));
    }

    public static String getNomConductor() {
        return dadesConductors[getAleatori(0, dadesConductors.length)];
    }

    private static List<Repostage> getRepostatge(int pos) throws MaEx {
        double km = 0;
        double litres = 0;
        double preu;
        List<Repostage> repos = new ArrayList<>();
        String[] separa = dadesRepostatges[pos].split("/");
        int cont = 1;
        for (String dadarepos : separa) {
            switch (cont) {
                case 1 -> {
                    km = Double.parseDouble(dadarepos);
                    cont++;
                }
                case 2 -> {
                    litres = Double.parseDouble(dadarepos);
                    cont++;
                }
                default -> {
                    preu = Double.parseDouble(dadarepos);
                    Repostage rep = new Repostage(km, litres, preu);
                    repos.add(rep);
                    cont = 1;
                }
            }
        }
        return repos;
    }
}
