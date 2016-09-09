package services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.google.gson.Gson;

import persistence.AlunoDao;
import entity.Aluno;
import entity.Endereco;

@Path("/aluno")
public class WebServices {

	
	
	@Path("/gravar/{nome}/{rua}/{bairro}")
	@GET
	@Produces("text/plain")
	public String  gravar(@PathParam("nome")    String nome,
						  @PathParam("rua")     String rua,
						  @PathParam("bairro")  String bairro){		
		try {		  
			
			Aluno a = new Aluno(null, nome);
			Endereco e = new Endereco(null, rua, bairro);			
			new AlunoDao().create(a, e);			
			return"Dados Gravados";
		
		} catch (Exception e) {
			return "ERROR:" + e.getMessage();
		}		
		
	}
	
	
	@Path("/deletar/{idAluno}")
	@GET
	@Produces("text/plain")
	public String deletar(@PathParam("idAluno") String idAluno){		
		try {
			
			new AlunoDao().delete(new Integer(idAluno));			
			return "Dados Removidos";
			
		} catch (Exception e) {
			return "ERROR:" + e.getMessage();
		}		
		
	}
	
	
	@Path("/buscar/{idAluno}")
	@GET
	@Produces("text/plain")
	public String  buscar(@PathParam("idAluno") String idAluno){		
		try {
			
				
			return new Gson().toJson(new AlunoDao().findByCod(new Integer(idAluno)));
		
		} catch (Exception e) {
			return "ERROR:" + e.getMessage();
		}		
		
	}
	
	
	
	@Path("/listar")
	@GET
	@Produces("application/json")
	public String  listar(){		
		try {		  
			return new Gson().toJson(new AlunoDao().findAll());
		} catch (Exception e) {
			return "ERROR:" + e.getMessage();
		}		
		
	}
	
	
	
	
}
