package pobj.motx.tme3.csp;

import java.util.ArrayList;
import java.util.List;

import pobj.motx.tme2.*;
import pobj.motx.tme1.*;
public class GrilleContrainte extends GrillePotentiel{
	private List<IContrainte> contraintes = new ArrayList<IContrainte>();
	
	public GrilleContrainte(GrillePlaces grille, Dictionnaire dicoComplet) {
		super(grille, dicoComplet);
		updateContraintes(); // renseigner l’attribut contraintes
	}
	
	
	private void updateContraintes() {
		GrillePlaces grillePlaces = super.getGrillePlaces();
		List<Emplacement> places = grillePlaces.getPlaces();
		
		// Taille pour la boucle
		int size_horizontaux = grillePlaces.getNbHorizontal();
		int size_verticaux= grillePlaces.getPlaces().size() - size_horizontaux;
		
		// Comparer les emplacements horizontaux contre tous les emplacements verticaux
		List<Case> case_lig;
		List<Case> case_col;
		for(int i = 0; i < size_horizontaux; i++) {
			for(int j = 0; j < size_verticaux; j++) {
				
			}
		}
		
	}
	
	public GrilleContrainte fixer(int m, String soluce) {
		
	}
	
	
	// Accesseurs 
	public List<IContrainte> getContraintes(){
		return contraintes;
	}
}
