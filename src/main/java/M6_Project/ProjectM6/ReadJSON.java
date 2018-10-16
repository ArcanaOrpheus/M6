package M6_Project.ProjectM6;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.io.FileWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ReadJSON {

	
	 public void comprarMaquina(String nomAula, String nomMaquina, String processador, boolean grafica){
		try {
			
			JSONObject jo = new JSONObject();
			jo.put("processador", processador);
			jo.put("grafica", grafica);
			jo.put("nom", nomMaquina);
			
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader("aules.json"));
			
			JSONArray array = (JSONArray) obj;
			for(Object o : array) {
				
				JSONObject aula = (JSONObject) o;
				if(aula.get("nom").equals(nomAula)) {
					
				JSONArray maquines = (JSONArray) aula.get("maquines");
				
				maquines.add(jo);
				
				}
			}
			
			//escribir el objeto RAIZ.
			FileWriter file = new FileWriter("aules.json");

	        file.write(array.toJSONString());
	        file.flush();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	 public void switchAC(String nomAula) {
		try {
			
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader("aules.json"));
			
			JSONArray array = (JSONArray) obj;
			for(Object o : array) {
				
				JSONObject aula = (JSONObject) o;
				if(aula.get("nom").equals(nomAula)) {
					
				if (aula.get("aireacondicionat").equals(true)){
					aula.put("aireacondicionat", false);
				}
				else
					aula.put("aireacondicionat", true);
				
				}
			}
			
			//escribir el objeto RAIZ.
			FileWriter file = new FileWriter("aules.json");

	        file.write(array.toJSONString());
	        file.flush();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	 public void canviaMaquina(String nomMaquina, String nomAula) {
		try {
			
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader("aules.json"));
			Maquina m = new Maquina();
			JSONArray array = (JSONArray) obj;
			for(Object o : array) {
				
				JSONObject aula = (JSONObject) o;
				JSONArray maquines = (JSONArray) aula.get("maquines");
				for(Object ma : maquines) {
					JSONObject test = (JSONObject) ma;
					if(test.get("nom").equals(nomMaquina)) {
						m.nom=(String) test.get("nom");
						m.processador=(String) test.get("processador");
						m.grafica=(Boolean) test.get("grafica");
					}
				}
				if(aula.get("nom").equals(nomAula)) {
					System.out.println(aula.get("nom"));
					JSONObject mac = new JSONObject();
					mac.put("processador", m.processador);
					mac.put("grafica", m.grafica);
					mac.put("nom", m.nom);
					
					maquines.add(mac);
					System.out.println(maquines.toString());
				}
				else {
					JSONObject mac = new JSONObject();
					mac.put("processador", m.processador);
					mac.put("grafica", m.grafica);
					mac.put("nom", m.nom);
					maquines.remove(mac);
				}
			}
			
			//escribir el objeto RAIZ.
			FileWriter file = new FileWriter("aules.json");

	        file.write(array.toJSONString());
	        file.flush();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
