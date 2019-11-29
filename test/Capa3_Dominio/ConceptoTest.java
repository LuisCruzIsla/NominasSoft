/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa3_Dominio;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Fermin Eras
 */
public class ConceptoTest {
    
    public ConceptoTest() {
    }
  /**
     * Test of calcularDescuento method, of class Concepto.
     */
    @Test
    public void testCalcularIngresoTest1() {
        System.out.println("calcularIngreso");
        Concepto concepto = new Concepto();  
        concepto.setMontoHorasExtras(1000.0);
        concepto.setMontoReintegros(1000.0);
        concepto.setMontoOtrosIngresos(1000.0);
        double resultadoEsperado = 3000.0;
        double resultadoObtenido = concepto.calcularIngreso();
        assertEquals(resultadoEsperado, resultadoObtenido, 0.0);

    }

    /**
     * Test of calcularDescuento method, of class Concepto.
     */
    @Test
    public void testCalcularDescuentoTest1() {
        System.out.println("calcularDescuento");
        Concepto concepto = new Concepto();  
        concepto.setMontoHoraAusente(1000.0);
        concepto.setMontoAdelantado(1000.0);
        concepto.setMontoOtroDescuentos(1000.0);
        double resultadoEsperado = 3000.0;
        double resultadoObtenido = concepto.calcularDescuento();
        assertEquals(resultadoEsperado, resultadoObtenido, 0.0);
    }
    
}
