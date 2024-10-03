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


public class GrilleSolverTest {

		@Test
		public void testEasy() {
			Dictionnaire gut = Dictionnaire.loadDictionnaire("data/frgut.txt");
			Grille gr = GrilleLoader.loadGrille("data/easy.grl");

			System.out.println("Test Easy (début) : \n" + gr);

			GrillePlaces grille = new GrillePlaces(gr);
			GrilleContrainte gp = new GrilleContrainte(grille, gut);
				
			ICSP problem = new MotX(gp);
			CSPSolver solver = new CSPSolver();

			long timestamp = System.currentTimeMillis();
			ICSP solution = solver.solve(problem);

			System.out.println("Solution \n" + solution + " \nCalculée en "+ (System.currentTimeMillis() - timestamp) +" ms " );
				
			System.out.println("Test Easy (fin) : \n" + gr);

		}
			
					
		@Test
		public void testPropage() {
			Dictionnaire gut = Dictionnaire.loadDictionnaire("data/frgut.txt");
			Grille gr = GrilleLoader.loadGrille("data/propage.grl");

			System.out.println("Test Propage (début) : \n" + gr);

			GrillePlaces grille = new GrillePlaces(gr);
			GrilleContrainte gp = new GrilleContrainte(grille, gut);
				
			ICSP problem = new MotX(gp);
			CSPSolver solver = new CSPSolver();

			long timestamp = System.currentTimeMillis();
			ICSP solution = solver.solve(problem);

			System.out.println("Solution \n" + solution + " \nCalculée en "+ (System.currentTimeMillis() - timestamp) +" ms " );
				
			System.out.println("Test Propage (fin) : \n" + gp);

		}
			
		@Test
		public void testSplit() {
			Dictionnaire gut = Dictionnaire.loadDictionnaire("data/frgut.txt");
			Grille gr = GrilleLoader.loadGrille("data/split.grl");

			System.out.println("Test Split (début) : \n" + gr);

			GrillePlaces grille = new GrillePlaces(gr);
			GrilleContrainte gp = new GrilleContrainte(grille, gut);
				
			ICSP problem = new MotX(gp);
			CSPSolver solver = new CSPSolver();
				
			long timestamp = System.currentTimeMillis();
			ICSP solution = solver.solve(problem);

			System.out.println("Solution \n" + solution + " \nCalculée en "+ (System.currentTimeMillis() - timestamp) +" ms " );
				
			System.out.println("Test Split (fin) : \n" + gr);
		}

}
