package pobj.motx.tme2;

import java.util.ArrayList;
import java.util.List;
import pobj.motx.tme1.*;

/**
 * Classe qui explore une Grille pour trouver tous les emplacements des mots qu’elle contient.
 */
public class GrillePlaces {
	/** stocke les emplacements trouvés */
	private List<Emplacement> places = new ArrayList<Emplacement>();
	/** la grille fournie  */
	private Grille grille;
	
	/**
	 *Construit une GrillePlaces explore la grille fournie et calcule les emplacements de mot qu’elle contient
	 *@param grille grille fournie
	 * */
	public GrillePlaces (Grille grille) {
		this.grille = grille;
		for(int i = 0; i < grille.nbLig(); i++) {
			List<Case> lig = getLig(i);
			cherchePlaces(lig);
		}
		for(int j = 0; j < grille.nbCol(); j++) {
			List<Case> col = getCol(j);
			cherchePlaces(col);
		}
	}	
	
	/**
	* donne une nouvelle GrillePotentiel avec la grille résultant de l’affectation.
	* @param m indice de l'emplacement 
	* @param soluce lettres a chercher
	* @return nouvelle grille où les cases constituant l’emplacement de mot d’indice m ont pour contenu les lettres de soluce
	 */
	public GrillePlaces fixer(int m, String soluce) {
		GrillePlaces res = new GrillePlaces(grille.copy());
		Emplacement e = res.getPlaces().get(m);
		for (int i = 0; i < e.size(); i++) {
			e.getCase(i).setChar(soluce.charAt(i));
		}
		return res;
		
	}
	
	/**
	* accede les emplacements détectés
	* @return les emplacements détectés
	 */
	public List<Emplacement> getPlaces(){
		return places;
	}
	
	/**
	* le nombre d’emplacements horizontaux
	* @return le nombre d’emplacements horizontaux
	 */
	public int getNbHorizontal() {
		int res = 0;
		for(Emplacement e : places)
			if(e.getCase(0).getLig() == e.getCase(1).getLig())
				res++;
		return res;
	}
	
	/**
	* afficher les emplacements de mot détectés de façon lisible
	* @return les emplacements de mot détectés de façon lisible
	 */
	@Override public String toString() {
		String s = "";
		for(Emplacement e : places)
			s += e.toString() + "\n";
		return s;
	}
	
	/**
	* donne les cases qui constituent une ligne 
	* @param lig ligne recherchee
	* @return les cases qui constituent une ligne 
	 */
	private List<Case> getLig(int lig){
		List<Case> res = new ArrayList<Case>();
		for(int j = 0; j < grille.nbCol(); j++)
			res.add(grille.getCase(lig, j));
		return res;
	}
	
	/**
	* donne les cases qui constituent une colonne 
	* @param col colonne recherchee
	* @return les cases qui constituent une colonne 
	 */
	private List<Case> getCol(int col){
		List<Case> res = new ArrayList<Case>();
		for(int i = 0; i < grille.nbLig(); i++)
			res.add(grille.getCase(i, col));
		return res;
	}
	
	/**
	* cherche les emplacements dans la liste de cases fourni et qui les ajoute à la liste
	* @param cases liste de cases
	* @return les emplacements dans la liste de cases fourni et qui les ajoute à la liste
	 */
	private void cherchePlaces(List<Case> cases) {
		Emplacement e = new Emplacement();
		for(Case c : cases) {
			if(!c.isPleine())
				e.add(c);
			else{
				if(e.size() >= 2)	
					places.add(e);
				e = new Emplacement();
			}
		}
		if (e.size() >= 2) {
	        places.add(e);
	    }
	}
}
