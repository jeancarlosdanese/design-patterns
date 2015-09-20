package br.com.danese.state;

interface EstadoDeUmOrcamento {
	
	void aplicaDescontoExtra(Orcamento orcamento);

	void aprova(Orcamento orcamento);

	void reprova(Orcamento orcamento);

	void finaliza(Orcamento orcamento);
}