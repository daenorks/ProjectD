package domLine;

import java.util.ArrayList;

import javax.swing.SwingUtilities;

import basic.GView;
import basic.Jeu;
import basic.Joueur;
import domino2d.DDJeu;

public class DLJeu extends DDJeu {
	private ArrayList<Joueur> classement;

	public DLJeu(int nbJoueurs, int nbCartes) {
		super(nbJoueurs, nbCartes, 40, 1);
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
				DLJeu j = new DLJeu(2, 5);
				GView view = new GView(j);
			}
		});
	}
}
