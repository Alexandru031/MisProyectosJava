/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import excep.EstaBuitEX;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
                CDVenda c = new CDVenda(f, botiga);
                f.setOidor(c);
                f.setVisible(true);
                break;
            case "LlistarVendes":
                String codi = JOptionPane.showInputDialog(finestra, "Introduceix el codi");
                if (!botiga.teVenedor(codi)) {
                    JOptionPane.showMessageDialog(finestra, "no hi ha cap venedor amb aquest codi");
                } else {
                finestra.mostra(botiga.llistarVendes(codi));
                }
                break;
        }
    }

}
