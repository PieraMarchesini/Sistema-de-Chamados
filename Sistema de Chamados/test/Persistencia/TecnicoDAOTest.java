/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Persistencia.TecnicoDAO;
import entidade.Tecnico;
import java.util.HashMap;
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
public class TecnicoDAOTest {
    
    public TecnicoDAOTest() {
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
     * Test of gerarCodigo method, of class TecnicoDAO.
     */
    @Test
    public void testGerarCodigo() {
        System.out.println("gerarCodigo");
        TecnicoDAO instance = new TecnicoDAO();
        int expResult = 0;
        int result = instance.gerarCodigo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of voltaCashTecnico method, of class TecnicoDAO.
     */
    @Test
    public void testVoltaCashTecnico() {
    }

    /**
     * Test of put method, of class TecnicoDAO.
     */
    @Test
    public void testPut() {
    }

    /**
     * Test of get method, of class TecnicoDAO.
     */
    @Test
    public void testGet() {
    }

    /**
     * Test of persit method, of class TecnicoDAO.
     */
    @Test
    public void testPersit() {
    }
    
}
