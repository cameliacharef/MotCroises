package pobj.motx.tme3;

import java.util.ArrayList;
import java.util.List;

import pobj.motx.tme2.*;
import pobj.motx.tme1.*;
public class GrilleContrainte extends GrillePotentiel{
	private List<IContrainte> contraintes;
	
	public GrilleContrainte(GrillePlaces grille, Dictionnaire dicoComplet) {
		super(grille, dicoComplet);
		contraintes = new ArrayList<IContrainte>();
		updateContraintes(); // renseigner l’attribut contraintes
		propage();
	}
	
	private void updateContraintes() {
		GrillePlaces grillePlaces = super.getGrillePlaces();
		List<Emplacement> places = grillePlaces.getPlaces();
		
		// Taille pour la boucle
		int size_horizontaux = grillePlaces.getNbHorizontal(); // nb emplacement horizontaux
		int size_total = places.size() ;
		
		// Comparer les emplacements horizontaux contre tous les emplacements verticaux
		for(int i = 0; i < size_horizontaux; i++) {
			Emplacement horizontal = places.get(i);
			
			for(int j = size_horizontaux; j < size_total; j++) {
				Emplacement vertical = places.get(j);
				
				for (int c1 = 0; c1 < horizontal.size(); c1++) {
					Case cHorizontal = horizontal.getCase(c1); // comparer cette case avec toutes les cases verticales
					
					for(int c2 = 0; c2 < vertical.size(); c2++) {
						Case cVertical = vertical.getCase(c2);
						
						
						if (cHorizontal.equals(cVertical) && horizontal.getCase(c1).isVide()) { // croisement et case sans lettre
							CroixContrainte c = new CroixContrainte(i, c1, j, c2 );
							contraintes.add(c); 
						}
					}
				}
			}
		}
		for(IContrainte ic : contraintes) {
    			ic.reduce(this);
    		}
	}
	
	/**
	* initialisera une nouvelle GrilleContrainte avec la grille résultant de l’affectation.
	* @param m indice de l'emplacement 	public boolean contains(Character c) {
		return l.contains(c);
	}
	
	* @param soluce lettres a chercher
	* @return une nouvelle GrilleContrainte avec la grille résultant de l’affectation.
	 */
	public GrilleContrainte fixer(int m, String soluce) {
		GrillePlaces grilleplace = super.getGrillePlaces();
		GrillePlaces nvgrillePlace = grilleplace.fixer(m, soluce);
		Dictionnaire dico = super.getDictionnaire();
		GrilleContrainte g = new GrilleContrainte(nvgrillePlace, dico);
		return g;
	}
	
	
	// Accesseurs 
	public List<IContrainte> getContraintes(){
		return contraintes;
	}
	private boolean propage() {
		int nb_mot_elimine = 0;
		while(true) {
			nb_mot_elimine = 0;
			for (IContrainte i :  contraintes) {
				nb_mot_elimine += i.reduce(this);
			}
			if (this.isDead()){
				return false;
			}
			if(nb_mot_elimine == 0) {
				return true;
			}
		}
		
		
	}
}

