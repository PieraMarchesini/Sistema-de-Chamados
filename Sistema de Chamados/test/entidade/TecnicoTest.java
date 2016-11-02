/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 31581773
 */
public class TecnicoTest {
    
    public TecnicoTest() {
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
    public void inserirTecnico(){
        Tecnico tec = new Tecnico("Mariana", 972616068);
        Assert.assertEquals("Mariana", tec.getNome());
        Assert.assertEquals(972616068, tec.getTelefone());
    }
    @Test
    public void inserirTelefoneInvalido(){
        Tecnico tec = new Tecnico("Paloma", 97261);
       Assert.assertEquals(97261, tec.getTelefone());
    }
    @Test
    public void inserirNomeCaracteres(){
       Tecnico tec = new Tecnico("P!er@", 972616068);
       Assert.assertEquals("P!er@",tec.getNome());
    }
    /**
     * Test of toString method, of class Tecnico.
     */
    
    @Test
    public void testToString() {
    }
    
}
