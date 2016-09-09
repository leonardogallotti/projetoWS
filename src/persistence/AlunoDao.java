package persistence;


import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import entity.Aluno;
import entity.Endereco;

public class AlunoDao extends  Dao {

	
	public void create(Aluno a, Endereco e)throws Exception{
		open();
		 con.setAutoCommit(false);
		  stmt = con.prepareStatement("insert into aluno values(null,?)", PreparedStatement.RETURN_GENERATED_KEYS);
		  stmt.setString(1, a.getNome());
		  stmt.execute();
		  
		  rs = stmt.getGeneratedKeys();
		  rs.next();
		  a.setIdAluno(rs.getInt(1));
		  stmt.close();
		  
		  stmt = con.prepareStatement("insert into endereco values(null,?,?,?)");
		  stmt.setString(1, e.getRua());
		  stmt.setString(2, e.getBairro());
		  stmt.setInt(3, a.getIdAluno());
		  stmt.execute();
		  stmt.close();	 
		
		 con.setAutoCommit(true);
		close();		
	}	
	
	public void delete(Integer cod)throws Exception{
		open();
		  stmt = con.prepareStatement("delete from aluno where idAluno=?");
		  stmt.setInt(1, cod);
		  stmt.execute();
		close();		
	}
	
	
	
	public List<Aluno> findAll()throws Exception{
		open();
		  stmt = con.prepareStatement("select * from v$consulta");		  
		  List<Aluno> lst = new ArrayList<Aluno>();
		  rs = stmt.executeQuery();
		  Aluno a = null;
		  while(rs.next()){
			  a = new Aluno();
			  	a.setIdAluno(rs.getInt(1));
			  	a.setNome(rs.getString(2));
			  	
			  	a.setEndereco(new Endereco());
			  	a.getEndereco().setIdEndereco(rs.getInt(3));
			  	a.getEndereco().setRua(rs.getString(4));
			  	a.getEndereco().setBairro(rs.getString(5));
		  }
		  lst.add(a);		  		  
		close();
		return lst;		
	}
	
	
	
	
	public Aluno findByCod(Integer cod)throws Exception{
		open();
		stmt = con.prepareStatement("select * from aluno  where idAluno=?");	
		  stmt.setInt(1, cod);
		  rs = stmt.executeQuery();
		  Aluno a = null;		  
		    if(rs.next()){
			    a = new Aluno(rs.getInt(1),rs.getString(2));		  	
		}		  		  		  
		close();
		return a;		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
	
		
		try {
//			Aluno a = new Aluno(null, "Gallotti");
//			Endereco e = new Endereco(null, "Rua Vera", "Bras de Pina");
//			new AlunoDao().create(a, e);
			
//			new AlunoDao().delete(3);
			
			
			
//			System.out.println(new AlunoDao().findAll());
			
		System.out.println(new AlunoDao().findByCod(4));
			
			
			System.out.println("OK");
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	   
	   
	   
	   
}
	
	
}
