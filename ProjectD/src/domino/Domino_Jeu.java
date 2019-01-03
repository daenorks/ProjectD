package domino;

import java.util.ArrayList;
import java.util.LinkedList;

import com.sun.java_cup.internal.runtime.Scanner;

import basic.Joueur;

public class Domino_Jeu {

	public static void main(String[] args) {
		Domino_jeu j = new Domino_jeu(2, 5);
		j.jouer_vueclassique();
	}

	final private DPlateau plateau;
	private ArrayList<DJoueur> joueurs;
	final private DPioche pioche;
	private ArrayList<DJoueur> classement;

	public Domino_Jeu(int nbJoueurs, int nbCartes) {
		joueurs = new ArrayList<DJoueur>();
		pioche = new DPioche();
		plateau = new DPlateau(120);
		classement = new ArrayList<DJoueur>();
		for (int i = 0; i < nbJoueurs; i++)
			joueurs.add(new DJoueur(pioche, nbCartes));
	}

	public void jouer_vueclassique() {

		if (joueurs.size() == 0) {
			findepartie();
			return;
		}

		for (int i = 0; i < joueurs.size(); i++) {
			if (joueurs.get(i).nombreDeCartes() == 1) {
				if (poser(joueurs.get(i))) {
					classement.add(joueurs.get(i));
					joueurs.remove(i);
				}
			} else {
				poser(joueurs.get(i));
			}

		}

		if (bloque()) {
			findepartie();
			return;
		}

		jouer();

	}

	private boolean bloque() {
		if (pioche.size() > 0)
			return false;
		for (int i = 0; i < joueurs.length; i++) {
			if (joueurs.get(i).posable() > 0)
				return false;
		}

		return true;
	}

	private boolean poser(DJoueur j) {
		ArrayList<Domino> disponible = posable();
		if (disponible.size() == 0) {
			pioche();
			return false;
		} else {

			afficher_vueclassique();
			afficher_mesdominos(j.getHand());
			java.util.Scanner scan = new Scanner(System.in);
			Domino c = new Domino(null,null);
			System.out.println("Choisisez un domino parmis ceux disponible, numérotés de 0 à n: ");
			int iterateur=0;
			int aux=0;
			boolean c=true;
			while(c) {
				switch (iterateur)
				{

				default :
					System.out.println("entrez une option (numérique) VALIDE !");
					break;
				case 0:
					afficher_mesdominos(disponible);
					Domino c = ChoixDomino(disponible);
					iterateur = 10;
					break;
				case 10:
					choixPlacement(c);
					iterateur = scan.nextInt();
					break;
				case 1:
					if (check(c.getCarre2(), plateau.getX1(), 0)) {
						plateau.poserPremier(c, true);
						c = false;
					}
					else {
						System.out.println("Veuillez choisir une orientation disponible");
						iterateur = 10;
					}
					break;
				case 2:
					if (check(c.getCarre1(), plateau.getX1(), 0)) {
						plateau.poserPremier(c, false);
						c = false;
					}
					else {
						System.out.println("Veuillez choisir une orientation disponible");
						iterateur = 10;
					}
					break;
				case 3:
					if (check(c.getCarre1(), plateau.getX2(), 0)) {
						plateau.poserDernier(c,true);
						c = false;
					}
					else {
						System.out.println("Veuillez choisir une orientation disponible");
						iterateur = 10;
					}
					break;
				case 4:
					if (check(c.getCarre2(), plateau.getX1(), 0)) {
						poserPremier(c,false);
						c = false;
					}

					else {


						System.out.println("Veuillez choisir une orientation disponible");
						iterateur = 10;
					}
					break;


				case -1:
					System.out.println("retour au choix des dominos");
					iterateur = 0;
					break;
				case -2:
					System.exit(0);
					break;
				}
			}
		}
		scan.close();
		return true;

	}

	private Domino choixDomino(ArrayList<Domino> al) {
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		if (x < 0 || x >= al.size()) {
			System.out.println("Veuillez choisir un numéro de domino VALIDE !");
			scan.close();
			return choixDomino(al);
		} else
			return al.get(x);
	}

	public void choixPlacement(Domino c) {
		if (check(c.getCarre2(), plateau.getX1(), 0)) {
			System.out.println(
					"Pour ajouter le domino au debut dans son orientation normale, appuyez sur 1");
		}

		if (check(c.getCarre1(), plateau.getX1(), 0)) {
			System.out.println(
					"Pour ajouter le domino numéro au debut dans son orientation inversée, appuyez sur 2");
		}

		if (check(c.getCarre1(), plateau.getX2(), 0)) {
			System.out.println(
					"Pour ajouter le domino numéro  a la fin dans son orientation normale, appuyez sur 3");
		}

		if (check(c.getCarre2(), plateau.getX2(), 0)) {
			System.out.println(
					"Pour ajouter le domino numéro a la fin dans son orientation inversée, appuyez sur 4");
		}

		System.out.println("Faites -1 revenir au choix des dominos, -2 pour quitter le programme");
	}

	public void afficher_vueclassique() {
		plateau.afficher_vueclassique();
	}

	public void afficher_mesdominos(ArrayList<Domino> al) {
		for (int i = 0; i < al.size(); i++) {
			System.out.print("\n" + i + " : ");
			al.get(i).afficher();
		}
	}

	private ArrayList<Domino> posable(DJoueur j) {
		ArrayList<Domino> disponible = new ArrayList<Domino>();
		for (int i = 0; i < j.nombreDeCartes(); j++) {
			if (plateau.check(j.get(i)))
				disponible.add(j.getHand().get(i));
		}
	}

	private void findepartie() {
		return;
	}
}