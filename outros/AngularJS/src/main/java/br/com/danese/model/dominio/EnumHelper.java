package br.com.danese.model.dominio;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named
public class EnumHelper {
	
	public DominioTipoEndereco[] getTipoEndereco() {
		return DominioTipoEndereco.values();
	}

	public DominioTipoTelefone[] getTipoTelefone() {
		return DominioTipoTelefone.values();
	}
	
	public DominioPerfil[] getPefilPessoa() {
		return DominioPerfil.values();
	}
	
	public DominioEstado[] getEstado() {
		return DominioEstado.values();
	}
	
	public DominioTipoPessoa[] getTipoPessoa() {
		return DominioTipoPessoa.values();
	}
	
	public DominioSexo[] getSexo() {
		return DominioSexo.values();
	}
	
	public DominioEstadoCivil[] getEstadoCivil() {
		return DominioEstadoCivil.values();
	}
	
	public DominioCampoTabelaPessoa[] getCamposTabelaPessoa() {
		return DominioCampoTabelaPessoa.values();
	}
	
}
