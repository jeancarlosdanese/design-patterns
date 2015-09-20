package br.com.danese;

public class Cpf implements Documento {

	private String valor;

	public Cpf(String valor) {
		this.valor = valor;
	}
	
	@Override
	public String getValor() {
		return this.valor;
	}

	@Override
	public boolean isValido() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public String toString() {
		return valor;
	}

}
