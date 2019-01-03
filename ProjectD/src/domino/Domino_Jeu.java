package domino;

import java.util.Scanner;
import java.util.ArrayList;

public class Domino_Jeu {

	public static void main(String[] args) {
		Domino_Jeu j = new Domino_Jeu(2, 5);
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

		jouer_vueclassique();

	}

	private boolean bloque() {
		if (pioche.getHand().size() > 0)
			return false;
		for (int i = 0; i < joueurs.size(); i++) {
			if (posable(joueurs.get(i)).size() > 0)
				return false;
		}

		return true;
	}

	private boolean poser(DJoueur j) {
		ArrayList<Domino> disponible = posable(j);
		if (disponible.size() == 0) {
			j.add(pioche,1);
			return false;
		} else {

			afficher_vueclassique();
			ArrayList d1 = j.getHand();
			afficher_mesdominos(d1);
			java.util.Scanner scan = new Scanner(System.in);
			Domino c = new Domino(null,null);
			System.out.println("Choisisez un domino parmis ceux disponible, num�rot�s de 0 � n: ");
			int iterateur=0;
			int aux=0;
			boolean bool=true;
			while(bool) {
				switch (iterateur)
				{

				default :
					System.out.println("entrez une option (num�rique) VALIDE !");
					break;
				case 0:
					afficher_mesdominos(disponible);
					c = choixDomino(disponible);
					iterateur = 10;
					break;
				case 10:
					choixPlacement(c);
					iterateur = scan.nextInt();
					break;
				case 1:
					if (plateau.check(c.getCarre2(), plateau.getX1())) {
						plateau.poserPremier(c, true);
						bool = false;
					}
					else {
						System.out.println("Veuillez choisir une orientation disponible");
						iterateur = 10;
					}
					break;
				case 2:
					if (plateau.check(c.getCarre1(), plateau.getX1())) {
						plateau.poserPremier(c, false);
						bool = false;
					}
					else {
						System.out.println("Veuillez choisir une orientation disponible");
						iterateur = 10;
					}
					break;
				case 3:
					if (plateau.check(c.getCarre1(), plateau.getX2())) {
						plateau.poserDernier(c,true);
						bool = false;
					}
					else {
						System.out.println("Veuillez choisir une orientation disponible");
						iterateur = 10;
					}
					break;
				case 4:
					if (plateau.check(c.getCarre2(), plateau.getX1())) {
						plateau.poserPremier(c,false);
						bool = false;
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
			scan.close();
		}
		
		return true;

	}

	private Domino choixDomino(ArrayList<Domino> al) {
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		if (x < 0 || x >= al.size()) {
			System.out.println("Veuillez choisir un num�ro de domino VALIDE !");
			scan.close();
			return choixDomino(al);
		} else
			return al.get(x);
	}

	public void choixPlacement(Domino c) {
		if (plateau.check(c.getCarre2(), plateau.getX1())) {
			System.out.println(
					"Pour ajouter le domino au debut dans son orientation normale, appuyez sur 1");
		}

		if (plateau.check(c.getCarre1(), plateau.getX1())) {
			System.out.println(
					"Pour ajouter le domino num�ro au debut dans son orientation invers�e, appuyez sur 2");
		}

		if (plateau.check(c.getCarre1(), plateau.getX2())) {
			System.out.println(
					"Pour ajouter le domino num�ro  a la fin dans son orientation normale, appuyez sur 3");
		}

		if (plateau.check(c.getCarre2(), plateau.getX2())) {
			System.out.println(
					"Pour ajouter le domino num�ro a la fin dans son orientation invers�e, appuyez sur 4");
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
		for (int i = 0; i < j.nombreDeCartes(); i++) {
			if (plateau.check((Domino)j.getHand().get(i)))
				disponible.add((Domino)j.getHand().get(i));
		}
		return disponible;
	}

	private void findepartie() {
		return;
	}
}