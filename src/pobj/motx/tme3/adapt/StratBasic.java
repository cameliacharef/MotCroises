package pobj.motx.tme3.adapt;

import java.util.List;

import pobj.motx.tme3.csp.ICSP;
import pobj.motx.tme3.csp.IChoixValeur;
import pobj.motx.tme3.csp.IVariable;

public class StratBasic implements IChoixValeur{
	public List<String> orderValues (ICSP problem, IVariable v){
		return v.getDomain();
	}

}
