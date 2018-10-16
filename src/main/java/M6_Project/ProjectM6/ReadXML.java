package M6_Project.ProjectM6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import javax.xml.bind.Marshaller;
import java.util.ArrayList;

public class ReadXML {
	
	Institut ins = new Institut();
	
	void read() {
		 
		try {  
			   
	        File file = new File("alumnes.xml");  
	        JAXBContext jaxbContext = JAXBContext.newInstance(Institut.class);  
	        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
	        ins = (Institut) jaxbUnmarshaller.unmarshal(file);
	      
	      }
		
		catch (JAXBException e) {  
			
	        e.printStackTrace();  
	        
	      }
		
		
			
	}
	
	 void write(){
		 	
			try {
				
				JAXBContext contextObj = JAXBContext.newInstance(Institut.class);  
				Marshaller marshallerObj = contextObj.createMarshaller();  
				marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				marshallerObj.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

				FileOutputStream fos = new FileOutputStream("alumnes.xml");
				
					marshallerObj.marshal(ins, fos);
				
				
			} catch (FileNotFoundException | JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  

	       
	} 
	
	  void afegeixAlumne(Alumne al){
		 
		read();
		ins.getAlumnes().add(al);
		write();
		
	}
	
	public void afegeixTelefon(String dniAlumne, String telefon) {
		 read();
		for(Alumne a : ins.getAlumnes()) {
			
			if(a.dni.equals(dniAlumne)) {
				a.telefons.add(telefon);
				
			}
		}
		
		write();
		
	}
	
	public void alCarrer(String dniAlumne) {
		
		read();
		ArrayList <Integer> denied = new ArrayList<Integer>();
		
		for(Alumne a : ins.getAlumnes()) {
					
			
			if(a.dni.equals(dniAlumne)) {
				
				denied.add(ins.getAlumnes().indexOf(a));
				
			}
			
		}
		for(int i : denied) {
			
			ins.getAlumnes().remove(i);
			
		}
		
		write();
		
	}
	
	
}
	


