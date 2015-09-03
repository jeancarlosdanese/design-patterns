package br.com.danese.maladiretacliente;

import javax.swing.JOptionPane;

import br.com.danese.maladiretacliente.xml.MalaDiretaXML;
import br.com.danese.maladiretalib.MalaDireta;

public class NovoClienteCadastrado {

	public static void main(String[] args) {
	    MalaDireta malaDireta = new MalaDiretaXML("contatos.xml");
	    String mensagem = JOptionPane.showInputDialog(null, "Informe a mensagem de novo cliente:");
	    boolean status = malaDireta.enviarEmail(mensagem);
	    JOptionPane.showMessageDialog(null, "E-mails enviados: " + status);
    }
	
}
