/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import entidade.Tecnico;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
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
public class ControleTecnicosTest {
    private ControleTecnicos controleTecnicos;
    public ControleTecnicosTest() {
    }
   
    private final long tempoTimeOut= 800;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws IOException,FileNotFoundException {
        try (FileOutputStream fos = new FileOutputStream("tecnicos.dat")) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            HashMap<Integer, Tecnico> cacheTecnico = new HashMap<>();

            cacheTecnico.put(1, new Tecnico("Mariana", 31546463));

            oos.writeObject(cacheTecnico);

            oos.flush();
            fos.flush();

            oos.close();
        }
        
    }
    
    @After
    public void tearDown() {
        File file = new File("tecnicos.dat");
        file.delete();
    }
//inserir um novo tecnico
    @Test(timeout = tempoTimeOut)
    public void testInsereNovoTecnico() {
        Tecnico tecnico = controleTecnicos.inserir(97261621, "Adeilson");
        controleTecnicos = new ControleTecnicos();
        assertEquals("Adeilson", tecnico.getNome());
        assertEquals(37818744, tecnico.getTelefone());
        
    }
//inserir um tecnico duplicado
    @Test(timeout = tempoTimeOut)
    public void testInsereTecnicoDuplicado() {
        controleTecnicos = new ControleTecnicos();
        Tecnico tecnico = controleTecnicos.inserir(12345,"");
        assertNull(controleTecnicos.inserir(31546463,"Mariana"));

    }
//    
   
    
}
