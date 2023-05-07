/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fraccions;

import oovv.Calculadora;
import oovv.EsZeroEx;
import oovv.MUtils;
import oovv.UnaFraccio;

/**
 *
 * @author Alexandru
 */
public class Fraccions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws EsZeroEx {
//        System.out.println(MUtils.getMCD(65, 90));
        UnaFraccio fraccio1 = new UnaFraccio(1, 3);
        UnaFraccio fraccio2 = new UnaFraccio(3, 5);
        
//        if (fraccio1.equals(fraccio2)) {
//            System.out.println("No dan el mismo resultado");
//            System.out.println(fraccio1.hashCode());
//            System.out.println(fraccio2.hashCode());
//        } else {
//            System.out.println("Dan el mismo resultado");
//            System.out.println(fraccio1.hashCode());
//            System.out.println(fraccio2.hashCode());
//        }
//        System.out.println(MUtils.getMCD(45, 90));
//        fraccio1.simplificar();
//        System.out.println(fraccio1);
//        System.out.println(MUtils.getMCD(12, 24));
//        fraccio2.simplificar();
//        System.out.println(fraccio2);
//        
        Calculadora calc = new Calculadora();
        System.out.println(calc.sumar(fraccio1, fraccio2));
        System.out.println(calc.restar(fraccio1, fraccio2));
    }

}
