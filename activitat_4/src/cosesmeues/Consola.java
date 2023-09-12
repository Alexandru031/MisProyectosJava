/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cosesmeues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author usuario
 */
public class Consola {

    /**
     * llig una cadena de text de teclat.
     *
     * @return la cadena llegida
     * @throws IOException
     */
    public static String lligText() throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in)); // el 
        //lector és el teclat
        return lector.readLine(); // llig el text del teclat
    }

    /**
     * llig un enter de teclat. el procés de lectura es repeteix mentre el valor
     * no siga un enter
     *
     * @return el número llegit
     * @throws IOException
     */
    public static int lligEnter() throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        boolean incorrecte = true;
        do {
            try {
                int valor = Integer.parseInt(lector.readLine()); // transforma el text a enter
                return valor; // retorna l'enter resultant de la transformació
            } catch (NumberFormatException ex) { // la transformació falla i s'agafa l'excepció
            }
        } while (incorrecte); // es repeteix mentre la transformació falla
        return -1;
    }
}
