/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oovv;

/**
 *
 * @author Alexandru
 */
public class MUtils {

    public static int getMCD(int a, int b) {
        if (a >= b) {
            getMCD(b, a); // Si el valor de A es mayor o igual a valor de B, se cambia
        }
        int residuo = 1;
        int mcd = 0;
        while (residuo != 0) { // Mientras que el residuo sea diferente de 0 es true
            residuo = a % b; // Calcula el residuo a través de modulo
            if (residuo == 0) { // Si residuo es igual a 0 entoces MCD es B
                mcd = b;
            } else { // Si no se cambia A por B y B por residuo. Entonces el MCD es el residuo
                a = b;
                b = residuo;
                mcd = residuo; // El MCD es el residuo
            }
        }
        return mcd;
    }
}
