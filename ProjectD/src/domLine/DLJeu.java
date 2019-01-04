package domLine;

import java.util.ArrayList;

import basic.Jeu;
import basic.Joueur;
import domino2d.DJoueur;
import domino2d.DPioche;
import domino2d.Domino;

public class DLJeu extends Jeu {
	private ArrayList<Joueur> classement;

	public DLJeu(int nbJoueurs, int nbCartes) {
		joueurs = new ArrayList<Joueur>();
		pioche = new DPioche();
		plateau = new DLPlateau(120, (Domino) pioche.pioche());
		classement = new ArrayList<Joueur>();
		for (int i = 0; i < nbJoueurs; i++)
			joueurs.add(new Joueur(pioche, nbCartes));
		actuel = joueurs.get(0);
	}

	@Override
	public boolean estFini() {
		return joueurs.size() == 0;
	}

	@Override
	public ArrayList<Joueur> lesGagnants() {
		return classement;
	}

	@Override
	protected void prochainTour() {
		Joueur oldJ = actuel;
		prochainJoueur();
		if (oldJ.getHand().size() == 0) {
			joueurs.remove(oldJ);
			classement.add(oldJ);
		}
	}

}
