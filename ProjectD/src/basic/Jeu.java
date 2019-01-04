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
	protected boolean passe, defausse, canPioche;
	
	public abstract boolean estFini();
	public abstract ArrayList<Joueur> lesGagnants();
	public abstract void nextState();
	
	public boolean poserCarte(int x, int y) {
		if (carte == null)
			return false;
		if (!actuel.peutPoser())
			return false;
		boolean reussi = carte.poser(plateau, x, y);
		if (reussi) {
			actuel.remove(carte);
			bloquer = 0;
			prochainTour();
		}
		return reussi;
	}
	
	public boolean useCarte(Joueur j) {
		if (carte == null)
			return false;
		if (actuel.peutPoser())
			return false;
		boolean reussi = carte.action(j);
		if (reussi) {
			actuel.remove(carte);
			bloquer = 0;
			prochainTour();
		}
		return reussi;
	}
	
	public boolean pioche() {
		if (!pioche.isEmpty())
			actuel.add(pioche.pioche());
		else
			bloquer++;
		prochainTour();
		return true;
	}
	
	public boolean defausse() {
		actuel.remove(carte);
		prochainTour();
		return true;
	}
	
	public boolean passer() {
		bloquer++;
		prochainTour();
		return true;
	}

	public boolean canPasse() {
		return passe;
	}
	
	public boolean canDef() {
		return defausse;
	}
	
	public boolean canPioche() {
		return canPioche;
	}

	public enum State {
		CHOOSEACTION(),
		CHOOSECARTEACTION(),
	}

	public boolean bloquer() {
		return bloquer == joueurs.size();
	}
	
	protected void setInitalState() {
		state = State.CHOOSEACTION;
		carte = null;
	}

	protected void prochainTour() {
		prochainJoueur();
		setInitalState();
	}
	
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
		state = State.CHOOSECARTEACTION;
	}
	
	
	public ArrayList<Joueur> getJoueurs() {
		return joueurs;
	}
	
	
	public State getState() {
		return state;
	}
}
