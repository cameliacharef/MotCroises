package pobj.motx.tme2;
import java.util.List;

import pobj.motx.tme1.*;

import java.util.ArrayList;



public class GrillePotentiel {
	private GrillePlaces grilleplace;
	private Dictionnaire dico;
	private List<Dictionnaire> motsPot = new ArrayList<Dictionnaire>();
	
	public GrillePotentiel(GrillePlaces grille, Dictionnaire dicoComplet) {
		this.grilleplace = grille;
		this.dico = dicoComplet;
		List<Emplacement> liste = grilleplace.getPlaces();
		for(Emplacement e : liste) {
			Dictionnaire d = dico.copy();
			d.filtreLongueur(e.size());
			for(int i = 0; i < e.size(); i++){
				Case c = e.getCase(i);
				if(!c.isVide()) {
					d.filtreParLettre(c.getChar(), i);
				}
			}
			motsPot.add(d);
		}
	}
	
	public List<Dictionnaire> getMotsPot() {
		return motsPot;
	}
	public boolean isDead() {
		for (Dictionnaire d : motsPot) {
			if(d.size() == 0) {
				return true;
			}
		}
		return false;
		
	}
}
