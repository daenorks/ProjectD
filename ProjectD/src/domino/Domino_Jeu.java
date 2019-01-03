public class Domino_Jeu {
	
	private DPlateau plateau;
	private LinkedList<Joueur> joueurs;
	private LinkedList<Joueur> classement;
	private DPioche pioche;
	
	public Domino_Jeu (){
		joueurs = new ArrayList<Joueur>;
		classement = new ArrayList <Joueur>;
	}
	
	public void add (Joueur j) {
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
	
	public void distribuer(int x) { // distribue X dominos au hasard à chaque joueurs
		for (int i = 0 ; i < joueurs.size() ; i++) {
			joueurs(i).add(hasard(x));
		}
	}
	
	
	public void jouer() {
		for(int i = 0 ; i < joueurs.size(); i++) {
			if (joueurs.get(i).nombreDeCartes() == 1) {
				if (joueurs.poser()) {
					classement.add(joueurs.get(i));
					joueurs.remove(i);
				}
			}
		}
		jouer();
	}
	
	
}