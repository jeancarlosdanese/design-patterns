package br.com.caelum.livraria.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.service.AutorService;

@Named
@RequestScoped
public class AutorBean {

	private Autor autor = new Autor();

	@Inject
	private AutorService autorService;
	
	/*@Inject
	private AutorDao dao; // = new AutorDao();*/
	
	public Autor getAutor() {
		return autor;
	}

	public void cadastra() {
		this.autorService.salva(autor);
		this.autor = new Autor();
	}

	public List<Autor> getAutores() {
		return this.autorService.todosAutores();
	}
}
