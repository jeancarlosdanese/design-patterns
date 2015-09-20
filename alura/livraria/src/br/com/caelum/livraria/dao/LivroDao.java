package br.com.caelum.livraria.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.caelum.livraria.modelo.Livro;

@Stateless
public class LivroDao {

	/*@Inject
	private Banco banco; // = new Banco(); */
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void salva(Livro livro) {
//		banco.save(livro);
		entityManager.persist(livro);
	}
	
	public List<Livro> todosLivros() {
//		return banco.listaLivros();
		return entityManager.createQuery("from Livro", Livro.class).getResultList();
	}
	
	public List<Livro> livrosPeloNome(String nome) {
		TypedQuery<Livro> query = entityManager
				.createQuery("select livro from Livro livro where livro.titulo like :pTitulo", Livro.class);
		query.setParameter("pTitulo", "%" + nome + "%");
		
		return query.getResultList();
	}
	
}
