package br.com.danese;

import java.util.HashMap;
import java.util.Map;

public class BancoDeDados implements ArmazenadorDeDividas {

	private final Map<Documento, Divida> dividasNoBanco = new HashMap<Documento, Divida>();

	public BancoDeDados(String endereco, String usuario, String senha) {
		System.out.println("Conectado...");
	}
	
	@Override
	public void salva(Divida divida) {
		dividasNoBanco.put(divida.getDocumentoCredor(), divida);
	}

	@Override
	public Divida carrega(Documento documentoCredor) {
		return dividasNoBanco.get(documentoCredor);
	}
	
	public void desconecta() {
		System.out.println("Desconectado");
	}
}
