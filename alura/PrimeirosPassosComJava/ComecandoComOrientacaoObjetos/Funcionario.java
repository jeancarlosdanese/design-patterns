class Funcionario {
	String nome;
	String departamento;
	Data dataDeEntrada;
	double salario;

	void recebeAumento(double valorASerAumentado) { 
		this.salario += valorASerAumentado;
	}

	double calculaGanhoAnual() {
		return this.salario * 12;
	}

	void mostra() {
		System.out.println("Nome: " + this.nome);
		System.out.println("Departamento: " + this.departamento);
		System.out.println("Data de Entrada: " + this.dataDeEntrada.getFormatada());
		System.out.println("Salário Atual: " + this.salario);
		System.out.println("Ganho Anual: " + this.calculaGanhoAnual());
	}
}

class TestaFuncionario {

    public static void main(String[] args) {
        Funcionario f1 = new Funcionario();

        f1.nome = "Hugo";
        f1.departamento = "TI";
        f1.dataDeEntrada = new Data();
        f1.dataDeEntrada.preencheData(23, 04, 1998);
        f1.salario = 100;
        f1.recebeAumento(50);

        /*System.out.println("salario atual:" + f1.salario);
        System.out.println("ganho anual:" + f1.calculaGanhoAnual());*/
        f1.mostra();

        Funcionario f2 = new Funcionario();        
        f2.nome = "Danilo";
        f2.dataDeEntrada = new Data();
        f2.dataDeEntrada.preencheData(24, 06, 1999);
        f2.salario = 100;

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