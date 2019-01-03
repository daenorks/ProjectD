package basic;

import java.util.ArrayList;

public abstract class Jeu {
	protected ArrayList<Joueur> joueurs;
	protected Pioche pioche;
	protected Plateau plateau;
	protected Joueur actuel;
	protected int bloquer;
	protected Carte carte;

	void piocher() {
		Carte c = pioche.pioche();
		if (c != null)
			actuel.add(c);
		else
			bloquer++;
		prochain();
	}

	public boolean bloquer() {
		return bloquer == joueurs.size();
	}

	public boolean utiliserCarte(Carte carte, int side, int x, int y) {
		if (!actuel.peutPoser()) return false;
		boolean reussi = carte.poser(plateau, side, x, y);
		if (reussi) {
			actuel.remove(carte);
			bloquer = 0;
			prochain();
		}
		return reussi;
	}
	
	public abstract boolean estFini();
	public abstract ArrayList<Joueur> lesGagnants();

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

	public Carte getCarte() {
		return carte;
	}

	public void setCarte(Carte carte) {
		this.carte = carte;
	}
}
