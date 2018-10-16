package M6_Project.ProjectM6;

import javax.xml.bind.annotation.*;

import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;
@XmlRootElement (name="institut")
public class Institut implements Serializable{
	
	String nom;
	ArrayList<Alumne> alumnes = new ArrayList<>();
	
	public Institut() {
		super();
	}

	public Institut(String nom, ArrayList<Alumne> alumnes) {
		super();
		this.nom = nom;
		this.alumnes = alumnes;
	}
	
	@XmlElement(name="nom")
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	@XmlElementWrapper(name ="alumnes")
	@XmlElement(name="alumne")
	public List<Alumne> getAlumnes() {
		return alumnes;
	}

	public void setAlumnes(ArrayList<Alumne> alumnes) {
		this.alumnes =  alumnes;
	}
	
	
	
	
	
}
