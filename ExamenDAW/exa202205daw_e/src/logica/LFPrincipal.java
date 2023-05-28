/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import excepcion.MaEx;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;;
import javax.swing.JOptionPane;
import oovv.Dades;
import oovv.Repostage;
import oovv.Vehicles;
import vista.DAfegirRepostage;
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
            case "afegir repostage" ->     {
                try {
                    afegirUnRepostatge();
                } catch (MaEx ex) {
                    JOptionPane.showMessageDialog(finestra, ex.getMessage());
                }
            }

            case "llistat complet" ->      llistatcomplet();
            case "llistat en ruta" ->      llistatEnruta();
            case "Eixir" ->                System.exit(0);
        }
    }

    private void llistatEnruta() {
        finestra.mostra(model.llistatRuta());
    }

    private void llistatcomplet() {
        finestra.mostra(model.llistatComplet());
    }

    private void afegirUnRepostatge() throws MaEx {
        DAfegirRepostage f = new DAfegirRepostage(finestra, true);
        f.carregaCB(model.getMatricules());
        LDAfegirRepostage c = new LDAfegirRepostage(f);
        f.setOidor(c);
        f.setVisible(true);
        String clauRepos = c.getClauRepos();
        Repostage repos = c.getRepostage();
        if (model.getMaximReposKm(repos.getKm())) {
            JOptionPane.showMessageDialog(finestra, "S'ha afegit un repostage");
        }
        model.afegirRespotage(clauRepos, repos);
    }

    private void afegirUnVehicle() {
        model.afegeix(LDAfegirVehicle.lligVehicle(finestra));
    }

}
