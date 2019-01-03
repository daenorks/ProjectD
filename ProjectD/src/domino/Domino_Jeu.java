package domino;

import java.util.ArrayList;
import java.util.LinkedList;
import basic.Joueur;

public class Domino_Jeu {
	
	final private DPlateau plateau;
	private ArrayList<DJoueur> joueurs;
	final private DPioche pioche;
	private ArrayList<DJoueur> classement;
	
	public Domino_Jeu (int nbJoueurs, int nbCartes){
		joueurs = new ArrayList<DJoueur>();
		pioche = new DPioche();
		plateau = new DPlateau(120);
		classement = new ArrayList <DJoueur>();
		for (int i = 0; i < nbJoueurs; i++)
			joueurs.add(new DJoueur(pioche, nbCartes));
	}
	
	public void jouer() {

		if (joueurs.size() == 0) {
			return null // erreur
		}
		
		boolean[][] bloquer = new boolean [joueurs.size()];
		
		for(int i = 0 ; i < joueurs.size(); i++) {
			if (joueurs.get(i).nombreDeCartes() == 1) {
				if (poser(joueurs.get(i))) {
					classement.add(joueurs.get(i));
					joueurs.remove(i);
				} else {
					bloquer[i]=false;
				}
			}
		}
		
		if(bloque(bloquer)) {
			return findepartie();
		}
		
		else {
			return jouer();
		}
	}
	
	private boolean bloque(boolean[] b) {
		if (pioche.size()>0) return false;
		for (int i = 0; i < b.length; i++) {
			if (b[i]) return false;
		}
		return true;
	}
	
	
	private void poser(DJoueur j) {
	}
	
	private void findepartie(){
		return;
	}
}