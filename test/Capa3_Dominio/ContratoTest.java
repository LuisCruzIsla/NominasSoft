/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa3_Dominio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
     * Test of esVigente method, of class Contrato.
     *
     * @throws java.text.ParseException
     */
    @Test
    public void testEsVigente() throws ParseException {
        System.out.println("esVigente");
        Contrato contrato = new Contrato();
        contrato.setEstado('A');
        SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
        Date fecha = f.parse("20-10-2019");
        contrato.setFechaFin(fecha);
        boolean resultadoEsperado = false;
        boolean resultadoObtenido = contrato.esVigente();
        assertEquals(resultadoEsperado, resultadoObtenido);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    @Test
    public void test2EsVigente() throws ParseException {
        System.out.println("esVigente2");
        Contrato contrato = new Contrato();
        contrato.setEstado('N');
        SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
        Date fecha = f.parse("18-10-2019");
        contrato.setFechaFin(fecha);
        boolean resultadoEsperado = false;
        boolean resultadoObtenido = contrato.esVigente();
        assertEquals(resultadoEsperado, resultadoObtenido);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    @Test
    public void test3EsVigente() throws ParseException {
        System.out.println("esVigente3");
        Contrato contrato = new Contrato();
        contrato.setEstado('N');
        SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
        Date fecha = f.parse("22-10-2019");// esta echa es superior al dia actual solo que se testeo dias antes,
        contrato.setFechaFin(fecha);
        boolean resultadoEsperado = true;
        boolean resultadoObtenido = contrato.esVigente();
        assertEquals(resultadoEsperado, resultadoObtenido);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    @Test
    public void test1EsRenovable() throws ParseException {
        System.out.println("esRenovable1");
        Contrato contrato = new Contrato();
        SimpleDateFormat f1 = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat f2 = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaFin1 = f1.parse("20-10-2019");
        Date fechaFin2 = f2.parse("24-10-2019");

        contrato.setFechaFin(fechaFin1);
        Contrato instance = new Contrato();
        instance.setFechaFin(fechaFin2);
        boolean resultadoEsperado = true;
        boolean resultadoObtenido = instance.esRenovable(contrato);
        assertEquals(resultadoEsperado, resultadoObtenido);
        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void test2EsRenovable() {
        System.out.println("esRenovable2");
        Contrato contrato = null;
        Contrato instance = new Contrato();
        boolean resultadoEsperado = true;
        boolean resultadoObtenido = instance.esRenovable(contrato);
        assertEquals(resultadoEsperado, resultadoObtenido);
        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void test3EsRenovable() throws ParseException {
        System.out.println("esRenovable3");
        Contrato contrato = new Contrato();
        SimpleDateFormat f1 = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat f2 = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaFin1 = f1.parse("24-09-2019");
        Date fechaFin2 = f2.parse("20-10-2019");

        contrato.setFechaFin(fechaFin1);
        Contrato instance = new Contrato();
        instance.setFechaFin(fechaFin2);
        boolean resultadoEsperado = false;
        boolean resultadoObtenido = instance.esRenovable(contrato);
        assertEquals(resultadoEsperado, resultadoObtenido);
        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void test1EsFechaValida() throws ParseException {
        System.out.println("esFechaValida1");
        Contrato contrato = new Contrato();
        SimpleDateFormat inicioFecha = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat finFecha = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaInicio = inicioFecha.parse("10-10-2018");
        Date fechaFin = finFecha.parse("10-10-2019");
        contrato.setFechaInicio(fechaInicio);
        contrato.setFechaFin(fechaFin);
        boolean resultadoEsperado = true;
        boolean resultadoObtenido = contrato.esFechaValida();
        assertEquals(resultadoEsperado, resultadoObtenido);
        // TODO review the generated test code and remove the default call to fail.

    }

    @Test
    public void test2EsFechaValida() throws ParseException {
        System.out.println("esFechaValida2");
        Contrato contrato = new Contrato();
        SimpleDateFormat inicioFecha = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat finFecha = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaInicio = inicioFecha.parse("10-01-2019");
        Date fechaFin = finFecha.parse("10-02-2019");
        contrato.setFechaInicio(fechaInicio);
        contrato.setFechaFin(fechaFin);
        boolean resultadoEsperado = false;
        boolean resultadoObtenido = contrato.esFechaValida();
        assertEquals(resultadoEsperado, resultadoObtenido);
        // TODO review the generated test code and remove the default call to fail.

    }

    @Test
    public void test3EsFechaValida() throws ParseException {
        System.out.println("esFechaValida3");
        Contrato contrato = new Contrato();
        SimpleDateFormat inicioFecha = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat finFecha = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaInicio = inicioFecha.parse("10-01-2019");
        Date fechaFin = finFecha.parse("10-02-2020");
        contrato.setFechaInicio(fechaInicio);
        contrato.setFechaFin(fechaFin);
        boolean resultadoEsperado = false;
        boolean resultadoObtenido = contrato.esFechaValida();
        assertEquals(resultadoEsperado, resultadoObtenido);
        // TODO review the generated test code and remove the default call to fail.

    }

    @Test
    public void test4EsFechaValida() throws ParseException {
        System.out.println("esFechaValida4");
        Contrato contrato = new Contrato();
        SimpleDateFormat inicioFecha = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat finFecha = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaInicio = inicioFecha.parse("10-04-2019");
        Date fechaFin = finFecha.parse("10-01-2019");
        contrato.setFechaInicio(fechaInicio);
        contrato.setFechaFin(fechaFin);
        boolean resultadoEsperado = false;
        boolean resultadoObtenido = contrato.esFechaValida();
        assertEquals(resultadoEsperado, resultadoObtenido);
        // TODO review the generated test code and remove the default call to fail.

    }

    @Test
    public void test1EsHoraValidaPorSemana() {
        System.out.println("esHoraValidaPorSemana1");
        Contrato contrato = new Contrato();
        contrato.setTotalHorasSemanal(10);
        boolean resultadoEsperado = true;
        boolean resultadoObtenido = contrato.esHoraValidaPorSemana();
        assertEquals(resultadoEsperado, resultadoObtenido);
        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void test2EsHoraValidaPorSemana() {
        System.out.println("esHoraValidaPorSemana2");
        Contrato contrato = new Contrato();
        contrato.setTotalHorasSemanal(44);
        boolean resultadoEsperado = false;
        boolean resultadoObtenido = contrato.esHoraValidaPorSemana();
        assertEquals(resultadoEsperado, resultadoObtenido);
        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void test3EsHoraValidaPorSemana() {
        System.out.println("esHoraValidaPorSemana3");
        Contrato contrato = new Contrato();
        contrato.setTotalHorasSemanal(6);
        boolean resultadoEsperado = false;
        boolean resultadoObtenido = contrato.esHoraValidaPorSemana();
        assertEquals(resultadoEsperado, resultadoObtenido);
        // TODO review the generated test code and remove the default call to fail.
    }
    

    /*
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
     */
}
