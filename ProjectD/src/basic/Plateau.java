package basic;

public class Plateau {
	protected Carre[][] carres;

	protected boolean check(Carre carre, int x, int y) {
		int i = 0;
		if (x < 0 || y < 0 || x >= carres.length || y >= carres[0].length)
			return false; // Error
		if (x > 0 && carres[x - 1][y] != null) {
			if (carre.getG() != carres[x + 1][y].getD())
				return false;
			else
				i++;
		}
		if (x < carres.length - 2 && carres[x + 1][y] != null) {
			if (carre.getD() != carres[x + 1][y].getG())
				return false;
			else
				i++;
		}
		if (y < carres[x].length - 2 && carres[x][y + 1] != null) {
			if (carre.getH() != carres[x + 1][y].getB())
				return false;
			else
				i++;
		}
		if (y > 0 && carres[x][y - 1] != null) {
			if (carre.getB() != carres[x + 1][y].getH())
				return false;
			else
				i++;
		}
		return i > 0;
	}

	boolean checkPut(Carre carre, int x, int y) {
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

	public int taille(int x) {
		return carres[x].length;
	}

	public Carre getCarre(int x, int y) {
		return carres[x][y];
	}

}
