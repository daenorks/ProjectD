package saboteur;

import java.util.ArrayList;
import basic.Jeu;
import basic.Joueur;
import basic.Carte;

public class SJeu extends Jeu {

	ArrayList<Joueur> gagnants = new <Joueur>ArrayList();

	@Override
	public boolean estFini() {
		return ((SPlateau) plateau).partie_finie();
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

	public boolean utiliserCarte(Carte carte, Joueur c) {
		// Utilisation d'une carte d'action seulement. c -> joueur cibl�
		boolean b = (carte.action(c));
		if (b) {
			actuel.remove(carte);
			prochainTour();
		}
		return b;
	}

	public void chemin_gagnant() {
		boolean[] b = ((SPlateau) plateau).parcourir();
		for (int i = 0; i < 3; i++) {
			if (b[i]) {
				if (gagnants.indexOf(actuel) == -1)
					gagnants.add(actuel);
				actuel.addScore(((SPlateau) plateau).tresor[i]);
			}
		}
	}

}