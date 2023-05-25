/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excep;

/**
 *
 * @author Eduardo Silvestre
 */
public class CodiRepetitEX extends Exception {

    /**
     * Creates a new instance of <code>CodiRepetitEX</code> without detail
     * message.
     */
    public CodiRepetitEX() {
        super("El codi està repetit");
    }

    /**
     * Constructs an instance of <code>CodiRepetitEX</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public CodiRepetitEX(String msg) {
        super(msg);
    }
}
