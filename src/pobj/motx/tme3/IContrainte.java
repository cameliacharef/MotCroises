package pobj.motx.tme3;

import pobj.motx.tme2.*;

/**
 * Interface IContrainte : définit une contrainte qui peut être appliquée sur une grille de mots potentiels.
 * Les classes qui implémentent cette interface doivent fournir une méthode pour réduire le nombre de mots possibles
 *  */
public interface IContrainte {
	/**
     * Applique la contrainte sur la grille donnée et réduit le nombre de mots possibles.
     * @param grille la grille sur laquelle la contrainte est appliquée
     * @return le nombre de mots éliminés de la grille après application de la contrainte
     */
	public int reduce(GrillePotentiel grille);
}
