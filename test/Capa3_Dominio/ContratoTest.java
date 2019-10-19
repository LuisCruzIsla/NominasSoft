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
public class ContratoTest {
    
    public ContratoTest() {
    }

    /**
     * Test of getEstado method, of class Contrato.
     */
    @Test
    public void testGetEstado() {
        System.out.println("getEstado");
        Contrato instance = new Contrato();
        char expResult = ' ';
        char result = instance.getEstado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstado method, of class Contrato.
     */
    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        char estado = ' ';
        Contrato instance = new Contrato();
        instance.setEstado(estado);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaInicio method, of class Contrato.
     */
    @Test
    public void testGetFechaInicio() {
        System.out.println("getFechaInicio");
        Contrato instance = new Contrato();
        Date expResult = null;
        Date result = instance.getFechaInicio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaInicio method, of class Contrato.
     */
    @Test
    public void testSetFechaInicio() {
        System.out.println("setFechaInicio");
        Date fechaInicio = null;
        Contrato instance = new Contrato();
        instance.setFechaInicio(fechaInicio);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaFin method, of class Contrato.
     */
    @Test
    public void testGetFechaFin() {
        System.out.println("getFechaFin");
        Contrato instance = new Contrato();
        Date expResult = null;
        Date result = instance.getFechaFin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaFin method, of class Contrato.
     */
    @Test
    public void testSetFechaFin() {
        System.out.println("setFechaFin");
        Date fechaFin = null;
        Contrato instance = new Contrato();
        instance.setFechaFin(fechaFin);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isAsignacionFamiliar method, of class Contrato.
     */
    @Test
    public void testIsAsignacionFamiliar() {
        System.out.println("isAsignacionFamiliar");
        Contrato instance = new Contrato();
        boolean expResult = false;
        boolean result = instance.isAsignacionFamiliar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAsignacionFamiliar method, of class Contrato.
     */
    @Test
    public void testSetAsignacionFamiliar() {
        System.out.println("setAsignacionFamiliar");
        boolean asignacionFamiliar = false;
        Contrato instance = new Contrato();
        instance.setAsignacionFamiliar(asignacionFamiliar);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotalHorasSemanal method, of class Contrato.
     */
    @Test
    public void testGetTotalHorasSemanal() {
        System.out.println("getTotalHorasSemanal");
        Contrato instance = new Contrato();
        int expResult = 0;
        int result = instance.getTotalHorasSemanal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTotalHorasSemanal method, of class Contrato.
     */
    @Test
    public void testSetTotalHorasSemanal() {
        System.out.println("setTotalHorasSemanal");
        int totalHorasSemanal = 0;
        Contrato instance = new Contrato();
        instance.setTotalHorasSemanal(totalHorasSemanal);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValorPorHora method, of class Contrato.
     */
    @Test
    public void testGetValorPorHora() {
        System.out.println("getValorPorHora");
        Contrato instance = new Contrato();
        double expResult = 0.0;
        double result = instance.getValorPorHora();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setValorPorHora method, of class Contrato.
     */
    @Test
    public void testSetValorPorHora() {
        System.out.println("setValorPorHora");
        double valorPorHora = 0.0;
        Contrato instance = new Contrato();
        instance.setValorPorHora(valorPorHora);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCargo method, of class Contrato.
     */
    @Test
    public void testGetCargo() {
        System.out.println("getCargo");
        Contrato instance = new Contrato();
        String expResult = "";
        String result = instance.getCargo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCargo method, of class Contrato.
     */
    @Test
    public void testSetCargo() {
        System.out.println("setCargo");
        String cargo = "";
        Contrato instance = new Contrato();
        instance.setCargo(cargo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmpleado method, of class Contrato.
     */
    @Test
    public void testGetEmpleado() {
        System.out.println("getEmpleado");
        Contrato instance = new Contrato();
        Empleado expResult = null;
        Empleado result = instance.getEmpleado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmpleado method, of class Contrato.
     */
    @Test
    public void testSetEmpleado() {
        System.out.println("setEmpleado");
        Empleado empleado = null;
        Contrato instance = new Contrato();
        instance.setEmpleado(empleado);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getContratoId method, of class Contrato.
     */
    @Test
    public void testGetContratoId() {
        System.out.println("getContratoId");
        Contrato instance = new Contrato();
        int expResult = 0;
        int result = instance.getContratoId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setContratoId method, of class Contrato.
     */
    @Test
    public void testSetContratoId() {
        System.out.println("setContratoId");
        int contratoId = 0;
        Contrato instance = new Contrato();
        instance.setContratoId(contratoId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAfp method, of class Contrato.
     */
    @Test
    public void testGetAfp() {
        System.out.println("getAfp");
        Contrato instance = new Contrato();
        AFP expResult = null;
        AFP result = instance.getAfp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAfp method, of class Contrato.
     */
    @Test
    public void testSetAfp() {
        System.out.println("setAfp");
        AFP afp = null;
        Contrato instance = new Contrato();
        instance.setAfp(afp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of esVigente method, of class Contrato.
     */
    @Test
    public void testEsVigente() {
        System.out.println("esVigente");
        Contrato instance = new Contrato();
        boolean expResult = false;
        boolean result = instance.esVigente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of esRenovable method, of class Contrato.
     */
    @Test
    public void testEsRenovable() {
        System.out.println("esRenovable");
        Contrato contrato = null;
        Contrato instance = new Contrato();
        boolean expResult = false;
        boolean result = instance.esRenovable(contrato);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of esFechaValida method, of class Contrato.
     */
    @Test
    public void testEsFechaValida() {
        System.out.println("esFechaValida");
        Contrato instance = new Contrato();
        boolean expResult = false;
        boolean result = instance.esFechaValida();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of esHoraValidaPorSemana method, of class Contrato.
     */
    @Test
    public void testEsHoraValidaPorSemana() {
        System.out.println("esHoraValidaPorSemana");
        Contrato instance = new Contrato();
        boolean expResult = false;
        boolean result = instance.esHoraValidaPorSemana();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of esValorizacionAceptada method, of class Contrato.
     */
    @Test
    public void testEsValorizacionAceptada() {
        System.out.println("esValorizacionAceptada");
        Contrato instance = new Contrato();
        boolean expResult = false;
        boolean result = instance.esValorizacionAceptada();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcularAsignacionFamiliar method, of class Contrato.
     */
    @Test
    public void testCalcularAsignacionFamiliar() {
        System.out.println("calcularAsignacionFamiliar");
        Contrato instance = new Contrato();
        double expResult = 0.0;
        double result = instance.calcularAsignacionFamiliar();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
