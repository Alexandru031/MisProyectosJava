/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import exception.MaEx;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        }
    }

}
