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

    /**
     * Test of getFecha method, of class Pago.
     */
    @Test
    public void testGetFecha() {
        System.out.println("getFecha");
        Pago instance = new Pago();
        Date expResult = null;
        Date result = instance.getFecha();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFecha method, of class Pago.
     */
    @Test
    public void testSetFecha() {
        System.out.println("setFecha");
        Date fecha = null;
        Pago instance = new Pago();
        instance.setFecha(fecha);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotalHoras method, of class Pago.
     */
    @Test
    public void testGetTotalHoras() {
        System.out.println("getTotalHoras");
        Pago instance = new Pago();
        int expResult = 0;
        int result = instance.getTotalHoras();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTotalHoras method, of class Pago.
     */
    @Test
    public void testSetTotalHoras() {
        System.out.println("setTotalHoras");
        int totalHoras = 0;
        Pago instance = new Pago();
        instance.setTotalHoras(totalHoras);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValorHoras method, of class Pago.
     */
    @Test
    public void testGetValorHoras() {
        System.out.println("getValorHoras");
        Pago instance = new Pago();
        int expResult = 0;
        int result = instance.getValorHoras();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setValorHoras method, of class Pago.
     */
    @Test
    public void testSetValorHoras() {
        System.out.println("setValorHoras");
        int valorHoras = 0;
        Pago instance = new Pago();
        instance.setValorHoras(valorHoras);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAsignacionFamiliar method, of class Pago.
     */
    @Test
    public void testGetAsignacionFamiliar() {
        System.out.println("getAsignacionFamiliar");
        Pago instance = new Pago();
        double expResult = 0.0;
        double result = instance.getAsignacionFamiliar();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAsignacionFamiliar method, of class Pago.
     */
    @Test
    public void testSetAsignacionFamiliar() {
        System.out.println("setAsignacionFamiliar");
        double asignacionFamiliar = 0.0;
        Pago instance = new Pago();
        instance.setAsignacionFamiliar(asignacionFamiliar);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPorcentajeAFP method, of class Pago.
     */
    @Test
    public void testGetPorcentajeAFP() {
        System.out.println("getPorcentajeAFP");
        Pago instance = new Pago();
        double expResult = 0.0;
        double result = instance.getPorcentajeAFP();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPorcentajeAFP method, of class Pago.
     */
    @Test
    public void testSetPorcentajeAFP() {
        System.out.println("setPorcentajeAFP");
        double porcentajeAFP = 0.0;
        Pago instance = new Pago();
        instance.setPorcentajeAFP(porcentajeAFP);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getContrato method, of class Pago.
     */
    @Test
    public void testGetContrato() {
        System.out.println("getContrato");
        Pago instance = new Pago();
        Contrato expResult = null;
        Contrato result = instance.getContrato();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setContrato method, of class Pago.
     */
    @Test
    public void testSetContrato() {
        System.out.println("setContrato");
        Contrato contrato = null;
        Pago instance = new Pago();
        instance.setContrato(contrato);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getConcepto method, of class Pago.
     */
    @Test
    public void testGetConcepto() {
        System.out.println("getConcepto");
        Pago instance = new Pago();
        Concepto expResult = null;
        Concepto result = instance.getConcepto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setConcepto method, of class Pago.
     */
    @Test
    public void testSetConcepto() {
        System.out.println("setConcepto");
        Concepto concepto = null;
        Pago instance = new Pago();
        instance.setConcepto(concepto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPeriodo method, of class Pago.
     */
    @Test
    public void testGetPeriodo() {
        System.out.println("getPeriodo");
        Pago instance = new Pago();
        Periodo expResult = null;
        Periodo result = instance.getPeriodo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPeriodo method, of class Pago.
     */
    @Test
    public void testSetPeriodo() {
        System.out.println("setPeriodo");
        Periodo periodo = null;
        Pago instance = new Pago();
        instance.setPeriodo(periodo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcularSueldoBasico method, of class Pago.
     */
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
