package basic;

import java.util.ArrayList;

public class Pioche {
	private ArrayList<Carte> hand;

	public ArrayList<Carte> getHand() {
		return hand;
	}
	
	public Carte pioche() {
		if (hand.size() == 0)
			return null; //Error
		return hand.remove(0);
	}
}
