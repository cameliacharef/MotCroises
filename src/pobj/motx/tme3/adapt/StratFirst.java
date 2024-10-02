package pobj.motx.tme3.adapt;

import pobj.motx.tme3.csp.*;

public class StratFirst implements IChoixVar{
	public IVariable chooseVar(ICSP problem) {
		return problem.getVars().get(0);
	}
}
