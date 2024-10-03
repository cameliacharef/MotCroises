package pobj.motx.tme3.test;

import org.junit.jupiter.api.Test;

import pobj.motx.tme1.*;
import pobj.motx.tme2.*;
import pobj.motx.tme3.*;
import pobj.motx.tme3.csp.*;
import pobj.motx.tme3.adapt.*;

public class GrilleSolverTestStrat {
	@Test
	public void compareStrategiesEnonce() {
	    Dictionnaire gut = Dictionnaire.loadDictionnaire("data/frgut.txt");
	    Grille gr = GrilleLoader.loadGrille("data/enonce.grl");

	    System.out.println("Comparaison des stratégies :");

	    GrillePlaces grille = new GrillePlaces(gr);
	    GrilleContrainte gp = new GrilleContrainte(grille, gut);
	    ICSP problem = new MotX(gp);
	    CSPSolver solver = new CSPSolver();

	    // Test avec StratFirst
	    solver.setChoixVarStrat(new StratFirst());
	    long startFirst = System.currentTimeMillis();
	    solver.solve(problem);
	    long durationFirst = System.currentTimeMillis() - startFirst;
	    System.out.println("StratFirst durée : " + durationFirst + " ms");

	    // Réinitialiser le problème
	    problem = new MotX(gp);

	    // Test avec StratMin
	    solver.setChoixVarStrat(new StratMin());
	    long startMin = System.currentTimeMillis();
	    solver.solve(problem);
	    long durationMin = System.currentTimeMillis() - startMin;
	    System.out.println("StratMin durée : " + durationMin + " ms");

	    // Comparaison des résultats
	    if (durationMin < durationFirst) {
	        System.out.println("StratMin est plus rapide que StratFirst.");
	    } else {
	        System.out.println("StratFirst est plus rapide que StratMin.");
	    }
	    
	    
	}
	@Test
	public void compareStrategiesHard() {
	    Dictionnaire gut = Dictionnaire.loadDictionnaire("data/frgut.txt");
	    Grille gr = GrilleLoader.loadGrille("data/hard.grl");

	    System.out.println("Comparaison des stratégies :");

	    GrillePlaces grille = new GrillePlaces(gr);
	    GrilleContrainte gp = new GrilleContrainte(grille, gut);
	    ICSP problem = new MotX(gp);
	    CSPSolver solver = new CSPSolver();

	    // Test avec StratFirst
	    solver.setChoixVarStrat(new StratFirst());
	    long startFirst = System.currentTimeMillis();
	    solver.solve(problem);
	    long durationFirst = System.currentTimeMillis() - startFirst;
	    System.out.println("StratFirst durée : " + durationFirst + " ms");

	    // Réinitialiser le problème
	    problem = new MotX(gp);

	    // Test avec StratMin
	    solver.setChoixVarStrat(new StratMin());
	    long startMin = System.currentTimeMillis();
	    solver.solve(problem);
	    long durationMin = System.currentTimeMillis() - startMin;
	    System.out.println("StratMin durée : " + durationMin + " ms");

	    // Comparaison des résultats
	    if (durationMin < durationFirst) {
	        System.out.println("StratMin est plus rapide que StratFirst.");
	    } else {
	        System.out.println("StratFirst est plus rapide que StratMin.");
	    }
	}
}
