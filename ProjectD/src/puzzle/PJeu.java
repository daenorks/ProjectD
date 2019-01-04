package puzzle;

import java.util.ArrayList;

import basic.Jeu;
import basic.Joueur;

import java.awt.*;


public class PJeu extends Jeu {
	
	
	public void Pajouter(Image img) {
		Image []imag = ((PPlateau)plateau).decouper(img);
		for (int i = 0; i<imag.length;i++) {
			actuel.add(new PPiece (i,imag[i]));
		}
	}
	@Override
	public boolean estFini() {
		return ((PPlateau)plateau).check_victoire();
	}

	@Override
	public ArrayList<Joueur> lesGagnants() {
		return joueurs;
	}

	@Override
	protected void prochainTour() {
		if (estFini()) {
			// fin du jeu, puzzle termine
		} else {

		}
	}

}
