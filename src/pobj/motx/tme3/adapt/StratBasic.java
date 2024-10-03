package pobj.motx.tme3.adapt;

import java.util.List;

import pobj.motx.tme3.csp.ICSP;
import pobj.motx.tme3.csp.IChoixValeur;
import pobj.motx.tme3.csp.IVariable;

/**
 * Classe de stratégie de choix de valeur de base.
 * Cette stratégie retourne simplement le domaine des valeurs
 * d'une variable sans effectuer de tri ou de modification.
 */
public class StratBasic implements IChoixValeur{
	/**
     * Retourne les valeurs du domaine d'une variable sans modification.
     * @param problem le problème de CSP (non utilisé ici mais peut être pertinent dans d'autres contextes)
     * @param v la variable dont les valeurs doivent être retournées
     * @return la liste des valeurs du domaine de la variable
     */
	public List<String> orderValues (ICSP problem, IVariable v){
		return v.getDomain();
	}

}
