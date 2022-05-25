package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Acessorio;
import dominio.Veiculo;

public class ConsultandoAcessorios {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("loja-veiculos");
		EntityManager em = emf.createEntityManager();

		//em.getTransaction().begin(); // há a necessidade de se fazer uma transação ao inserir algo no bd
		
		Veiculo veiculo = em.find(Veiculo.class, 1L);
		System.out.println("Veículo: " + veiculo.getModelo());
		
		for (Acessorio acessorio : veiculo.getAcessorios()) {
		System.out.println("Acessório: " + acessorio.getDescricao());
		}
		
		//em.getTransaction().commit();

		System.out.println("pronto!");
		em.close(); // fechando...
		emf.close();

	}

}
