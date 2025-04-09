package br.edu.ifsc.fln;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculadoraController {

	@RequestMapping(value = "/soma/{valor1}/{valor2}",
					method = RequestMethod.GET)
	public int somar(@PathVariable int valor1, @PathVariable int valor2) {
		//int soma = valor1 + valor2;
		//return soma;
		return Calculadora.somar(valor1, valor2);
	}
	
	@RequestMapping(value = "/subtrai/{valor1}/{valor2}",
			method = RequestMethod.GET)
	public int subtrair(@PathVariable int valor1, @PathVariable int valor2) {
		return Calculadora.subtrair(valor1, valor2);
	}	
	
	@RequestMapping(value = "/multiplica/{valor1}/{valor2}",
			method = RequestMethod.GET)
	public int multiplicar(@PathVariable int valor1, @PathVariable int valor2) {
		return Calculadora.multiplicar(valor1, valor2);
	}	
	
}
