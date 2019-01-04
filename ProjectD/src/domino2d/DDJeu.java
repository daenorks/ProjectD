package domino2d;

import java.util.ArrayList;

import javax.swing.SwingUtilities;

import basic.GView;
import basic.Jeu;
import basic.Joueur;
import tp10.ImageEditModel;
import tp10.ImageEditView;
import trash.Domino2D_jeu;

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
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				DDJeu j = new DDJeu(2, 5);
				GView view = new GView(j);
				}
		});
	}

}
