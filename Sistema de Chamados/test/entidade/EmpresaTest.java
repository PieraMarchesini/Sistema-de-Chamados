/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import entidade.Empresa;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 31581773
 */
public class EmpresaTest {
    Empresa emp = new Empresa(123456,"Duratex");
    
    public EmpresaTest() {
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

    /**
     * Test of getNumeroContrato method, of class Empresa.
     */
    @Test
    public void testGetNumeroContrato() {
        assertEquals(123456,emp.getNumeroContrato());
    }

    /**
     * Test of setNumeroContrato method, of class Empresa.
     */
    @Test
    public void testSetNumeroContrato() {
        emp.setNumeroContrato(123465);
        assertEquals(123465,emp.getNumeroContrato());
    }

    /**
     * Test of getNomeEmpresa method, of class Empresa.
     */
    @Test
    public void testGetNomeEmpresa() {
        assertEquals("Duratex",emp.getNomeEmpresa());
    }

    /**
     * Test of setNomeEmpresa method, of class Empresa.
     */
    @Test
    public void testSetNomeEmpresa() {
        emp.setNomeEmpresa("Twitter");
        assertEquals("Twitter",emp.getNomeEmpresa());
    }

    /**
     * Test of toString method, of class Empresa.
     */
    @Test
    public void testToString() {
        assertEquals("123456 - Duratex",emp.toString());
    }
    
}
