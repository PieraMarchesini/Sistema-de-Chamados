/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import entidade.Pessoa;
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
public class PessoaTest {
    Pessoa p = new Pessoa("Mariana", 30817564);
    public PessoaTest() {
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
     * Test of getNome method, of class Pessoa.
     */
    @Test
    public void testGetNome() {
        assertEquals("Mariana", p.getNome());
    }

    /**
     * Test of setNome method, of class Pessoa.
     */
    @Test
    public void testSetNome() {
        p.setNome("Paloma");
        assertEquals("Paloma", p.getNome());
    }
    @Test 
    public void NomeInvalidoPassa(){
        p.setNome("Mari@ M@d@l$en@");
        assertEquals("Mari@ M@d@l$en@", p.getNome());
    }

    /**
     * Test of getTelefone method, of class Pessoa.
     */
    @Test
    public void testGetTelefone() {
        assertEquals(30817564,p.getTelefone());
    }

    /**
     * Test of setTelefone method, of class Pessoa.
     */
    @Test
    public void testSetTelefone() {
        p.setTelefone(972616068);
        assertEquals(972616068,p.getTelefone());
    }
    
    @Test
    public void TelefoneInvalidoPassa(){
        p.setTelefone(123);
        assertEquals(123,p.getTelefone());
    }
    
}
