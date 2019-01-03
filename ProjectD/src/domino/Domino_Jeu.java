public class Domino_Jeu {
	
	private DPlateau plateau;
	private ArrayList<Joueur> joueurs;
	
	public Domino_Jeu (){
		joueurs = new ArrayList<Joueur>;
	}
	
	public void add (Joueur j) {
		joueurs.add(j);
	}
	
	public void demarrer(int x){
		distribuer(x);
		plateau = new DPlateau (x);
		jouer();
	}
	
	public void distribuer(int x) { // distribue X dominos au hasard à chaque joueurs
		for (int i = 0 ; i < joueurs.size() ; i++) {
			joueurs(i).add(hasard(x))
		}
	}
	
	
	public void jouer() {
		
	}
	
	
}