package pobj.motx.tme3.adapt;

import java.util.*;
import java.util.List;

import pobj.motx.tme3.csp.ICSP;
import pobj.motx.tme3.csp.IChoixValeur;
import pobj.motx.tme3.csp.IVariable;

/**
 * Classe de stratégie de choix de valeur pour la résolution de CSP.
 * Cette stratégie choisit les valeurs d'une variable de manière aléatoire.
 */
public class StratRandom implements IChoixValeur{
	
	/**
     * Ordre les valeurs du domaine d'une variable de manière aléatoire.
     * @param problem le problème de CSP (non utilisé ici mais peut être pertinent dans d'autres contextes)
     * @param v la variable dont les valeurs doivent être ordonnées
     * @return une liste de valeurs du domaine, mélangées aléatoirement
     */
	public List<String> orderValues (ICSP problem, IVariable v){
		List<String> l = v.getDomain();
		Collections.shuffle(l);  // Mélanger les valeurs du domaine
		return l;
	}
	

}
