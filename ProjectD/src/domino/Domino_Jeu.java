import java.util.ArrayList;
import basic.Joueur;

public class Domino_Jeu {
	
	final private DPlateau plateau;
	private ArrayList<DJoueur> joueurs;
	final private DPioche pioche;
	
	public Domino_Jeu (int nbJoueurs){
		joueurs = new ArrayList<DJoueur>();
		pioche = new DPioche();
		plateau = new DPlateau(120);
		
	}
	
	public void add (DJoueur j) {
		joueurs.add(j);
	}
	
	public void distribuer(int x) {
		
	}
	
	
	public void jouer() {
		
	}
	
	
}