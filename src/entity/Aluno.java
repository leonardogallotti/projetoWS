package entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Aluno {

	private Integer idAluno;
	
	private String nome;
	
	private Endereco   endereco;

	public Aluno() {
		
	}
	
	
	public Aluno(Integer idAluno, String nome) {
		super();
		this.idAluno = idAluno;
		this.nome = nome;
	}

	public Aluno(Integer idAluno, String nome, Endereco endereco) {
		super();
		this.idAluno = idAluno;
		this.nome = nome;
		this.endereco = endereco;
	}



	@Override
	public String toString() {
		return "Aluno [idAluno=" + idAluno + ", nome=" + nome + ", endereco="
				+ endereco + "]";
	}

	public Integer getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Integer idAluno) {
		this.idAluno = idAluno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
	
	
}
