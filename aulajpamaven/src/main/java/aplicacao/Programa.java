package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;
import dominio.PessoaId;

public class Programa {

	public static void main(String[] args) {

		///*
		// parte I
		Pessoa p1 = new Pessoa(new PessoaId("AAA-1111", "Uberlândia"), "Elias", "e@e"); // trocar para nulo ao inserir
		//Pessoa p2 = new Pessoa(null, "Lis", "l@l");
		//Pessoa p3 = new Pessoa(null, "Nilo", "n@n");
		//*/
		
		
		//p1.setNome("Elias");
		//p1.setEmail("e@e");
		//p1.setId(new PessoaId("AAA-1111", "Uberlândia"));
		

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		///*
		// parte I
		em.getTransaction().begin(); // há a necessidade de se fazer uma transação ao inserir algo no bd
		em.persist(p1);
		//em.persist(p2);
		//em.persist(p3);
		em.getTransaction().commit();
		//*/
		
		/*
		// parte II
		Pessoa p = em.find(Pessoa.class, 2);
		System.out.println(p);
		*/
		
		/*
		// parte III
		//Pessoa p = new Pessoa(2, null, null); // não consegue remover pq a entidade não está monitorada!
		Pessoa p = em.find(Pessoa.class, 2); // não excluiu ainda: falta uma transação...		
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();	
		*/
		
		/*		
		// parte IV (não funcionou)
		Query query = em.createQuery("select v from pessoa v");
		List<Pessoa> pessoas = query.getResultList();
		
		for (Pessoa pessoa : pessoas) {
			System.out.println(pessoa.getId() + " - "
			+ pessoa.getEmail() + " "
			+ pessoa.getNome());
		}
		*/

		System.out.println("pronto!");
		em.close(); // fechando...
		emf.close();

		/*
		System.out.println(p1); 
		System.out.println(p2); 
		System.out.println(p3);
		*/

	}

}
