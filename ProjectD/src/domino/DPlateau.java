package domino;

import basic.Carre;
import basic.Plateau;

public class DPlateau extends Plateau {

	private DCarre premier;
	private int x1;
	private DCarre dernier;
	private int x2;

	boolean check(DCarre c, int x) {
		return check(c, x, 0);
	}

	void put(Domino d, int x1, int y1, int x2, int y2) {
		put(d.getCarre1(), x1, y1);
		put(d.getCarre2(), x2, y2);
	}

	public DPlateau(int x) {
		super(new Carre[x][0]);
	}

	boolean check(Domino d) {
		if (premier == null && dernier == null)
			return true;
		return (check(d.getCarre1(), x1) || check(d.getCarre1(), x2) || check(d.getCarre2(), x1)
				|| check(d.getCarre2(), x2));
	}

	public void poserPremier(Domino d, boolean b) {
		if (premier == null && dernier == null) {
			premier = d.getCarre1();
			dernier = d.getCarre2();
			put(d, (this.taille(1) / 2), 0, (this.taille(1) / 2) + 1, 0);
			this.x1 = (this.taille(1) / 2);
			this.x2 = x1 + 1;
		}

		else {
			if (b)
				put(d, x1 - 1, 0, x1 - 2, 0);
			else
				put(d, x1 - 2, 0, x1 - 1, 0);
			x1 -= 2;
		}
	}

	public void poserDernier(Domino d, boolean b) {
		if (premier == null && dernier == null) {
			premier = d.getCarre1();
			dernier = d.getCarre2();
			put(d, (this.taille(1) / 2), 0, (this.taille(1) / 2) + 1, 0);
			this.x1 = (this.taille(1) / 2);
			this.x2 = x1 + 1;
		}

		else {
			if (b)
				put(d, x2 + 1, 0, x1 + 2, 0);
			else
				put(d, x2 + 2, 0, x1 + 1, 0);
			x2 += 2;
		}
	}

	public void afficher_vueclassique() {
		int i = x1;
		while (i < x2) {
			System.out.println("[" + ((DCarre)this.getCarre(i,0)).getN() + "|" + ((DCarre)this.getCarre(i+1,0)).getN() + "]");
			i += 2;
		}
	}

	public int getX1() {
		return this.x1;
	}

	public int getX2() {
		return this.x2;
	}
}
