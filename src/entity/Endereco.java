package entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Endereco {

	private Integer idEndereco;
	
	private String  rua;
	
	private String  bairro;
	
	private Aluno	aluno;
	
	public Endereco() {
		
	}

	public Endereco(Integer idEndereco, String rua, String bairro) {
		super();
		this.idEndereco = idEndereco;
		this.rua = rua;
		this.bairro = bairro;
	}

	@Override
	public String toString() {
		return "Endereco [idEndereco=" + idEndereco + ", rua=" + rua
				+ ", bairro=" + bairro + "]";
	}

	public Integer getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	
	
	
}
