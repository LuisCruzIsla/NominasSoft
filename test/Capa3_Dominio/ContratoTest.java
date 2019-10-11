/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa3_Dominio;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author LuisCriz
 */
public class ContratoTest {

    public ContratoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testSetFecha() {
        System.out.println("setFecha");
        Date fecha = null;
        Empleado instance = new Empleado();
        instance.setFechaNacimiento(fecha);
        // TODO review the generated test code and remove the default call to fail.
        Date expResult = null;
        assertEquals(expResult,instance.getFechaNacimiento());
        //fail("The test case is a prototype.");
    }
    
    /*@Test
    public void testEsVigente() {
        System.out.println("getContrado");
        //Empleado empleado = new Empleado();
        //AFP afp = new AFP();
        SimpleDateFormat dateformat2 = new SimpleDateFormat("dd-M-yyyy");
        //Date date1 = dateformat2.parse("10/07/2019");
        //Date date2 = dateformat2.parse("11/07/2019");
        Contrato contrato = new Contrato();

        //contrato.setFechaInicio(date1);
        //contrato.setFechaFin(date2);
        contrato.setFechaInicio(java.sql.Date.valueOf(LocalDate.now()));
        contrato.setFechaFin(java.sql.Date.valueOf(LocalDate.now()));
        contrato.setTipo('A');
        boolean expResult = false;
        assertEquals(expResult, contrato.esVigente());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    @Test
    public void testEsVigente() throws ParseException {
        System.out.println("testEsVigente");
        //Empleado empleado = new Empleado();
        //AFP afp = new AFP();
        SimpleDateFormat dateformat2 = new SimpleDateFormat("dd-M-yyyy");
       // Date date1 = dateformat2.parse("10/07/2019");
        //Date date2 = dateformat2.parse("11/07/2019");
        Contrato contrato = new Contrato();

        contrato.setFechaInicio(java.sql.Date.valueOf(LocalDate.now()));
        contrato.setFechaFin(java.sql.Date.valueOf(LocalDate.now()));
        contrato.setEstado('A');

        boolean expResult = false;
        System.out.println("Fecha: "+contrato.esVigente());
        assertEquals(expResult, contrato.esVigente());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void testEsRenovable() throws ParseException {
        System.out.println("testEsRenovable");
        SimpleDateFormat dateformat2 = new SimpleDateFormat("dd-M-yyyy");
        Contrato contrato = new Contrato();
        contrato.setFechaFin(java.sql.Date.valueOf(LocalDate.now()));
        boolean result = contrato.esRenovable(java.sql.Date.valueOf(LocalDate.now()));
       
        boolean expResult = false;
        System.out.println("Fecha: "+result);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void testEsHoraValidaPorSemana() throws ParseException {
        System.out.println("getContrado");
        
        Contrato contrato = new Contrato();

        //contrato.calcularTotalHora();
        contrato.setTotalHorasSemanal(8);
        
        boolean expResult = true;
        assertEquals(expResult, contrato.esHoraValidaPorSemana());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    
}
