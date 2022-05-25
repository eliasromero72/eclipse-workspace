package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Proprietario;
import dominio.Veiculo;

public class BuscandoProprietario {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("loja-veiculos");
		EntityManager em = emf.createEntityManager();

		//em.getTransaction().begin(); // há a necessidade de se fazer uma transação ao inserir algo no bd

		Proprietario proprietario = em.find(Proprietario.class, 1L);
		
		System.out.println("Proprietário: " + proprietario.getNome());
		
		for (Veiculo veiculo : proprietario.getVeiculos()) {
		System.out.println("Veículo: " + veiculo.getModelo());
		}

		//em.getTransaction().commit();

		System.out.println("pronto!");
		em.close(); // fechando...
		emf.close();

	}

}
