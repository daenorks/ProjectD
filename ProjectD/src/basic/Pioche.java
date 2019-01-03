package basic;

import java.util.ArrayList;

public class Pioche {
	private ArrayList<Carte> hand;

	public ArrayList<Carte> getHand() {
		return hand;
	}
	
	public Carte pioche(Carte carte) {
		hand.remove(carte);
	}
}
