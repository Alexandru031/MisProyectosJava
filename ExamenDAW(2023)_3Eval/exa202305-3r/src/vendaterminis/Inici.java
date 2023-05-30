/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendaterminis;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import control.CFPrincipal;
import excep.DNIincorrecteEX;
import excep.EstaBuitEX;
import javax.swing.JOptionPane;
import oovv.Botiga;
import vista.FPrincipal;

/**
 *
 * @author Eduardo Silvestre
 */
public class Inici {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
        }
        java.awt.EventQueue.invokeLater(() -> {
            
//            System.out.println(Muutil.esDNIcorrecte("40007000-X"));
            
            FPrincipal f = new FPrincipal();
            Botiga botiga = new Botiga();
            try {
                botiga = DadesIni.creaBotiga();
            } catch (DNIincorrecteEX | EstaBuitEX ex) {
                JOptionPane.showMessageDialog(f, ex.getMessage());
            }
            CFPrincipal cp = new CFPrincipal(f, botiga);
            f.setOidor(cp);
            f.setVisible(true);
        });
    }

}
