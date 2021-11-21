package NewPractice;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class JsonHashMap {

	@Test(dataProvider = "dp")
	public void RunData(HashMap<String, String> map) throws IOException, ParseException {

		Set<Entry<String, String>> s1 = map.entrySet();
		for (Entry<String, String> a : s1) {
			System.out.println(a.getKey() + ":-  " + a.getValue());
		}
	}

	@DataProvider(name = "dp")
	public Object[][] getData() throws IOException, ParseException {

		JSONParser json = new JSONParser();
		FileReader reader = new FileReader(".\\jsonData\\testdata.json");

		Object obj = json.parse(reader);

		JSONObject data = (JSONObject) obj;

		// System.out.println(data.get("FIORIURL"));

		HashMap<String, String> map = new HashMap<String, String>();
		for (Object s : data.keySet()) {
			// System.out.println((String)s + "," +data.get(s));
			map.put((String) s, (String) data.get(s));
		}

		return new Object[][] {

				{ map }

		};
	}

}
