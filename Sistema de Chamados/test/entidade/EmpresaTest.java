package entidade;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 31581773
 */
public class EmpresaTest {
    
    Empresa emp;
    
    public EmpresaTest() {
    }
    
    @Test
    public void criarEmpresaTest(){
        emp = new Empresa(123456,"Duratex");
        
        assertEquals(123456, emp.getNumeroContrato());
        assertEquals("Duratex", emp.getNomeEmpresa());
    }
    
    @Test
    public void editarEmpresaTest(){
        emp = new Empresa(123456,"Duratex");
        emp.setNomeEmpresa("Twitter");
        emp.setNumeroContrato(7891011);
        
        assertEquals("Twitter", emp.getNomeEmpresa());
        assertEquals(7891011, emp.getNumeroContrato());
    }
}

