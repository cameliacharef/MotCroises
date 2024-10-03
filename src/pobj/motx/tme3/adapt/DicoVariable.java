package pobj.motx.tme3.adapt;

import java.util.List;
import pobj.motx.tme2.*;
import pobj.motx.tme3.*;
import pobj.motx.tme3.csp.*;

/**
 * Représentation d'une variable de dictionnaire dans le contexte des contraintes.
 * Cette classe implémente l'interface IVariable et est utilisée pour
 * manipuler les domaines de mots associés à un emplacement donné dans la grille.
 */
public class DicoVariable implements IVariable{
	private int indice ; // Indice de l'emplacement du mot dans la grille
	private GrilleContrainte grille_contrainte ; // Référence à la grille de contraintes associée
	
	 /**
     * Constructeur de la classe DicoVariable.
     * @param index indice de l'emplacement du mot
     * @param gp la grille de contraintes associée à cette variable
     */
	public DicoVariable(int index, GrilleContrainte gp) {
		indice = index;
		grille_contrainte = gp;
	}
	
	/**
     * Récupère le domaine de mots possibles pour cette variable.
     * @return une liste de mots qui constituent le domaine de cette variable
     */
	public List<String> getDomain(){
		List<String> mots = grille_contrainte.getMotsPot().get(indice).getMots();
		return mots;
	}
	
	/**
     * Définit un nouveau domaine de mots pour cette variable.
     * @param domain nouvelle liste de mots qui constitue le domaine de cette variable
     */
	public void setDomain(List<String> domain){
		grille_contrainte.getMotsPot().get(indice).setMots(domain);
	}
	
	/**
     * Représentation textuelle de la variable de dictionnaire.
     * @return une chaîne de caractères décrivant l'indice et le domaine de la variable
     */
	public String toString() {
		return "index = " + indice + ", domaine = " + getDomain()+"}";
	}
	
	/**
     * Récupère la grille de contraintes associée à cette variable.
     * @return la grille de contraintes
     */
	public GrilleContrainte getGrilleContrainte() {
		return grille_contrainte;
	}
	
	 /**
     * Récupère l'indice de cette variable.
     * @return l'indice de l'emplacement du mot
     */
	public int getIndice() {
		return indice;
	}
}
