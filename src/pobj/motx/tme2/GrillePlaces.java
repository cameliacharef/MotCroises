package pobj.motx.tme2;

import java.util.ArrayList;
import java.util.List;
import pobj.motx.tme1.*;

public class GrillePlaces {
	private List<Emplacement> places = new ArrayList<Emplacement>();
	private Grille grille;
	
	public GrillePlaces (Grille grille) {
		this.grille = grille;
		for(int i = 0; i < grille.nbLig(); i++) {
			List<Case> lig = getLig(i);
			cherchePlaces(lig);
		}
		for(int j = 0; j < grille.nbCol(); j++) {
			List<Case> col = getCol(j);
			cherchePlaces(col);
		}
	}	
	
	public List<Emplacement> getPlaces(){
		return places;
	}
	
	public int getNbHorizontal() {
		int res = 0;
		for(Emplacement e : places)
			if(e.getCase(0).getLig() == e.getCase(1).getLig())
				res++;
		return res;
	}
	
	@Override public String toString() {
		String s = "";
		for(Emplacement e : places)
			s += e + "\n";
		return s;
	}
	
	
	private List<Case> getLig(int lig){
		List<Case> res = new ArrayList<Case>();
		for(int j = 0; j < grille.nbCol(); j++)
			res.add(grille.getCase(lig, j));
		return res;
	}
	
	private List<Case> getCol(int col){
		List<Case> res = new ArrayList<Case>();
		for(int i = 0; i < grille.nbLig(); i++)
			res.add(grille.getCase(i, col));
		return res;
	}
	private void cherchePlaces(List<Case> cases) {
		Emplacement e = new Emplacement();
		for(Case c : cases) {
			if(!c.isPleine())
				e.add(c);
			else{
				if(e.size() >= 2)	
					places.add(e);
				e = new Emplacement();
			}
		}
		if (e.size() >= 2) {
	        places.add(e);
	    }
	}
}
