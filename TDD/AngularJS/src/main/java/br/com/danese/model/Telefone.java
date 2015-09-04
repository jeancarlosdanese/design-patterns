package br.com.danese.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.danese.model.dominio.DominioTipoTelefone;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Telefone implements BaseModel<Long> {

	private static final long serialVersionUID = 4358608421117674997L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_pessoa")
	@NotNull
	private Pessoa pessoa;

	@Enumerated(EnumType.STRING)
	@Column(length = 15)
	private DominioTipoTelefone tipo;

	@NotNull
	@Size(max = 11)
	private String numero;

	@Size(max = 5)
	private String ramal;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public DominioTipoTelefone getTipo() {
		return tipo;
	}

	public void setTipo(DominioTipoTelefone tipo) {
		this.tipo = tipo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero.isEmpty() ? null : numero;
	}

	public String getRamal() {
		return ramal;
	}

	public void setRamal(String ramal) {
		this.ramal = ramal.isEmpty() ? null : ramal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telefone other = (Telefone) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return tipo.getDescricao() + ": " + numero;
	}

}
