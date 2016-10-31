/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.es2.controller;

import com.br.es2.model.entities.Empresa;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 31581773
 */
public class ControleEmpresasTest {

    public ControleEmpresasTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws FileNotFoundException, IOException {
        HashMap<Long, Empresa> cacheEmpresas = new HashMap<>();
        cacheEmpresas.put((long)1, new Empresa((1), "CreditSuisse"));
        String nomearq = "empresas.dat";
        try (FileOutputStream fos = new FileOutputStream(nomearq)) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            oos.writeObject(cacheEmpresas);
            
            oos.flush();
            fos.flush();
            
            oos.close();
        }
        ControleEmpresas controleEmpresas = new ControleEmpresas();

    }

    @After
    public void tearDown() {
        File file = new File("empresas.dat");
        file.delete();
    }

    /**
     * Test of retorna method, of class ControleEmpresas.
     */
    @Test
    public void testRetorna() {
    }

    /**
     * Test of validar method, of class ControleEmpresas.
     */
    @Test
    public void testValidar() {
    }

    /**
     * Test of inserir method, of class ControleEmpresas.
     */
    @Test
    public void testInserir() {
    }

    /**
     * Test of checar method, of class ControleEmpresas.
     */
    @Test
    public void testChecar() {
    }

    /**
     * Test of cadastrarEmpresa method, of class ControleEmpresas.
     */
    @Test
    public void testCadastrarEmpresa() {
    }

    /**
     * Test of fecharTela method, of class ControleEmpresas.
     */
    @Test
    public void testFecharTela() {
    }

}
