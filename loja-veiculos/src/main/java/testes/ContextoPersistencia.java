package testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Veiculo;

public class ContextoPersistencia {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("loja-veiculos");
		EntityManager em = emf.createEntityManager();

		//em.getTransaction().begin(); // há a necessidade de se fazer uma transação ao inserir algo no bd

		/* parte i
		Veiculo veiculo1 = em.find(Veiculo.class, 2L);
		System.out.println("Buscou veiculo pela primeira vez...");
		Veiculo veiculo2 = em.find(Veiculo.class, 2L);
		System.out.println("Buscou veiculo pela segunda vez...");
		System.out.println("Mesmo veículo? " + (veiculo1 == veiculo2));
		*/
		
		Veiculo veiculo1 = em.find(Veiculo.class, 2L);
		System.out.println("Buscou veiculo pela primeira vez...");
		System.out.println("Gerenciado? " + em.contains(veiculo1));
		em.detach(veiculo1);
		System.out.println("E agora? " + em.contains(veiculo1));
		Veiculo veiculo2 = em.find(Veiculo.class, 2L);
		System.out.println("Buscou veiculo pela segunda vez...");
		System.out.println("Mesmo veículo? " + (veiculo1 == veiculo2));

		//em.getTransaction().commit();

		System.out.println("pronto!");
		em.close(); // fechando...
		emf.close();

	}

}
