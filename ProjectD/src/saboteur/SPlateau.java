package saboteur;

import basic.Carre;
import basic.Carte;
import basic.Plateau;

public class SPlateau extends Plateau {

	private int[] tresor;
	private boolean[] tresor_revele;
	
	public SPlateau(Carre[][] c) {
		super(new Carre[21][21]);
		tresor = new int [3];
		tresor_revele = new boolean [3];
		for (int i = 0 ; i < 3; i++) {
			tresor[i]=(int)((Math.random()*((100-1)+1))+1);
		}
		
		put(SCarte.CTRESOR1,20,20);
		put(SCarte.CTRESOR2,20,20);
		put(SCarte.CTRESOR3,20,10);
	}
	
	public boolean[] parcourir() {
		revele(c);
		parcours();
		// parcours tous les chemins jusqu'au tresor, si possible. Si non renvoit false;
	}
	
	public boolean partie_finie() {
		for (int i = 0 ; i < 3; i++) {
			if(!tresor_revele[i]) return false;
		} 
		return true;
	}

	@Override
	public boolean poser(SCarte carte, int x, int y) {
		if ((hasVoisin(x,y)) && (check(carte, x, y))) {
			this.carres[x][y] = carte;
			return true;
		}
		return false;
	}
	
}
