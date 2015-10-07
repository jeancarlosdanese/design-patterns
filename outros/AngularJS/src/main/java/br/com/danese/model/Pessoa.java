package br.com.danese.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;
import org.hibernate.bytecode.internal.javassist.FieldHandled;
import org.hibernate.bytecode.internal.javassist.FieldHandler;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.hibernate.validator.constraints.NotBlank;

import br.com.danese.model.dominio.DominioEstadoCivil;
import br.com.danese.model.dominio.DominioSexo;
import br.com.danese.model.dominio.DominioTipoPessoa;
import br.com.danese.validator.CpfCnpj;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("deprecation")
@Audited
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "cpfcnpj", name = "cpfcnpj_ukey"))
@XmlRootElement
public class Pessoa implements BaseModel<Long>, FieldHandled {

	private static final long serialVersionUID = 2038138058466087609L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private FieldHandler handler;

	@NotBlank
	@Size(min = 3, max = 100)
	@Pattern(regexp = "[^0-9]*", message = "não deve conter números")
	private String nome;

	@Enumerated(EnumType.STRING)
	@Column(length = 8)
	private DominioTipoPessoa tipoPessoa;

	@Enumerated(EnumType.STRING)
	@Column(length = 9)
	private DominioSexo sexo;

	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private DominioEstadoCivil estadoCivil;

	@Temporal(TemporalType.DATE)
	private Date dataNascimento;

	@CpfCnpj
	private String cpfCnpj;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@PrimaryKeyJoinColumn
	@LazyToOne(LazyToOneOption.NO_PROXY)
	private Usuario usuario;

	@NotAudited
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pessoa", orphanRemoval = true)
	@ForeignKey(name = "pessoa_fkey")
	private List<EnderecoEmail> emails;

	@NotAudited
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pessoa", orphanRemoval = true)
	@ForeignKey(name = "pessoa_fkey")
	private List<Endereco> enderecos;

	@NotAudited
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pessoa", orphanRemoval = true)
	@ForeignKey(name = "pessoa_fkey")
	private List<Telefone> telefones;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome.isEmpty() ? null : nome;
	}

	public DominioSexo getSexo() {
		return sexo;
	}

	public void setSexo(DominioSexo sexo) {
		this.sexo = sexo;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public DominioTipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(DominioTipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj.isEmpty() ? null : cpfCnpj;
	}

	public Usuario getUsuario() {
		if (handler != null) {
			return (Usuario) handler.readObject(this, "usuario", usuario);
		}
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		if (handler != null) {
			this.usuario = (Usuario) handler.writeObject(this, "usuario",
					this.usuario, usuario);
		}
		this.usuario = usuario;
	}

	public List<EnderecoEmail> getEmails() {
		return emails;
	}

	public void setEmails(List<EnderecoEmail> emails) {
		this.emails = emails;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	@Override
	public void setFieldHandler(FieldHandler handler) {
		this.handler = handler;
	}

	@Override
	public FieldHandler getFieldHandler() {
		return handler;
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
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public boolean isEmpresa() {
		if (this.tipoPessoa != null
				&& this.tipoPessoa.equals(DominioTipoPessoa.JURIDICA)) {
			return true;
		}
		return false;
	}

	public DominioEstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(DominioEstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

}