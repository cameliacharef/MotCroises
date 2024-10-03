package pobj.motx.tme3.csp;

import java.util.List;

/**
 * Cette interface permet de trier les valeurs d'un ICSP problem (en fonction de la stratégie de résolution adoptée)
 */

public interface IChoixValeur {
	/**
	 * Permet de trier les variable de v du problème problem
	 * @param problem
	 * @param v
	 * @return le domaine trié (en fonction de la stratégie adoptée)
	 */
	public List<String> orderValues (ICSP problem, IVariable v);
}
