package javaesuasbibliotecas.collections.banco;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javaesuasbibliotecas.collections.banco.conta.Conta;

public class Banco {
	private List<Conta> contas = new ArrayList<Conta>();
	private Map<String, Conta> contasIndexadoPorNome = new HashMap<String, Conta>();
	
	public void adiciona(Conta conta) {
		this.contas.add(conta);
		contasIndexadoPorNome.put(conta.getNome(), conta);
	}
	
	public Conta pega(int posicao) {
		return contas.get(posicao);
	}
	
	public int getQuantidadeDeContas() {
		return contas.size();
	}
	
	public Conta getContasPorNome(String nome) {
		return contasIndexadoPorNome.get(nome);
	}
}
