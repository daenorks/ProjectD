package basic;

import java.awt.Container;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public interface Carte {
	boolean estPosable();

	boolean action(Joueur j);

	default boolean poser(Plateau plateau, int x, int y) {
		return plateau.poser(this, x, y);
	}

	static ArrayList<Carte> getPioche() {
		return null;
	}

	Container getCont(ActionListener e);

	int getSide();

	void setSide(int s);

	default void rotate() {
		setSide((getSide() + 1) % 4);
	}
}
