package basic;

import java.util.ArrayList;

public class Joueur {
	private ArrayList<Carte> hand;

	public ArrayList<Carte> getHand() {
		return hand;
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
