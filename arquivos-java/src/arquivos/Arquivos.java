package arquivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Arquivos {
	
	public static void main(String[] args) throws IOException {
		
		File arquivo = new File("/home/nino/git/arquivos-java/arquivos-java/src/arquivos/arquivo.txt");
		
		if(!arquivo.exists()) {
			arquivo.createNewFile();
			
		}
		
		FileWriter escrever_no_arquivo = new FileWriter(arquivo);
		
		escrever_no_arquivo.write("Meu texto no arquivo"); //Escrever no arquivo
		escrever_no_arquivo.write("\n");
		escrever_no_arquivo.write("Minha segunda linha");
		escrever_no_arquivo.flush(); //persistir no arquivo
		escrever_no_arquivo.close(); //fechar arquivo

	}

}
