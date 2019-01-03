package basic;

import java.util.ArrayList;

public abstract class Jeu {
	protected ArrayList<Joueur> joueurs;
	protected Pioche pioche;
	protected Plateau plateau;
	protected Joueur actuel;
	protected int bloquer;

	void piocher() {
		Carte c = pioche.pioche();
		if (c != null)
			actuel.add(c);
		else
			bloquer++;
		prochain();
	}

	boolean bloquer() {
		return bloquer == joueurs.size();
	}

	boolean utiliserCarte(Carte carte, int side, int x, int y) {
		if (!actuel.peutPoser()) return false;
		boolean reussi = carte.poser(plateau, side, x, y);
		if (reussi) {
			actuel.remove(carte);
			bloquer = 0;
			prochain();
		}
		return reussi;
	}
	
	abstract boolean estFini();
	abstract ArrayList<Joueur> lesGagnants();

	private void prochain() {
		actuel = joueurs.get(((joueurs.indexOf(actuel)) + 1) % joueurs.size());
	}
	
	public void passerTour() {
		prochain();
	}

	ArrayList<Carte> getActualHand() {
		return actuel.getHand();
	}

	Carre[][] getPCarres() {
		return plateau.getCarres();
	}
}
