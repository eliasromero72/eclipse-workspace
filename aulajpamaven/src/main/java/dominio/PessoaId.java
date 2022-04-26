package dominio;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class PessoaId implements Serializable {
	private static final long serialVersionUID = 1L;

	private String rg;
	private String cidadeNasc;
	
	public PessoaId() {
		
	}

	public PessoaId(String rg, String cidadeNasc) {
		super();
		this.rg = rg;
		this.cidadeNasc = cidadeNasc;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCidadeNasc() {
		return cidadeNasc;
	}

	public void setCidadeNasc(String cidadeNasc) {
		this.cidadeNasc = cidadeNasc;
	}
	
}
