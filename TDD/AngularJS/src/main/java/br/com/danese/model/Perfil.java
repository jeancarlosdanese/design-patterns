package br.com.danese.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.envers.Audited;

import br.com.danese.model.dominio.DominioPerfil;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Audited
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "perfil", name = "perfil_ukey"))
@XmlRootElement
public class Perfil implements BaseModel<Long> {

	private static final long serialVersionUID = -492985985526197917L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(length = 15)
	private DominioPerfil perfil;

	public Perfil() {
		super();
	}

	public Perfil(DominioPerfil perfil) {
		this.perfil = perfil;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public DominioPerfil getPerfil() {
		return perfil;
	}

	public void setPerfil(DominioPerfil perfil) {
		this.perfil = perfil;
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
		Perfil other = (Perfil) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
