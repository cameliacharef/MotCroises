package pobj.motx.tme1;

import java.util.ArrayList;
import java.util.List;

/**
* Classe de représentation d'Emplacement de mot
*/
public class Emplacement {
	/** liste de cases*/
	private List<Case> cases = new ArrayList<Case>();
	
	/** 
	 * Construit un emplacement
	 */
	public Emplacement() {}
	
	/**
	 * Ajoute une case à la liste
	 * @param e case à rajouter
	 */
	public void add(Case e) {
		cases.add(e);
	}
	/**
	 * Donne la taille de la liste
	 * @return la taille
	 */
	public int size() {
		return cases.size();
	}
	/**
	 * Donne la case à l'emplacement i
	 * @param i l'emplacement de la case
	 * @return la case à l'emplacement i
	 */
	public Case getCase(int i) {
		return cases.get(i);
	}
	/**
	 * Affiche le mot
	 * @return le mot
	 */
	@Override public String toString() {
		String s = "";
		for(Case c : cases) {
			s += c.getChar();
		}
		return s;
	}
}
