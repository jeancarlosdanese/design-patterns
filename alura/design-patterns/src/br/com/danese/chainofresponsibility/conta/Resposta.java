package br.com.danese.chainofresponsibility.conta;

public interface Resposta {
	
	void responde(Requisicao req, Conta conta);
//	void setProxima(Resposta resposta);

}