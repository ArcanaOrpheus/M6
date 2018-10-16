package M6_Project.ProjectM6;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Collections;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;


public class ReadTXT {
	
 ArrayList<String> profesors= new ArrayList<String>();

 public void afegirProfessor(String Professor) {
	 
	 profesors.add(Professor);
	 Collections.sort(profesors);
	 write();
	 
 }
 
 public void jubilarProfessor(String profesor) {
	 
	 profesors.remove(profesors.indexOf(profesor));
	 Collections.sort(profesors);
	 write();
 }
 
 void write() {
	
	try {


		FileReader fr = new FileReader("professors.txt.txt");
		BufferedReader br = new BufferedReader(fr);
		FileWriter fw = new FileWriter("professors.txt.txt");
		BufferedWriter bw = new BufferedWriter(fw);




	while(br.ready()) {
		String s=br.readLine();
		profesors.add(s);
	}
	
	br.close();
	fr.close();
	
		Collections.sort(profesors);
		
	for(String s: profesors) {
		bw.write(s);
	}
	bw.flush();
		
		
	} catch (Exception pasanCosas) {
		pasanCosas.printStackTrace();
	}
}

}
 

