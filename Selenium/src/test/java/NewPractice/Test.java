package NewPractice;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Test {

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		
		JSONParser json = new JSONParser();
		FileReader reader = new FileReader(".\\jsonData\\testdata.json");
		
		Object obj = json.parse(reader);
		
		JSONObject data = (JSONObject)obj;
		
		//System.out.println(data.get("FIORIURL"));
		
		
		HashMap<String, String> map = new HashMap<String, String>();
		for(Object s:data.keySet()) {
			//System.out.println((String)s + "," +data.get(s));
			map.put((String)s, (String) data.get(s));
		}
		
		
		
		
		
		

	}

}
