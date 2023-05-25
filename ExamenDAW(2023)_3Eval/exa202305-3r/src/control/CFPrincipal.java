/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import oovv.Botiga;
import vista.DVenda;
import vista.FPrincipal;

/**
 *
 * @author Eduardo Silvestre
 */
public class CFPrincipal implements ActionListener {

    private FPrincipal finestra;
    private Botiga botiga;

    public CFPrincipal(FPrincipal finestra, Botiga botiga) {
        this.finestra = finestra;
        this.botiga = botiga;
    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "AfegirVenda":
                DVenda f = new DVenda(finestra, true);
                CDVenda c = new CDVenda(f);
                f.setOidor(c);
                f.setVisible(true);
                break;
            case "LlistarVendes":
                finestra.mostra(botiga.llistarVendes());
                break;
        }
    }

}
