package br.com.danese.state;

class EmAprovacao implements EstadoDeUmOrcamento {
	@Override
	public void aplicaDescontoExtra(Orcamento orcamento) {
		orcamento.valor -= orcamento.valor * 0.05;
	}

	@Override
	public void aprova(Orcamento orcamento) {
		// desse estado posso ir para o estado de aprovado
		orcamento.estadoAtual = new Aprovado();
	}

	@Override
	public void reprova(Orcamento orcamento) {
		// desse estado posso ir para o estado de reprovado tambem
		orcamento.estadoAtual = new Reprovado();
	}

	@Override
	public void finaliza(Orcamento orcamento) {
		// daqui não posso ir direto para finalizado
		throw new RuntimeException("Orcamento em aprovação não podem ir para finalizado diretamente");
	}
}
