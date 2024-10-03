package pobj.motx.tme3.adapt;

import java.util.*;
import java.util.List;

import pobj.motx.tme3.csp.ICSP;
import pobj.motx.tme3.csp.IChoixValeur;
import pobj.motx.tme3.csp.IVariable;

/**
 * Classe de stratégie de choix de valeur basée sur la fréquence des lettres.
 * Cette stratégie ordonne les mots du domaine d'une variable en fonction 
 * d'un score basé sur la fréquence des lettres.
 */
public class StratFreq implements IChoixValeur {
	// Tableau des scores de chaque lettre basé sur leur fréquence
	private static int[] letterFrequencies = new int[26];
	
	static {	
	// Scores de chaque lettre basée sur leur fréquence 
	letterFrequencies['E' - 'A'] = 1; 
	letterFrequencies['A' - 'A'] = 1; 
	letterFrequencies['I' - 'A'] = 1; 
	letterFrequencies['N' - 'A'] = 1; 
	letterFrequencies['O' - 'A'] = 1; 
	letterFrequencies['R' - 'A'] = 1;
	letterFrequencies['S' - 'A'] = 1; 
	letterFrequencies['T' - 'A'] = 1; 
	letterFrequencies['U' - 'A'] = 1; 
	letterFrequencies['L' - 'A'] = 1; 
	letterFrequencies['D' - 'A'] = 2; 
	letterFrequencies['M' - 'A'] = 2; 
	letterFrequencies['G' - 'A'] = 2; 
	letterFrequencies['B' - 'A'] = 3; 
	letterFrequencies['C' - 'A'] = 3; 
	letterFrequencies['P' - 'A'] = 3; 
	letterFrequencies['F' - 'A'] = 4; 
	letterFrequencies['H' - 'A'] = 4; 
	letterFrequencies['V' - 'A'] = 4; 
	letterFrequencies['J' - 'A'] = 8; 
	letterFrequencies['Q' - 'A'] = 8; 
	letterFrequencies['K' - 'A'] = 10; 
	letterFrequencies['W' - 'A'] = 10; 
	letterFrequencies['X' - 'A'] = 10; 
	letterFrequencies['Y' - 'A'] = 10; 
	letterFrequencies['Z' - 'A'] = 10;
}	
	 /**
     * Calcule le score d'un mot en additionnant les scores de chaque lettre.
     * @param mot le mot pour lequel le score doit être calculé
     * @return le score total du mot
     */
	private int getScore(String mot) {
		int score = 0;
		for(int i = 0; i < mot.length(); i++) {
			String MOT = mot.toUpperCase();
			char l = MOT.charAt(i);
			score = score + letterFrequencies[l - 'A'];	
		}
		return score ;
	}
	
	/**
     * Ordre les valeurs du domaine d'une variable en fonction de leur score,
     * en utilisant une méthode de tri par insertion.
     * @param problem le problème de CSP (non utilisé ici mais peut être pertinent dans d'autres contextes)
     * @param v la variable dont les valeurs doivent être ordonnées
     * @return une liste de mots du domaine, triée par score
     */
	public List<String> orderValues (ICSP problem, IVariable v){
		List<String> liste = v.getDomain();
		for(int i = 0; i < liste.size(); i++) {
			String mot = liste.get(i);
			int score_i = getScore(mot); // Calculer le score du mot
			int j = i -1;
			
			// Déplacer les mots de la liste pour insérer le mot courant à sa position
			while(j >= 0 && getScore(liste.get(j)) > score_i){
				liste.set(j + 1,  liste.get(j)); // Déplacer le mot vers la droite
				j--;
			}
			liste.set(j +1, mot);
		}
		return liste;
	}
	

}
