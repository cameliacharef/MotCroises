package pobj.motx.tme1;

import java.util.ArrayList;

public class Emplacement {
	private ArrayList<Case> cases = new ArrayList<Case>();
	
	public Emplacement() {}
	
	public void add(Case e) {
		cases.add(e);
	}
}
