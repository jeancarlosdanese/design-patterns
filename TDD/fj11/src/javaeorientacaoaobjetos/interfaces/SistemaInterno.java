package javaeorientacaoaobjetos.interfaces;

public class SistemaInterno {
	
	public void autentica(Autenticavel f) {
		
		int senha = 123; // no futuro, pegamos do teclado
		
		if(f.autentica(senha)) {
			System.out.println("Bem vindo ao sistema!");
		} else {
			System.out.println("Senha incorreta");
		}
		
	}
	
}
