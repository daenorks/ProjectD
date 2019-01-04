package domLine;

import basic.Carre;
import basic.Carte;
import basic.Plateau;
import domino2d.DCarre;
import domino2d.DPlateau;
import domino2d.Domino;

public class DLPlateau extends DPlateau {

	public DLPlateau(int x, Domino d) {
		super(x, 1, d);
	}

	public boolean poserAGauche(Domino d) {
		int xgauche = getXGauche();
		if (check(d, xgauche - 2, xgauche - 1))
			put(d, xgauche - 2, xgauche - 1);
		else
			return false;
		return true;
	}

	private void put(Domino d, int x1, int x2) {
		put(d, x1, 0, x2, 0);
	}

	public boolean poserADroite(Domino d) {
		int xdroite = getXDroite();
		if (check(d, xdroite + 1, xdroite + 2))
			put(d, xdroite + 1, xdroite + 2);
		else
			return false;
		return true;
	}

	public void afficher_vueclassique() {
		int i = getXGauche();
		while (i < getXDroite()) {
			System.out.print("[" + (this.getCarre(i, 0)).getH() + "|" + this.getCarre(i + 1, 0).getH() + "]");
			i += 2;
		}
	}

	public void afficher_vueclassique2() {
		for (int i = this.taille2() - 1; i > 0; i--) {

			for (int j = 0; j < this.taille(i); j++) {
				if (this.getCarre(j, i) != null)
					System.out.print(this.getCarre(j, i).getH());
				else
					System.out.print(" ");
			}
			System.out.print("\n");
		}
	}

	public int getXGauche() {
		int xgauche = 0;
		while (xgauche < carres.length && carres[xgauche][0] == null)
			xgauche++;
		if (xgauche >= carres.length)
			return -1; // Error
		return xgauche;
	}

	public int getXDroite() {
		int xdroite = carres.length - 1;
		while (xdroite >= 0 && carres[xdroite][0] == null)
			xdroite--;
		if (xdroite < 0)
			return -1; // Error
		return xdroite;
	}

}
