package domino;

import basic.Carre;
import basic.Carte;
import basic.Plateau;

public class DPlateau extends Plateau {

	boolean check(DCarre c, int x) {
		return check(c, x, 0);
	}
	
	public boolean poser(Carte carte, int side , int x, int y) {
		Domino d = (Domino) carte;
		side = side % 4;
		switch (side) {
		case 0 : return poser(d, x, y, x + 1, y);
		case 1 : return poser(d, x, y, x, y - 1);
		case 2 : return poser(d, x, y, x - 1, y);
		case 3 : return poser(d, x, y, x, y + 1);
		default : return false;
		}
	}
	
	boolean poser(Domino d, int x1, int y1, int x2, int y2) {
		if (check(d, x1, y1, x2, y2)) {
			put(d, x1, y1, x2, y2);
			return true;
		}
		return false;
	}
	void put(Domino d, int x1, int y1, int x2, int y2) {
		put(d.getCarre1(), x1, y1);
		put(d.getCarre2(), x2, y2);
	}
	
	void put(Domino d, int x1, int x2) {
		put(d, x1, 0, x2, 0);
	}

	public DPlateau (int x, int y, Domino d) {
		super(new Carre[x][y]);
		carres[x/2][y/2] = d.getCarre1();
		carres[x/2+1][y/2] = d.getCarre2();
	}
	
	public DPlateau(int x, Domino d) {
		super(new Carre[x][1]);
		carres[x/2][0] = d.getCarre1();
		carres[x/2 + 1][0] = d.getCarre2();
	}

	boolean check(Domino d, int x1, int y1, int x2, int y2) {
		return (hasVoisin(x1, y1) || hasVoisin(x2, y2))
				&& (check(d.getCarre1(), x1, y1))
				&& (check(d.getCarre2(), x2, y2));
	}
	
	boolean check(Domino d, int x1, int x2) {
		return check(d, x1, 0, x2, 0);
	}

	public boolean poserAGauche(Domino d) {
		int xgauche = getXGauche();
		if (check(d, xgauche - 2, xgauche - 1)) put(d, xgauche - 2, xgauche - 1);
		else return false;
		return true;
	}

	public boolean poserADroite(Domino d) {
		int xdroite = getXDroite();
		if (check(d, xdroite + 1, xdroite + 2)) put(d, xdroite + 1, xdroite + 2);
		else return false;
		return true;
	}

	public void afficher_vueclassique() {
		int i = getXGauche();
		while (i < getXDroite()) {
			System.out.print("[" + (this.getCarre(i,0)).getH() + "|" + this.getCarre(i+1,0).getH() + "]");
			i += 2;
		}
	}

	public int getXGauche() {
		int xgauche = 0;
		while (xgauche < carres.length && carres[xgauche][0] == null)
			xgauche++;
		if (xgauche >= carres.length)
			return -1; //Error
		return xgauche;
	}

	public int getXDroite() {
		int xdroite = carres.length-1;
		while (xdroite >= 0 && carres[xdroite][0] == null)
			xdroite--;
		if (xdroite < 0)
			return -1; //Error
		return xdroite;
	}
}
