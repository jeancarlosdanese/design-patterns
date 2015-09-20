package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.modelo.Autor;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)	// opcional este é o modo padrão
//@Interceptors({ LogInterceptador.class })  // anotação substituída pelo arquivo ejb-jar.xml
public class AutorDao {

	/*@Inject
	private Banco banco;	// = new Banco(); */
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@PostConstruct
	void aposCriacao() {
		System.out.println("AutorDao foi criado");
	}

//	@TransactionAttribute(TransactionAttributeType.REQUIRED)	// opcional, este é o modo padrão
	@TransactionAttribute(TransactionAttributeType.MANDATORY)
	public void salva(Autor autor) {
		
		System.out.println("[INFO] Salvando o Autor: " + autor.getNome());
		
		/*try {
			Thread.sleep(20000);  // 20s
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		
//		banco.save(autor);
		entityManager.persist(autor);

		System.out.println("[INFO] Salvou o Autor: " + autor.getNome());
	}
	
	public List<Autor> todosAutores() {
//		return banco.listaAutores();
		return entityManager.createQuery("select a from Autor a", Autor.class)
	            .getResultList();
	}

	public Autor buscaPelaId(Integer autorId) {
//		Autor autor = this.banco.buscaPelaId(autorId);
		Autor autor = entityManager.find(Autor.class, autorId);
		return autor;
	}
	
}
