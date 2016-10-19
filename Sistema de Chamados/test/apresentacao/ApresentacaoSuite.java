/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author 31546463
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({apresentacao.TelaCadastroEmpresaTest.class, apresentacao.TelaRelatorioChamadoTest.class, apresentacao.TelaCadastroChamadoTest.class, apresentacao.TelaCadastroClienteTest.class, apresentacao.TelaPrincipalTest.class, apresentacao.TelaRegistAcompTest.class, apresentacao.TelaCadastroTecnicoTest.class})
public class ApresentacaoSuite {

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
