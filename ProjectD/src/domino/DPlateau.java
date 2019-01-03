package domino;

import basic.Carre;
import basic.Plateau;

public class DPlateau extends Plateau {

	boolean check(DCarre c, int x) {
		return check(c, x, 0);
	}

	void put(Domino d, int x1, int y1, int x2, int y2) {
		put(d.getCarre1(), x1, y1);
		put(d.getCarre2(), x2, y2);
	}

	void put(Domino d, int x1, int x2) {
		put(d, x1, 0, x2, 0);
	}

	public DPlateau(int x, int y, Domino d) {
		super(new Carre[x][y]);
		carres[x / 2][y / 2] = d.getCarre1();
		carres[x / 2 + 1][y / 2] = d.getCarre2();
	}

	public DPlateau(int x, Domino d) {
		super(new Carre[x][1]);
		carres[x / 2][0] = d.getCarre1();
		carres[x / 2 + 1][0] = d.getCarre2();
	}

	public boolean poser2D(Domino d, int x, int y, int x1, int y1) {
		if (!this.check(d, x, y, x1, y1))
			return false;
		put(d, x, y, x1, y1);
		return true;
	}

	boolean check(Domino d, int x1, int y1, int x2, int y2) {
		return (hasVoisin(x1, y1) || hasVoisin(x2, y2)) && (check(d.getCarre1(), x1, y1))
				&& (check(d.getCarre2(), x2, y2));
	}

	boolean check(Domino d, int x1, int x2) {
		return check(d, x1, 0, x2, 0);
	}

	public boolean poserAGauche(Domino d) {
		int xgauche = getXGauche();
		if (check(d, xgauche - 2, xgauche - 1))
			put(d, xgauche - 2, xgauche - 1);
		else
			return false;
		return true;
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
		for (int i = this.taille2()-1; i > 0; i--) {
			
			for (int j = 0; j < this.taille(i); j++) {
				if (this.getCarre(j, i) != null)
					System.out.print(this.getCarre(j, i).getH());
				else System.out.print(" ");
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
