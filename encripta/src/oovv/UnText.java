/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oovv;

import exception.MaEx;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Alexandru
 */
public class UnText {

    private String text;

    public UnText() {
        this.text = "";
    }

    public UnText(String text) {
        if (text == null) {
            text = "";
        }
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        if (text == null) {
            text = "";
        }
        this.text = text;
    }

    public void encripta(String palabra) {
        String lletra = "";
        char[] carc = text.toCharArray();
        int suma;
        int contP = 0;
        for (int i = 0; i < carc.length; i++) {
            if (contP == palabra.length()) {
                contP = 0;
            }
            suma = carc[i] + palabra.charAt(contP);
            lletra += (char) suma;
            contP++;
            suma = 0;
        }
        text = lletra;
    }

    public void desencripta(String palabra) {
        String lletra = "";
        char[] carc = text.toCharArray();
        int resta;
        int contP = 0;
        for (int i = 0; i < carc.length; i++) {
            if (contP == palabra.length()) {
                contP = 0;
            }
            resta = carc[i] - palabra.charAt(contP);
            lletra += (char) resta;
            contP++;
            resta = 0;
        }
        text = lletra;
    }

}
