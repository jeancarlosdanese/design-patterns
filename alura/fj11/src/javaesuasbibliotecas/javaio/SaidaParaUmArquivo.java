package javaesuasbibliotecas.javaio;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class SaidaParaUmArquivo {
	public static void main(String[] args) throws IOException {
//		InputStream is = new FileInputStream("arquivo.txt");
//		Scanner entrada = new Scanner(is);
		
		/*OutputStream os = new FileOutputStream("saida.txt");
        OutputStreamWriter osw = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(osw);*/
		
		Scanner entrada = new Scanner(new FileInputStream("arquivo.txt"));

		BufferedWriter bw = new BufferedWriter(
								new OutputStreamWriter(
									new FileOutputStream("saida.txt")));
		
        while (entrada.hasNextLine()) {
            String linha = entrada.nextLine();
            bw.write(linha);
            bw.newLine(); 
        }
        bw.close();
		entrada.close();
	}
}
