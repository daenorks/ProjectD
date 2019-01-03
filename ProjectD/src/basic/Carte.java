package basic;

public interface Carte {
	boolean estPosable();
	default boolean use(Plateau plateau, int side, int x, int y) {
		if (estPosable()) return poser(plateau, side, x, y);
		else return action();
	}
	boolean action();
	default boolean poser(Plateau plateau, int side, int x, int y) {
		return plateau.poser(this, side, x , y);
	}
}
