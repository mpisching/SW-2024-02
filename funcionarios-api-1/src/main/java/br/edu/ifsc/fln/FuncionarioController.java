package br.edu.ifsc.fln;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/funcionarios") /* Requisição para chamar o métodp que irá listar funcionarios armazenados no DataSource*/
public class FuncionarioController {
	
	public void Funcionario(@RequestBody Funcionario funcionario) {
		DataSource.addFuncionario(funcionario);
	}
	
	
	@GetMapping
	public List<Funcionario> listarFuncionarios(){
		return DataSource.getFuncionario();
	}

	@GetMapping("/{matricula}") /*Buscar funcionário por matrícula*/
	public Funcionario buscarMatricula(@PathVariable int matricula) {
		for (Funcionario funcionario : DataSource.getFuncionario()) {
			if (funcionario.getMatricula() == matricula) {
				return funcionario;
			}
		}
		
		return null;
	}
	
	@GetMapping("/{matricula}/salario-liquido") /*Calcular salário líquido */
	public double calcularSalarioLiquido(@PathVariable int matricula) {
		Funcionario funcionario = buscarMatricula(matricula);
		if (funcionario != null) {
			return funcionario.calcularSalarioLiquido(funcionario.getSlbase());
		}
		return 0.0;
	}
	
	@PostMapping("/criar/{matricula}/{nome}/{slbase}/{numDepend}")
	public Funcionario criarFuncionario(
			
			@PathVariable int matricula,
			@PathVariable String nome,
			@PathVariable double slbase,
			@PathVariable int numDepend){
			Funcionario funcionario = new Funcionario(matricula, nome,slbase,numDepend);
			
			DataSource.addFuncionario(funcionario);
			
			return funcionario;
    }
}
