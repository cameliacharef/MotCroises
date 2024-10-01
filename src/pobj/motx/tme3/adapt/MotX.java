package pobj.motx.tme3.adapt;

import java.util.ArrayList;
import java.util.List;

import pobj.motx.tme3.*;
import pobj.motx.tme3.csp.*;


public class MotX implements ICSP{
	private List<IVariable> dicoV;
	private GrilleContrainte gc ;
	
	public MotX(GrilleContrainte gc) {
		dicoV = new ArrayList<DicoVariable>();
		this.gc = gc;
	}
	
	
	public List<IVariable> getVars(){
		return dicoV;
	}
	public boolean isConsistent() {}
	public ICSP assign(IVariable vi, String val) {}
}
