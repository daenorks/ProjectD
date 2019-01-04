package saboteur;

import java.awt.Container;
import java.awt.event.ActionListener;

import javax.swing.Icon;

import basic.Carre;
import basic.Carte;
import basic.Joueur;

public enum SCarte implements Carte, Carre {

	DEPART(1,1,1,1),
	C1(1,0,1,1,false,true,"fichier"),
	C2(1,1,0,1,false,true,"fichier"),
	C3(0,0,0,1,false,true,"fichier"),
	C4(1,1,1,1,false,true,"fichier"),
	C5(0,0,1,1,false,true,"fichier"),		
	C6(0,1,0,1,false,true,"fichier"),
	C7(1,0,1,1,false,false,"fichier"), // SaboteurChemin 7 n est pas traversable.
	C8(1,1,0,0,false,true,"fichier"),
	CTRESOR1(1,0,1,0,true, true,"fichier"),
	CTRESOR2(0,1,1,0,true, true,"fichier"),
	CTRESOR3(1,1,1,1,true, true,"fichier"),
	
	SLampe(),
	SOutil(),
	SChariot(),
	RLampe(),
	ROutil(),
	RChariot();

	
	private final int h;
	private final int b;
	private final int g;
	private final int d;
	
	private final int indexBloquer;
	private final boolean traversable;
	private final boolean tresor;
	private final boolean posable;
	private Icon icon;
	
	public void SCarte(String file) {
		this.posable = false;
		this.icon = toIcon(file);
	}
	
	public void SCarte(int h, int g, int b, int d,
			boolean tresor,boolean traversable, String file) {
		this.h=h;
		this.b=b;
		this.g=g;
		this.d=d;
		this.tresor=tresor;
		this.traversable=traversable;
		this.posable = false;
		this.icon = toIcon(file);
		this.posable = true;
	}

	private Icon toIcon(String file) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean getTraversable() {
		return this.traversable;
	}
	
	public void SCarte(int action) {
		this.indexBloquer = action;
	}

	@Override
	public int getH() {
		return h;
	}

	@Override
	public int getD() {
		return d;
	}

	@Override
	public int getG() {
		return g;
	}

	@Override
	public int getB() {
		return b;
	}

	@Override
	public Icon getIcon() {
		return icon;
	}

	@Override
	public boolean estPosable() {
		return posable;
	}

	@Override
	public boolean action(Joueur j) {
		return false;
	}
	
	public void revele() {
		switch (this) {
		case CTRESOR1:
			this.file = "fichier";
			break;
		case CTRESOR2:
			this.file = "fichier";
			break;
		case CTRESOR3:
			this.file = "fichier";
			break;
		}
	}

	@Override
	public Container getCont(ActionListener e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSide() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setSide(int s) {
		// TODO Auto-generated method stub

	}

}
