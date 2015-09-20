package br.com.caelum.maven;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

@Resource
public class BemvindoController {

	private Result result;

	public BemvindoController(Result result) {
		this.result = result;
	}

	@Path("/")
	public void bemvindo() {
		System.out.println("estou invocando o vraptor");
		result.use(Results.http()).body("<html>bem vindo!</html>");
	}

}