package domino;

import basic.Carte;

public class Domino implements Carte {
	private DCarre carre1;
	private DCarre carre2;

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
	
	public void reverse() {
		DCarre d = carre1;
		carre1 = carre2;
		carre2 = d;
	}

	@Override
	public boolean action() {
		// TODO Auto-generated method stub
		return false;
	}

}