/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package matricad;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author usuario
 */
public class MatricadTest {
    
    private ArrayList<String> cadena;
    
    public MatricadTest() {
    }
    
    @BeforeAll
    public void setUpClass() {
        cadena = new ArrayList(Arrays.asList(new String[]{"hola", "que", "tal", "como", "estás", "hola"}));
        String[] prueba = (String[]) cadena.toArray();
    }
    
    @Test
    public void testMethod() {
        System.out.println("constructor amb la matriu cadenes");
        String[] prueba = (String[]) cadena.toArray();
        Matricad instacia = new Matricad(prueba);
    }

//    @Test
    public void crea1() {
        System.out.println("constructor amb un null");
        Matricad instance = new Matricad(null);
    }
    
//    @Test
    public void crea2() {
        System.out.println("constructor amb una matriu buida");
        String[] cads = {};
        Matricad instance = new Matricad(cads);
    }

    /**
     * Test of getCantidadCadenasQueEmpiezanCon method, of class Matricad.
     */
//    @Test
    public void testGetCantidadCadenasQueEmpiezanCon() {
        System.out.println("getCantidadCadenasQueEmpiezanCon");
        char letra = 'h';
        String[] prueba = (String[]) cadena.toArray();
        Matricad instance = new Matricad(prueba);
        int expResult = 2;
        int result = instance.getCantidadCadenasQueEmpiezanCon(letra);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of hayCadenasQueEmpiezanPor method, of class Matricad.
     */
    @Test
    public void testHayCadenasQueEmpiezanPor() {
        System.out.println("hayCadenasQueEmpiezanPor");
        char letra = 't';
        String[] prueba = (String[]) cadena.toArray();
        Matricad instance = new Matricad(prueba);
        boolean expResult = true;
        boolean result = instance.hayCadenasQueEmpiezanPor(letra);
        assertNotEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getConcatenacionCadenas method, of class Matricad.
     */
//    @Test
    public void testGetConcatenacionCadenas() {
        System.out.println("getConcatenacionCadenas");
        Matricad instance = null;
        String expResult = "";
        String result = instance.getConcatenacionCadenas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPosicionesDe method, of class Matricad.
     */
//    @Test
    public void testGetPosicionesDe() {
        System.out.println("getPosicionesDe");
        String unaCadena = "";
        String[] prueba = (String[]) cadena.toArray();
        Matricad instance = new Matricad(prueba);
        ArrayList<Integer> expResult = null;
        ArrayList<Integer> result = instance.getPosicionesDe(unaCadena);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
