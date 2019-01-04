package basic;

import java.util.Scanner;

public abstract class TermController {
	Jeu jeu;
	TermView view;
	public static Scanner scan = new Scanner(System.in);

	public void jouer() {
		while (true)
			;
	}

	public void jouerUnTour() {
		boolean actionDone = false;
		// view the board
		view.afficherPlateau();
		// view the hand
		view.afficherMain();
		// select card to play or pioche or passe
		while (!actionDone) {
			actionDone = askAction();
			if (jeu.getCarte() != null) {
				// if posable select where and the angle
				if (jeu.getCarte().estPosable())
					actionDone = askPosition();
				else
					askPlayer();
			}
		}
	}

	protected abstract void askPlayer();

	protected abstract boolean askPosition();

	protected boolean askAction() {
		System.out.println("Choisisez une carte/domino numerotes de 0 a n" + "ou -1 pour piocher : ");
		int x = getInt();
		if (x < -1 || x >= jeu.getActualHand().size()) {
			System.out.println("Veuillez choisir un numero VALIDE !");
			return askAction();
		} else {
			jeu.setCarte(jeu.getActualHand().get(x));
			return true;
		}
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
}
