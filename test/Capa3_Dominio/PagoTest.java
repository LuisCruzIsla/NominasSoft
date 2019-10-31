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
public class PagoTest {

    public PagoTest() {
    }

    @Test
    public void testCalcularSueldoBasico() {
        System.out.println("calcularSueldoBasico");
        Pago pago = new Pago();
        pago.setTotalHoras(20);
        pago.setValorHoras(10);
        double resultadoEsperado = 200.0;
        double resultadoObtenido = pago.calcularSueldoBasico();
        assertEquals(resultadoEsperado, resultadoObtenido, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of calcularTotalIngreso method, of class Pago.
     */
    @Test
    public void testCalcularTotalIngreso() {
        System.out.println("calcularTotalIngreso");
        Pago pago = new Pago();
        Concepto concepto = new Concepto();
        Contrato contrato = new Contrato();
        pago.setTotalHoras(20);
        pago.setValorHoras(10);
        //200
        concepto.setMontoHoras(200);
        concepto.setMontoReIngresos(100);
        concepto.setMontoOtrosIngresos(58);
        //358
        contrato.setAsignacionFamiliar(true); //93
        //
        pago.setContrato(contrato);
        pago.setConcepto(concepto);

        double resultadoEsperado = 651.0;
        double resultadoObtenido = pago.calcularTotalIngreso();
        assertEquals(resultadoEsperado, resultadoObtenido, 0.0);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of calcularDescuento method, of class Pago.
     */
    @Test
    public void testCalcularDescuento() {
        System.out.println("calcularDescuento");
        Pago pago = new Pago();
        pago.setTotalHoras(20);
        pago.setValorHoras(10);
        pago.setPorcentajeAFP(0.02);
        double resultadoEsperado = 4.0;
        double resultadoObtenido = pago.calcularDescuento();
        assertEquals(resultadoEsperado, resultadoObtenido, 0.0);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of calcularTotalDescuento method, of class Pago.
     */
    @Test
    public void testCalcularTotalDescuento() {
        System.out.println("calcularTotalDescuento");
        Pago pago = new Pago();
        Concepto concepto = new Concepto();
        concepto.setMontoHoraAusente(20);
        concepto.setMontoAdelantado(100);
        concepto.setMontoOtroDescuentos(80);
        pago.setTotalHoras(20);
        pago.setValorHoras(10);
        pago.setPorcentajeAFP(0.02);
        pago.setConcepto(concepto);
        double resultadoEsperado = 204.0;
        double resultadoObtenido = pago.calcularTotalDescuento();
        assertEquals(resultadoEsperado, resultadoObtenido, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of calcularSueldoNeto method, of class Pago.
     */
    @Test
    public void testCalcularSueldoNeto() {
        System.out.println("calcularSueldoNeto");
        Pago pago = new Pago();
        Concepto concepto = new Concepto();
        Contrato contrato = new Contrato();
        concepto.setMontoHoraAusente(20);
        concepto.setMontoAdelantado(100);
        concepto.setMontoOtroDescuentos(80);
        pago.setTotalHoras(20);
        pago.setValorHoras(10);
        pago.setPorcentajeAFP(0.02);
        concepto.setMontoHoras(200);
        concepto.setMontoReIngresos(100);
        concepto.setMontoOtrosIngresos(58);
        contrato.setAsignacionFamiliar(true);
        pago.setContrato(contrato);
        pago.setConcepto(concepto);
        double resultadoEsperado = 855.0;
        double resultadoObtenido = pago.calcularSueldoNeto();
        assertEquals(resultadoEsperado, resultadoObtenido, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of calcularTotalHoras method, of class Pago.
     */
    @Test
    public void testCalcularTotalHoras() throws ParseException {
        System.out.println("calcularTotalHoras");
        Pago pago = new Pago();
        Contrato contrato = new Contrato();
        Periodo periodo = new Periodo();
        SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaFin = f.parse("30-11-2019");
        Date fechaInicio = f.parse("30-10-2019");
        periodo.setFechaInicio(fechaInicio);
        periodo.setFechaFin(fechaFin);
        contrato.setTotalHorasSemanal(20);
        pago.setPeriodo(periodo);
        pago.setContrato(contrato);

        int resultadoEsperado = 80;
        int resultadoObtenido = pago.calcularTotalHoras();

        assertEquals(resultadoEsperado, resultadoObtenido);
        // TODO review the generated test code and remove the default call to fail.
    }

}
