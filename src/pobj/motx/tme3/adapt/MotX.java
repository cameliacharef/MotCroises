package pobj.motx.tme3.adapt;

import java.util.ArrayList;
import java.util.List;

import pobj.motx.tme1.*;
import pobj.motx.tme3.*;
import pobj.motx.tme3.csp.*;


public class MotX implements ICSP{
	//
	private List<IVariable> dicoV;
	private GrilleContrainte gc ;
	
	public MotX(GrilleContrainte gc) {
		dicoV = new ArrayList<IVariable>();
		this.gc = gc;
		
		//on cherche emplacement grille ou au moins une case est vide
		List<Emplacement> liste_emplacement = this.gc.getGrillePlaces().getPlaces();
		for(int i = 0; i < liste_emplacement.size(); i++) {
			if (liste_emplacement.get(i).hasCaseVide()) {
				DicoVariable dv = new DicoVariable(i, this.gc); 
				dicoV.add(dv);
			}
		}
	}
	
	public List<IVariable> getVars(){
		return dicoV;
	}
	public boolean isConsistent() {
		if(dicoV.isEmpty()) return true;
		if(gc.isDead()) return false;
		
		return true;
	}
	public ICSP assign(IVariable vi, String val) {
		//MotX mx = new MotX(gc);
		MotX mx = null;
		if(vi instanceof DicoVariable) {
			DicoVariable d = (DicoVariable) vi;
			GrilleContrainte nv_gc = d.getGrilleContrainte().fixer(d.getIndice(), val);
			mx = new MotX(nv_gc);
		}
		
		return mx;
	}
}
