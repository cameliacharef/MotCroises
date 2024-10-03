package pobj.motx.tme1;


/**
	 * Classe de représentation de Case dans une grille de mots croisés
	 */

public class Case {
	/** numéro de ligne de la case*/
	private int ligne;
	/** numéro de colonne de la case*/
	private int colonne;
	/** contenu de la case*/
	private char valeur;
	
	/**
	 *Construit une case de coordonnées
	 *@param lig numéro de ligne de la case
	 *@param col numéro de colonne de la case
	 *@param c contenu de la case
	 */
	public Case(int lig, int col, char c) {
		ligne=lig;
		colonne=col;
		valeur=c;
	}
	/**
	* Accède au numéro de ligne de la case
	* @return le numéro de ligne de la case
	 */
	public int getLig(){
		return ligne;
	}
	/**
	* Accède au numéro de colonne de la case
	* @return le numéro de colonne de la case
	 */
	public int getCol(){
		return colonne;
	}
	/**
	* Accède au contenu de la case
	* @return le contenu valeur de la case 
	 */
	public char getChar(){
		return valeur;
	}
	/**
	* Modifie le contenu de la case
	* @param c nouveau contenu de la case
	 */
	public void setChar(char c){
		valeur = c;
	}
	/**
	* Test si la case est vide 
	* @return true si la case est vide , false sinon
	 */
	public boolean isVide() {
		return valeur == ' ';
	}
	/**
	* Test si la case est pleine 
	* @return true si la case est pleine , false sinon
	 */
	public boolean isPleine() {
		return valeur == '*';
	}
	
}
