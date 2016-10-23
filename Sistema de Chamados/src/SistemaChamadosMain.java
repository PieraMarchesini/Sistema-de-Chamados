
import com.br.es2.controller.ControladorPrincipal;
import com.br.es2.model.entities.Chamado;
import com.br.es2.model.entities.ClienteEmpresa;
import com.br.es2.model.entities.Empresa;
import com.br.es2.model.entities.Tecnico;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Piera
 */
public class SistemaChamadosMain {
	
	public static void main(String[] args){
		
		new ControladorPrincipal().start();
     
	}
	
}
