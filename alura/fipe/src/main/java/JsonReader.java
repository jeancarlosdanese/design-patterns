import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonReader {

	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	public static JSONArray readJsonFromUrl(String url) throws IOException, JSONException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONArray json = new JSONArray(jsonText);
			return json;
		} finally {
			is.close();
		}
	}

	public static void main(String[] args) throws IOException, JSONException {
		JSONArray marcas = readJsonFromUrl("http://fipeapi.appspot.com/api/1/carros/marcas.json");

		for (int i = 0; i < marcas.length(); i++) {
			JSONObject obj = marcas.getJSONObject(i);

			// System.out.println("MARCA: ".concat(obj.get("name").toString()));
			System.out.println("MARCA: ".concat(obj.toString()));
		}

		JSONArray modelos = readJsonFromUrl("http://fipeapi.appspot.com/api/1/carros/veiculos/56.json");

		for (int i = 0; i < modelos.length(); i++) {
			JSONObject obj = modelos.getJSONObject(i);

			// System.out.println("MARCA: ".concat(obj.get("name").toString()));
			System.out.println("Modelo: ".concat(obj.toString()));
		}

		JSONArray veiculos = readJsonFromUrl("http://fipeapi.appspot.com/api/1/carros/veiculo/21/4828.json");

		for (int i = 0; i < veiculos.length(); i++) {
			JSONObject obj = veiculos.getJSONObject(i);

			// System.out.println("MARCA: ".concat(obj.get("name").toString()));
			System.out.println("Veículos: ".concat(obj.toString()));
		}

		JSONArray preco = readJsonFromUrl("http://fipeapi.appspot.com/api/1/carros/veiculo/21/4828/2009-1.json");

		System.out.println(preco.toString());
	}
}