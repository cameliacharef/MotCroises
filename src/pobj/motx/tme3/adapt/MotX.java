package pobj.motx.tme3.adapt;

import java.util.ArrayList;
import java.util.List;

import pobj.motx.tme1.*;
import pobj.motx.tme3.*;
import pobj.motx.tme3.csp.*;

/**
 * Classe représentant un problème de satisfaction de contraintes (CSP) pour le jeu de mots.
 * Elle gère un ensemble de variables de dictionnaire et les contraintes associées dans une grille.
 */
public class MotX implements ICSP{
	//
	private List<IVariable> dicoV;// Liste des variables de dictionnaire
	private GrilleContrainte gc ; // Grille de contraintes associée
	
	 /**
     * Constructeur de la classe MotX.
     * @param gc la grille de contraintes à utiliser pour ce problème de CSP
     */
	public MotX(GrilleContrainte gc) {
		dicoV = new ArrayList<IVariable>();
		this.gc = gc;
		
		//on cherche emplacement grille ou au moins une case est vide
		List<Emplacement> liste_emplacement = this.gc.getGrillePlaces().getPlaces();
		for(int i = 0; i < liste_emplacement.size(); i++) {
			if (liste_emplacement.get(i).hasCaseVide()) {
				 // Ajout d'une variable de dictionnaire pour chaque emplacement avec une case vide
				DicoVariable dv = new DicoVariable(i, this.gc); 
				dicoV.add(dv);
			}
		}
	}
	
	/**
     * Récupère la liste des variables de dictionnaire.
     * @return la liste des variables (IVariable)
     */
	public List<IVariable> getVars(){
		return dicoV;
	}
	
	/**
     * Vérifie la cohérence de l'état actuel des variables.
     * @return true si l'état est cohérent, false sinon
     */
	public boolean isConsistent() {
		if(dicoV.isEmpty()) return true;
		if(gc.isDead()) return false;
		
		return true;
	}
	
	/**
     * Assigne une valeur à une variable de dictionnaire et renvoie une nouvelle instance de MotX.
     * @param vi la variable à assigner
     * @param val la valeur à assigner à la variable
     * @return une nouvelle instance de MotX représentant l'état mis à jour du problème
     */
	public ICSP assign(IVariable vi, String val) {
		MotX mx = null;
		if(vi instanceof DicoVariable) {
			DicoVariable d = (DicoVariable) vi;
			 // Crée une nouvelle grille de contraintes en assignant la valeur à la variable
			GrilleContrainte nv_gc = d.getGrilleContrainte().fixer(d.getIndice(), val);
			mx = new MotX(nv_gc); // Crée une nouvelle instance de MotX avec la nouvelle grille
		}
		
		return mx;
	}
}
