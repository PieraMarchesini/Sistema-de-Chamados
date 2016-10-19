/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.es2.view;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author 31581773
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({com.br.es2.view.TelaPrincipalTest.class, com.br.es2.view.TelaCadastroClienteTest.class, com.br.es2.view.TelaCadastroEmpresaTest.class, com.br.es2.view.TelaRelatorioChamadoTest.class, com.br.es2.view.TelaCadastroTecnicoTest.class, com.br.es2.view.TelaCadastroChamadoTest.class, com.br.es2.view.TelaRegistAcompTest.class})
public class ViewSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
