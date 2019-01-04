package domino2;

import basic.Carte;
import basic.Joueur;

public class Domino implements Carte {
	private DCarre carre1;
	private DCarre carre2;
	private int side = 0;

	public Domino(DCarre c1, DCarre c2) {
		carre1 = c1;
		carre2 = c2;
	}

	public DCarre getCarre1() {
		return carre1;
	}

	public DCarre getCarre2() {
		return carre2;
	}

	public boolean estPosable() {
		return true;
	}
	
	public void afficher () {
		System.out.println("[" + carre1.getN() + "|" + carre2.getN() + "]");
	}
	
	@Override
	public boolean action(Joueur j) {
		return false;
	}

	@Override
	public String getView() {
		switch (side) {
		case 0 : return "[" + carre1.getN() + "|" + carre2.getN() + "]";
		case 1 : return "|" + carre1.getN() + "|\n|" + carre2.getN() + "|";
		case 2 : return "[" + carre2.getN() + "|" + carre1.getN() + "]";
		case 3 : return "|" + carre2.getN() + "|\n|" + carre1.getN() + "|";
		}
		return "[" + carre1.getN() + "|" + carre2.getN() + "]";
	}

	@Override
	public int getSide() {
		return side;
	}

	@Override
	public void setSide(int s) {
		side = s%4;
	}

}