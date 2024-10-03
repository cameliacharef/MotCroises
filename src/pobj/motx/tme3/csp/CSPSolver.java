package pobj.motx.tme3.csp;

import java.util.List;

/**
 * Cette classe résout un ICSP problème
 */

public class CSPSolver {
	// BONUS
	/** Sert à choisir le type de statégie de résolution pour la variable */
	private IChoixVar stratVar;
	/** Sert à choisir le type de statégie de résolution pour la valeur */
	private IChoixValeur stratVal;
	
	/**
     * Constructeur de la classe DicoVariable.
     * @param index indice de l'emplacement du mot
     * @param gp la grille de contraintes associée à cette variable
     */
	public ICSP solve(ICSP problem) {
		System.out.println("Solve : \n" + problem);
		// Condition terminale : succès
		if (problem.getVars().isEmpty()) {
			System.out.println("Problème résolu.");
			return problem;
		}
		// condition terminale : échec sur cette branche
		if (!problem.isConsistent()) {
			System.out.println("Problème invalide.");
			return problem;
		} else {
			System.out.println("Problème valide.");
		}
		// On choisit une variable arbitraire, ici la première
		// On est garantis que ! getVars().isEmpty(), testé au dessus
		
		//=======================BONUS============================
		IVariable vi = problem.getVars().get(0); // Valeur par défaut si stratVal == null
		if(stratVar != null) {
			vi = stratVar.chooseVar(problem);
		}
		if (stratVal != null) {
			List<String> new_domain = stratVal.orderValues(problem, vi); 
			vi.setDomain(new_domain);
		}
		
		//==========================================================

		ICSP next = null;
		// On est garantis que toute variable a un domaine non nul
		for (String val : vi.getDomain()) {
			System.out.println("Fixe var :" + vi + " à " + val);
			next = problem.assign(vi, val);
			next = solve(next);
			if (next.isConsistent()) {
				return next;
			} else {
				System.out.println("Essai valeur suivante.");
			}
		}
		System.out.println("Backtrack sur variable "+ vi);
		return next;
	}
	
	// BONUS
	
	/**
	 * Définit le type de stratégie pour la variable
	 * @param strat
	 */
	public void setChoixVarStrat(IChoixVar strat) {
		stratVar = strat;
	}
	
	/**
	 * Définit le stype de stratégie pour la valeur
	 * @param strat
	 */
	public void setChoixValeurStrat(IChoixValeur strat) {
		stratVal = strat;
	}


}
