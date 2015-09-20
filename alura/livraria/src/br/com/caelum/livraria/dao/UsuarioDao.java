package br.com.caelum.livraria.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.modelo.Usuario;

@Stateless
public class UsuarioDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	/*@Inject
	private Banco banco; // = new Banco();*/
	
	public Usuario buscaPeloLogin(String login) {
//		return this.banco.buscaPeloNome(login);
        Usuario usuario = (Usuario) entityManager
                .createQuery("select usuario from Usuario usuario where usuario.login=:login")
                .setParameter("login", login).getSingleResult();
        return usuario;
	}
	
}
