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
						
						/*Egalitees*/
						if (cHorizontal.equals(cVertical) && horizontal.getCase(c1).isVide()) { // croisement et case sans lettre
							contraintes.add(new CroixContrainte(i, c1, j, c2 )); 
						}
					}
				}
			}
		}
	}
	
	public GrilleContrainte fixer(int m, String soluce) {
		return ;
	}
	
	
	// Accesseurs 
	public List<IContrainte> getContraintes(){
		return contraintes;
	}
}

