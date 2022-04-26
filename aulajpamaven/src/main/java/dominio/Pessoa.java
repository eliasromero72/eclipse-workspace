package dominio;

import java.io.Serializable;
import javax.persistence.EmbeddedId;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PessoaId id;
	
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//private Integer id;
	
	//@Column (name = "nome_completo") // caso eu queria mudar o nome da columa na tabela
	private String nome;
	private String email;

	public Pessoa() {

	}

	/*
	public Pessoa(Integer id, String nome, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	*/
	
	// novos 
	public Pessoa(PessoaId id, String nome, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
	}

	public PessoaId getId() {
		return id;
	}

	public void setId(PessoaId id) {
		this.id = id;
	}	
	//---

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", email=" + email + "]";
	}

}
