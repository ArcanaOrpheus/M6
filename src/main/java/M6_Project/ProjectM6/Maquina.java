package M6_Project.ProjectM6;

import java.io.Serializable;

public class Maquina implements Serializable{

	String nom;
	String processador;
	boolean grafica;
	
	public Maquina(String nom, String processador, boolean grafica) {
		super();
		this.nom = nom;
		this.processador = processador;
		this.grafica = grafica;
	}

	public Maquina() {
		super();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getProcessador() {
		return processador;
	}

	public void setProcessador(String processador) {
		this.processador = processador;
	}

	public boolean isGrafica() {
		return grafica;
	}

	public void setGrafica(boolean grafica) {
		this.grafica = grafica;
	}
	
	
}
