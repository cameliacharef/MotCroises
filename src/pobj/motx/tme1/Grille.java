package pobj.motx.tme1;

/**
 * Classe de représentation de Grille de mots croisés
 */

public class Grille {
	/** tableau 2D de cases */
	private Case[][] matrice;
	
	/**
	 *Construit une grille de cases
	 *@param hauteur nombre de lignes
	 *@param largeur nombre de colonnes
	 */
	public Grille(int hauteur, int largeur) {
		matrice = new Case[hauteur][largeur];
		for(int i = 0; i < matrice.length; i++) {
			for(int j = 0; j < matrice[i].length; j++) {
				matrice[i][j] = new Case(i, j, ' ');
			}
		}
	}
	
	/**
	* Accède à la case de position (lig, col)
	* @param lig numéro de ligne de la case
	* @param col numéro de colonne de la case
	* @return la case
	 */
	public Case getCase(int lig, int col) {
		return matrice[lig][col];
	}
	
	/**
	 * Affiche la grille
	 * @return la grille
	 */
	public String toString() {
		return pobj.motx.tme1.GrilleLoader.serialize(this, false);
	}
	
	/**
	 * Donne la hauteur de la grille
	 * @return le nombre de lignes de la grille
	 */
	public int nbLig() {
		return matrice.length;
	}
	
	/**
	 * Donne la largeur de la grille
	 * @return le nombre de colonnes de la grille
	 */
	public int nbCol() {
		return matrice[0].length;
	}
	
	/**
	 * Donne une copie à l’identique de la grille courante
	 * @return la grille copiée
	 */
	public Grille copy() {
		Grille g = new Grille(this.matrice.length, this.matrice[0].length);
		for(int i = 0; i < g.matrice.length; i++) {
			for(int j = 0; j < g.matrice[i].length; j++) {
				g.matrice[i][j] = new Case(i, j, this.matrice[i][j].getChar());
			}
		}
		return g;
	}
	
	
}
