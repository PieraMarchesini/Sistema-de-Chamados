package entidade;


import org.junit.Test;
import static org.junit.Assert.*;

public class ChamadoTest {
    
    Empresa e = new Empresa(56,"Magna Sistemas");
    Pessoa p = new Pessoa("Ana",30235734);
    ClienteEmpresa ce = new ClienteEmpresa(123,e,567891090,p.getNome(),p.getTelefone());
    Tecnico t = new Tecnico("Paloma",30224761);
    
    public ChamadoTest() {
    }
    
    //Chamado para problema de rede
    @Test
    public void criarChamadoTest(){
        Chamado ch = new Chamado(ce.getCodigo(),"Internet não funciona","Não consigo navegar na internet",2,t,ce,"Windows","7","Cabo","192.168.2.13");
        
        assertEquals(t, ch.getTecnico());
        assertEquals(123, ch.getCodigo());
        assertEquals(ce, ch.getCliente());
        assertEquals("Iniciado", ch.getStatus());
        assertEquals("Problema de Rede", ch.getTipoProblema());
        assertEquals("Internet não funciona", ch.getTitulo());
        assertEquals("Não consigo navegar na internet", ch.getDescricao());
        assertEquals(3, ch.getPrioridade());
        assertEquals("Windows", ch.getSistemaOperacional());
        assertEquals("7", ch.getVersaoSO());
        assertEquals("Cabo", ch.getTipoConexao());
        assertEquals("192.168.2.13", ch.getEnderecoRede());
    }
    
    //Chamado para problema de banco de dados
    @Test
    public void criarChamadoTest2(){
        Chamado ch2 = new Chamado("banco de dados","banco de dados não conecta",1,t,ce,"Windows","7","BD1");
        
        assertEquals("banco de dados", ch2.getTitulo());
        assertEquals("banco de dados não conecta", ch2.getDescricao());
        assertEquals(1, ch2.getPrioridade());
        assertEquals(t, ch2.getTecnico());
        assertEquals(ce, ch2.getCliente());
        assertEquals("Windows", ch2.getSistemaOperacional());
        assertEquals("7", ch2.getVersaoSO());
        assertEquals("BD1", ch2.getBancoDeDados());
    }

    //Chamado para problema de desempenho
    @Test
    public void criarChamadoTest3(){
        Chamado ch3 = new Chamado("problema de desempenho","melhorar desempenho da máquina",2,t,ce,"Windows","7","HD",8.9);
        
        assertEquals("problema de desempenho", ch3.getTitulo());
        assertEquals("melhorar desempenho da máquina", ch3.getDescricao());
        assertEquals(2, ch3.getPrioridade());
        assertEquals(t, ch3.getTecnico());
        assertEquals(ce, ch3.getCliente());
        assertEquals("Windows", ch3.getSistemaOperacional());
        assertEquals("7", ch3.getVersaoSO());
        assertEquals("HD", ch3.getOperacao());
        assertEquals(ch3.getDuracaoOperacao(), ch3.getDuracaoOperacao());
    }
    
    //Update chamado de problema de rede
    public void editarChamadoTest(){
        Pessoa p2 = new Pessoa("Bruna",45732712);
        ClienteEmpresa ce2 = new ClienteEmpresa(345,e,5765410,p2.getNome(),p2.getTelefone());
        Tecnico t2 = new Tecnico("Paula",3423566);
        Chamado ch = new Chamado(ce.getCodigo(),"Internet não funciona","Não consigo navegar na internet",2,t,ce,"Windows","7","Cabo","192.168.2.13");
        
        ch.setTecnico(t2);
        ch.setCodigo(345);
        ch.setCliente(ce2);
        ch.setStatus("Concluído");
        ch.setTipoProblema("Problema de Infra");
        ch.setTitulo("E-mail nao conecta");
        ch.setDescricao("Nao consigo receber e-mail e preciso trabalhar");
        ch.setPrioridade(4);
        ch.setSistemaOperacional("Linux");
        ch.setVersaoSO("8");
        ch.setTipoConexao("Radio");
        ch.setEnderecoRede("192.168.2.14");
        
        assertEquals(t2, ch.getTecnico());
        assertEquals(345, ch.getCodigo());
        assertEquals(ce2, ch.getCliente());
        assertEquals("Concluído", ch.getStatus());
        assertEquals("Problema de Infra", ch.getTipoProblema());
        assertEquals("E-mail nao conecta", ch.getTitulo());
        assertEquals("Nao consigo receber e-mail e preciso trabalhar", ch.getDescricao());
        assertEquals(4, ch.getPrioridade());
        assertEquals("Linux", ch.getSistemaOperacional());
        assertEquals("8", ch.getVersaoSO());
        assertEquals("Radio", ch.getTipoConexao());
        assertEquals("192.168.2.14", ch.getEnderecoRede());
    }
 
    //update chamado de problema de banco de dados
    @Test
    public void editarChamadoTest2(){
        Chamado ch2 = new Chamado("banco de dados","banco de dados não conecta",1,t,ce,"Windows","7","BD1");
        ch2.setBancoDeDados("BD2");
        assertEquals("BD2", ch2.getBancoDeDados());
    }
    
    //update chamado de problema de desempenho
    @Test
    public void editarChamadoTest3(){
        Chamado ch3 = new Chamado("problema de desempenho","melhorar desempenho da máquina",2,t,ce,"Windows","7","HD",8.9);
        ch3.setDuracaoOperacao(10.0);
        ch3.setOperacao("SSD");
        
        assertEquals(ch3.getDuracaoOperacao(), ch3.getDuracaoOperacao());
        assertEquals("SSD", ch3.getOperacao());
    }
}
