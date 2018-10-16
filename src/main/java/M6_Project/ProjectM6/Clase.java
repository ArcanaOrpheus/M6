package M6_Project.ProjectM6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Clase implements Serializable{


	
	public void crearClasse(){
		try {
		ArrayList<String> profesors = new ArrayList<String>();
		ArrayList<Object> o = new ArrayList<Object>();
		String choosedOne;
		FileReader fr = new FileReader("professors.txt.txt");
		BufferedReader br = new BufferedReader(fr);
		while(br.ready()) {
			String s=br.readLine();
			profesors.add(s);
		}
		br.close();
		fr.close();
		
		choosedOne= profesors.get((int)(Math.random()*profesors.size()));
		
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("aules.json"));
		JSONArray array = (JSONArray) obj;
		JSONObject aula =(JSONObject) array.get((int)(Math.random()*array.size()));
		Institut ins = new Institut();
		File file = new File("alumnes.xml");  
        JAXBContext jaxbContext = JAXBContext.newInstance(Institut.class);  
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
        ins = (Institut) jaxbUnmarshaller.unmarshal(file);
		
        for(int i=0;i<5;i++) {
        	o.add(ins.alumnes.get((int)(Math.random()*ins.alumnes.size())));
        }
		
		o.add(choosedOne);
		o.add(aula);
		
		File f = new File("classe.dat");
		FileOutputStream fol = new FileOutputStream(f);
		ObjectOutputStream oos = new ObjectOutputStream(fol);
		int j= o.size();
		for(int i =0; i<j;i++) {
			oos.writeObject(o.get(i));
		}
		oos.flush();
		oos.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void llegirClasse() {
		
		try {
			ArrayList<Alumne> alum = new ArrayList<Alumne>();
			JSONObject clas = new JSONObject();
			String profe=null;
			FileInputStream fis = new FileInputStream("classe.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);

			try {
				
				while (true) {
					Object o2 = ois.readObject();
					if(o2 instanceof Alumne) {
						alum.add((Alumne) o2);
					}
					if(o2 instanceof JSONObject) {
						clas =((JSONObject) o2);
					}
					if(o2 instanceof String) {
						profe=(String)o2;
					}
				}
			}

			 catch (EOFException fin) {
				ois.close();
			}
			
			System.out.println("Classe="+clas.toString());
			System.out.println("Professor "+ profe);
			System.out.println("Alumnes ="+alum.toString());
			
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
