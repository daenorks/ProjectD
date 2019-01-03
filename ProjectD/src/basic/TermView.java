package basic;

public abstract class TermView {
	private Jeu jeu;
	
	public void afficherMain() {
	
	}
	public void afficherPlateau() {
		Carre[][] carres = jeu.getPCarres();
		String[] strs = new String[carres.length];
		for (int x = 0; x < carres.length; x++)
			for (int y = 0; y < strs.length; y++)
				strs[y] += carres[x][y].getView();
		for (int y = 0; y < strs.length; y++)
			System.out.println(strs[y]);
	}
	public abstract void afficherCarte();
}
