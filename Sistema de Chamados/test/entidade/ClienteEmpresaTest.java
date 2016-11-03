package entidade;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 31581773
 */
public class ClienteEmpresaTest {
    
    Empresa empresa = new Empresa(123456, "Anbima");
    Pessoa p = new Pessoa("Mariana",30817564);
    ClienteEmpresa ce;
    
    public ClienteEmpresaTest() {
    }

    @Test
    public void criarClienteEmpresaTest(){
       ce = new ClienteEmpresa(1234,empresa,12345,p.getNome(),p.getTelefone());
       
       assertEquals(ce.getCodigo(), ce.getCodigo());
       assertEquals(empresa, ce.getEmpresa());
       assertEquals(12345, ce.getCpf());
       assertEquals("Mariana", ce.getNome());
       assertEquals(30817564, ce.getTelefone());
    }
   
    @Test
    public void editarClienteEmpresTest(){
       ce = new ClienteEmpresa(1234,empresa,12345,p.getNome(),p.getTelefone());
       ce.setCodigo(6789);
       ce.setCpf(1234567);
       ce.setNome("Paloma");
       ce.setTelefone(30224761);
      
       assertEquals(ce.getCodigo(), ce.getCodigo());
       assertEquals(1234567, ce.getCpf());
       assertEquals("Paloma", ce.getNome());
       assertEquals(30224761, ce.getTelefone());
    }
    
    @Test
    public void CPFInvalidoPassa(){
        ce = new ClienteEmpresa(1234,empresa,12345,p.getNome(),p.getTelefone());
        assertEquals(12345, ce.getCpf());
    } 
}

