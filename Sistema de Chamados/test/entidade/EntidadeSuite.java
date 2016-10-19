/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

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
@Suite.SuiteClasses({entidade.TecnicoTest.class, entidade.EmpresaTest.class, entidade.ChamadoTest.class, entidade.BancoDeDadosTest.class, entidade.StatusTest.class, entidade.ClienteEmpresaTest.class, entidade.PessoaTest.class, entidade.SistemaOperacionalTest.class, entidade.TipoConexaoTest.class, entidade.RegistroChamadoTest.class, entidade.TipoProblemaTest.class})
public class EntidadeSuite {

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
