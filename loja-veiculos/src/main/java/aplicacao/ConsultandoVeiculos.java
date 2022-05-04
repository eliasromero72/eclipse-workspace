package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Proprietario;
import dominio.Veiculo;

public class ConsultandoVeiculos {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("loja-veiculos");
		EntityManager em = emf.createEntityManager();

		// em.getTransaction().begin(); // há a necessidade de se fazer uma transação ao inserir algo no bd
		

		// Quando consultamos veículos, o provedor JPA executa uma consulta do proprietário para cada veículo encontrado:
		/*
		List<Veiculo> veiculos = em.createQuery("select v from Veiculo v", Veiculo.class).getResultList();
		for (Veiculo veiculo : veiculos) {
			System.out.println(veiculo.getModelo() + " - " + veiculo.getProprietario().getNome());
		}
		*/
		
		// Se consultarmos um veículo pelo identificador, a query inclui um left join ou inner join com a tabela de proprietários, dependendo do que foi definido noatributo optional do mapeamento @OneToOne.
		//Veiculo veiculo = em.find(Veiculo.class, 1L);
		//System.out.println(veiculo.getModelo() + " - " + veiculo.getProprietario().getNome());
		
		// Agora podemos consultar um proprietário e obter o veículo dele.
		Proprietario proprietario = em.find(Proprietario.class, 2L);
		System.out.println(proprietario.getVeiculo().getModelo() + " - " + proprietario.getNome());
		
		
		// em.getTransaction().commit();

		System.out.println("pronto!");
		em.close(); // fechando...
		emf.close();

	}

}
