package pobj.motx.tme3.csp;

import java.util.List;

/**
 * Cette interface représente une variable d'un problème
 */

public interface IVariable {
	/**
	 * Renvoie les valeurs d'une variable d'un problème
	 * @return le domaine de la IVAriable
	 */
	public List<String> getDomain();
	
	/**
	 * Modifie le domaine
	 * @param domain
	 */
	public void setDomain(List<String> domain);
}
