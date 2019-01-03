package domino;

import java.util.ArrayList;

import basic.Jeu;
import basic.Joueur;

public class DominoJeu extends Jeu {
	private ArrayList<Joueur> classement;
	
	public DominoJeu(int nbJoueurs, int nbCartes) {
		joueurs = new ArrayList<Joueur>();
		pioche = new DPioche();
		plateau = new DPlateau(120, (Domino) pioche.pioche());
		classement = new ArrayList<Joueur>();
		for (int i = 0; i < nbJoueurs; i++)
			joueurs.add(new DJoueur(pioche, nbCartes));
		actuel = joueurs.get(0);
	}
}
