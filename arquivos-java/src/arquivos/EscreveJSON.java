package arquivos;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;

public class EscreveJSON {

	public static void main(String[] args) throws IOException {
		
		Usuario usuario1 = new  Usuario();
		usuario1.setCpf("004005006001");
		usuario1.setLogin("João");
		usuario1.setSenha("123456");	

		usuario1.setNome("João Teste");
		
		Usuario usuario2 = new Usuario();
		usuario2.setCpf("00500600702");
		usuario2.setLogin("Nicholas");
		usuario2.setSenha("654321");
		usuario2.setNome("Nicholas Sena");
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(usuario1);
		usuarios.add(usuario2);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		String jsonUser = gson.toJson(usuarios);
		
		System.out.println(jsonUser);
		
		FileWriter fileWriter = new FileWriter("/home/nino/git/arquivos-java/arquivos-java/src/arquivos/filejson.json");
		
		fileWriter.write(jsonUser);
		fileWriter.flush();
		fileWriter.close();
		
		/*ACIMA ESCREVEU O ARQUIVO JSON*/
		
		/*AGORA VAMOS LER O ARQUIVO JSON*/
		
		FileReader fileReader = new FileReader("/home/nino/git/arquivos-java/arquivos-java/src/arquivos/filejson.json");
		
		JsonArray jsonArray = (JsonArray) JsonParser.parseReader(fileReader);
		
		List<Usuario>  listUsuarios = new ArrayList<Usuario>();
		
		for(JsonElement jsonElement : jsonArray) {
			
			Usuario usuario = new Gson().fromJson(jsonElement, Usuario.class);
			listUsuarios.add(usuario);
			
		}
		
		System.out.println("Leitura do arquivo JSON: " +  listUsuarios);
		
		
		
		
	}

}
