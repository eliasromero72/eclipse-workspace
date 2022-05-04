package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.util.List;

import dominio.Veiculo;

public class ListandoVeiculos {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("loja-veiculos");
		EntityManager em = emf.createEntityManager();

		// em.getTransaction().begin(); // há a necessidade de se fazer uma transação ao inserir algo no bd

		Query query = em.createQuery("select v from Veiculo v");
		
		List<Veiculo> veiculos = query.getResultList();
		for (Veiculo veiculo : veiculos) {
			System.out.println(veiculo.getCodigo() + " - " 
					+ veiculo.getFabricante() + " " 
					+ veiculo.getModelo() + ", ano " 
					+ veiculo.getAnoFabricacao() + "/" 
					+ veiculo.getAnoModelo() + " por " 
					+ "R$"+ veiculo.getValor());
		}

		// em.getTransaction().commit();

		System.out.println("pronto!");
		em.close(); // fechando...
		emf.close();

	}

}
