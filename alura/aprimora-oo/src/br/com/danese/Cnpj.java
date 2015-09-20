package br.com.danese;

public class Cnpj implements Documento {

	private String valor;

	public Cnpj(String valor) {
		super();
		this.valor = valor;
	}

	/* (non-Javadoc)
	 * @see br.com.danese.Domento#getValor()
	 */
	@Override
	public String getValor() {
		return this.valor;
	}

	/* (non-Javadoc)
	 * @see br.com.danese.Domento#isValido()
	 */
	@Override
	public boolean isValido() {
		return primeiroDigitoVerificador() == primeiroDigitoCorreto()
				&& segundoDigitoVerificador() == segundoDigitoCorreto();
	}

	private int segundoDigitoCorreto() {
		// Calcula o segundo dígito verificador correto para
		// o CNPJ armazenado no atributo valor
		return 0;
	}

	private int segundoDigitoVerificador() {
		// Extrai o segundo dígito verificador do CNPJ armazenado
		// no atributo valor
		return 0;
	}

	private int primeiroDigitoCorreto() {
		// Calcula o primeiro dígito verificador correto para
		// o CNPJ armazenado no atributo valor
		return 0;
	}

	private int primeiroDigitoVerificador() {
		// Extrai o primeiro dígito verificador do CNPJ armazenado
		// no atributo valor
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cnpj other = (Cnpj) obj;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return this.valor;
	}
}
