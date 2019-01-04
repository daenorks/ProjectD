package saboteur;

import java.awt.Container;
import java.awt.event.ActionListener;

import javax.swing.Icon;

import basic.Carre;
import basic.Carte;
import basic.Joueur;

public enum SCarte implements Carte, Carre {

	DEPART(1,1,1,1),
	C1(1,0,1,1,false,true,"../ressources/SaboteurChemin1.png"),
	C2(1,1,0,1,false,true,"../ressources/SaboteurChemin2.png"),
	C3(0,0,0,1,false,true,"../ressources/SaboteurChemin3.png"),
	C4(1,1,1,1,false,true,"../ressources/SaboteurChemin4.png"),
	C5(0,0,1,1,false,true,"../ressources/SaboteurChemin5.png"),	
	C6(0,1,0,1,false,true,"../ressources/SaboteurChemin6.png"),
	C7(1,0,1,1,false,false,"../ressources/SaboteurChemin7.png"), // SaboteurChemin 7 n est pas traversable.
	C8(1,1,0,0,false,true,"../ressources/SaboteurChemin8.png"),
	CTRESOR1(1,0,1,0,true, true, "../ressources/SaboteurCache.png"),
	CTRESOR2(0,1,1,0, true, true,"../ressources/SaboteurCache.png"),
	CTRESOR3(1,1,1,1,true, true, "../ressources/SaboteurCache.png"),
	SLampe("../ressources/SaboteurLampe0.png") {
		@Override
		public boolean action(Joueur j) {
			return true;
		}
	},
	SOutil("../ressources/SaboteurLampe0.png") {
		@Override
		public boolean action(Joueur j) {
			return true;
		}
	},
	SChariot("../ressources/SaboteurChariot0.png") {
		@Override
		public boolean action(Joueur j) {
			return true;
		}
	},
	RLampe("../ressources/SaboteurLampe1.png") {
		@Override
		public boolean action(Joueur j) {
			return true;
		}
	},
	ROutil("../ressources/SaboteurOutil1.png") {
		@Override
		public boolean action(Joueur j) {
			return true;
		}
	},
	RChariot("../ressources/SaboteurChariot1.png") {
		@Override
		public boolean action(Joueur j) {
			return true;
		}
	};


	
	private final int h;
	private final int b;
	private final int g;
	private final int d;
	
	private final int indexBloquer;
	private final boolean traversable;
	private final boolean tresor;
	private final boolean posable;
	private Icon icon;
	
	private SCarte(String file) {
		this.posable = false;
		this.icon = toIcon(file);
	}
	
	private SCarte(int h, int g, int b, int d,
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
			this.icon = toIcon("../ressources/SaboteurTresor0.png");
			break;
		case CTRESOR2:
			this.icon = toIcon("../ressources/SaboteurTresor0bis.png");
			break;
		case CTRESOR3:
			this.icon = toIcon("../ressources/SaboteurTresor1.png");
			break;
		default:
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
