package pobj.motx.tme3.csp;

import java.util.ArrayList;
import java.util.List;

import pobj.motx.tme2.*;

public class CroixContrainte implements IContrainte {
	
	private int m1, c1, m2, c2;
	
	public CroixContrainte(int m1, int c1, int m2, int c2) {
		this.m1 = m1;
		this.c1 = c1;
		this.m2 = m2;
		this.c2 = c2;
	}
	private List<Character> ensemble(int m, int c, List<Dictionnaire> liste_dico){
		Dictionnaire motsPot = liste_dico.get(m);
		List<Character> ensemble = new ArrayList<Character>();
		for(int i = 0; i < motsPot.size(); i++) {
			String mot = motsPot.get(i);
			ensemble.add(mot.charAt(c));
		}
		return ensemble;
	}
	public int reduce(GrillePotentiel grille){
		
		List<Dictionnaire> liste_dico = grille.getMotsPot();
		
		// Ensemble des lettres l1
		List<Character> l1 = ensemble(m1, c1, liste_dico);

		// Ensemble des lettres l1
		List<Character> l2 = ensemble(m2, c2, liste_dico);
		
		// Ensemble des lettres l1 INTER l2
		List<Character> s = new ArrayList<>(l1);
		s.retainAll(l2);
		
		//
		Dictionnaire motsPot1 = liste_dico.get(m1);
		int nb_mots_filtre = 0;
		if(l1.size() > s.size()) {
			for(Character c_s : s) {
				nb_mots_filtre += motsPot1.filtreParLettre(c_s, c1); 
			}
		}
		//
		Dictionnaire motsPot2 = liste_dico.get(m2);
		if(l2.size() > s.size()) {
			for(Character c_s : s) {
				nb_mots_filtre += motsPot2.filtreParLettre(c_s, c2); 
			}
		}
		
		return nb_mots_filtre;
		
		
		
		
	}
}
