package basic;

public class Plateau {
	Carre[][] cartes;
	
	protected boolean check(Carre carte, int x, int y) {
		int i = 0;
		if (x < 0 || y < 0 || x >= cartes.length || y >= cartes[0].length)
			return false; //Error
		if (x > 0 && cartes[x-1][y] != null) {
			if (carte.getG() != cartes[x+1][y].getD())
				return false;
			else i++;
		}
		if (x < cartes.length - 2 && cartes[x+1][y] != null) {
			if (carte.getD() != cartes[x+1][y].getG())
				return false;
			else i++;
		}
		if (y < cartes[x].length -2 && cartes[x][y+1] != null) {
			if (carte.getH() != cartes[x+1][y].getB())
				return false;
			else i++;
		}
		if (y > 0 && cartes[x][y-1] != null) {
			if (carte.getB() != cartes[x+1][y].getH()) 
				return false;
			else i++;
		}
		return i > 0;
	}
	
	boolean checkPut(Carre carte, int x, int y) {
		if (check(carte, x ,y))
			put(carte, x, y);
		else return false;
		return true;
	}
	
	protected void put(Carre carte, int x, int y) {
		cartes[x][y] = carte;
	}
	
	public Plateau (Carre[][] c) {
		this.cartes = c;
	}
	
}
