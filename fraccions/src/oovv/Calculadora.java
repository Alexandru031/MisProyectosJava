/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oovv;

/**
 *
 * @author Alexandru
 */
public class Calculadora {
    
    public UnaFraccio sumar(UnaFraccio fraccioA, UnaFraccio fraccioB) throws EsZeroEx{
        int num = 0,  den = 0;
        if (fraccioA.getDenominador() == fraccioB.getDenominador()) {
            num = fraccioA.getNumerador() + fraccioB.getNumerador();
            den = fraccioA.getDenominador();
        } else {
            int tmpDenA = fraccioA.getDenominador();
            int tmpDenB = fraccioB.getDenominador();
            den = fraccioA.getDenominador() * fraccioB.getDenominador();
            num = (tmpDenB * fraccioA.getNumerador()) + (tmpDenA * fraccioB.getNumerador());
        }
        return new UnaFraccio(num, den);
    }
    
    public UnaFraccio restar(UnaFraccio fraccioA, UnaFraccio fraccioB) throws EsZeroEx{
        int num = 0,  den = 0;
        if (fraccioA.getDenominador() == fraccioB.getDenominador()) {
            num = fraccioA.getNumerador() - fraccioB.getNumerador();
            den = fraccioA.getDenominador();
        } else {
            int tmpDenA = fraccioA.getDenominador();
            int tmpDenB = fraccioB.getDenominador();
            den = fraccioA.getDenominador() * fraccioB.getDenominador();
            num = (tmpDenB * fraccioA.getNumerador()) - (tmpDenA * fraccioB.getNumerador());
        }
        return new UnaFraccio(num, den);
    }
    
    public UnaFraccio multiplicar(UnaFraccio fraccioA, UnaFraccio fraccioB) throws EsZeroEx{
        int num = 0,  den = 0;
        if (fraccioA.getDenominador() == fraccioB.getDenominador()) {
            num = fraccioA.getNumerador() - fraccioB.getNumerador();
            den = fraccioA.getDenominador();
        } else {
            int tmpDenA = fraccioA.getDenominador();
            int tmpDenB = fraccioB.getDenominador();
            den = fraccioA.getDenominador() * fraccioB.getDenominador();
            num = (tmpDenB * fraccioA.getNumerador()) - (tmpDenA * fraccioB.getNumerador());
        }
        return new UnaFraccio(num, den);
    }
    
}
