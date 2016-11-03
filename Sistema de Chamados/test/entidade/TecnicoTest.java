package entidade;

import static org.junit.Assert.*;
import org.junit.Test;
 
 /**
  *
  * @author 31581773
  */
 public class TecnicoTest {

     Tecnico tec;
     
    public TecnicoTest() {
    }

    @Test
    public void inserirTecnicoTest(){
        tec = new Tecnico("Mariana", 972616068);
        assertEquals("Mariana", tec.getNome());
        assertEquals(972616068, tec.getTelefone());
    }
    
    public void editarTecnicoTest(){
        tec = new Tecnico("Mariana", 972616068);
        tec.setNome("Mariana Macedo");
        tec.setTelefone(97261606);
        
        assertEquals("Mariana Macedo", tec.getNome());
        assertEquals(97261606, tec.getTelefone());
    }
     
    @Test
    public void inserirTelefoneInvalidoTest(){
        tec = new Tecnico("Paloma", 97261);
        assertEquals(97261, tec.getTelefone());
    }
      
    @Test
    public void inserirNomeCaracteresTest(){
        tec = new Tecnico("P!er@", 972616068);
        assertEquals("P!er@",tec.getNome());
    } 
}

