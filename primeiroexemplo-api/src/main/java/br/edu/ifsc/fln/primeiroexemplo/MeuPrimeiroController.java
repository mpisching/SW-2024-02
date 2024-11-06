package br.edu.ifsc.fln.primeiroexemplo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MeuPrimeiroController {
    
	@GetMapping("/mensagem")
	@ResponseBody
	public String mensagem() {
		return "Bem-vindo ao mundo Spring... alunos do CTDS... IFSC";
	}
}
