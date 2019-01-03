package basic;

import java.util.ArrayList;

public class Joueur {
	protected ArrayList<Carte> hand;
	
	public boolean peutPoser() {
		return true;
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
}