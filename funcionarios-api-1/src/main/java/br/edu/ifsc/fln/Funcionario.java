package br.edu.ifsc.fln;


public class Funcionario {
	
	private int matricula;
	private String nome;
	private double slbase;
	private int numDepend;

	public  Funcionario(int matricula, String nome, double slbase, int numDepend) {
		this.matricula = matricula;
		this.nome = nome;
		this.slbase = slbase;
		this.numDepend = numDepend;
	}
	

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSlbase() {
		return slbase;
	}

	public void setSlbase(double slbase) {
		this.slbase = slbase;
	}

	public int getNumDepend() {
		return numDepend;
	}

	public void setNumDepend(int numDepend) {
		this.numDepend = numDepend;
	}
	
	 public double calcularSalarioLiquido(double slbruto) {	       
	        double inss = calcularInss(slbruto);
	        double irpf = calcularIrpf(slbruto - inss);
	        return arredondar(slbruto - irpf - inss);
	    }

	   	        
	    /* Valores  de INSS e IRPF Brasil - 2024  */
	    
	    
	    private double calcularInss(double slbruto) {
	    	double inss = 0.0;
	    	
	        if (slbruto <= 1320.00) {
	            inss = slbruto * 0.075; 
	        } else if (slbruto <= 2571.29) {
	            inss = 1320.00 * 0.075 + (slbruto - 1320.00) * 0.09; 
	        } else if (slbruto <= 3856.94) {
	            inss = 1320.00 * 0.075 + (2571.29 - 1320.00) * 0.09 + (slbruto - 2571.29) * 0.12; 
	        } else if (slbruto <= 6101.06) {
	            inss = 1320.00 * 0.075 + (2571.29 - 1320.00) * 0.09 + (3856.94 - 2571.29) * 0.12 + (slbruto - 3856.94) * 0.14; 
	        } else {
	            inss = 1320.00 * 0.075 + (2571.29 - 1320.00) * 0.09 + (3856.94 - 2571.29) * 0.12 + (6101.06 - 3856.94) * 0.14; 
	        }
	        return arredondar(inss);
	    }
	    

	    private double calcularIrpf(double slbruto) {
	    	double irpf = 0.0;
	    	
	        if (slbruto <= 2112.00) return 0.0;
	        if (slbruto <= 2826.65) irpf = (slbruto * 0.075) - 158.40;
	        else if (slbruto <= 3751.05) irpf = (slbruto * 0.15) - 370.40;
	        else if (slbruto <= 4664.68) irpf =  (slbruto * 0.225) - 651.73;
	        else irpf = (slbruto * 0.275) - 884.96;
	        
	        return arredondar(irpf);
	    }	   
	    
	    private double arredondar(double valor) {
	    	return Math.round(valor * 100.0) / 100.0;
	    }
	
}
