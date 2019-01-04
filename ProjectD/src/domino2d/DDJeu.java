package domino2d;

import java.util.ArrayList;

import javax.swing.SwingUtilities;
import basic.GView;
import basic.Jeu;
import basic.Joueur;

public class DDJeu extends Jeu {

	public DDJeu(int nbJoueurs, int nbCartes, int x, int y) {
		joueurs = new ArrayList<Joueur>();
		pioche = new DPioche();
		plateau = new DPlateau(x, y, (Domino) pioche.pioche());
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
	
	public DDJeu(int nbJoueurs, int nbCartes) {
		this(nbJoueurs, nbCartes, 30, 30);
	}

	public DDJeu() {
	}

	@Override
	public boolean estFini() {
		if (joueurs.size() <= 1) {
			if(joueurs.size() == 1)
				classement.add(joueurs.remove(0));
			return true;
		}
		else return false;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				DDJeu j = new DDJeu(2, 5);
				GView view = new GView(j);
			}
		});
	}

	@Override
	protected void prochainTourSup() {

	}
	
	@Override
	protected void prochainJoueur() {
		int i = joueurs.indexOf(actuel);
		if (getActualHand().size() == 0) {
			joueurs.remove(actuel);
			classement.add(actuel);
			actuel = joueurs.get(i%joueurs.size());
		}
		else
			actuel = joueurs.get((i + 1)%joueurs.size());
	}

}
