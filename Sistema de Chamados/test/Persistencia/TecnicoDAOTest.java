/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Persistencia.TecnicoDAO;
import entidade.Tecnico;
import entidade.Tecnico;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 31581773
 */
public class TecnicoDAOTest {

    private TecnicoDAO tDAO;
    private HashMap<Long, Tecnico> cacheTecnico;

    public TecnicoDAOTest() {
    }

    @Before
    public void setUp() throws IOException {
        cacheTecnico = new HashMap<>();
        cacheTecnico.put((long) 1, new Tecnico("Piera Marchesini", 961043824));
        String arquivo = "tecnicos.dat";
        try (FileOutputStream fos = new FileOutputStream(arquivo)) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(cacheTecnico);

            oos.flush();
            fos.flush();

            oos.close();
        }
        tDAO = new TecnicoDAO();
    }

    @After
    public void tearDown() {
        File file = new File("tecnicos.dat");
        file.delete();
    }
    
    @Test
    public void testInserirTecnico(){
        Tecnico t1 = new Tecnico("Guilherme Bellemo", 959212079);
        tDAO.put(t1);
        //verifica se foi inserido no HashMap
        Tecnico tInserido = tDAO.get(tDAO.gerarCodigo()-1);
        Assert.assertEquals(t1.getNome(), tInserido.getNome());
        Assert.assertEquals(t1.getTelefone(), tInserido.getTelefone());
    }

    @Test(expected = Exception.class)
    public void testInserirTecnicoDuplicado() {
        //técnico já inserido no setUp 
        Tecnico existente = new Tecnico("Piera Marchesini", 961043824);
        tDAO.put(existente);
    }
    
    @Test(expected = Exception.class)
    public void testInserirTecnicoTelefoneNegativo() {
        Tecnico t1 = new Tecnico("Mariana Macedo", -12345678);
        tDAO.put(t1);
    }
    
    @Test
    public void testGerarCodigo(){
        int codEsperado = tDAO.voltaCashTecnico().size()+1;
        Assert.assertEquals(codEsperado, tDAO.gerarCodigo());
    }
    /*
    @Test
    public void testBuscarTecnicos(){
        Tecnico t1 = new Tecnico("Guilherme Bellemo", 959212079);
        Tecnico t2 = new Tecnico("Mariana Macedo", 12345678);
        Tecnico t3 = new Tecnico("Alessandra Marchesini", 996173174);
        tDAO.put(t1);
        tDAO.put(t2);
        tDAO.put(t3);
        cacheTecnico.put((long)2, t1);
        cacheTecnico.put((long)3, t1);
        cacheTecnico.put((long)4, t1);
        
        
        //Verifica os técnicos inseridos
        int contador = 1;
        for (Tecnico tecnico : cacheTecnico.values()) {
            Assert.assertEquals(tecnico.getNome(), tDAO.voltaCashTecnico().get(contador).getNome());
            Assert.assertEquals(tecnico.getTelefone(), tDAO.voltaCashTecnico().get(contador).getTelefone());
            contador++;
        }
    }
    */
    @Test
    public void testVerificaInsercao(){
        Tecnico t1 = new Tecnico("Guilherme Bellemo", 959212079);
        tDAO.put(t1);
        Assert.assertTrue(tDAO.voltaCashTecnico().size()>1);
    }
}
