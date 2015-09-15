package br.com.danese.chainofresponsibility.conta;

public class RespostaEmXml implements Resposta {

	private Resposta outraResposta;
	
	public RespostaEmXml() {}

	public RespostaEmXml(Resposta outraResposta) {
		this.outraResposta = outraResposta;
	}

	public void responde(Requisicao req, Conta conta) {
		if (req.getFormato() == Formato.XML) {
			System.out.println("<conta><titular>" + conta.getTitular() + "</titular><saldo>" + conta.getSaldo()
					+ "</saldo></conta>");
		} else {
			outraResposta.responde(req, conta);
		}
	}

	/*@Override
	public void setProxima(Resposta resposta) {
		this.outraResposta = resposta;
	}*/
}