package domino2d;

import basic.Carre;
import basic.Carte;
import basic.Plateau;

public class DPlateau extends Plateau {

	boolean check(DCarre c, int x) {
		return check(c, x, 0);
	}

	@Override
	public boolean poser(Carte carte, int x, int y) {
		Domino d = (Domino) carte;
		switch (carte.getSide()) {
		case 0:
			return poser(d, x, y, x + 1, y);
		case 1:
			return poser(d, x, y, x, y + 1);
		case 2:
			return poser(d, x + 1, y, x, y);
		case 3:
			return poser(d, x, y + 1, x, y);
		default:
			return false;
		}
	}

	boolean poser(Domino d, int x1, int y1, int x2, int y2) {
		if (check(d, x1, y1, x2, y2)) {
			put(d, x1, y1, x2, y2);
			return true;
		}
		return false;
	}

	protected void put(Domino d, int x1, int y1, int x2, int y2) {
		put(d.getCarre1(), x1, y1);
		put(d.getCarre2(), x2, y2);
	}

	public DPlateau(int x, int y, Domino d) {
		super(new Carre[x][y]);
		carres[x / 2][y / 2] = d.getCarre1();
		carres[x / 2 + 1][y / 2] = d.getCarre2();
	}

	boolean check(Domino d, int x1, int y1, int x2, int y2) {
		return (hasVoisin(x1, y1) || hasVoisin(x2, y2)) && (check(d.getCarre1(), x1, y1))
				&& (check(d.getCarre2(), x2, y2));
	}

	protected boolean check(Domino d, int x1, int x2) {
		return check(d, x1, 0, x2, 0);
	}

}
