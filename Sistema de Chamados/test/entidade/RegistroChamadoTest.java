package entidade;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 31581773
 */
public class RegistroChamadoTest {
  
    Empresa e = new Empresa(87,"Magna Sistemas");
    Pessoa p = new Pessoa("Ana",45362712);
    ClienteEmpresa ce = new ClienteEmpresa(123,e,5678910,p.getNome(),p.getTelefone());
    Tecnico t = new Tecnico("Paloma",30224761);
    Chamado ch = new Chamado(ce.getCodigo(),"Internet não funciona","Não consigo navegar na internet",2,t,ce,"Windows","7","Cabo","192.168.2.13");
    RegistroChamado rc;
    
    public RegistroChamadoTest(){
        
    }
    
    @Test
    public void criarRegistroChamadoTest(){
        rc = new RegistroChamado("Software instalado",ch,t);
        
        assertEquals("Software instalado",rc.getAssunto());
        assertEquals(ch,rc.getChamado());
        assertEquals(t,rc.getTecnico());
    } 

    @Test
    public void editarRegistroChamadoTest(){
        Tecnico t2 = new Tecnico("Maria",67832672);
        Chamado ch2 = new Chamado("banco de dados","banco de dados não conecta",1,t2,ce,"Windows","7","BD1");
        rc = new RegistroChamado("Software instalado",ch,t);
        
        rc.setAssunto("Problema de conexão resolvido");
        rc.setChamado(ch2);
        rc.setTecnico(t2);
        
        assertEquals("Problema de conexão resolvido",rc.getAssunto());
        assertEquals(ch2,rc.getChamado());
        assertEquals(t2,rc.getTecnico());
    }
    
    @Test
    public void assuntoInvalidoTest(){
        rc = new RegistroChamado(" ",ch,t);
        assertEquals(" ", rc.getAssunto());
    }
}
