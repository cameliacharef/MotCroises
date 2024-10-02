package pobj.motx.tme3;
import java.util.HashSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import pobj.motx.tme2.*;

public class CroixContrainte implements IContrainte {
	
	private int m1, c1, m2, c2;
	
	public CroixContrainte(int m1, int c1, int m2, int c2) {
		this.m1 = m1;
		this.c1 = c1;
		this.m2 = m2;
		this.c2 = c2;
	}

	private Set<Character> ensemble(int m, int c, List<Dictionnaire> liste_dico){
		Dictionnaire motsPot = liste_dico.get(m);
		Set<Character> ensemble = new HashSet<Character>();
		for(int i = 0; i < motsPot.size(); i++) {
			String mot = motsPot.get(i);
			ensemble.add(mot.charAt(c));
		}
		return ensemble;
	}
	
	 public int reduce(GrillePotentiel grille) {
	        Dictionnaire d1 = grille.getMotsPot().get(m1);
	        Dictionnaire d2 = grille.getMotsPot().get(m2);
	        
	        List<Dictionnaire> liste_dico = grille.getMotsPot();
			
			// Ensemble des lettres l1
			 Set<Character> l1 = ensemble(m1, c1, liste_dico);
	
			// Ensemble des lettres l
			 Set<Character> l2 = ensemble(m2, c2, liste_dico);
	       

	        // intersection L1 ET L2
	        Set<Character> intersection = new HashSet<>(l1);
	        intersection.retainAll(l2);

	        int nbReduce = 0;

	        // Si l'ensemble l1 est plus grand que l'intersection, filtrer d1
	        if (l1.size() > intersection.size()) {
	            nbReduce += filtreParEnsembleLettre(d1, intersection, c1);
	        }

	        // Si l'ensemble l2 est plus grand que l'intersection, filtrer d2
	        if (l2.size() > intersection.size()) {
	            nbReduce += filtreParEnsembleLettre(d2, intersection, c2);
	        }

	        return nbReduce;
	    }
	    

	    // Méthode pour filtrer les mots dans un dictionnaire selon un ensemble de lettres à l'index donné
	    private int filtreParEnsembleLettre(Dictionnaire d, Set<Character> lettresPossibles, int index) {
	        List<String> mots = d.getMots();  // Récupérer les mots
	        List<String> motsFiltrés = new ArrayList<>();  // Créer une nouvelle liste pour stocker les mots filtrés
	        int nbFiltres = 0;

	        for (String mot : mots) {
	            if (lettresPossibles.contains(mot.charAt(index))) {
	                motsFiltrés.add(mot);  // Ajouter le mot à la liste filtrée s'il satisfait la contrainte
	            } else {
	                nbFiltres++;  // Incrémenter le compteur de mots filtrés
	            }
	        }

	        // Mettre à jour la liste des mots du dictionnaire avec la liste filtrée
	        d.setMots(motsFiltrés);

	        return nbFiltres;
	    }

	

	public boolean equals(Object other) {
		if (other == this) return true;
		if(!( other instanceof CroixContrainte)) return false;
		CroixContrainte c = (CroixContrainte) other;
		return c.m1 == m1 && c.m2 == m2 && c.c1 == c1 && c.c2 == c2;
	}
}
