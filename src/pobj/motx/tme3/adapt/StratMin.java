package pobj.motx.tme3.adapt;

import java.util.List;

import pobj.motx.tme3.csp.ICSP;
import pobj.motx.tme3.csp.IChoixVar;
import pobj.motx.tme3.csp.IVariable;

public class StratMin implements IChoixVar{
	
	public IVariable chooseVar(ICSP problem) {
		List<IVariable> vars = problem.getVars();
		List<String> min = vars.get(0).getDomain();
		
		int indice_min = 0;
		for(int i = 0; i < vars.size(); i++) {
			List<String> current = vars.get(i).getDomain();
			
			if(current.size() < min.size()) {
				min = current;
				indice_min = i;
			}
		}
		return vars.get(indice_min);
	}

}
