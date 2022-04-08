package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {

		Pessoa p1 = new Pessoa(null, "Elias", "e@e");
		Pessoa p2 = new Pessoa(null, "Vivi", "v@v");
		Pessoa p3 = new Pessoa(null, "Nilo", "n@n");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.getTransaction().commit();
		
		System.out.println("pronto!");

		/*System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);*/

	}

}
