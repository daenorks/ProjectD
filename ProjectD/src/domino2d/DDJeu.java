package domino2d;

import java.util.ArrayList;

import javax.swing.SwingUtilities;
import java.awt.*;

import basic.Carte;
import basic.GView;
import basic.Jeu;
import basic.Joueur;
import basic.Jeu.State;
// import trash.Domino2D_jeu;

public class DDJeu extends Jeu {
	private ArrayList<Joueur> classement;

	public DDJeu(int nbJoueurs, int nbCartes) {
		joueurs = new ArrayList<Joueur>();
		pioche = new DPioche();
		plateau = new DPlateau(30, 30, (Domino) pioche.pioche());
		classement = new ArrayList<Joueur>();
		for (int i = 0; i < nbJoueurs; i++)
			joueurs.add(new Joueur(pioche, nbCartes));
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Joueur> lesGagnants() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				DDJeu j = new DDJeu(2, 5);
				GView view = new GView(j);
			}
		});
	}

}
