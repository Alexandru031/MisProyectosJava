/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import excepcion.MaEx;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import oovv.Repostage;
import vista.DAfegirRepostage;
import vista.FPrincipal;

/**
 *
 * @author Eduardo Silvestre
 */
public class LDAfegirRepostage implements ActionListener {

    private DAfegirRepostage finestra;
    private String clauRepostage;

    public LDAfegirRepostage(FPrincipal fp) {
        finestra = new DAfegirRepostage(fp, true);
        finestra.setOidor(this);
        finestra.setVisible(true);
    }
    
    public LDAfegirRepostage(DAfegirRepostage finestra) {
        this.finestra = finestra;
    }
    
    public String getClauRepos(){
        return clauRepostage;
    }
    
    public Repostage getRepostage() throws MaEx {
        return finestra.getDadesRepostage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case "valida":
                clauRepostage = finestra.getClauRepos();
            case "cancela":
                finestra.dispose();
                break;
        }
    }

    
}
