/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import controle.ControleEmpresas;
import entidade.Empresa;
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
public class ControleEmpresasTest {
    
    private ControleEmpresas controleEmpresas;
    private final int tempoTimeOut = 800;

    @Before
    public void setUp() throws FileNotFoundException, IOException {
        HashMap<Long, Empresa> cacheEmpresas = new HashMap<>();
        cacheEmpresas.put((long)1, new Empresa((1), "CreditSuisse"));
        String nomearq = "empresas.dat";
        try (FileOutputStream fos = new FileOutputStream(nomearq)) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            oos.writeObject(cacheEmpresas);
            
            oos.flush();
            fos.flush();
            
            oos.close();
        }
    }

    @After
    public void tearDown() {
        File file = new File("empresas.dat");
        file.delete();
    }

    /**
     * Test of retorna method, of class ControleEmpresas.
     */
    @Test
    public void testRetorna() {
    }

    /**
     * Test of validar method, of class ControleEmpresas.
     */
    @Test
    public void testValidar() {
    }

    /**
     * Test of inserir method, of class ControleEmpresas.
     */
    //Inserir uma nova empresa
    @Test(timeout = tempoTimeOut)
    public void testInserirNova() {
        Empresa e1 = new Empresa(2, "Anbima");
        controleEmpresas = new ControleEmpresas();
        Assert.assertEquals(2, e1.getNumeroContrato());
        Assert.assertEquals("Anbima", e1.getNomeEmpresa());
    }
    
    //Inserir uma empresa duplicada
    @Test(timeout = tempoTimeOut)
    public void testInserirDuplicada() {
        Empresa e1 = new Empresa(1, "");
        controleEmpresas = new ControleEmpresas();
        Assert.assertEquals(2, e1.getNumeroContrato());
        Assert.assertEquals("Anbima", e1.getNomeEmpresa());
    }

    /**
     * Test of checar method, of class ControleEmpresas.
     */
    @Test
    public void testChecar() {
    }

    /**
     * Test of cadastrarEmpresa method, of class ControleEmpresas.
     */
    @Test
    public void testCadastrarEmpresa() {
    }

    /**
     * Test of fecharTela method, of class ControleEmpresas.
     */
    @Test
    public void testFecharTela() {
    }

}
