package pobj.motx.tme3.test;

import org.junit.jupiter.api.Test;

import pobj.motx.tme1.Grille;
import pobj.motx.tme1.GrilleLoader;
import pobj.motx.tme2.Dictionnaire;
import pobj.motx.tme2.GrillePlaces;
import pobj.motx.tme3.GrilleContrainte;
import pobj.motx.tme3.adapt.MotX;
import pobj.motx.tme3.csp.CSPSolver;
import pobj.motx.tme3.csp.ICSP;

public class GrilleSolverTestEnonce {
	@Test
	public void testEnoncer() {
		Dictionnaire gut = Dictionnaire.loadDictionnaire("data/frgut.txt");
		Grille gr = GrilleLoader.loadGrille("data/enonce.grl");

		System.out.println("Test Enoncer (début) : \n" + gr);

		GrillePlaces grille = new GrillePlaces(gr);
		GrilleContrainte gp = new GrilleContrainte(grille, gut);
			
		ICSP problem = new MotX(gp);
		CSPSolver solver = new CSPSolver();

		long timestamp = System.currentTimeMillis();
		ICSP solution = solver.solve(problem);

		System.out.println("Solution \n" + solution + " \nCalculée en "+ (System.currentTimeMillis() - timestamp) +" ms " );
			
		System.out.println("Test Enoncer (fin) : \n" + gr);

	}

}
