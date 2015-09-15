package br.com.danese.chainofresponsibility.conta;

public class RespostaEmCsv implements Resposta {

	private Resposta outraResposta;

	public RespostaEmCsv(Resposta outraResposta) {
		this.outraResposta = outraResposta;
	}

	public void responde(Requisicao req, Conta conta) {
		if (req.getFormato() == Formato.CSV) {
			System.out.println(conta.getTitular() + ";" + conta.getSaldo());
		} else {
			outraResposta.responde(req, conta);
		}
	}

	/*@Override
	public void setProxima(Resposta resposta) {
		this.outraResposta = resposta;
	}*/
}