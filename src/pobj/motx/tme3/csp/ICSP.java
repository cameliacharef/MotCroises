package pobj.motx.tme3.csp;

import java.util.List;

/**
 * Cette interface définit une CSP 
 */
public interface ICSP {
	/**
	 * Donne la liste des variables du problème
	 * @return la liste des variables du problème
	 */
	public List<IVariable> getVars();
	
	/**
	 * Indique si le problème est satisfiable
	 * @return true si le problème est satisfiable, false sinon
	 */
	public boolean isConsistent();
	
	/**
	 * retire la valeur val du problème de vi et retourne 
	 * @param vi
	 * @param val
	 * @return le problèmme de vi avec val en moins
	 */
	public ICSP assign(IVariable vi, String val);
}
