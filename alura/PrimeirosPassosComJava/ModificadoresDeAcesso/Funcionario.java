class Funcionario {
	private String nome;
	private String departamento;
	private Data dataDeEntrada;
	private double salario;

	void setAumento(double valorASerAumentado) { 
		this.salario += valorASerAumentado;
	}

	public double getGanhoAnual() {
		return this.salario * 12;
	}

	public void mostra() {
		System.out.println("Nome: " + this.getNome());
		System.out.println("Departamento: " + this.getDepartamento());
		System.out.println("Data de Entrada: " + this.getDataDeEntrada());
		System.out.println("Salário Atual: " + this.getSalario());
		System.out.println("Ganho Anual: " + this.getGanhoAnual());
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public double getSalario() {
		return salario;
	}

	public String getDataDeEntrada() {
		return this.dataDeEntrada.getFormatada();
	}

	public void setDataDeEntrada(int dia, int mes, int ano) {
		this.dataDeEntrada = new Data();
		this.dataDeEntrada.preencheData(dia, mes, ano);
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

}

class Data {
	int dia;
	int mes;
	int ano;

	void preencheData (int dia, int mes, int ano) {
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}

	String getFormatada() {
		return this.dia+"/"+this.mes+"/"+this.ano;
	}
}

class Empresa {
	private String nome;
	private String cnpj;
	private Funcionario[] empregados;
	/*int livre = 0;

    void adiciona(Funcionario f) {
        this.empregados[this.livre] = f;
        this.livre++;
    }*/

    public void mostra() {
    	for (int i = 0; i < empregados.length; i++) {
    		Funcionario f = this.empregados[i];
    		if(f == null) continue;
    		System.out.println("Funcionário na posição: " + f.getSalario());
    	}

    }

    public void mostraTodasInformacoes() {
    	for (int i = 0; i < empregados.length; i++) {
    		Funcionario f = this.empregados[i];
    		if(f == null) continue;
    		System.out.println("Funcionário na posição: " + i);
    		f.mostra();
    	}

    }

	public void adiciona(Funcionario f) {
		for (int i = 0; i < empregados.length; i++) {
			if(this.empregados[i] == null) {
				this.empregados[i] = f;
				break;
			}
		}
    }

    public String getNome() {
    	return nome;
    }

    public void setNome(String nome) {
    	this.nome = nome;
    }

    public String getCnpj() {
    	return cnpj;
    }

    public void setCnpj() {
    	this.cnpj = cnpj;
    }

    public void setEmpregados(Funcionario[] empregados) {
    	this.empregados = empregados;
    }

}

class TestaFuncionario {

    public static void main(String[] args) {
        Funcionario f1 = new Funcionario();

        f1.setNome("Hugo");
        f1.setDepartamento("TI");
        f1.setDataDeEntrada(23, 04, 1998);
        f1.setSalario(100);
        f1.setAumento(50);

        /*System.out.println("salario atual:" + f1.salario);
        System.out.println("ganho anual:" + f1.calculaGanhoAnual());*/
        f1.mostra();

        Funcionario f2 = new Funcionario();        
        f2.setNome("Danilo");
        f2.setDataDeEntrada(24, 06, 1999);
        f2.setSalario(100);

        /*Funcionario f3 = new Funcionario();        
        f3.nome = "Danilo";
        f3.salario = 100;*/

        Funcionario f3 = f2;

        if (f2 == f3) {
            System.out.println("iguais");
        } else {
            System.out.println("diferentes");        
        }
    }
}

class TestaEmpresa {

	public static void main(String[] args) {
		Empresa empresa = new Empresa();
	    empresa.setEmpregados(new Funcionario[10]);

		for (int i = 0; i < 5; i++) {
	        Funcionario f = new Funcionario();
	        f.setNome("Funcionário " + i);
	        f.setDataDeEntrada(24, 06, 1999);
  	        f.setSalario(1000.0 + i * 100);
	        empresa.adiciona(f);
	    }

	    empresa.mostra();

	    empresa.mostraTodasInformacoes();
	}

}
