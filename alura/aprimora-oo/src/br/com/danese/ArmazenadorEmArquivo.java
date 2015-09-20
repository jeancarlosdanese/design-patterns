package br.com.danese;

public class ArmazenadorEmArquivo implements ArmazenadorDeDividas {

	@Override
	public void salva(Divida divida) {
		System.out.println("Gravando no arquivo");
	}

	@Override
	public Divida carrega(Documento documentoCredor) {
		return null;
	}


}
