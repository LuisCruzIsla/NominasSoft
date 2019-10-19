/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa3_Dominio;

import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author LuisCriz
 */
public class PagoTest {
    
    public PagoTest() {
    }

   
    @Test
    public void testCalcularSueldoBasico() {
        System.out.println("calcularSueldoBasico");
        Pago instance = new Pago();
        double expResult = 0.0;
        double result = instance.calcularSueldoBasico();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcularTotalIngreso method, of class Pago.
     */
    @Test
    public void testCalcularTotalIngreso() {
        System.out.println("calcularTotalIngreso");
        Pago instance = new Pago();
        double expResult = 0.0;
        double result = instance.calcularTotalIngreso();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcularDescuento method, of class Pago.
     */
    @Test
    public void testCalcularDescuento() {
        System.out.println("calcularDescuento");
        Pago instance = new Pago();
        double expResult = 0.0;
        double result = instance.calcularDescuento();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcularTotalDescuento method, of class Pago.
     */
    @Test
    public void testCalcularTotalDescuento() {
        System.out.println("calcularTotalDescuento");
        Pago instance = new Pago();
        double expResult = 0.0;
        double result = instance.calcularTotalDescuento();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcularSueldoNeto method, of class Pago.
     */
    @Test
    public void testCalcularSueldoNeto() {
        System.out.println("calcularSueldoNeto");
        Pago instance = new Pago();
        double expResult = 0.0;
        double result = instance.calcularSueldoNeto();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcularTotalHoras method, of class Pago.
     */
    @Test
    public void testCalcularTotalHoras() {
        System.out.println("calcularTotalHoras");
        Pago instance = new Pago();
        int expResult = 0;
        int result = instance.calcularTotalHoras();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
