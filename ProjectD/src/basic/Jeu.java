package basic;

import java.util.ArrayList;

public class Jeu {
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
	}

	boolean bloquer() {
		return bloquer == joueurs.size();
	}

	boolean utiliserCarte(Carte carte, int side, int x, int y) {
		boolean reussi = carte.poser(plateau, side, x, y);
		if (reussi) {
			actuel.remove(carte);
			bloquer = 0;
		}
		return reussi;
	}

	ArrayList<Carte> getActualHand() {
		return actuel.getHand();
	}

	Carre[][] getPCarres() {
		return plateau.getCarres();
	}
}
