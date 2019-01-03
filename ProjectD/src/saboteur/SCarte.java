package saboteur;

import java.io.File;

import basic.Carre;
import basic.Carte;
import basic.Joueur;

public enum SCarte implements Carte, Carre {
	;

	@Override
	public int getH() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getD() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getG() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getB() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public File getPicture() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean estPosable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void jouerCarte(Joueur joueur) {
		// TODO Auto-generated method stub
		
	}
}
