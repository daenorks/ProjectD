package domino2d;

import java.util.ArrayList;

import basic.Jeu;
import basic.Joueur;

public class DDJeu extends Jeu {
	private ArrayList<Joueur> classement;
	
	public DDJeu(int nbJoueurs, int nbCartes) {
		joueurs = new ArrayList<Joueur>();
		pioche = new DPioche();
		plateau = new DPlateau(120, 120, (Domino) pioche.pioche());
		classement = new ArrayList<Joueur>();
		for (int i = 0; i < nbJoueurs; i++)
			joueurs.add(new Joueur(pioche, nbCartes));
		actuel = joueurs.get(0);
	}

	@Override
	public boolean estFini() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Joueur> lesGagnants() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void prochainTour() {
		// TODO Auto-generated method stub
		
	}
}
