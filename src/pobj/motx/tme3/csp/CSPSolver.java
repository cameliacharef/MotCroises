package pobj.motx.tme3.csp;

import java.util.List;

import pobj.motx.tme3.*;

public class CSPSolver {
	// BONUS
	private IChoixVar stratVar;
	private IChoixValeur stratVal;

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
		IVariable vi = null;
		if(stratVar != null) {
			vi = stratVar.chooseVar(problem);
		}
		if (stratVal != null) {
			List<String> new_domain = stratVal.orderValues(problem, vi); 
			vi.setDomain(new_domain);
		}
		else {
			vi = problem.getVars().get(0);
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
	
	public void setChoixVarStrat(IChoixVar strat) {
		stratVar = strat;
	}
	
	public void setChoixValeurStrat(IChoixValeur strat) {
		stratVal = strat;
	}


}
