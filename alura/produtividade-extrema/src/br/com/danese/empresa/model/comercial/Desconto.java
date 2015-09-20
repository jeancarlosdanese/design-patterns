package br.com.danese.empresa.model.comercial;

public class Desconto {
	private String motivo;
	private double porcentagem;
	
	public Desconto(String motivo, double porcentagem) {
		this.motivo = motivo;
		this.porcentagem = porcentagem;
	}
	
	public String getMotivo() {
		return motivo;
	}
	
	public double getPorcentagem() {
		return porcentagem;
	}
}
