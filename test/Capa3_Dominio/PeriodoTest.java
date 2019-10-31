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
public class PeriodoTest {

    public PeriodoTest() {
    }

    @Test
    public void test1EsActivo() throws ParseException {
        System.out.println("esActivo1");
        Periodo periodo = new Periodo();
        SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
        Date fecha = f.parse("28-11-2019");
        periodo.setFechaFin(fecha);
        boolean resultadoEsperado = true;
        boolean resuldadoObtenido = periodo.esActivo();
        assertEquals(resultadoEsperado, resuldadoObtenido);
        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void test2EsActivo() throws ParseException {
        System.out.println("esActivo2");
        Periodo periodo = new Periodo();
        SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
        Date fecha = f.parse("28-01-2019");
        periodo.setFechaFin(fecha);
        boolean resultadoEsperado = false;
        boolean resultadoObtenido = periodo.esActivo();
        assertEquals(resultadoEsperado, resultadoObtenido);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of calcularTotalSemanas method, of class Periodo.
     */
    @Test
    public void testCalcularTotalSemanas() throws ParseException {
        System.out.println("calcularTotalSemanas");
        Periodo periodo = new Periodo();
        SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaFin = f.parse("30-11-2019");
        Date fechaInicio = f.parse("30-10-2019");
        periodo.setFechaInicio(fechaInicio);
        periodo.setFechaFin(fechaFin);
        int reultadoEsperado = 4;
        int resultadoObtenido = periodo.calcularTotalSemanas();
        assertEquals(reultadoEsperado, resultadoObtenido);
        // TODO review the generated test code and remove the default call to fail.
    }

}
