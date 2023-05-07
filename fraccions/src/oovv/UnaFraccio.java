/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oovv;

/**
 *
 * @author Alexandru
 */
public class UnaFraccio {

    private int numerador;
    private int denominador;

    public UnaFraccio(int numerador, int denominador) throws EsZeroEx{
        if (denominador <= 0) {
            throw new EsZeroEx("El denominador no puede ser 0 o entero negativo");
        }
        this.numerador = numerador;
        this.denominador = denominador;
    }
    
    public void asignar(UnaFraccio fraccio) throws EsZeroEx {
        this.numerador = fraccio.numerador;
        this.denominador = fraccio.denominador;
    }

//    public void asignar(int numerador, int denominador) throws EsZeroEx {
//        if (denominador <= 0) {
//            throw new EsZeroEx("El denominador no puede ser 0 o entero negativo");
//        }
//        this.numerador = numerador;
//        this.denominador = denominador;
//    }

    public void invertir() {
        int tmp = this.numerador;
        this.numerador = denominador;
        this.denominador = tmp;
    }
    
    public void simplificar(){
        int MCD = MUtils.getMCD(numerador, denominador);
        this.numerador = numerador / MCD;
        this.denominador = denominador / MCD;
    }
    
    public double getValor(){
        return (double) numerador / denominador;
    }

    public int getNumerador() {
        return numerador;
    }

    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    public void setDenominador(int denominador) {
        this.denominador = denominador;
    }

    @Override
    public String toString() {
        return numerador + "/" + denominador;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.getValor()) ^ (Double.doubleToLongBits(this.getValor()) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }  
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UnaFraccio other = (UnaFraccio) obj;
        return Double.doubleToLongBits(this.getValor()) == Double.doubleToLongBits(other.getValor());
    }
    
}
