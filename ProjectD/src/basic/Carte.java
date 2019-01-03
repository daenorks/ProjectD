package basic;

import java.util.ArrayList;

public interface Carte {
	boolean estPosable();
	boolean action(Joueur j);
	default boolean poser(Plateau plateau, int side, int x, int y) {
		return plateau.poser(this, side, x , y);
	}
	
	static ArrayList<Carte> getPioche() {
		return null;
	}
	
	String getView();
}
