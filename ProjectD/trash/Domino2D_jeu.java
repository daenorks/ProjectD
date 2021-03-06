package trash;

import java.util.Scanner;
import basic.Carte;
import java.util.ArrayList;

public class Domino2D_jeu {

	public static Scanner scan = new Scanner(System.in);
	final private DLPlateau plateau;
	private ArrayList<DJoueur> joueurs;
	final private DPioche pioche;
	private ArrayList<DJoueur> classement;
	private DJoueur actuel;

	public static void main(String[] args) {
		Domino2D_jeu j = new Domino2D_jeu(2, 5);
		j.jouer_vueclassique();
	}

	public Domino2D_jeu(int nbJoueurs, int nbCartes) {
		joueurs = new ArrayList<DJoueur>();
		pioche = new DPioche();
		plateau = new DLPlateau(120, 120, pioche.pioche());
		classement = new ArrayList<DJoueur>();
		for (int i = 0; i < nbJoueurs; i++)
			joueurs.add(new DJoueur(pioche, nbCartes));
		actuel = joueurs.get(0);
	}

	public void jouer_vueclassique() {
		if (joueurs.size() == 0) {
			findepartie();
			return;
		}
		for (int i = 0; i < joueurs.size(); i++) {
			actuel = joueurs.get(i);
			if (actuel.nombreDeCartes() == 1) {
				if (poser()) {
					classement.add(actuel);
					joueurs.remove(actuel);
				}
			} else
				poser();
		}
		jouer_vueclassique();
	}

	private boolean poser() {
		boolean poser = false;
		while (actuel.nombreDeCartes() > 0 && !poser) {
			// montrer le jeu
			plateau.afficher_vueclassique2();
			// choisir domino
			afficher_mesdominos();
			int d = choixAction();
			// choisir placement ou piocher
			if (d == -1) {
				poser = true;
				joueurPioche();
			} else
				poser = placement((Domino) actuel.getHand().get(d));
		}
		if (actuel.nombreDeCartes() == 0)
			return true;
		return false;
	}

	@SuppressWarnings("resource")
	private int choixAction() {
		System.out.println("Choisisez un domino parmis ceux disponible, numerotes de 0 a n" + "ou -1 pour piocher : ");
		int x = getInt();
		if (x < -1 || x >= actuel.getHand().size()) {
			System.out.println("Veuillez choisir un numero VALIDE !");
			return choixAction();
		} else
			return x;
	}

	public int getInt() {
		boolean hasX = false;
		int x = 0;
		while (!hasX)
			try {
				x = scan.nextInt();
				hasX = true;
			} catch (Exception e) {
			}
		return x;
	}

	public boolean placement(Domino d) {
		System.out.println("Veuillez choisir une position X pour le cote droit");
		int x = getInt();
		System.out.println("Veuillez choisir une position Y pour le cote droit");
		int y = getInt();
		System.out.println("Veuillez choisir une position pour placer le cote gauche du domino \n "
				+ "1 haut, 2 droite, 3 bas, 4 gauche \n Pour passer votre tour, -5");
		int x1 = getInt();
		if (x1 == 1)
			if (plateau.poser2D(d, x, y, x, y + 1))
				return true;
		if (x1 == 2)
			if (plateau.poser2D(d, x, y, x + 1, y))
				return true;
		if (x1 == 3)
			if (plateau.poser2D(d, x, y, x, y - 1))
				return true;
		if (x1 == 4)
			if (plateau.poser2D(d, x, y, x - 1, y))
				return true;
		if (x1 == -5)
			return false;
		System.out.println("Choisisez une position V-A-L-I-D-E !");

		return placement(d);
	}

	public void joueurPioche() {
		actuel.add(pioche.pioche());
	}

	public void afficher_vueclassique() {
		plateau.afficher_vueclassique();
	}

	public void afficher_mesdominos() {
		int i = 0;
		for (Carte c : actuel.getHand()) {
			Domino d = (Domino) c;
			System.out.print("\n" + i + " : ");
			d.afficher();
			i++;
		}
	}

	private void findepartie() {
		return;
	}

}

/*
 * public class Domino_Jeu {
 * 
 * public static void main(String[] args) { Domino_Jeu j = new Domino_Jeu(2, 5);
 * j.jouer_vueclassique(); }
 * 
 * public static Scanner scan = new Scanner(System.in); final private DPlateau
 * plateau; private ArrayList<DJoueur> joueurs; final private DPioche pioche;
 * private ArrayList<DJoueur> classement; private DJoueur actuel;
 * 
 * public Domino_Jeu(int nbJoueurs, int nbCartes) { joueurs = new
 * ArrayList<DJoueur>(); pioche = new DPioche(); plateau = new DPlateau(120,
 * pioche.pioche()); classement = new ArrayList<DJoueur>(); for (int i = 0; i <
 * nbJoueurs; i++) joueurs.add(new DJoueur(pioche, nbCartes)); actuel =
 * joueurs.get(0); }
 * 
 * public void jouer_vueclassique() { if (joueurs.size() == 0) { findepartie();
 * return; } for (int i = 0; i < joueurs.size(); i++) { actuel = joueurs.get(i);
 * if (actuel.nombreDeCartes() == 1) { if (poser()) { classement.add(actuel);
 * joueurs.remove(actuel); } } else poser(); } jouer_vueclassique(); }
 * 
 * private boolean poser() { boolean poser = false; while
 * (actuel.nombreDeCartes() > 0 && !poser) { // montrer le jeu
 * afficher_vueclassique(); // choisir domino afficher_mesdominos(); int d =
 * choixAction(); // choisir placement ou de piocher if (d == -1 ) { poser =
 * true; joueurPioche(); } else poser = placement((Domino)
 * actuel.getHand().get(d)); } if (actuel.nombreDeCartes() == 0) return true;
 * return false; }
 * 
 * @SuppressWarnings("resource") private int choixAction() { System.out.
 * println("Choisisez un domino parmis ceux disponible, num�rot�s de 0 � n" +
 * "ou -1 pour piocher : "); int x = getInt(); if (x < -1 || x >=
 * actuel.getHand().size()) {
 * System.out.println("Veuillez choisir un numero VALIDE !"); return
 * choixAction(); } else return x; }
 * 
 * public int getInt() { boolean hasX = false; int x = 0; while (!hasX) try { x
 * = scan.nextInt(); hasX = true; } catch (Exception e) {} return x; }
 * 
 * public boolean placement(Domino d) { System.out.
 * println("Faites 0 pour poser a gauche, 1 pour poser a droite et 2 pour tourner le domino"
 * ); System.out.println("Faites -1 revenir au choix des dominos"); boolean
 * poser = false; while (!poser) { int x = getInt(); switch (x) { case 0: poser
 * = plateau.poserAGauche(d); break; case 1: poser = plateau.poserADroite(d);
 * break; case 2: d.reverse(); break; case -1: return false; default:
 * System.out.println("Veuillez entrer un numero VALIDE !"); } if (!poser && x
 * != 2 ) System.out.println("Impossible de le poser !"); } return true; }
 * 
 * public void joueurPioche() { actuel.add(pioche.pioche()); }
 * 
 * public void afficher_vueclassique() { plateau.afficher_vueclassique(); }
 * 
 * public void afficher_mesdominos() { int i = 0; for (Carte c :
 * actuel.getHand()) { Domino d = (Domino) c; System.out.print("\n" + i +
 * " : "); d.afficher(); i++; } }
 * 
 * private void findepartie() { return; } }
 */