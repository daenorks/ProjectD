package puzzle;

import java.util.ArrayList;

import basic.Jeu;
import basic.Joueur;

public class PJeu extends Jeu {

	@Override
	public boolean estFini() {
		
		return false;
	}

	@Override
	public ArrayList<Joueur> lesGagnants() {
		// TODO Auto-generated method stub
		return joueurs;
	}

	@Override
	protected void prochainTour() {
		// TODO Auto-generated method stub

	}

}
