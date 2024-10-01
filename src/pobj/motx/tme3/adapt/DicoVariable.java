package pobj.motx.tme3.adapt;

import java.util.List;
import pobj.motx.tme2.*;
import pobj.motx.tme3.*;
import pobj.motx.tme3.csp.*;

public class DicoVariable implements IVariable{
	private int indice ; // indice de lemplacement de mot 
	private GrilleContrainte grille_contrainte ;
	
	public DicoVariable(int index, GrilleContrainte gp) {
		indice = index;
		grille_contrainte = gp;
	}
	
	public List<String> getDomain(){
		List<String> mots = grille_contrainte.getMotsPot().get(indice).getMots();
		return mots;
	}
	
	public String toString() {
		return "index = " + indice + ", domaine = " + getDomain()+"}";
	}
}
