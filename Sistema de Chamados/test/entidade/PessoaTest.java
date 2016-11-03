package entidade;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 31581773
 */
public class PessoaTest {
    
    Pessoa p;
    
    public PessoaTest() {
    }
    
    @Test
    public void criarPessoaTest(){
        p = new Pessoa("Mariana", 30817564);
        
        assertEquals("Mariana", p.getNome());
        assertEquals(30817564, p.getTelefone());
    }
    
    @Test
    public void editarPessoaTest(){
        p = new Pessoa("Mariana", 30817564);
        p.setNome("Paloma");
        p.setTelefone(30224761);
        
        assertEquals("Paloma", p.getNome());
        assertEquals(30224761, p.getTelefone());
    }
 
    @Test 
    public void NomeInvalidoPassa(){
        p = new Pessoa("Mariana", 30817564);
        p.setNome("Mari@ M@d@l$en@");
        assertEquals("Mari@ M@d@l$en@", p.getNome());
    }

    @Test
    public void TelefoneInvalidoPassa(){
        p = new Pessoa("Mariana", 30817564);
        p.setTelefone(123);
        assertEquals(123,p.getTelefone());
    }
}
