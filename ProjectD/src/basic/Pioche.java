package basic;

import java.util.ArrayList;

public class Pioche {
	protected ArrayList<Carte> hand;

	public ArrayList<Carte> getHand() {
		return hand;
	}

	public Carte pioche() {
		if (hand.size() == 0)
			return null; // Error
		return hand.remove(0);
	}
	
	public boolean isEmpty() {
		return hand.isEmpty();
	}
}
