package basic;

public abstract class Plateau {
	protected Carre[][] carres;

	public abstract boolean poser(Carte carte, int x, int y);

	protected boolean check(Carre carre, int x, int y) {
		if (x < 0 || y < 0 || x >= carres.length || y >= carres[0].length)
			return false; // Error
		if (x > 0 && carres[x - 1][y] != null)
			if (carre.getG() != carres[x - 1][y].getD())
				return false;
		if (x < carres.length - 1 && carres[x + 1][y] != null)
			if (carre.getD() != carres[x + 1][y].getG())
				return false;
		if (y < carres[x].length - 1 && carres[x][y + 1] != null)
			if (carre.getH() != carres[x][y + 1].getB())
				return false;
		if (y > 0 && carres[x][y - 1] != null)
			if (carre.getB() != carres[x][y - 1].getH())
				return false;
		return true;
	}

	protected boolean hasVoisin(int x, int y) {
		return ((y > 0 && carres[x][y - 1] != null)
				|| (y < carres[x].length - 1 && carres[x][y + 1] != null)
				|| (x < carres.length - 1 && carres[x + 1][y] != null)
				|| (x > 0 && carres[x - 1][y] != null));
	}

	protected boolean checkPut(Carre carre, int x, int y) {
		if (check(carre, x, y))
			put(carre, x, y);
		else
			return false;
		return true;
	}

	protected void put(Carre carre, int x, int y) {
		carres[x][y] = carre;
	}

	public Plateau(Carre[][] c) {
		this.carres = c;
	}

	public int taille(int y) {
		return carres[y].length;
	}

	public Carre getCarre(int x, int y) {
		return carres[x][y];
	}

	public Carre[][] getCarres() {
		return carres;
	}

	public int taille2() {
		return carres.length;
	}

}
