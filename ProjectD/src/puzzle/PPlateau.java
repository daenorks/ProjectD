package puzzle;

import basic.Carte;
import basic.Plateau;

public class PPlateau extends Plateau {

	private PPiece[][] plateau_final;

	public PPlateau(int x, int y) {
		super(x, y);
		this.plateau_final = new PPiece[x][y];
		plateau_final = remplir();
		remplir_main();
	}

	@Override
	public boolean poser(Carte carte, int x, int y) {
		if (plateau[x][y] != null)
			return false;
		put(carte, x, y);
		actuel.remove(c);
		return true;
	}

	public boolean retirer(int x, int y) {
		if ((x<0 || y<0) || (x>=plateau.length || y>=plateau[0].length)) 
			return false;
		if (plateau[x][y] == null)
			return false;
		else {
			Carte c = plateau[x][y];
			plateau[x][y]=null;
			actuel.add(c);
		}
	}

	private boolean check(int x, int y) {
		return (carres[x][y].getH()==plateau_final[x][y].getH());
	}

	public boolean check_victoire() {
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < y.length; j++) {
				if (!check(i,j))
					return false;
			}
		}
		return true;
	}
	
	public void remplir() {
		/*
		 * Mettre les indices de pieces dans l-ordre pour remplir plateau_final
		 * 
		 * 
		 */
	}
	
	public void remplir_main() {
		// rempli la main dans le desordre
	}

}
