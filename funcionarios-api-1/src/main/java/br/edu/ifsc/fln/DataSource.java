package br.edu.ifsc.fln;

import java.util.ArrayList;
import java.util.List;

public class DataSource {
	private static List<Funcionario> funcionarios = new ArrayList<>();
	
	/*  Inicializar Funcionarios, para
	 * serem acessados por meio de endpoints do controlador
	 * FuncionarioController, sem a necessidade de um POST */	
	static {
		funcionarios.add(new Funcionario(1235, "José", 3000.00, 2));
		funcionarios.add(new Funcionario(6789, "Cairo", 2500.00, 3));
		funcionarios.add(new Funcionario(3214, "Kenai", 5000.00, 0));
		funcionarios.add(new Funcionario(54321, "Odé", 1800.00, 1));
	}
	

	public static void addFuncionario(Funcionario funcionario) {			
			funcionarios.add(funcionario);
	}
	
	public static Funcionario buscarMatricula(int matricula) {
		for (Funcionario funcionario : funcionarios) {
			if (funcionario.getMatricula() == matricula) {
				return funcionario;
			}
		}
		
		return null;
	}
	
	public static List<Funcionario> getFuncionario(){
		return funcionarios;
	}
	
}
