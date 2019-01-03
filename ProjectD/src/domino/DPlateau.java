package domino;

import basic.Carre;
import basic.Plateau;

public class DPlateau extends Plateau {
	
	boolean check(Domino d, int x1, int y1, int x2, int y2) {
		return (check(d.getCarre1(), x1, y1) && check(d.getCarre2(), x2, y2));
	}
	
	void put(Domino d, int x1, int y1, int x2, int y2) {
		put(d.getCarre1(), x1, y1);
		put(d.getCarre2(), x2, y2);
	}
	
	public DPlateau (int x) {
		super(new Carre [x][1]);
	}
	
	boolean check(Domino d, boolean droite) {
		int x = cartes.length;
		while (cartes[x][1] != null) {
			if (droite) x++;
			else x--;
		}
		//TODO
		return false;
	}
	
	
}
