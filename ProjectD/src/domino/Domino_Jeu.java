import java.util.ArrayList;
import basic.Joueur;

public class Domino_Jeu {
	
	private DPlateau plateau;
	private ArrayList<DJoueur> joueurs;
	private DPioche pioche;
	
	public Domino_Jeu (){
		joueurs = new ArrayList<DJoueur>();
	}
	
	public void add (DJoueur j) {
		joueurs.add(j);
	}
	
	public void demarrer(int x){
		distribuer(x);
		plateau = new DPlateau (x);
		jouer();
	}
	
	public void distribuer(int x) { // distribue X dominos au hasard � chaque joueurs
		for (int i = 0 ; i < joueurs.size() ; i++) {
			joueurs(i).add(hasard(x))
		}
	}
	
	
	public void jouer() {
		
	}
	
	
}