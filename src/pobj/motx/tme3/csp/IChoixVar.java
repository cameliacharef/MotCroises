package pobj.motx.tme3.csp;

/**
 * Cette interface permet de choisir les variables d'un ICSP problem
 */
public interface IChoixVar {
	/**
	 * Choisit une IVariable du problème ICSP problem
	 * @param problem
	 * @return la variable
	 */
	public IVariable chooseVar(ICSP problem);
}
