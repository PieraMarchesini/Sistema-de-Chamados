/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import Persistencia.ClienteDAO;
import entidade.ClienteEmpresa;
import entidade.Empresa;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
public class ControleClientesTest {

    private ControleClientes controleClientes;
    private final int tempoTimeOut = 800;

    public ControleClientesTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws IOException {
        try (FileOutputStream fos = new FileOutputStream("clientes.dat")) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            HashMap<Long, ClienteEmpresa> cacheCE = new HashMap<>();
            String cpf = "11568375379";
            Empresa emp = new Empresa(123456, "Apple");
            ClienteEmpresa ce = new ClienteEmpresa(12, emp, Long.parseLong(cpf), "Gisleine", 30817564);
            cacheCE.put(Long.parseLong(cpf), ce);

            oos.writeObject(cacheCE);

            oos.flush();
            fos.flush();

            oos.close();
        }
    }

    @After
    public void tearDown() {
        File file = new File("clientes.dat");
        file.delete();
    }

    @Test(timeout = tempoTimeOut)
    public void testInserirNovoCliente() {
        controleClientes = new ControleClientes();
        Empresa emp1 = new Empresa(54321, "Samsung");
        String cpf = "11568375378";
        ClienteEmpresa ct1 = new ClienteEmpresa(123, emp1, Long.parseLong(cpf), "Pedro", 94561235);
        assertEquals(54321, ct1.getEmpresa().getNumeroContrato());
        assertEquals("Samsung", ct1.getEmpresa().getNomeEmpresa());
        assertEquals(Long.parseLong(cpf), ct1.getCpf());
        assertEquals("Pedro", ct1.getNome());
        assertEquals(94561235, ct1.getTelefone());
    }

    @Test(timeout = tempoTimeOut)
    public void testInserirClienteDuplicado() {
        controleClientes = new ControleClientes();
        Empresa emp1 = new Empresa(54321, "Samsung");
        String cpf = "11568375377";
//        ClienteEmpresa ct1 = new ClienteEmpresa(123, emp1, Long.parseLong(cpf), "Pedro", 94561235);
        assertNull(controleClientes.incluiNovoCliente(emp1, Long.parseLong(cpf),"Gisleine", 30817564));
  
    }
      @Test(expected = Exception.class)
    public void testEmpresaNula() {
       controleClientes= new ControleClientes();
       
        String cpf = "22829701445";
        controleClientes.incluiNovoCliente(null, Long.parseLong(cpf), "Temer", 93656418);
    }
    
    @Test(expected = Exception.class)
    public void testClienteNomeNulo() {
        controleClientes = new ControleClientes();

        
        String cpf = "91482915448";
        controleClientes.incluiNovoCliente(new Empresa(123, "SBT"), Long.parseLong(cpf), "", 12457896);
    }

  
}
