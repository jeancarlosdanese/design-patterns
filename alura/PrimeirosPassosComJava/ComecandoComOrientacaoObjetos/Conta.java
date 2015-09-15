class Conta {
	int numero;
	/*String titular;
	String cpf;
	String dataNascimento;*/
	Pessoa pessoa;

	double saldo;
	int agencia;

	void deposita(double valorASerDepositado) {
		this.saldo += valorASerDepositado - 0.1;
	}

	void saca(double valorASerSacado) {
		if(this.saldo >= valorASerSacado) {
			this.saldo -= valorASerSacado;
		}
	}

	void transfere(double valorASerTransferido, Conta destino) {
		if(this.saldo >= valorASerTransferido) {
			this.saldo -= valorASerTransferido;
			destino.saldo += valorASerTransferido;
		}
	}

}

class Programa {
	public static void main(String[] args) {
		Conta bernardo = new Conta();
		bernardo.numero = 123;
		bernardo.saldo = 1300.0;
		bernardo.agencia = 3325;
		// bernardo.titular = "Bernardo Danese";
		Pessoa pessoaBernardo = new Pessoa();
		pessoaBernardo.nome = "Bernardo Danese";
		pessoaBernardo.cpf = "1231321311";
		pessoaBernardo.dataNascimento = "30/08/2006";
		bernardo.pessoa = pessoaBernardo;

		Conta jean = new Conta();
		jean.numero = 333;
		jean.agencia = 3325;
		jean.saldo = 1400;
		// jean.titular = "Jean Carlos Danese";
		Pessoa pessoaJean = new Pessoa();
		pessoaJean.nome = "Jean Carlos Danese";
		pessoaJean.cpf = "1231322121";
		pessoaJean.dataNascimento = "27/01/1974";
		jean.pessoa = pessoaJean;

		bernardo.deposita(100.0);

		jean.saca(3000.0);
		jean.saca(200);

		bernardo.transfere(500, jean);

		// System.out.println(bernardo.titular + " = " + bernardo.saldo);
		// System.out.println(jean.titular + " = " + jean.saldo);
		System.out.println(bernardo.pessoa.nome + " = " + bernardo.saldo);
		System.out.println(jean.pessoa.nome + " = " + jean.saldo);
	}
}

class Pessoa {
	String nome;
	String cpf;
	String dataNascimento;
}