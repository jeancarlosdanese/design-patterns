package br.com.danese.maladiretacliente.csv;

import br.com.danese.maladiretalib.MalaDireta;
import br.com.danese.maladiretalib.contato.Contatos;

public class MalaDiretaCSV extends MalaDireta {
	
	private String nomeArquivo;

	public MalaDiretaCSV(String nomeArquivo) {
		super();
		this.nomeArquivo = nomeArquivo;
	}

	@Override
	protected Contatos criarContatos() {
		return new ContatosCSV(nomeArquivo);
	}
	
}
