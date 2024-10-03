package pobj.motx.tme3.test;

import org.junit.jupiter.api.Test;

import pobj.motx.tme1.Grille;
import pobj.motx.tme1.GrilleLoader;
import pobj.motx.tme2.Dictionnaire;
import pobj.motx.tme2.GrillePlaces;
import pobj.motx.tme3.GrilleContrainte;
import pobj.motx.tme3.adapt.*;
import pobj.motx.tme3.adapt.StratFirst;
import pobj.motx.tme3.adapt.StratMin;
import pobj.motx.tme3.csp.CSPSolver;
import pobj.motx.tme3.csp.*;

public class GrilleSolverTestStrat2 {
	@Test
	public void compareStratBasicRandom() {
	    Dictionnaire gut = Dictionnaire.loadDictionnaire("data/frgut.txt");
	    Grille gr = GrilleLoader.loadGrille("data/enonce.grl");

	    System.out.println("Comparaison des stratégies :");

	    GrillePlaces grille = new GrillePlaces(gr);
	    GrilleContrainte gp = new GrilleContrainte(grille, gut);
	    ICSP problem = new MotX(gp);
	    CSPSolver solver = new CSPSolver();

	    // Test avec StratBasic
	    solver.setChoixValeurStrat(new StratBasic());
	    long startBasic = System.currentTimeMillis();
	    solver.solve(problem);
	    long durationBasic = System.currentTimeMillis() - startBasic;
	    System.out.println("StratBasic durée : " + durationBasic + " ms");

	    // Réinitialiser le problème
	    problem = new MotX(gp);

	    // Test avec StratRandom
	    solver.setChoixValeurStrat(new StratRandom());
	    long stratRandom = System.currentTimeMillis();
	    solver.solve(problem);
	    long durationRandom = System.currentTimeMillis() - stratRandom;
	    System.out.println("StratRandom durée : " + durationRandom + " ms");

	    // Comparaison des résultats
	    if (durationBasic < durationRandom) {
	        System.out.println("StratBasic est plus rapide que stratRandom.");
	    } else {
	        System.out.println("StratRandom est plus rapide que StratBasic.");
	    }
	    
	    
	}
	
	@Test
	public void compareStratBasicFreq() {
	    Dictionnaire gut = Dictionnaire.loadDictionnaire("data/frgut.txt");
	    Grille gr = GrilleLoader.loadGrille("data/enonce.grl");

	    System.out.println("Comparaison des stratégies :");

	    GrillePlaces grille = new GrillePlaces(gr);
	    GrilleContrainte gp = new GrilleContrainte(grille, gut);
	    ICSP problem = new MotX(gp);
	    CSPSolver solver = new CSPSolver();

	    // Test avec StratBasic
	    solver.setChoixValeurStrat(new StratBasic());
	    long StratBasic = System.currentTimeMillis();
	    solver.solve(problem);
	    long durationBasic = System.currentTimeMillis() - StratBasic;
	    System.out.println("StratBasic durée : " + durationBasic + " ms");

	    // Réinitialiser le problème
	    problem = new MotX(gp);

	    // Test avec StratFreq
	    solver.setChoixValeurStrat(new StratFreq());
	    long StratFreq = System.currentTimeMillis();
	    solver.solve(problem);
	    long durationFreq = System.currentTimeMillis() - StratFreq;
	    System.out.println("StratFreq durée : " + durationFreq + " ms");

	    // Comparaison des résultats
	    if (durationBasic < durationFreq) {
	        System.out.println("StratBasic est plus rapide que StratFreq.");
	    } else {
	        System.out.println("StratFreq est plus rapide que StratBasic.");
	    }
	    
	    
	}
	@Test
	public void compareStratFreqRandom() {
	    Dictionnaire gut = Dictionnaire.loadDictionnaire("data/frgut.txt");
	    Grille gr = GrilleLoader.loadGrille("data/enonce.grl");

	    System.out.println("Comparaison des stratégies :");

	    GrillePlaces grille = new GrillePlaces(gr);
	    GrilleContrainte gp = new GrilleContrainte(grille, gut);
	    ICSP problem = new MotX(gp);
	    CSPSolver solver = new CSPSolver();

	    // Test avec StratFreq
	    solver.setChoixValeurStrat(new StratFreq());
	    long StratFreq = System.currentTimeMillis();
	    solver.solve(problem);
	    long durationFreq = System.currentTimeMillis() - StratFreq;
	    System.out.println("StratFreq durée : " + durationFreq + " ms");

	    // Réinitialiser le problème
	    problem = new MotX(gp);

	    // Test avec StratRandom
	    solver.setChoixValeurStrat(new StratRandom());
	    long StratRandom = System.currentTimeMillis();
	    solver.solve(problem);
	    long durationRandom = System.currentTimeMillis() - StratRandom;
	    System.out.println("StratRandom durée : " + durationRandom + " ms");

	    // Comparaison des résultats
	    if (durationFreq < durationRandom) {
	        System.out.println("StratFreq est plus rapide que StratRandom.");
	    } else {
	        System.out.println("StratRandom est plus rapide que StratFreq.");
	    }
	    
	    
	}
	@Test
	public void compareStratFreqMin() {
	    Dictionnaire gut = Dictionnaire.loadDictionnaire("data/frgut.txt");
	    Grille gr = GrilleLoader.loadGrille("data/enonce.grl");

	    System.out.println("Comparaison des stratégies :");

	    GrillePlaces grille = new GrillePlaces(gr);
	    GrilleContrainte gp = new GrilleContrainte(grille, gut);
	    ICSP problem = new MotX(gp);
	    CSPSolver solver = new CSPSolver();

	    // Test avec StratFreq
	    solver.setChoixValeurStrat(new StratFreq());
	    long StratFreq = System.currentTimeMillis();
	    solver.solve(problem);
	    long durationFreq = System.currentTimeMillis() - StratFreq;
	    System.out.println("StratFreq durée : " + durationFreq + " ms");

	    // Réinitialiser le problème
	    problem = new MotX(gp);

	    // Test avec StratMin
	    solver.setChoixVarStrat(new StratMin());
	    long startMin = System.currentTimeMillis();
	    solver.solve(problem);
	    long durationMin = System.currentTimeMillis() - startMin;
	    System.out.println("StratMin durée : " + durationMin + " ms");

	    // Comparaison des résultats
	    if (durationMin < durationFreq) {
	        System.out.println("StratMin est plus rapide que StratFreq.");
	    } else {
	        System.out.println("StratFreq est plus rapide que StratMin.");
	    }
	    
	    //BONJOURRRRRRRRRRRRRRRRRRRRRRRRR
	}
}
