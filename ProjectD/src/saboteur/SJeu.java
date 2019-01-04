package saboteur;

import java.util.ArrayList;

import basic.Jeu;
import basic.Joueur;

public class SJeu extends Jeu {

	ArrayList<Joueur> gagnants = new <Joueur>ArrayList();
	
	@Override
	public boolean estFini() {
		return plateau.partie_fini();
	}
	
	@Override
	public ArrayList<Joueur> lesGagnants() {
		return this.gagnants;
	}

	@Override
	protected void prochainTour() {
		chemin_gagnant();
		if (estFini()) {
			// termine la partie
		} else {
			prochainJoueur();
			// continue la partie
		}
	}

	public void supprimerCarte(SCarte carte) {
		actuel.remove(carte);
	}

	public boolean utiliserCarte(SCarte carte, joueur c) {
		// Utilisation d'une carte d'action seulement. c -> joueur ciblé
		boolean b = (carte.action(actuel, plateau, c, 0, 0));
		if (b) {
			actuel.remove(carte);
			prochainTour();
		}
		return b;
	}

	public void chemin_gagnant() {
		boolean[] b = parcourir();
		for (int i = 0; i < 3; i++) {
			if (b[i]) {
				if(gagnants.indexOf(actuel)==-1) gagnants.add(actuel);
				actuel.score += tresor[i];
			}
		}
	}

}