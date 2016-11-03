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
import java.io.FileNotFoundException;
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
public class ControladorPrincipalTest {

    private ControladorPrincipal controladorPrincipal;

    public ControladorPrincipalTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream("tecnicos.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        HashMap<Integer, Tecnico> cacheTecnico = new HashMap<>();

        cacheTecnico.put(1, new Tecnico("Marineide", 38716465));

        oos.writeObject(cacheTecnico);

        oos.flush();
        fos.flush();

        oos.close();
        fos.close();

        fos = new FileOutputStream("empresas.dat");
        oos = new ObjectOutputStream(fos);

        HashMap<Long, Empresa> cacheEmpresa = new HashMap<>();

        cacheEmpresa.put((long) 1234, new Empresa(1234, "Apple"));

        oos.writeObject(cacheEmpresa);

        oos.flush();
        fos.flush();

        oos.close();
        fos.close();

        fos = new FileOutputStream("clientes.dat");
        oos = new ObjectOutputStream(fos);

        HashMap<Long, ClienteEmpresa> cacheCliente = new HashMap<>();

        String cpf = "45661789397";

        cacheCliente.put(Long.parseLong(cpf), new ClienteEmpresa(1, new Empresa(1234, "Apple"), Long.parseLong(cpf), "Marineide", 38716465));

        oos.writeObject(cacheCliente);

        oos.flush();
        fos.flush();

        oos.close();
        fos.close();

        fos = new FileOutputStream("chamados.dat");
        oos = new ObjectOutputStream(fos);

        HashMap<Integer, Chamado> cacheChamado = new HashMap<>();
        Tecnico tec1 = new Tecnico("Mariana", 31546463);
        ClienteEmpresa ce = new ClienteEmpresa(1, new Empresa(1010, "Samsung"), 123456789, "Amanda", 987456152);
        cacheChamado.put(1, new Chamado("banco de dados", "banco de dados não conecta", 1, tec1, ce, "Windows", "7", "BD1"));

        oos.writeObject(cacheChamado);

        oos.flush();
        fos.flush();

        oos.close();
        fos.close();

        fos = new FileOutputStream("registroChamados.dat");
        oos = new ObjectOutputStream(fos);

        HashMap<Integer, RegistroChamado> cacheRegistro = new HashMap<>();
        Tecnico tec = new Tecnico("Mariana", 31546463);

        String cpf1 = "11568375379";
        Empresa emp = new Empresa(123456, "Apple");
        ClienteEmpresa ce1 = new ClienteEmpresa(12, emp, Long.parseLong(cpf), "Gisleine", 30817564);

        cacheRegistro.put(1, new RegistroChamado("Teste", new Chamado(ce1.getCodigo(), "Chamado de Rede", "Mapeamento de pasta", 3, tec, ce1, "Windows", "7", "cabo de rede", "172.21.3.35"), tec));

        oos.writeObject(cacheRegistro);

        oos.flush();
        fos.flush();

        oos.close();
        fos.close();
    }

    @After
    public void tearDown() {
        File fileEmp = new File("tecnicos.dat");
        fileEmp.delete();
        File fileTec = new File("empresas.dat");
        fileTec.delete();
        File fileCli = new File("clientes.dat");
        fileCli.delete();
        File fileCha = new File("chamados.dat");
        fileCha.delete();
        File fileReg = new File("registroChamados.dat");
        fileReg.delete();
    }

    /**
     * Test of start method, of class ControladorPrincipal.
     */
    @Test
    public void testArquivosCriados() {
        controladorPrincipal = new ControladorPrincipal();
        assertNotNull(controladorPrincipal.getCtrTecnicos());
        assertNotNull(controladorPrincipal.getCtrEmpresa());
        assertNotNull(controladorPrincipal.getCtrChamados());
        assertNotNull(controladorPrincipal.getCtrClientes());

    }

}
