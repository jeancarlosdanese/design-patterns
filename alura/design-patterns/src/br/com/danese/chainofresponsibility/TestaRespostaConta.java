package br.com.danese.chainofresponsibility;

import java.time.LocalDate;

import br.com.danese.chainofresponsibility.conta.Conta;
import br.com.danese.chainofresponsibility.conta.Formato;
import br.com.danese.chainofresponsibility.conta.Requisicao;
import br.com.danese.chainofresponsibility.conta.Resposta;
import br.com.danese.chainofresponsibility.conta.RespostaEmCsv;
import br.com.danese.chainofresponsibility.conta.RespostaEmPorcento;
import br.com.danese.chainofresponsibility.conta.RespostaEmXml;

public class TestaRespostaConta {

	public static void main(String[] args) {
		
		Requisicao req = new Requisicao(Formato.PORCENTO);
		Conta conta = new Conta("Mario de Andrade", LocalDate.now(), 500.0);
		
		Resposta resposta = new RespostaEmXml(new RespostaEmCsv(new RespostaEmPorcento()));
		resposta.responde(req, conta);
		
	}

}
