package br.edu.ifsc.fln;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculadoraController {

	//localhost:port/soma?valor1=10&valor2=20
	@RequestMapping("/soma")
	public int somar(
			@RequestParam(value = "valor1", defaultValue = "0") int valor1, 
			@RequestParam(value = "valor2", defaultValue = "0") int valor2) {
		//int soma = valor1 + valor2;
		//return soma;
		return Calculadora.somar(valor1, valor2);
	}
}
