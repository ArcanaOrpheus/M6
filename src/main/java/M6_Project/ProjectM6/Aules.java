package M6_Project.ProjectM6;

import java.io.Serializable;
import java.util.ArrayList;

public class Aules implements Serializable{
	String nom;
	int capacitat;
	boolean aireacondicionat;
	ArrayList <Maquina> maquines = new ArrayList<Maquina>();
	
	Aules(Aules aules){
		this.nom=nom;
		this.capacitat=capacitat;
		this.aireacondicionat=aireacondicionat;
		this.maquines.addAll(maquines);
	}
	
	
	
	
	public Aules() {
		super();
	}




	public String toString() {
		return "Aula [nom=" + nom + ", capacitat=" + capacitat + ", aireacondicionat=" + aireacondicionat
				+ ", maquines=" + maquines + "]";
	} 
	
	
}
