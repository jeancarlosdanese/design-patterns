package br.com.danese;

public interface ArmazenadorDeDividas {

	public void salva(Divida divida);

	public Divida carrega(Documento documentoCredor);
	
}
