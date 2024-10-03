package pobj.motx.tme3.adapt;

import java.util.List;

import pobj.motx.tme3.csp.ICSP;
import pobj.motx.tme3.csp.IChoixVar;
import pobj.motx.tme3.csp.IVariable;

/**
 * Classe de stratégie de choix de variable pour la résolution de CSP.
 * Cette stratégie choisit la variable avec le domaine le plus petit (Minimum Remaining Values).
 */
public class StratMin implements IChoixVar{
	
	 /**
     * Choisit la variable ayant le plus petit domaine parmi celles disponibles dans le problème CSP.
     * @param problem le problème de CSP dont les variables doivent être choisies
     * @return la variable avec le domaine le plus petit
     */
	public IVariable chooseVar(ICSP problem) {
		List<IVariable> vars = problem.getVars();
		List<String> min = vars.get(0).getDomain();
		
		int indice_min = 0;
		
		 // Parcourir toutes les variables pour trouver celle avec le domaine le plus petit
		for(int i = 0; i < vars.size(); i++) {
			List<String> current = vars.get(i).getDomain();
			 // Vérifier si le domaine actuel est plus petit que le domaine minimum enregistré
			if(current.size() < min.size()) {
				min = current;
				indice_min = i;
			}
		}
		return vars.get(indice_min);
	}

}
