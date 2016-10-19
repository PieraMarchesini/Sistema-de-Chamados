/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.es2.controller;

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
@Suite.SuiteClasses({com.br.es2.controller.ControladorPrincipalTest.class, com.br.es2.controller.ControleTecnicosTest.class, com.br.es2.controller.ControleChamadosTest.class, com.br.es2.controller.IControladorTest.class, com.br.es2.controller.ControleClientesTest.class, com.br.es2.controller.ControleEmpresasTest.class})
public class ControllerSuite {

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
