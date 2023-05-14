/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package encripta;

import control.CFPrincipal;
import vista.FPrincipal;

/**
 *
 * @author Alexandru
 */
public class Encripta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FPrincipal f = new FPrincipal();
        CFPrincipal c = new CFPrincipal(f);
        f.setOidor(c);
        f.setVisible(true);
    }
    
}
