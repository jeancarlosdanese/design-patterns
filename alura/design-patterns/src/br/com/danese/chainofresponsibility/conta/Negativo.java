package br.com.danese.chainofresponsibility.conta;

class Negativo implements EstadoDaConta {

	@Override
	public void saca(Conta conta, double valor) {
		throw new RuntimeException("Sua conta está no vermelho. Não é possível sacar!");
	}

	@Override
	public void deposita(Conta conta, double valor) {
		conta.saldo += valor * 0.95;
		if (conta.saldo > 0)
			conta.estado = new Positivo();
	}

}