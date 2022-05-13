package aplicacao;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import javax.imageio.ImageIO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import dominio.TipoCombustivel;
import dominio.Veiculo;

public class ExibindoImagem {

	public static void main(String[] args) throws IOException {

		// Lê bytes do arquivo da imagem
		Path path = FileSystems.getDefault().getPath("arquivos-extras/ix35.jpg");
		byte[] foto = Files.readAllBytes(path);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("loja-veiculos");
		EntityManager em = emf.createEntityManager();

		///*
		em.getTransaction().begin(); // há a necessidade de se fazer uma transação ao inserir algo no bd

		Veiculo veiculo = new Veiculo();
		veiculo.setFabricante("Hyundai");
		veiculo.setModelo("ix35");
		veiculo.setAnoFabricacao(2019);
		veiculo.setAnoModelo(2020);
		veiculo.setValor(new BigDecimal(100_000));
		veiculo.setTipoCombustivel(TipoCombustivel.BICOMBUSTIVEL);
		veiculo.setDataCadastro(LocalDate.now());
		veiculo.setFoto(foto);
		
		em.persist(veiculo);

		em.getTransaction().commit();
		//*/

		em.detach(veiculo);
		Veiculo veiculo2 = em.find(Veiculo.class, veiculo.getCodigo());
		if (veiculo2.getFoto() != null) {
			BufferedImage img = ImageIO.read(new ByteArrayInputStream(veiculo2.getFoto()));
			JOptionPane.showMessageDialog(null, new JLabel(new ImageIcon(img)));
		} else {
			System.out.println("Veículo não possui foto.");
		}

		System.out.println("pronto!");
		em.close(); // fechando...
		emf.close();
	}

}
