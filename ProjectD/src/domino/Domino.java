package domino;

import basic.Carte;
import basic.Joueur;

public class Domino implements Carte {
	private DCarre carre1;
	private DCarre carre2;
	
	public void hasard() { // retourne un domino au hasard
		
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
	@Override
	public void jouerCarte(Joueur joueur) {
		
	}
	
	
}
