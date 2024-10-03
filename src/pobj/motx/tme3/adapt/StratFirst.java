package pobj.motx.tme3.adapt;

import pobj.motx.tme3.csp.*;

/**
 * Classe de stratégie de choix de variable pour la résolution de CSP.
 * Cette stratégie choisit simplement la première variable disponible.
 */
public class StratFirst implements IChoixVar{
	/**
     * Choisit la première variable parmi celles disponibles dans le problème CSP.
     * @param problem le problème de CSP dont les variables doivent être choisies
     * @return la première variable disponible
     */
	public IVariable chooseVar(ICSP problem) {
		return problem.getVars().get(0);
	}
}
