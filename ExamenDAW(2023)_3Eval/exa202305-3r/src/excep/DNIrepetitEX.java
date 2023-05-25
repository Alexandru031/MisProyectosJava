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
public class DNIrepetitEX extends Exception {

    /**
     * Creates a new instance of <code>DNIrepetitEX</code> without detail
     * message.
     */
    public DNIrepetitEX() {
        super("El DNI està repetit");
    }

    /**
     * Constructs an instance of <code>DNIrepetitEX</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public DNIrepetitEX(String msg) {
        super(msg);
    }
}
