package arquivos;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoi {

	public static void main(String[] args) throws Exception {

		File file = new File
				("/home/nino/git/arquivos-java/arquivos-java/src/arquivos/aquivo_excel.xls");

		if (!file.exists()) {
			file.createNewFile();

		}

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

		/* Pode vir do banco de dados ou quelquer outra fonte de dados */
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);

		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(); /* VAI SER USADO PARA ESCREVER A PLANILHA */
		HSSFSheet linhasPessoa =
				hssfWorkbook.createSheet("Planilha de pessoas JDev Treinamento"); /* Criar a planilha */

		int numeroLinha = 0;
		for (Pessoa p : pessoas) {
			Row linha = linhasPessoa.createRow(numeroLinha++); /* Criando a linha na planilha */

			int celula = 0;

			Cell celNome = linha.createCell(celula++); // Celula 1
			celNome.setCellValue(p.getNome());

			Cell celEmail = linha.createCell(celula++); // Celula 2
			celEmail.setCellValue(p.getEmail());

			Cell celIdade = linha.createCell(celula++); // Celula 1
			celIdade.setCellValue(p.getIdade());
		} // Terminou de montar a planilha

		FileOutputStream saida = new FileOutputStream(file);
		hssfWorkbook.write(saida); // Escreve planilha em arquivo
		saida.flush();
		saida.close();

		System.out.println("Planilha foi criada");

	}

}
