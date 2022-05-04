package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Veiculo;
import dominio.VeiculoId;

public class BuscandoVeiculoPelaPlaca {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("loja-veiculos");
		EntityManager em = emf.createEntityManager();

		//em.getTransaction().begin(); // h� a necessidade de se fazer uma transa��o ao inserir algo no bd

		VeiculoId codigo = new VeiculoId("ABC-1234", "Uberl�ndia");
		Veiculo veiculo = em.find(Veiculo.class, codigo);
		System.out.println("Placa: " + veiculo.getCodigo().getPlaca());
		System.out.println("Cidade: " + veiculo.getCodigo().getCidade());
		System.out.println("Fabricante: " + veiculo.getFabricante());
		System.out.println("Modelo: " + veiculo.getModelo());

		//em.getTransaction().commit();

		System.out.println("pronto!");
		em.close(); // fechando...
		emf.close();

	}

}
