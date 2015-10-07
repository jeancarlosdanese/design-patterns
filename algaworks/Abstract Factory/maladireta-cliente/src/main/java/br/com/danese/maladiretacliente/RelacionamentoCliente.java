package br.com.danese.maladiretacliente;

import javax.swing.JOptionPane;

import br.com.danese.maladiretacliente.csv.MalaDiretaCSV;
import br.com.danese.maladiretalib.MalaDireta;

public class RelacionamentoCliente {

	public static void main(String[] args) {
	    MalaDireta malaDireta = new MalaDiretaCSV("contatos.csv");
	    String mensagem = JOptionPane.showInputDialog(null, "Digite a mensagem do e-mail:");
	    
	    boolean status = malaDireta.enviarEmail(mensagem);
	    
	    JOptionPane.showConfirmDialog(null, "E-mails enviados: " + status);
    }
	
}
