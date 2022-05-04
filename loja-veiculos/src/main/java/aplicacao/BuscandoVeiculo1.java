package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Veiculo;

public class BuscandoVeiculo1 {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("loja-veiculos");
		EntityManager em = emf.createEntityManager();

		//em.getTransaction().begin(); // há a necessidade de se fazer uma transação ao inserir algo no bd

		Veiculo veiculo = em.find(Veiculo.class, 2L);
		System.out.println("Veículo de código " + veiculo.getCodigo()
		+ " é um " + veiculo.getModelo());

		//em.getTransaction().commit();

		System.out.println("pronto!");
		em.close(); // fechando...
		emf.close();
		

	}

}
