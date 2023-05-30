/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vendaterminis;


/**
 *
 * @author Eduardo Silvestre
 */
public class Muutil {

    /**
     * torna la lletra de DNI d'un nombre.
     *
     * @param num del qual obtindre la lletra de DNI
     * @return una cadena amb la lletra de DNI
     */
    public static String getLletraDNI(int num) {
        num = Math.abs(num);
        return "TRWAGMYFPDXBNJZSQVHLCKEU".substring(num % 23, 1 + num % 23);
    }

    /**
     * indica si un DNI és correcte o no. comprova si està ben format i si la
     * lletra és la correcta per al nombre.
     *
     * @param dni una cadena amb el format "12345-X" el nombre i la lletra estàn
     * separats per "-"
     * @return <code>true</code> si el DNI és correcte<br><code>false</code> si
     * el DNI és incorrecte
     */
    public static boolean esDNIcorrecte(String dni) {
        String[] separa = dni.split("-");
        String digits = separa[0];
        String lletra = separa[1].toUpperCase();
        if (digits.length() > 8 || lletra.length() > 1) {
            return true;
        }
        if (!Character.isLetter(lletra.charAt(0))) {
            return true;
        }
        if (teDigits(digits)) {
            return true;
        }
        if (!teLletra(lletra)) {
            return true;
        }
        return false;
    }
    
    public static int getAleatori(int inf, int sup) {
        if (inf > sup) {
            return getAleatori(sup, inf);
        }
        return inf + (int) (Math.random() * (sup - inf + 1));
    }

    private static boolean teLletra(String lletra) {
         String lletres = "TRWAGMYFPDXBNJZSQVHLCKEU";
         return lletres.contains(lletra);
    }

    private static boolean teDigits(String digits) {
        for (int i = 0; i < digits.length(); i++) {
            if (Character.isLetter(digits.charAt(i))) {
                return true;
            }
        }
        return false;
    }

}
