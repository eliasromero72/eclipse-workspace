 package aplicacao;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Persistence;

import dominio.Acessorio;
import dominio.Proprietario;
import dominio.ProprietarioEmbedded;
import dominio.TipoCombustivel;
import dominio.Veiculo;

public class Programa {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("loja-veiculos");
		EntityManager em = emf.createEntityManager();

		///*
		em.getTransaction().begin(); // há a necessidade de se fazer uma transação ao inserir algo no bd		
		
		/*
		// parte i - Chaves compostas
		Veiculo veiculo = new Veiculo();
		veiculo.setCodigo(new VeiculoId("ABC-1234", "Uberlândia"));
		veiculo.setFabricante("Honda");
		veiculo.setModelo("Civic");
		veiculo.setAnoFabricacao(2020);
		veiculo.setAnoModelo(2020);
		veiculo.setValor(new BigDecimal(71_300));		
		
		em.persist(veiculo);
		*/
		
		/*
		// parte ii - Usando Enum
		Veiculo veiculo = new Veiculo();
		veiculo.setFabricante("Ford");
		veiculo.setModelo("Focus");
		veiculo.setAnoFabricacao(2019);
		veiculo.setAnoModelo(2020);
		veiculo.setValor(new BigDecimal(41_500));
		veiculo.setTipoCombustivel(TipoCombustivel.BICOMBUSTIVEL);
		veiculo.setDataCadastro(LocalDate.now());
		
		em.persist(veiculo);
		*/
		
		/*
		// parte iii - Usado data e CLOB
		StringBuilder especificacoes = new StringBuilder();
		especificacoes.append("Carro em excelente estado.\n");
		especificacoes.append("Completo, menos ar.\n");
		especificacoes.append("Primeiro dono, com manual de instrução ");
		especificacoes.append("e todas as revisões feitas.\n");
		especificacoes.append("IPVA pago, aceita financiamento.");
		
		Veiculo veiculo = new Veiculo();
		veiculo.setFabricante("VW");
		veiculo.setModelo("Gol");
		veiculo.setAnoFabricacao(2018);
		veiculo.setAnoModelo(2019);
		veiculo.setValor(new BigDecimal(17_200));
		veiculo.setTipoCombustivel(TipoCombustivel.BICOMBUSTIVEL);
		veiculo.setDataCadastro(LocalDate.now());
		veiculo.setEspecificacoes(especificacoes.toString());
		
		em.persist(veiculo);
		*/// parte iii continua abaixo

		/*
		// parte iv - Objetos embutidos
		ProprietarioEmbedded proprietario = new ProprietarioEmbedded();
		proprietario.setNome("João das Couves");
		proprietario.setTelefone("(34) 1234-5678");
		proprietario.setEmail("joaodascoves@gmail.com");
		
		Veiculo veiculo = new Veiculo();
		veiculo.setFabricante("VW");
		veiculo.setModelo("Gol");
		veiculo.setAnoFabricacao(2018);
		veiculo.setAnoModelo(2019);
		veiculo.setValor(new BigDecimal(17_200));
		veiculo.setTipoCombustivel(TipoCombustivel.BICOMBUSTIVEL);
		veiculo.setDataCadastro(LocalDate.now());
		veiculo.setProprietario(proprietario);
		
		em.persist(veiculo);
		*/
		
		/*
		// parte v - @OneToOne
		Proprietario proprietario = new Proprietario();
		proprietario.setNome("João das Couves");
		proprietario.setTelefone("(34) 1234-5678");
		
		// Basta incluir essa linha abaixo para persistir o proprietário.
		em.persist(proprietario);

		Veiculo veiculo = new Veiculo();
		veiculo.setFabricante("VW");
		veiculo.setModelo("Gol");
		veiculo.setAnoFabricacao(2018);
		veiculo.setAnoModelo(2018);
		veiculo.setValor(new BigDecimal(17_200));
		veiculo.setTipoCombustivel(TipoCombustivel.BICOMBUSTIVEL);
		veiculo.setDataCadastro(LocalDate.now());
		veiculo.setProprietario(proprietario);
		
		em.persist(veiculo);
		*/

		/*
		// parte vi - @ManyToOne
		Proprietario proprietario = new Proprietario();
		proprietario.setNome("João das Couves");
		proprietario.setTelefone("(34) 1234-5678");
		
		// Basta incluir essa linha abaixo para persistir o proprietário.
		em.persist(proprietario);

		Veiculo veiculo1 = new Veiculo();
		veiculo1.setFabricante("GM");
		veiculo1.setModelo("Celta");
		veiculo1.setAnoFabricacao(2015);
		veiculo1.setAnoModelo(2015);
		veiculo1.setValor(new BigDecimal(11_000));
		veiculo1.setTipoCombustivel(TipoCombustivel.GASOLINA);
		veiculo1.setDataCadastro(LocalDate.now());
		veiculo1.setProprietario(proprietario);

		em.persist(veiculo1);		
		
		Veiculo veiculo2 = new Veiculo();
		veiculo2.setFabricante("VW");
		veiculo2.setModelo("Gol");
		veiculo2.setAnoFabricacao(2018);
		veiculo2.setAnoModelo(2018);
		veiculo2.setValor(new BigDecimal(17_200));
		veiculo2.setTipoCombustivel(TipoCombustivel.BICOMBUSTIVEL);
		veiculo2.setDataCadastro(LocalDate.now());
		veiculo2.setProprietario(proprietario);
		
		em.persist(veiculo2);		
		*/	
		
		///*
		// parte vii - @ManyToMany
		
		// instancia acessórios
		Acessorio roda = new Acessorio();
		roda.setDescricao("Rodas de liga leve");
		Acessorio sensor = new Acessorio();
		sensor.setDescricao("Sensores de estacionamento");
		Acessorio mp3 = new Acessorio();
		mp3.setDescricao("MP3 Player");
		Acessorio pintura = new Acessorio();
		pintura.setDescricao("Pintura metalizada");
		
		// persiste acessórios
		em.persist(roda);
		em.persist(sensor);
		em.persist(mp3);
		em.persist(pintura);
		
		// instancia veículos
		Veiculo veiculo1 = new Veiculo();
		veiculo1.setFabricante("VW");
		veiculo1.setModelo("Gol");
		veiculo1.setAnoFabricacao(2018);
		veiculo1.setAnoModelo(2018);
		veiculo1.setValor(new BigDecimal(17_200));
		veiculo1.setTipoCombustivel(TipoCombustivel.BICOMBUSTIVEL);
		veiculo1.setDataCadastro(LocalDate.now());
		veiculo1.getAcessorios().add(roda);
		veiculo1.getAcessorios().add(mp3);
		
		Veiculo veiculo2 = new Veiculo();
		veiculo2.setFabricante("Hyundai");
		veiculo2.setModelo("i30");
		veiculo2.setAnoFabricacao(2019);
		veiculo2.setAnoModelo(2019);
		veiculo2.setValor(new BigDecimal(53_500));
		veiculo2.setTipoCombustivel(TipoCombustivel.BICOMBUSTIVEL);
		veiculo2.setDataCadastro(LocalDate.now());
		veiculo2.getAcessorios().add(roda);
		veiculo2.getAcessorios().add(sensor);
		veiculo2.getAcessorios().add(mp3);
		veiculo2.getAcessorios().add(pintura);
		
		// persiste veículos
		em.persist(veiculo1);
		em.persist(veiculo2);	
		//*/			
		
		em.getTransaction().commit();
		//*/
				
		/*
		// parte iii - Usado data e CLOB (continuação)
		em.detach(veiculo);
		Veiculo veiculo2 = em.find(Veiculo.class, veiculo.getCodigo());
		System.out.println("Veículo: " + veiculo2.getModelo());
		System.out.println("-------");
		System.out.println(veiculo2.getEspecificacoes());
		*/		

		System.out.println("pronto!");
		em.close(); // fechando...
		emf.close();

	}

}
