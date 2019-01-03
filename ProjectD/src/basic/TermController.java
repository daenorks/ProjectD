package basic;

public abstract class TermController {
	Jeu jeu;
	TermView view;
	Carte carte;

	public void joueur() {
		boolean actionDone = false;
		//view the board
		view.afficherPlateau();
		//view the hand
		view.afficherMain();
		//select card to play or pioche or passe
		while (!actionDone) {
			actionDone = askAction();
			if (carte != null) {
				//	if posable select where and the angle
				if (carte.estPosable())
					actionDone = askPosition();
				else askPlayer();
			}
		}
	}
	
	protected abstract void askPlayer();

	protected abstract boolean askPosition();

	private boolean askAction();
}
