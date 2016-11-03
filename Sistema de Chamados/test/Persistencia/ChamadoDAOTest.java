/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import entidade.Chamado;
import entidade.ClienteEmpresa;
import entidade.Empresa;
import entidade.RegistroChamado;
import entidade.Tecnico;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
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
public class ChamadoDAOTest {
    private ChamadoDAO cDAO;
    private HashMap<Integer, RegistroChamado> cacheRegistro;
    private HashMap<Integer, Chamado> cacheChamado;
    
    @Before
    public void setUp() throws FileNotFoundException, IOException {
        Empresa e1 = new Empresa(1, "Credit Suisse");
        ClienteEmpresa ce1 = new ClienteEmpresa(1, e1, Long.parseLong("39706715827"), "Piera Marchesini", 961043824);
        Tecnico t1 = new Tecnico("Guilherme Bellemo", 952912079);
        Chamado c1 = new Chamado(ce1.getCodigo(), "Problema Conexão", "Impressora não conecta", 5, t1, ce1, "Mac", "OS X", "Wireless", "10.211.55.1");
        RegistroChamado r1 = new RegistroChamado("Impressora sem conexão", c1, t1);
        
        try (FileOutputStream fosChamado = new FileOutputStream("chamados.dat")) {
            ObjectOutputStream oosChamado = new ObjectOutputStream(fosChamado);
            cacheChamado = new HashMap<>();
            
            cacheChamado.put(1, c1);

            oosChamado.writeObject(cacheChamado);
            oosChamado.flush();
            fosChamado.flush();
            oosChamado.close();
        }

        try (FileOutputStream fosRegistro = new FileOutputStream("registroChamados.dat")) {
            ObjectOutputStream oosRegistro = new ObjectOutputStream(fosRegistro);

            cacheRegistro = new HashMap<>();

            cacheRegistro.put(1, r1);

            oosRegistro.writeObject(cacheRegistro);
            oosRegistro.flush();
            fosRegistro.flush();
            oosRegistro.close();
        }
        
    }

    @After
    public void tearDown() {
        File fileChamado = new File("chamados.dat");
        fileChamado.delete();
        File fileRegistro = new File("registroChamados.dat");
        fileRegistro.delete();
    }
    
    @Test
    public void testInserirChamado(){
        Empresa e2 = new Empresa(2, "Goldman Sachs");
        ClienteEmpresa ce2 = new ClienteEmpresa(2, e2, Long.parseLong("14305910802"), "Alessandra Marchesini", 996173174);
        Tecnico t2 = new Tecnico("Mariana Macedo", 972616068);
        Chamado c2 = new Chamado(2, "Troca de senha", "Senha de login esquecida pelo usuário",1, t2, ce2, "Windows", "7", "Rede", "192.168.133");
        cDAO.put(c2);
        //Verifica se foi inserido no HashMap
        Chamado inserido = cDAO.get(cDAO.gerarCodigo() -1);
        Assert.assertEquals(c2.getCodigo(), inserido.getCodigo());
    }
    
    @Test
    public void testInserirRegistro() throws FileNotFoundException, IOException, ClassNotFoundException{
        Empresa e2 = new Empresa(2, "Goldman Sachs");
        ClienteEmpresa ce2 = new ClienteEmpresa(2, e2, Long.parseLong("14305910802"), "Alessandra Marchesini", 996173174);
        Tecnico t2 = new Tecnico("Mariana Macedo", 972616068);
        Chamado c2 = new Chamado(2, "Troca de senha", "Senha de login esquecida pelo usuário",1, t2, ce2, "Windows", "7", "Rede", "192.168.133");
        RegistroChamado r2 = new RegistroChamado("Senha esquecida", c2, t2);
        cDAO.putRegistro(r2);
        
        //Verifica se foi inserido no Arquivo
        FileInputStream fis = new FileInputStream("registroChamados.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);
        cacheRegistro = (HashMap<Integer, RegistroChamado>) ois.readObject();
        ois.close();
        fis.close();
        
        assertEquals(r2.getCodigo(), cacheRegistro.get(2).getCodigo());
        assertEquals(r2.getChamado().getCodigo(), cacheRegistro.get(2).getChamado().getCodigo());
    }

    @Test(expected = Exception.class)
    public void testInserirChamadoDuplicado() {
        Empresa e1 = new Empresa(1, "Credit Suisse");
        ClienteEmpresa ce1 = new ClienteEmpresa(1, e1, Long.parseLong("39706715827"), "Piera Marchesini", 961043824);
        Tecnico t1 = new Tecnico("Guilherme Bellemo", 952912079);
        Chamado c1 = new Chamado(ce1.getCodigo(), "Problema Conexão", "Impressora não conecta", 5, t1, ce1, "Mac", "OS X", "Wireless", "10.211.55.1");
        cDAO.put(c1);
    }
}
