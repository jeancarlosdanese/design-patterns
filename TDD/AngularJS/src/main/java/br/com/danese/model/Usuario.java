package br.com.danese.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.NotBlank;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("deprecation")
@Audited
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "login", name = "usuario_ukey"))
@XmlRootElement
public class Usuario implements BaseModel<Long> {

	private static final long serialVersionUID = 4418325096384236436L;

	@Id
	private Long id;

	@OneToOne(fetch = FetchType.LAZY)
	private Pessoa pessoa;

	@NotBlank
	@Size(max = 100)
	private String login;

	@NotNull
	@Size(min = 6, max = 32)
	private String senha;

	@Transient
	private String senhaCheck1;

	@Transient
	private String senhaCheck2;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinTable(name = "usuario_perfil", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_perfil"), uniqueConstraints = @UniqueConstraint(columnNames = {
			"id_usuario", "id_perfil"}, name = "usuario_perfil_ukey"))
	@ForeignKey(name = "usuario_fkey", inverseName = "perfil_fkey")
	private List<Perfil> perfis;

	public Usuario() {
		super();
	}

	public Usuario(Long id, Pessoa pessoa, List<Perfil> perfis) {
		super();
		this.id = id;
		this.pessoa = pessoa;
		this.perfis = perfis;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}

	public String getPerfisAsString() {
		StringBuilder sb = new StringBuilder();
		for (Perfil perfil : this.getPerfis()) {
			sb.append(perfil.getPerfil().getDescricao() + " - ");
		}
		String perfisDesc = sb.toString();
		return perfisDesc.substring(0, perfisDesc.length() - 3);
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSenhaCheck1() {
		return senhaCheck1;
	}

	public void setSenhaCheck1(String senhaCheck1) {
		this.senhaCheck1 = senhaCheck1;
	}

	public String getSenhaCheck2() {
		return senhaCheck2;
	}

	public void setSenhaCheck2(String senhaCheck2) {
		this.senhaCheck2 = senhaCheck2;
	}

	public boolean isNaoEnviavelPorEmail() {
		return this.pessoa == null || this.pessoa.getUsuario() == null
				|| this.pessoa.getUsuario().getLogin() == null
				|| this.pessoa.getEmails() == null
				|| this.pessoa.getEmails().size() == 0;
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
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}