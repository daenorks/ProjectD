package basic;

import java.util.ArrayList;

public class Joueur {
	protected ArrayList<Carte> hand;
	protected int numJ;
	protected boolean[] bloquer;
	protected int score;
	
	public boolean peutPoser() {
		for (int i = 0; i<bloquer.length;i++) {
			if (bloquer[i]) return false;
		}
		return true;
	}
	
	boolean action(SCarte carte) {
		switch(SCarte) {
		case saboter_Lampe:
			if (bloquer[0]) {
				bloquer[0]=false;
				return true;
			}
			break;
		case saboter_Outil:
			if (bloquer[1]) {
				bloquer[1]=false;
				return true;
			}
			break;
		case saboter_Chariot:
			if (bloquer[2]) {
				bloquer[2]=false;
				return true;
			}
			break;
		case reparer_Lampe:
			if (!bloquer[0]) {
				bloquer[0]=true;
				return true;
			}
			break;
		case reparer_Outil:
			if (!bloquer[1]) {
				bloquer[1]=true;
				return true;
			}
			break;
		case reparer_Chariot:
			if (!bloquer[1]) {
				bloquer[1]=true;
				return true;
			}
			break;
		}
		return false;
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
}