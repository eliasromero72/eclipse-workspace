package aplicacao;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//import dominio.Proprietario;
import dominio.TipoCombustivel;
import dominio.Veiculo;
import dominio.VeiculoId;

public class Programa {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("loja-veiculos");
		EntityManager em = emf.createEntityManager();

		///*
		em.getTransaction().begin(); // h� a necessidade de se fazer uma transa��o ao inserir algo no bd		
		
		///*
		// parte i - Chaves compostas
		Veiculo veiculo = new Veiculo();
		veiculo.setCodigo(new VeiculoId("ABC-1234", "Uberl�ndia"));
		veiculo.setFabricante("Honda");
		veiculo.setModelo("Civic");
		veiculo.setAnoFabricacao(2020);
		veiculo.setAnoModelo(2020);
		veiculo.setValor(new BigDecimal(71_300));		
		em.persist(veiculo);
		//*/
		
		/*
		// parte ii - Usando Enum
		Veiculo veiculo = new Veiculo();
		veiculo.setFabricante("Ford");
		veiculo.setModelo("Focus");
		veiculo.setAnoFabricacao(2019);
		veiculo.setAnoModelo(2020);
		veiculo.setValor(new BigDecimal(41_500));
		veiculo.setTipoCombustivel(TipoCombustivel.BICOMBUSTIVEL);
		em.persist(veiculo);
		*/
		
		/*
		// parte iii - Usado data e CLOB
		StringBuilder especificacoes = new StringBuilder();
		especificacoes.append("Carro em excelente estado.\n");
		especificacoes.append("Completo, menos ar.\n");
		especificacoes.append("Primeiro dono, com manual de instru��o ");
		especificacoes.append("e todas as revis�es feitas.\n");
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
		Proprietario proprietario = new Proprietario();
		proprietario.setNome("Jo�o das Couves");
		proprietario.setTelefone("(34) 1234-5678");
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
		// parte v - 
		Proprietario proprietario = new Proprietario();
		proprietario.setNome("Jo�o das Couves");
		proprietario.setTelefone("(34) 1234-5678");
		
		// Basta incluir essa linha abaixo para persistir o propriet�rio.
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
			
		em.getTransaction().commit();
		//*/
				
		/*
		// parte iii - Usado data e CLOB (continua��o)
		//em.detach(veiculo);
		Veiculo veiculo2 = em.find(Veiculo.class, veiculo.getCodigo());
		System.out.println("Ve�culo: " + veiculo2.getModelo());
		System.out.println("-------");
		System.out.println(veiculo2.getEspecificacoes());
		*/		

		System.out.println("pronto!");
		em.close(); // fechando...
		emf.close();

	}

}
