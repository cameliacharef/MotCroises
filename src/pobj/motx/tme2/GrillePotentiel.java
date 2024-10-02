package pobj.motx.tme2;
import java.util.List;

import pobj.motx.tme1.*;

import java.util.ArrayList;

/**
 * Classe qui enrichit la classe GrillePlace en associant à chaque emplacement de mot un dictionnaire : son domaine potentiel.
 */
public class GrillePotentiel {
	/** stocke la grille actuelle (partiellement remplie) */
	private GrillePlaces grilleplace;
	/** stocke le dictionnaire français complet */
	private Dictionnaire dico;
	/** stocke le domaine de chaque emplacement de la grille*/
	private List<Dictionnaire> motsPot = new ArrayList<Dictionnaire>();
	
	/**
	 *Construit une GrillePotentiel qui initialise le domaine des emplacements
	 *@param grille la grille actuelle
	 *@param dicoComplet dictionnaire français
	 */
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
	/**
	* Accède aux domaine de chaque emplacement de la grille
	* @return domaine de chaque emplacement de la grille
	 */
	public List<Dictionnaire> getMotsPot() {
		return motsPot;
	}
	
	/**
	* Verifie si au moins un emplacement a un domaine potentiel vide
	* @return vrai si au moins un emplacement a un domaine potentiel vide
	 */
	public boolean isDead() {
		for (Dictionnaire d : motsPot) {
			if(d.size() == 0) {
				return true;
			}
		}
		return false;
		
	}
	
	/**
	* initialisera une nouvelle GrillePotentiel avec la grille résultant de l’affectation.
	* @param m indice de l'emplacement 
	* @param soluce lettres a chercher
	* @return une nouvelle GrillePotentiel avec la grille résultant de l’affectation.
	 */
	public GrillePotentiel fixer(int m, String soluce) {
		GrillePlaces nvgrillePlace = grilleplace.fixer(m, soluce);
		GrillePotentiel g = new GrillePotentiel(nvgrillePlace, dico);
		return g;
	}
	
	/**
	* Accède a l'Attribut grillePlace
	* @return la grille actuelle
	 */
	public GrillePlaces getGrillePlaces() {
		return grilleplace;
	}
	
	/**
	* Accède a l'Attribut dico
	* @return le dictionnaire français
	 */
	public Dictionnaire getDictionnaire() {
		return dico;
	}
	
	@Override public String toString() {return grilleplace.toString();}
	
}
