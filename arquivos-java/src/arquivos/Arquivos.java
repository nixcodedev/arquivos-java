package arquivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arquivos {

	public static void main(String[] args) throws IOException {

		Pessoa pessoa1 = new Pessoa();
		pessoa1.setEmail("pessoa1@gmail.com");
		pessoa1.setIdade(41);
		pessoa1.setNome("Nixon Sena");

		Pessoa pessoa2 = new Pessoa();
		pessoa2.setEmail("pessoa2@gmail.com");
		pessoa2.setIdade(8);
		pessoa2.setNome("Nicholas Sena");

		Pessoa pessoa3 = new Pessoa();
		pessoa3.setEmail("pessoa3@gmail.com");
		pessoa3.setIdade(36);
		pessoa3.setNome("Mel Sena");

		/*Pode vir do banco de dados ou quelquer outra fonte de dados*/
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);

		File arquivo = new File("/home/nino/git/arquivos-java/arquivos-java/src/arquivos/arquivo.txt");

		if (!arquivo.exists()) {
			arquivo.createNewFile();

		}

		FileWriter escrever_no_arquivo = new FileWriter(arquivo);

		for (Pessoa p : pessoas) {
			escrever_no_arquivo.write(p.getNome() + ";" + p.getEmail() + ";" + p.getIdade() + "\n");
		}

		escrever_no_arquivo.flush(); // persistir no arquivo
		escrever_no_arquivo.close(); // fechar arquivo

	}

}
