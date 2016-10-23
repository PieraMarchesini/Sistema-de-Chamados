package com.br.es2.model.entities;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ChamadoTest {
    Empresa e = new Empresa(56,"AB");
    ClienteEmpresa ce = new ClienteEmpresa(123,e,5678910,"Paloma",45362712);
    Tecnico t = new Tecnico("Ana",34231256);
    Chamado ch = new Chamado(03,"instalar software","instalação do skype",3,t,ce,"Windows","7","Cabo","privado");
    
    public ChamadoTest() {
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
     * Test of getTecnico method, of class Chamado.
     */
    @Test
    public void testGetTecnico() {
        assertEquals(t, ch.getTecnico());
    }

    /**
     * Test of getCodigo method, of class Chamado.
     */
    @Test
    public void testGetCodigo() {
        assertEquals(03,ch.getCodigo());
    }

    /**
     * Test of setCodigo method, of class Chamado.
     */
    @Test
    public void testSetCodigo() {
        ch.setCodigo(02);
        assertEquals(02,ch.getCodigo());
    }

    /**
     * Test of setTecnico method, of class Chamado.
     */
    @Test
    public void testSetTecnico() {
        Tecnico t2 = new Tecnico("Paula",3423566);
        ch.setTecnico(t2);
        assertEquals(t2,ch.getTecnico());
    }

    /**
     * Test of getCliente method, of class Chamado.
     */
    @Test
    public void testGetCliente() {
        assertEquals(ce,ch.getCliente());
    }

    /**
     * Test of setCliente method, of class Chamado.
     */
    @Test
    public void testSetCliente() {
        ClienteEmpresa ce2 = new ClienteEmpresa(345,e,5765410,"Bruna",45732712);
        ch.setCliente(ce2);
        assertEquals(ce2,ch.getCliente());
    }

    /**
     * Test of getStatus method, of class Chamado.
     */
    @Test
    public void testGetStatus() {
        assertEquals("Iniciado",ch.getStatus());
    }

    /**
     * Test of setStatus method, of class Chamado.
     */
    @Test
    public void testSetStatus() {
        ch.setStatus("Concluído");
        assertEquals("Concluído",ch.getStatus());
    }

    /**
     * Test of getTipoProblema method, of class Chamado.
     */
    @Test
    public void testGetTipoProblema() {
        assertEquals("Problema de Rede",ch.getTipoProblema());
    }

    /**
     * Test of setTipoProblema method, of class Chamado.
     */
    @Test
    public void testSetTipoProblema() {
        ch.setTipoProblema("Problema de Infra");
        assertEquals("Problema de Infra",ch.getTipoProblema());
    }

    /**
     * Test of getData method, of class Chamado.
     */
    @Test
    public void testGetData() {
        Calendar c = Calendar.getInstance();
        String date = DateFormat.getDateInstance().format(c.getTime());
	assertEquals(date,ch.getData());
    }

    /**
     * Test of setData method, of class Chamado.
     */
    @Test
    public void testSetData() {
       Date date = new Date();
       String date1 = DateFormat.getDateInstance().format(date.getTime());
	ch.setData(date1);
	assertEquals(date1,ch.getData());
    }

    /**
     * Test of getHora method, of class Chamado.
     */
    @Test
    public void testGetHora() {
        Calendar c = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(c.getTime());
        assertEquals(hora,ch.getHora());
    }

    /**
     * Test of setHora method, of class Chamado.
     */
    @Test
    public void testSetHora() {
        Date date = new Date();
        String hora = DateFormat.getTimeInstance().format(date.getTime());
        ch.setHora(hora);
        assertEquals(hora,ch.getHora());
    }

    /**
     * Test of getTitulo method, of class Chamado.
     */
    @Test
    public void testGetTitulo() {
        assertEquals("instalar software",ch.getTitulo());
    }

    /**
     * Test of setTitulo method, of class Chamado.
     */
    @Test
    public void testSetTitulo() {
        ch.setTitulo("E-mail nao conecta");
        assertEquals("E-mail nao conecta",ch.getTitulo());
    }

    /**
     * Test of getDescricao method, of class Chamado.
     */
    @Test
    public void testGetDescricao() {
        assertEquals("instalação do skype",ch.getDescricao());
    }

    /**
     * Test of setDescricao method, of class Chamado.
     */
    @Test
    public void testSetDescricao() {
        ch.setDescricao("Nao consigo receber e-mail e preciso trabalhar");
        assertEquals("Nao consigo receber e-mail e preciso trabalhar",ch.getDescricao());
    }

    /**
     * Test of getPrioridade method, of class Chamado.
     */
    @Test
    public void testGetPrioridade() {
        assertEquals(3,ch.getPrioridade());
    }

    /**
     * Test of setPrioridade method, of class Chamado.
     */
    @Test
    public void testSetPrioridade() {
        ch.setPrioridade(4);
        assertEquals(4,ch.getPrioridade());
    }

    /**
     * Test of getSistemaOperacional method, of class Chamado.
     */
    @Test
    public void testGetSistemaOperacional() {
        assertEquals("Windows",ch.getSistemaOperacional());
    }

    /**
     * Test of setSistemaOperacional method, of class Chamado.
     */
    @Test
    public void testSetSistemaOperacional() {
        ch.setSistemaOperacional("Linux");
        assertEquals("Linux",ch.getSistemaOperacional());
    }

    /**
     * Test of getVersaoSO method, of class Chamado.
     */
    @Test
    public void testGetVersaoSO() {
        assertEquals("7",ch.getVersaoSO());
    }

    /**
     * Test of setVersaoSO method, of class Chamado.
     */
    @Test
    public void testSetVersaoSO() {
        
    }

    /**
     * Test of getBancoDeDados method, of class Chamado.
     */
    @Test
    public void testGetBancoDeDados() {
        
    }

    /**
     * Test of setBancoDeDados method, of class Chamado.
     */
    @Test
    public void testSetBancoDeDados() {
        
    }

    /**
     * Test of getCausaProblema method, of class Chamado.
     */
    @Test
    public void testGetCausaProblema() {
        
    }

    /**
     * Test of setCausaProblema method, of class Chamado.
     */
    @Test
    public void testSetCausaProblema() {
        
    }

    /**
     * Test of getSolucaoProblema method, of class Chamado.
     */
    @Test
    public void testGetSolucaoProblema() {
        
    }

    /**
     * Test of setSolucaoProblema method, of class Chamado.
     */
    @Test
    public void testSetSolucaoProblema() {
        
    }

    /**
     * Test of getTipoConexao method, of class Chamado.
     */
    @Test
    public void testGetTipoConexao() {
        
    }

    /**
     * Test of setTipoConexao method, of class Chamado.
     */
    @Test
    public void testSetTipoConexao() {
        
    }

    /**
     * Test of getEnderecoRede method, of class Chamado.
     */
    @Test
    public void testGetEnderecoRede() {
        
    }

    /**
     * Test of setEnderecoRede method, of class Chamado.
     */
    @Test
    public void testSetEnderecoRede() {
        
    }

    /**
     * Test of getOperacao method, of class Chamado.
     */
    @Test
    public void testGetOperacao() {
        
    }

    /**
     * Test of setOperacao method, of class Chamado.
     */
    @Test
    public void testSetOperacao() {
        
    }

    /**
     * Test of getDuracaoOperacao method, of class Chamado.
     */
    @Test
    public void testGetDuracaoOperacao() {
        
    }

    /**
     * Test of setDuracaoOperacao method, of class Chamado.
     */
    @Test
    public void testSetDuracaoOperacao() {
        
    }

    /**
     * Test of equals method, of class Chamado.
     */
    @Test
    public void testEquals() {
        
    }
    
}
