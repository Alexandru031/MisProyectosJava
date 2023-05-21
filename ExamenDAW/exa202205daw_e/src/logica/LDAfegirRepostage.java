/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.DAfegirRepostage;

/**
 *
 * @author Eduardo Silvestre
 */
public class LDAfegirRepostage implements ActionListener {

    private DAfegirRepostage finestra;

    public LDAfegirRepostage(DAfegirRepostage finestra) {
        this.finestra = finestra;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case "valida":
                break;
            case "cancela":
                break;
        }

    }

}
