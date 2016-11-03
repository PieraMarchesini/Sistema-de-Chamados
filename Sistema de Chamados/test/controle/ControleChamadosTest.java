/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import entidade.Chamado;
import entidade.ClienteEmpresa;
import entidade.Empresa;
import entidade.RegistroChamado;
import entidade.Tecnico;
import java.io.File;
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
public class ControleChamadosTest {

    private ControleChamados controleChamados;
    private final int tempoTimeOut = 800;

    public ControleChamadosTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws IOException {
        try (FileOutputStream fos = new FileOutputStream("chamados.dat")) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            HashMap<Integer, Chamado> cacheChamados = new HashMap<>();
            Tecnico tec = new Tecnico("Mariana", 31546463);
            String cpf = "11568375379";
            Empresa emp = new Empresa(123456, "Apple");
            ClienteEmpresa ce = new ClienteEmpresa(12, emp, Long.parseLong(cpf), "Gisleine", 30817564);

            cacheChamados.put(2, new Chamado("banco de dados", "banco de dados não conecta", 1, tec, ce, "Windows", "7", "BD1"));
            oos.writeObject(cacheChamados);

            oos.flush();
            fos.flush();

            oos.close();
        }
    }

    @After
    public void tearDown() {
        File file = new File("chamados.dat");
        file.delete();
    }

    // teste para inserir chamado de rede
    @Test
    public void testInserirChamadoRede() {
        controleChamados = new ControleChamados();
        Tecnico tec = new Tecnico("Mariana", 31546463);
        String cpf = "11568375379";
        Empresa emp = new Empresa(123456, "Apple");
        ClienteEmpresa ce = new ClienteEmpresa(12, emp, Long.parseLong(cpf), "Gisleine", 30817564);

        Chamado chamado = controleChamados.InserirChamadoRede("Rede", "Sem mapeamento das pastas e rede",
                2, tec, ce, "Windows", "7", "cabo de rede", "172.21.3.35");
        chamado.setEnderecoRede("172.21.3.35");
        chamado.setSistemaOperacional("Windows");
        assertEquals("Rede", chamado.getTitulo());
        assertEquals("Sem mapeamento das pastas e rede", chamado.getDescricao());
        assertEquals(2, chamado.getPrioridade());
        assertEquals(tec, chamado.getTecnico());
        assertEquals(ce, chamado.getCliente());
        assertEquals("Windows", chamado.getSistemaOperacional());
        assertEquals("7", chamado.getVersaoSO());
        assertEquals("cabo de rede", chamado.getTipoConexao());
        assertEquals("172.21.3.35", chamado.getEnderecoRede());
    }

    /**
     * Test of InserirChamadoBancoDeDados method, of class ControleChamados.
     */
    //teste para inserir chamado de bd
    @Test(timeout = tempoTimeOut)
    public void testInserirChamadoBancoDeDados() {
        controleChamados = new ControleChamados();
        Tecnico tec = new Tecnico("Mariana", 31546463);
        String cpf = "11568375379";
        Empresa emp = new Empresa(123456, "Apple");
        ClienteEmpresa ce = new ClienteEmpresa(12, emp, Long.parseLong(cpf), "Gisleine", 30817564);
        Chamado chamado = controleChamados.InserirChamadoBancoDeDados("Banco de Dados", "insercao de novas colunas",
                4, tec, ce, "Windows", "7", "SQL");
        assertEquals("Banco de Dados", chamado.getTitulo());
        assertEquals("insercao de novas colunas", chamado.getDescricao());
        assertEquals(4, chamado.getPrioridade());
        assertEquals(tec, chamado.getTecnico());
        assertEquals(ce, chamado.getCliente());
        assertEquals("Windows", chamado.getSistemaOperacional());
        assertEquals("7", chamado.getVersaoSO());
        assertEquals("SQL", chamado.getBancoDeDados());
    }

    /**
     * Test of InserirChamadoDesempenho method, of class ControleChamados.
     */
    @Test(timeout = tempoTimeOut)
    public void testInserirChamadoDesempenho() {
        controleChamados = new ControleChamados();
        Tecnico tec = new Tecnico("Mariana", 31546463);
        String cpf = "11568375379";
        Empresa emp = new Empresa(123456, "Apple");
        ClienteEmpresa ce = new ClienteEmpresa(12, emp, Long.parseLong(cpf), "Gisleine", 30817564);

        Chamado chamado = controleChamados.InserirChamadoDesempenho("Máquina lenta", "Todos os programas travam e demora 15 minutos para a máquina iniciar",
                4, tec, ce, "Windows", "7", "verificar disco", 20.10);
        assertEquals("Máquina lenta", chamado.getTitulo());
        assertEquals("Todos os programas travam e demora 15 minutos para a máquina iniciar", chamado.getDescricao());
        assertEquals(4, chamado.getPrioridade());
        assertEquals(tec, chamado.getTecnico());
        assertEquals(ce, chamado.getCliente());
        assertEquals("Windows", chamado.getSistemaOperacional());
        assertEquals("7", chamado.getVersaoSO());
        assertEquals("verificar disco", chamado.getOperacao());
        assertEquals(20.10, chamado.getDuracaoOperacao(), 0.0);
    }

   
    //Definir Status
    @Test (timeout = tempoTimeOut)
    public void testAlterarChamado() {
        controleChamados = new ControleChamados();
        Tecnico tec = new Tecnico("Mariana", 31546463);
        String cpf = "11568375379";
        Empresa emp = new Empresa(123456, "Apple");
        ClienteEmpresa ce = new ClienteEmpresa(12, emp, Long.parseLong(cpf), "Gisleine", 30817564);

        Chamado chamado = new Chamado("banco de dados", "banco de dados não conecta", 1, tec, ce, "Windows", "7", "BD1");
        ce.setCodigo(100);
        chamado.setStatus("Pendente");
  
        assertEquals("Pendente", chamado.getStatus());
      
    }

    @Test (timeout = tempoTimeOut)
    public void testValidarQtdChamados() {
        controleChamados = new ControleChamados();

        Tecnico tec = new Tecnico("Mariana", 31546463);
        String cpf = "11568375379";
        Empresa emp = new Empresa(123456, "Apple");
        ClienteEmpresa ce = new ClienteEmpresa(12, emp, Long.parseLong(cpf), "Gisleine", 30817564);
        Chamado chamado = new Chamado("banco de dados", "banco de dados não conecta", 1, tec, ce, "Windows", "7", "BD1");

        int qtd = controleChamados.validarQtdChamados(ce);

        Assert.assertEquals(1, qtd);
    }

}
