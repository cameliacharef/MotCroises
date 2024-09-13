package pobj.motx.tme1;
	
public class Case {
	private int ligne;
	private int colonne;
	private char valeur;
	
	public Case(int lig, int col, char c) {
		ligne=lig;
		colonne=col;
		valeur=c;
	}
	public int getLig(){
		return ligne;
	}
	public int getCol(){
		return colonne;
	}
	public char getChar(){
		return valeur;
	}
	public void setChar(char c){
		valeur = c;
	}
	public boolean isVide() {
		return valeur == ' ';
	}
	public boolean isPleine() {
		return valeur == '*';
	}
	
}
