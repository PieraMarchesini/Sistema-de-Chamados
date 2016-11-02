/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import entidade.Empresa;
import entidade.ClienteEmpresa;
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
public class ClienteEmpresaTest {
    
    public ClienteEmpresaTest() {
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
     * Test of getCodigo method, of class ClienteEmpresa.
     */
  @Test
    public void testGetCodigo() {
        Empresa empresa = new Empresa(123456, "Anbima");
        ClienteEmpresa ce = new ClienteEmpresa(1234,empresa,12345,"Mariana",30817564);
        assertEquals(ce.getCodigo(),ce.getCodigo());
    }

    /**
     * Test of setCodigo method, of class ClienteEmpresa.
     */
    @Test
    public void testSetCodigo() {
        Empresa empresa = new Empresa(123456, "Anbima");
        ClienteEmpresa ce = new ClienteEmpresa(1234,empresa,12345,"Mariana",30817564);
        ce.setCodigo(123456);
       assertEquals(ce.getCodigo(),ce.getCodigo());
    }

    /**
     * Test of getCpf method, of class ClienteEmpresa.
     */
    
    
    @Test
    public void testGetCpf() {
      Empresa empresa = new Empresa(123456, "Anbima");
        ClienteEmpresa ce = new ClienteEmpresa(1234,empresa,12345,"Mariana",30817564);
        
        assertEquals(12345,ce.getCpf());
    }

    /**
     * Test of setCpf method, of class ClienteEmpresa.
     */
    
    @Test
    public void CPFInvalidoPassa(){
        Empresa empresa = new Empresa(123456, "Anbima");
        ClienteEmpresa ce = new ClienteEmpresa(1234,empresa,12345,"Mariana",30817564);
        assertEquals(12345, ce.getCpf());
    }
    @Test
    public void testSetCpf() {
      Empresa empresa = new Empresa(123456, "Anbima");
        ClienteEmpresa ce = new ClienteEmpresa(1234,empresa,12345,"Mariana",30817564);
        ce.setCpf(123456);
        assertEquals(123456,ce.getCpf());
    }

    /**
     * Test of getEmpresa method, of class ClienteEmpresa.
     */
    @Test
    public void testGetEmpresa() {
        Empresa empresa = new Empresa(123456, "Anbima");
        ClienteEmpresa ce = new ClienteEmpresa(1234,empresa,12345,"Mariana",30817564);
        assertEquals(empresa, ce.getEmpresa());
    }

    /**
     * Test of toString method, of class ClienteEmpresa.
     */
    @Test
    public void testToString() {
        Empresa empresa = new Empresa(123456, "Anbima");
        ClienteEmpresa ce = new ClienteEmpresa(1234,empresa,12345,"Mariana",30817564);
        assertEquals("Contrato: 123456 - Nome Empresa:Anbima - Cliente: 12345 - Mariana",ce.toString());
    }
    
}
