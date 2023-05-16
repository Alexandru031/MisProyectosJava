/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import oovv.UnText;
import vista.FPrincipal;

/**
 *
 * @author Alexandru
 */
public class CFPrincipal implements ActionListener {

    private FPrincipal finestra;
    private UnText model;

    public CFPrincipal(FPrincipal finestra) {
        this.finestra = finestra;
        this.model = new UnText();
        finestra.setLocationRelativeTo(finestra);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Encripta":
                String text = JOptionPane.showInputDialog(finestra, "Introduce una palabra secreta:");
                if (text != null) {
                    model.setText(finestra.getOriginal());
                    model.encripta(text);
                    finestra.mostrar(model.getText());
                }
                break;
            case "Desencripta":
                text = JOptionPane.showInputDialog(finestra, "Introduce una palabra secreta:");
                if (text != null) {
                    model.setText(finestra.getOriginal());
                    model.desencripta(text);
                    finestra.mostrar(model.getText());
                }
                break;
            case "Passa":
                finestra.canvia();
                break;
            case "Llig fitxer": {
                try {
                    model.setText(llegirText());
                    finestra.mostraOrig(model.getText());
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(finestra, ex.getMessage());
                }
            }
            break;

            case "Guarda fitxer":

                break;
        }
    }

    public String llegirText() throws FileNotFoundException, IOException {
        String texto = "";
        
        FileReader f = new FileReader("fichero.txt");
        int aux = f.read(); // llig un caràcter del flux i l'assigna a aux llig un enter
        texto += (char) aux;
        while (aux != -1) { // mentre no llig el EOF
            aux = f.read(); // llig un caràcter del flux i l'assigna a aux llig un enter
            texto += (char) aux;
        }
        return texto;
    }

}
