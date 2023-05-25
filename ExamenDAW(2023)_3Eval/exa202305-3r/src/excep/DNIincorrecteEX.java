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
public class DNIincorrecteEX extends Exception {

    /**
     * Creates a new instance of <code>DNIincorrecteEX</code> without detail
     * message.
     */
    public DNIincorrecteEX() {
        super("El DNI és incorrecte");
    }

    /**
     * Constructs an instance of <code>DNIincorrecteEX</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public DNIincorrecteEX(String msg) {
        super(msg);
    }
}
