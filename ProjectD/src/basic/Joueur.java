package basic;

import java.util.ArrayList;

public class Joueur {
	protected ArrayList<Carte> hand;
	protected int numJ;
	protected boolean[] bloquer = {false, false, false};
	protected int score;
	
	public boolean peutPoser() {
		for (int i = 0; i<bloquer.length;i++) {
			if (bloquer[i]) return false;
		}
		return true;
	}
	
	public boolean[] getBloquer() {
		return bloquer;
	}

	public ArrayList<Carte> getHand() {
		return hand;
	}
	
	public Joueur(Pioche p, int x) {
		hand = new ArrayList<Carte>();
		for (int i = 0; i < x; i++)
			hand.add(p.pioche());
	}
	
	public void add(Pioche p, int x) {
		for (int i = 0; i < x; i++)
			hand.add(p.pioche());
	}
	
	public void remove(Carte carte) {
		hand.remove(carte);
	}
	
	public void add(Carte carte) {
		hand.add(carte);
	}
	
	public int nombreDeCartes() {
		return hand.size();
	}

	public int getNumJ() {
		return numJ;
	}
	
	public boolean getBloquer(int i) {
		return bloquer[i];
	}
	
	public void setBloquer(int i, boolean b) {
		bloquer[i]=b;
	}
	
	public void addScore(int x){
		this.score +=x;
	}
}