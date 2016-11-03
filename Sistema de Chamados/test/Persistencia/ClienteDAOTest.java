/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this telate file, choose Tools | Telates
 * and open the telate in the editor.
 */
package Persistencia;

import entidade.ClienteEmpresa;
import entidade.Empresa;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
public class ClienteDAOTest {

    private ClienteDAO cDAO;
    private HashMap<Long, ClienteEmpresa> cacheCliente;

    @Before
    public void setUp() throws FileNotFoundException, IOException {
        try (FileOutputStream fos = new FileOutputStream("clientes.dat")) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            cacheCliente = new HashMap<>();
            String cpf = "397056715827";
            Empresa e1 = new Empresa(1, "Credit Suisse");
            ClienteEmpresa ce1 = new ClienteEmpresa(1, e1, Long.parseLong(cpf), "Piera Marchesini", 961043824);
            cacheCliente.put(Long.parseLong(cpf), ce1);

            oos.writeObject(cacheCliente);

            oos.flush();
            fos.flush();

            oos.close();
        }

        cDAO = new ClienteDAO();
    }

    @After
    public void tearDown() {
        File file = new File("clientes.dat");
        file.delete();
    }

    @Test
    public void testIncluirClienteEmpresa() throws FileNotFoundException, IOException, ClassNotFoundException {
        Empresa e1 = new Empresa(2, "Goldman Sachs");
        ClienteEmpresa c1 = new ClienteEmpresa(2, e1, Long.parseLong("14305910802"), "Alessandra Marchesini", 996173174);
        cDAO.put(c1);
        //Verifica se está no HashMap
        Assert.assertEquals(c1.getCodigo(), cDAO.get(c1.getCpf()).getCodigo());
        Assert.assertEquals(c1.getCpf(), cDAO.get(c1.getCpf()).getCpf());
        Assert.assertEquals(c1.getEmpresa(), cDAO.get(c1.getCpf()).getEmpresa());
        Assert.assertEquals(c1.getNome(), cDAO.get(c1.getCpf()).getNome());
        Assert.assertEquals(c1.getTelefone(), cDAO.get(c1.getCpf()).getTelefone());

        //Verifica se está no arquivo de persistência
        FileInputStream fis = new FileInputStream("clientes.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);
        HashMap<Long, ClienteEmpresa> cache = (HashMap<Long, ClienteEmpresa>) ois.readObject();
        ois.close();
        fis.close();

        Assert.assertEquals(c1.getCodigo(), cache.get(c1.getCpf()).getCodigo());
        Assert.assertEquals(c1.getCpf(), cache.get(c1.getCpf()).getCpf());
        Assert.assertEquals(c1.getNome(), cache.get(c1.getCpf()).getNome());
        Assert.assertEquals(c1.getTelefone(), cache.get(c1.getCpf()).getTelefone());
        Assert.assertEquals(c1.getEmpresa().getNumeroContrato(), cache.get(c1.getCpf()).getEmpresa().getNumeroContrato());
        Assert.assertEquals(c1.getEmpresa().getNomeEmpresa(), cache.get(c1.getCpf()).getEmpresa().getNomeEmpresa());
    }

    @Test(expected = Exception.class)
    public void testInserirClienteDuplicado() {
        //Cliente já inserido no método SetUp
        String cpf = "397056715827";
        Empresa e1 = new Empresa(1, "Credit Suisse");
        ClienteEmpresa ce1 = new ClienteEmpresa(1, e1, Long.parseLong(cpf), "Piera Marchesini", 961043824);
        cDAO.put(ce1);
    }

    @Test
    public void verificarSeCpfNaoExisteNoBancoTest() {
        String cpf = "397056715827";
        Empresa e1 = new Empresa(1, "Credit Suisse");
        ClienteEmpresa ce1 = new ClienteEmpresa(1, e1, Long.parseLong(cpf), "Piera Marchesini", 961043824);
        cDAO.put(ce1);
        boolean validacao = cDAO.validarCPF(Long.parseLong(cpf));
        Assert.assertFalse(validacao);
    }

    @Test
    public void testBuscarClientes() {
        Empresa e1 = new Empresa(2, "Goldman Sachs");
        ClienteEmpresa ce1 = new ClienteEmpresa(2, e1, Long.parseLong("57832717483"), "Mariana Macedo", 972616068);
        cacheCliente.put(ce1.getCpf(), ce1);
        cDAO.put(ce1);
        Empresa e2 = new Empresa(3, "Bloomberg");
        ClienteEmpresa ce2 = new ClienteEmpresa(3, e2, Long.parseLong("14305910802"), "Alessandra Marchesini", 961043824);
        cacheCliente.put(ce2.getCpf(), ce2);
        cDAO.put(ce2);
        Empresa e3 = new Empresa(4, "JP Morgan");
        ClienteEmpresa ce3 = new ClienteEmpresa(4, e3, Long.parseLong("33875779150"), "Guilherme Bellemo", 952912079);
        cacheCliente.put(ce3.getCpf(), ce3);
        cDAO.put(ce3);
        Empresa e4 = new Empresa(5,"Morgan Stanley");
        ClienteEmpresa c43 = new ClienteEmpresa(5, e4, Long.parseLong("46961026370"), "Paloma Araujo", 968211686);
        cacheCliente.put(ce3.getCpf(), ce3);
        cDAO.put(ce3);

        for (ClienteEmpresa cliEsperado : cacheCliente.values()) {
            assertEquals(cliEsperado.getCpf(), cDAO.get(cliEsperado.getCpf()).getCpf());
            assertEquals(cliEsperado.getEmpresa().getNomeEmpresa(), cDAO.get(cliEsperado.getCpf()).getEmpresa().getNomeEmpresa());
            assertEquals(cliEsperado.getNome(), cDAO.get(cliEsperado.getCpf()).getNome());
            assertEquals(cliEsperado.getTelefone(), cDAO.get(cliEsperado.getCpf()).getTelefone());
        }
    }
}
