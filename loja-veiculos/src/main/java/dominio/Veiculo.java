package dominio;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "tab_veiculo")
public class Veiculo {
	
	@EmbeddedId	
	private VeiculoId codigo;

	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//private Long codigo;
	
	@Column(length = 60, nullable = false)
	private String fabricante;
	
	@Column(length = 60, nullable = false)
	private String modelo;
	
	@Column(name = "ano_fabricacao", nullable = false)
	private Integer anoFabricacao;
	
	@Column(name = "ano_modelo", nullable = false)
	private Integer anoModelo;
	
	@Column(precision = 10, scale = 2, nullable = true)
	private BigDecimal valor;
	
	//@Column(name = "tipo_combustivel", nullable = false)
	//@Enumerated(EnumType.STRING) // EnumType.ORDINAL (insere número ao invés da string)
	//private TipoCombustivel tipoCombustivel;
	
	//@Temporal(TemporalType.DATE)
	//@Column(name = "data_cadastro", nullable = false)
	//private LocalDate dataCadastro;
	
	/*
	@Lob
	private String especificacoes;
	
	@Lob
	private byte[] foto;
	*/
	
	//@Embedded
	//private Proprietario proprietario;
	
	/*
	@OneToOne(optional = false)
	@JoinColumn(name = "cod_proprietario")
	private Proprietario proprietario;
	*/

	/*
	As propriedades de uma entidade são automaticamente mapeadas se não especificarmos nenhuma anotação.
	Por diversas vezes, podemos precisar criar atributos que não representam uma coluna no banco de dados. Nestes casos, devemos anotar com @Transient.
	A propriedade será ignorada totalmente pelo mecanismo de persistência.
	*/
	//@Transient
	//private String descricaoCompleta;
	
	public Veiculo() {
	}

	public Veiculo(VeiculoId codigo, String fabricante, String modelo, Integer anoFabricacao, Integer anoModelo,
			BigDecimal valor) {
		super();
		this.codigo = codigo;
		this.fabricante = fabricante;
		this.modelo = modelo;
		this.anoFabricacao = anoFabricacao;
		this.anoModelo = anoModelo;
		this.valor = valor;
	}

	public VeiculoId getCodigo() {
		return codigo;
	}

	public void setCodigo(VeiculoId codigo) {
		this.codigo = codigo;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(Integer anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public Integer getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(Integer anoModelo) {
		this.anoModelo = anoModelo;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(anoFabricacao, anoModelo, codigo, fabricante, modelo, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		return Objects.equals(anoFabricacao, other.anoFabricacao) && Objects.equals(anoModelo, other.anoModelo)
				&& Objects.equals(codigo, other.codigo) && Objects.equals(fabricante, other.fabricante)
				&& Objects.equals(modelo, other.modelo) && Objects.equals(valor, other.valor);
	}
	
}
