import java.util.ArrayList;
import basic.Joueur;

public class Domino_Jeu {
	
	private DPlateau plateau;
	private LinkedList<DJoueur> joueurs;
	private LinkedList<DJoueur> classement;
	private DPioche pioche;
	
	public Domino_Jeu (){
		joueurs = new ArrayList<DJoueur>();
		classement = new ArrayList <DJoueur>;
	}
	
	public void add (DJoueur j) {
		joueurs.add(j);
	}
	
	public void demarrer(int x){
		if (joueurs.size() == 0) {
			// leve une exception
			return;
		}
		distribuer(x);
		plateau = new DPlateau (x);
		jouer();
	}
	
	public void distribuer(int x) { // distribue X dominos au hasard � chaque joueurs
		for (int i = 0 ; i < joueurs.size() ; i++) {
			joueurs(i).add(hasard(x));
		}
	}
	
	
	public void jouer() {
		
		if (joueurs.size() == 0) findepartie();
		
		for(int i = 0 ; i < joueurs.size(); i++) {
			if (joueurs.get(i).nombreDeCartes() == 1) {
				if (poser(joueurs.get(i))) {
					classement.add(joueurs.get(i));
					joueurs.remove(i);
				}
			}
		}
		jouer();
	}
	
	
	public void poser(DJoueur j) {
		
	}
	
	public void findepartie(){
		return;
	}
}