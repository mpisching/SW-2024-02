package br.edu.ifsc.fln;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.ifsc.fln.model.datasource.ProdutoDataSource;

@SpringBootApplication
public class PrjProdutoApiApplication {

	public static void main(String[] args) {
		ProdutoDataSource.criarLista();
		SpringApplication.run(PrjProdutoApiApplication.class, args);
	}

}
