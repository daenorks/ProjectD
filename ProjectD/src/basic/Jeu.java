package basic;

import java.util.ArrayList;

public abstract class Jeu {
	protected ArrayList<Joueur> joueurs;
	protected Pioche pioche;
	protected Plateau plateau;
	protected Joueur actuel;
	protected int bloquer;
	protected Carte carte;
	protected State state;



	public enum State {
		CHOOSEACTION(),
		CHOOSEPLAYER(),
		CHOOSEXY(),
		CHOOSESIDE();
	}

	void piocher() {
		Carte c = pioche.pioche();
		if (c != null)
			actuel.add(c);
		else
			bloquer++;
		prochainTour();
	}

	public boolean bloquer() {
		return bloquer == joueurs.size();
	}

	public boolean utiliserCarte(Carte carte, int x, int y) {
		if (!actuel.peutPoser()) return false;
		boolean reussi = carte.poser(plateau, x, y);
		if (reussi) {
			actuel.remove(carte);
			bloquer = 0;
			prochainTour();
		}
		return reussi;
	}
	
	public abstract boolean estFini();
	public abstract ArrayList<Joueur> lesGagnants();

	protected abstract void prochainTour();
	
	protected void prochainJoueur() {
		actuel = joueurs.get(((joueurs.indexOf(actuel)) + 1) % joueurs.size());
	}
	
	public void passerTour() {
		prochainTour();
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
	
	
	public ArrayList<Joueur> getJoueurs() {
		return joueurs;
	}
	
	
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
}
