package basic;

public interface Carte {
	boolean estPosable();
	boolean action(Joueur j);
	default boolean poser(Plateau plateau, int side, int x, int y) {
		return plateau.poser(this, side, x , y);
	}
}
