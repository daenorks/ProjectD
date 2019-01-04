package saboteur;

import java.util.ArrayList;

import basic.Jeu;
import basic.Joueur;

public class SJeu extends Jeu {

	@Override
	public boolean estFini() {
		return plateau.partie_fini();
	}

	@Override
	public ArrayList<Joueur> lesGagnants() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void prochainTour() {
		chemin_gagnant();
		if (estFini()) {
			//termine la partie
		else {
			prochainJoueur();
		}
	}
	
	public void supprimerCarte(SCarte carte) {
		actuel.remove(carte);
	}
	
	public boolean utiliserCarte(SCarte carte, joueur c) {
		// Utilisation d'une carte d'action seulement. c -> joueur ciblé
		boolean b = (carte.action(actuel, plateau,c,0,0));
		if (b) {
			actuel.remove(carte);
			prochainTour();
		}
		return b;
	}
	
	public void chemin_gagnant() {
		boolean[] b = parcourir();
		for (int i = 0; i < b.length;i++) {
			if (i==0 && b[i]) {
				actuel.score += CTRESOR1.revele();
				aux++;
			}
			if (i==1 && b[i]) {
				actuel.score += CTRESOR2.revele();
				aux++;
			}
			if (i==2 && b[i]) {
				actuel.score += CTRESOR2.revele();
			}
		}
	}
}
