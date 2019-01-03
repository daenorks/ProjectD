package domino;

import basic.Carte;
import basic.Joueur;

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
	
	public boolean jouerCarte(Joueur joueur, DPlateau plateau, boolean droite) {
		if (plateau.)
		return false;
		joueur.remove(this);
		return true;
	}
	
	
}
