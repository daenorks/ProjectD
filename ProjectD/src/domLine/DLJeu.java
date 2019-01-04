package domLine;

import java.util.ArrayList;

import javax.swing.SwingUtilities;

import basic.GView;
import basic.Jeu;
import basic.Joueur;
import basic.Jeu.State;
import domino2d.DDJeu;
import domino2d.DPioche;
import domino2d.DPlateau;
import domino2d.Domino;

public class DLJeu extends DDJeu {
	private ArrayList<Joueur> classement;

	public DLJeu(int nbJoueurs, int nbCartes, int x) {
		super();
		joueurs = new ArrayList<Joueur>();
		pioche = new DPioche();
		plateau = new DLPlateau(x, (Domino) pioche.pioche());
		classement = new ArrayList<Joueur>();
		for (int i = 0; i < nbJoueurs; i++)
			joueurs.add(new Joueur(pioche, nbCartes, i));
		actuel = joueurs.get(0);
		state = State.CHOOSEACTION;
		bloquer = 0;
		carte = null;
		passe = false;
		defausse = false;
		canPioche = true;
	}

	@Override
	public boolean estFini() {
		return joueurs.size() == 0;
	}

	@Override
	public ArrayList<Joueur> lesGagnants() {
		return classement;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				DLJeu j = new DLJeu(2, 5, 30);
				GView view = new GView(j);
			}
		});
	}
}
