package dominio;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tab_veiculo")
public class Veiculo {
	
	//@EmbeddedId	
	//private VeiculoId codigo;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

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
	
	@Column(name = "tipo_combustivel", nullable = false)
	@Enumerated(EnumType.STRING) // EnumType.ORDINAL (insere número ao invés da string)
	private TipoCombustivel tipoCombustivel;
	
	//@Temporal(TemporalType.DATE) // Precisão de data, mas não está funcionando nesta IDE Eclipse
	@Column(name = "data_cadastro", nullable = false)
	private LocalDate dataCadastro;
	
	/*
	@Lob
	private String especificacoes;
	
	@Lob
	private byte[] foto;
	*/
	
	//@Embedded
	//private ProprietarioEmbedded proprietario;
	
	///*
	// O relacionamento one-to-one aceita referências nulas, por padrão. Podemos obrigar a atribuição de proprietário durante a persistência de Veiculo, incluindo o atributo optional com valor false na anotação @OneToOne.
	//@OneToOne
	//@OneToOne(optional = false)
	//@JoinColumn(name = "cod_proprietario")
	//private Proprietario proprietario;
	//*/
	
	/*
	@ManyToOne
	@JoinColumn(name = "proprietario_codigo")
	private Proprietario proprietario;
	*/
	
	@ManyToMany
	///*
	// parte ii - @JoinTable
	@JoinTable(name = "veiculo_acessorio",
	joinColumns = @JoinColumn(name = "veiculo_codigo"),
	inverseJoinColumns = @JoinColumn(name = "acessorio_codigo"))
	//*/
	// parte i
	private Set<Acessorio> acessorios = new HashSet<>(); // Definimos aqui um conjunto para que um veículo não tenha um acessório repetido

	/*
	As propriedades de uma entidade são automaticamente mapeadas se não especificarmos nenhuma anotação.
	Por diversas vezes, podemos precisar criar atributos que não representam uma coluna no banco de dados. Nestes casos, devemos anotar com @Transient.
	A propriedade será ignorada totalmente pelo mecanismo de persistência.
	*/
	//@Transient
	//private String descricaoCompleta;
	
	public Veiculo() {
	}

	public Veiculo(Long codigo, String fabricante, String modelo, Integer anoFabricacao, Integer anoModelo,
			BigDecimal valor, TipoCombustivel tipoCombustivel, LocalDate dataCadastro, Set<Acessorio> acessorios) {
		super();
		this.codigo = codigo;
		this.fabricante = fabricante;
		this.modelo = modelo;
		this.anoFabricacao = anoFabricacao;
		this.anoModelo = anoModelo;
		this.valor = valor;
		this.tipoCombustivel = tipoCombustivel;
		this.dataCadastro = dataCadastro;
		this.acessorios = acessorios;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
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

	public TipoCombustivel getTipoCombustivel() {
		return tipoCombustivel;
	}

	public void setTipoCombustivel(TipoCombustivel tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Set<Acessorio> getAcessorios() {
		return acessorios;
	}

	public void setAcessorios(Set<Acessorio> acessorios) {
		this.acessorios = acessorios;
	}

	@Override
	public int hashCode() {
		return Objects.hash(acessorios, anoFabricacao, anoModelo, codigo, dataCadastro, fabricante, modelo,
				tipoCombustivel, valor);
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
		return Objects.equals(acessorios, other.acessorios) && Objects.equals(anoFabricacao, other.anoFabricacao)
				&& Objects.equals(anoModelo, other.anoModelo) && Objects.equals(codigo, other.codigo)
				&& Objects.equals(dataCadastro, other.dataCadastro) && Objects.equals(fabricante, other.fabricante)
				&& Objects.equals(modelo, other.modelo) && tipoCombustivel == other.tipoCombustivel
				&& Objects.equals(valor, other.valor);
	}
	
}
