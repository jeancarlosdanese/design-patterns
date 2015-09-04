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
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.danese.model.dominio.DominioEstado;
import br.com.danese.model.dominio.DominioTipoEndereco;
import br.com.danese.validator.Cep;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Endereco implements BaseModel<Long> {

	private static final long serialVersionUID = 4215652442396270251L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_pessoa")
	@NotNull
	private Pessoa pessoa;

	@Enumerated(EnumType.STRING)
	@Column(length = 11)
	private DominioTipoEndereco tipo;

	@NotEmpty
	@Size(max = 100)
	private String logradouro;

	@Max(value = 99999)
	private Integer numero;

	@Size(max = 100)
	private String complemento;

	@Size(max = 100)
	private String bairro;

	@NotEmpty
	@Size(max = 100)
	private String cidade;

	@Enumerated(EnumType.STRING)
	@Column(length = 2)
	@NotNull
	private DominioEstado estado;

	@Cep
	private String cep;

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

	public DominioTipoEndereco getTipo() {
		return tipo;
	}

	public void setTipo(DominioTipoEndereco tipo) {
		this.tipo = tipo;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro.isEmpty() ? null : logradouro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento.isEmpty() ? null : complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro.isEmpty() ? null : bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade.isEmpty() ? null : cidade;
	}

	public DominioEstado getEstado() {
		return estado;
	}

	public void setEstado(DominioEstado estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep.isEmpty() ? null : cep;
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
		Endereco other = (Endereco) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return tipo.getDescricao() + ": " + logradouro + ", " + numero;
	}

}
