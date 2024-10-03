package pobj.motx.tme3.adapt;

import java.util.*;
import java.util.List;

import pobj.motx.tme3.csp.ICSP;
import pobj.motx.tme3.csp.IChoixValeur;
import pobj.motx.tme3.csp.IVariable;

public class StratRandom implements IChoixValeur{
	
	public List<String> orderValues (ICSP problem, IVariable v){
		List<String> l = v.getDomain();
		Collections.shuffle(l);
		return l;
	}
	

}
