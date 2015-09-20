package br.com.caelum.livraria.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import br.com.caelum.livraria.dao.AutorDao;
import br.com.caelum.livraria.modelo.Autor;

@Stateless
public class AutorService {

	@Inject
	AutorDao autorDao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED) // opcional este é o padrão
	public void salva(Autor autor) {
		// ... regras de negócio
		
		autorDao.salva(autor);
	}

	public List<Autor> todosAutores() {
		return autorDao.todosAutores();
	}

}
