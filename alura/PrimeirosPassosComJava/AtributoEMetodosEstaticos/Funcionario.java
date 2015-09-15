class Funcionario {

    private static int proximoFuncionario = 1;

    private int identificador;
	private String nome;
	private String departamento;
	private Data dataDeEntrada;
	private double salario;

	public Funcionario() {
        this.identificador = proximoFuncionario++;
    }

	public Funcionario(String nome) {
        this.identificador = proximoFuncionario++;
 		this.nome = nome;
	}

    public int getIdentificador() {
        return this.identificador;
    }

	void setAumento(double valorASerAumentado) { 
		this.salario += valorASerAumentado;
	}

	public double getGanhoAnual() {
		return this.salario * 12;
	}

	public void mostra() {
        System.out.println("Identificador: " + this.identificador);
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

	public Data() {}

	public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        if (!isDataViavel(dia, mes, ano)) {
            System.out.println("A data " + getFormatada() + " não existe!");
        }
    }
    
    private boolean isDataViavel(int dia, int mes, int ano) {
        if (dia <= 0 || mes <= 0) {
            return false;
        }
        int ultimoDiaDoMes = 31; // por padrao são 31 dias
        if (mes == 4 || mes == 6 || mes == 9 || mes == 11 ) {
            ultimoDiaDoMes = 30;
        } else if (mes == 2) {
            if (ano % 4 == 0) {
                ultimoDiaDoMes = 29;
            } else {
                ultimoDiaDoMes = 28;
            }
        }
        if (dia > ultimoDiaDoMes) {
            return false;
        }
        return true;
    }

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
	//int livre = 0;

	public Empresa() {
		this.empregados = new Funcionario[10];
	}

    /*void adiciona(Funcionario f) {
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

        f2.mostra();

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
