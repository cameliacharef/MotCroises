package pobj.motx.tme3;

import java.util.ArrayList;
import java.util.List;

import pobj.motx.tme2.*;
import pobj.motx.tme1.*;

/**
 * Classe GrilleContrainte : gère une grille de mots avec des contraintes de croisement.
 * Hérite de GrillePotentiel et ajoute des contraintes de croisement pour gérer les intersections entre les mots.
 */
public class GrilleContrainte extends GrillePotentiel{
	/** Liste des contraintes de croisement */
	private List<IContrainte> contraintes;
	
	/**
     * Constructeur : initialise une GrilleContrainte avec une grille et un dictionnaire complet.
     * Ajoute les contraintes de croisement entre les mots et propage les réductions possibles.
     * @param grille la grille de mots avec les emplacements
     * @param dicoComplet le dictionnaire complet de mots possibles
     */
	public GrilleContrainte(GrillePlaces grille, Dictionnaire dicoComplet) {
		super(grille, dicoComplet);
		contraintes = new ArrayList<IContrainte>();
		updateContraintes(); // renseigner l’attribut contraintes
		propage(); // Propage les contraintes pour réduire le nombre de mots possibles
	}
	
	/**
     * Met à jour la liste des contraintes en détectant les croisements entre les mots de la grille.
     * Compare les emplacements horizontaux et verticaux pour ajouter les contraintes de croisement.
     */
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
				// Comparer chaque case de l'emplacement horizontal avec chaque case de l'emplacement vertical
				for (int c1 = 0; c1 < horizontal.size(); c1++) {
					Case cHorizontal = horizontal.getCase(c1); // comparer cette case avec toutes les cases verticales
					
					for(int c2 = 0; c2 < vertical.size(); c2++) {
						Case cVertical = vertical.getCase(c2);
						
						 // Ajouter une contrainte si les deux cases se croisent et sont vides
						if (cHorizontal.equals(cVertical) && horizontal.getCase(c1).isVide()) { // croisement et case sans lettre
							CroixContrainte c = new CroixContrainte(i, c1, j, c2 );
							contraintes.add(c); 
						}
					}
				}
			}
		}
		 // Appliquer les réductions pour chaque contrainte trouvée
		for(IContrainte ic : contraintes) {
    			ic.reduce(this);
    		}
	}
	
	 /**
     * Crée une nouvelle GrilleContrainte après avoir fixé une solution pour un emplacement donné.
     * Applique la solution (mot) à l'emplacement, met à jour la grille et renvoie la nouvelle grille contrainte.
     * 
     * @param m l'indice de l'emplacement à fixer
     * @param soluce la solution (mot) à placer à l'emplacement
     * @return une nouvelle GrilleContrainte avec la grille mise à jour
     */
	public GrilleContrainte fixer(int m, String soluce) {
		GrillePlaces grilleplace = super.getGrillePlaces();
		GrillePlaces nvgrillePlace = grilleplace.fixer(m, soluce);
		Dictionnaire dico = super.getDictionnaire();
		GrilleContrainte g = new GrilleContrainte(nvgrillePlace, dico);
		return g;
	}
	
	
	/**
     * Accesseur pour obtenir la liste des contraintes.
     * @return la liste des contraintes appliquées sur la grille
     */
	public List<IContrainte> getContraintes(){
		return contraintes;
	}
	
	/**
     * Propage les contraintes jusqu'à ce que la grille soit stable.
     * Applique les réductions des mots possibles pour chaque contrainte, tant que des changements sont détectés.
     * 
     * @return true si la propagation est terminée avec succès, false si la grille est insolvable (bloquée)
     */
	private boolean propage() {
		int nb_mot_elimine = 0;
		while(true) {
			nb_mot_elimine = 0;
			// Applique les réductions pour chaque contrainte
			for (IContrainte i :  contraintes) {
				nb_mot_elimine += i.reduce(this);
			}
			// Vérifie si la grille est bloquée
			if (this.isDead()){
				return false;
			}
			 // Si aucun mot n'a été éliminé, la grille est stable
			if(nb_mot_elimine == 0) {
				return true;
			}
		}
		
	}
	 /**
     * Renvoie une représentation sous forme de chaîne de caractères de la grille contrainte.
     * @return la chaîne de caractères représentant la grille actuelle
     */
	@Override 
		public String toString() {
			return super.toString();
		}
}

