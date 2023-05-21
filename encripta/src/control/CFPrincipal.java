/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
            case "Llig fitxer": 
            {
                String ruta = JOptionPane.showInputDialog(finestra, "Introduce una ruta de fichero, estás en la ruta(...\\MisProyectosJava\\encripta)");
                try {
                    model.setText(llegirText(ruta));
                    finestra.mostraOrig(model.getText());
                } catch (IOException ex) {
                }
            }
            break;

            case "Guarda fitxer":
                String ruta = JOptionPane.showInputDialog(finestra, "Introduce una ruta de fichero, estás en la ruta(...\\MisProyectosJava\\encripta)");
            {
                try {
                    escriuText(finestra.getCanviat(), ruta);
                } catch (IOException ex) {
                }
            }
                break;

        }
    }

    public String llegirText(String ruta) throws FileNotFoundException, IOException {
        String texto = "";

        try (FileReader f = new FileReader(ruta) // Abre un stream de entrada hacia la ruta
                ) {
            int aux = f.read(); // llig un caràcter del flux i l'assigna a aux llig un enter
            texto += (char) aux;
            while (aux != -1) {
                // mentre no llig el EOF
                aux = f.read(); // llig un caràcter del flux i l'assigna a aux llig un enter
                texto += (char) aux;
            }
            // cerrar el stream
        } // llig un caràcter del flux i l'assigna a aux llig un enter
        return texto;
    }

    public void escriuText(String texto, String ruta) throws FileNotFoundException, IOException {
        try (FileWriter f = new FileWriter(ruta)) {
            for (int i = 0; i < texto.length(); i++) {
                f.write(texto.charAt(i));
            }
            f.close(); // cerrar el stream
        }
    }

}
