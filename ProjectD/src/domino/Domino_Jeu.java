package domino;

import java.util.ArrayList;
import java.util.LinkedList;
import basic.Joueur;

public class Domino_Jeu {
	
	final private DPlateau plateau;
	private ArrayList<DJoueur> joueurs;
	final private DPioche pioche;
	private ArrayList<DJoueur> classement;
	
	public Domino_Jeu (int nbJoueurs){
		joueurs = new ArrayList<DJoueur>();
		pioche = new DPioche();
		plateau = new DPlateau(120);
		classement = new ArrayList <DJoueur>();
		for (int i = 0; i < nbJoueurs; i++)
			joueurs.add(new DJoueur(pioche, 7));
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