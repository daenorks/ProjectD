package puzzle;

import java.util.ArrayList;

import basic.Jeu;
import basic.Joueur;

public class PJeu extends Jeu {
	
	@Override
	public boolean estFini() {
		return plateau.check_victoire();
	}

	@Override
	public ArrayList<Joueur> lesGagnants() {
		return joueurs;
	}

	@Override
	protected void prochainTour() {
		if (estFini()) {
			//fin du jeu, puzzle termine
		} else {
			
		}
	}

}
