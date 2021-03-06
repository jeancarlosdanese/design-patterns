package br.com.danese.maladiretacliente.xml;

import br.com.danese.maladiretalib.MalaDireta;
import br.com.danese.maladiretalib.contato.Contatos;

public class MalaDiretaXML extends MalaDireta {

	private String nomeArquivo;

	public MalaDiretaXML(String nomeArquivo) {
	    this.nomeArquivo = nomeArquivo;
    }

	@Override
    protected Contatos criarContatos() {
	    return new ContatosXML(nomeArquivo);
    }

}
