package pobj.motx.tme1;

public class Grille {
	private Case[][] matrice;
	
	public Grille(int hauteur, int largeur) {
		matrice = new Case[hauteur][largeur];
		for(int i = 0; i < matrice.length; i++) {
			for(int j = 0; j < matrice[i].length; j++) {
				matrice[i][j] = new Case(i, j, ' ');
			}
		}
	}
	
	public Case getCase(int lig, int col) {
		return matrice[lig][col];
	}
	
	public String toString() {
		return pobj.motx.tme1.GrilleLoader.serialize(this, false);
	}
	
	public int nbLig() {
		return matrice.length;
	}
	
	public int nbCol() {
		return matrice[0].length;
	}
	
	public Grille copy() {
		Grille g = new Grille(this.matrice.length, this.matrice[0].length);
		for(int i = 0; i < g.matrice.length; i++) {
			for(int j = 0; j < g.matrice[i].length; j++) {
				g.matrice[i][j] = new Case(i, j, this.matrice[i][j].getChar());
			}
		}
		return g;
	}
	
	
}
