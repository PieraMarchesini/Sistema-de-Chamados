/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import entidade.Empresa;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;
import junit.framework.Assert;
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
public class EmpresaDAOTest {

    private EmpresaDAO eDAO;
    private HashMap<Long, Empresa> cacheEmpresa;

    @Before
    public void setUp() throws IOException {
        HashMap<Long, Empresa> cacheEmpresas = new HashMap<>();
        cacheEmpresas.put((long) 1, new Empresa((1), "Anbima"));
        String arquivo = "empresas.dat";
        try (FileOutputStream fos = new FileOutputStream(arquivo)) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(cacheEmpresas);

            oos.flush();
            fos.flush();

            oos.close();
        }
        eDAO = new EmpresaDAO();
    }

    @After
    public void tearDown() {
        File file = new File("empresas.dat");
        file.delete();
    }

    /**
     * Test of put method, of class EmpresaDAO.
     */
    @Test
    public void testInserirNovaEmpresa() throws FileNotFoundException, IOException, ClassNotFoundException {
        Empresa e1 = new Empresa(2, "Credit Suisse");
        eDAO.put(e1);
        //verifica se foi inserido no HasMap
        Assert.assertEquals(e1, eDAO.voltaEmpresa().get(e1.getNumeroContrato()));
        
        //verifica se foi inserido no arquivo externo
        FileInputStream fis = new FileInputStream("empresas.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);
        cacheEmpresa = (HashMap<Long, Empresa>) ois.readObject();
        ois.close();
        fis.close();
        Assert.assertEquals(e1.getNumeroContrato(), cacheEmpresa.get(e1.getNumeroContrato()).getNumeroContrato());
        Assert.assertEquals(e1.getNomeEmpresa(), cacheEmpresa.get(e1.getNumeroContrato()).getNomeEmpresa());
    }
    
    @Test(expected = Exception.class)
    public void testInserirEmpresaDuplicada(){
        //empresa já inserida no setUp 
        Empresa existente = new Empresa(1, "Anbima"); 
        eDAO.put(existente);
    }

    @Test(expected = Exception.class)
    public void testInserirEmpresaCodigoNegativo(){
        Empresa e1 = new Empresa(-1234, "Goldman Sachs");
        eDAO.put(e1);
    }
    
    /**
     * Test of getEmpresas method, of class EmpresaDAO.
     */
    @Test
    public void buscaUmaEmpresaHashMap() {
        Empresa e1 = new Empresa(2, "")
    }

    /**
     * Test of voltaEmpresa method, of class EmpresaDAO.
     */
    @Test
    public void testVoltaEmpresa() {
        
    }
}
