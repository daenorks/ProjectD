package saboteur;

import java.awt.Container;
import java.awt.event.ActionListener;

import javax.swing.Icon;

import basic.Carre;
import basic.Carte;
import basic.Joueur;

public enum SCarte implements Carte, Carre {

	DEPART(1,1,1,1);
	C1(1,0,1,1,false,true,"../ressources/SaboteurChemin1.png");
	C2(1,1,0,1,false,true,"../ressources/SaboteurChemin2.png");
	C3(0,0,0,1,false,true,"../ressources/SaboteurChemin3.png");
	C4(1,1,1,1,false,true,"../ressources/SaboteurChemin4.png");
	C5(0,0,1,1,false,true,"../ressources/SaboteurChemin5.png");		
	C6(0,1,0,1,false,true,"../ressources/SaboteurChemin6.png");
	C7(1,0,1,1,false,false,"../ressources/SaboteurChemin7.png"); // SaboteurChemin 7 n est pas traversable.
	C8(1,1,0,0,false,true,"../ressources/SaboteurChemin8.png");
	CTRESOR1(1,0,1,0,true,"../ressources/SaboteurCache.png");
	CTRESOR2(0,1,1,0,true,"../ressources/SaboteurCache.png");
	CTRESOR3(1,1,1,1,true,"../ressources/SaboteurCache.png");
	
	saboter_Lampe("../ressources/SaboteurLampe0.png");
	saboter_Outil("../ressources/SaboteurLampe0.png");
	saboter_Chariot("../ressources/SaboteurChariot0.png");
	reparer_Lampe("../ressources/SaboteurLampe1.png");
	reparer_Outil("../ressources/SaboteurOutil1.png");
	reparer_Chariot("../ressources/SaboteurChariot1.png");

	
	private final int h;
	private final int b;
	private final int g;
	private final int d;
	
	private final int a;
	private final boolean traversable;
	private final boolean tresor;
	private File file;

	public SCarte(File f) {
		this.file = f;
	}
	
	public SCarte(int x, int y, int z, int c, boolean b,boolean t, File f) {
		this.h=x;
		this.b=y;
		this.g=z;
		this.d=c;
		this.tresor=b;
		this.traversable=t;
		this.file = f;
	}

	public boolean getTraversable() {
		return this.traversable;
	}
	
	public void SCarte(int action) {
		this.a = action;
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
		return file;
	}

	@Override
	public boolean estPosable() {
		// inutile ?
	}

	@Override
	public boolean action(Joueur j, SPlateau p, Joueur c, int x, int y) {
		switch (this) {
		case C1:
			if (j.peutPoser()) {
				return this.poser(plateau, x, y);
			}
			break;
		case C2:
			if (j.peutPoser())
				return this.poser(p, x, y);
			break;
		case C3:
			if (j.peutPoser())
				return this.poser(p, x, y);
			break;
		case C4:
			if (j.peutPoser())
				return this.poser(p, x, y);
			break;
		case C5:
			if (j.peutPoser())
				return this.poser(p, x, y);
			break;
		case C6:
			if (j.peutPoser())
				return this.poser(p, x, y);
			break;
		case C7:
			if (j.peutPoser())
				return this.poser(p, x, y);
			break;
		case saboter_Lampe:
			return c.action(this);
			break;
		case saboter_Outil:
			return c.action(this);
			break;
		case saboter_Chariot:
			return c.action(this);
			break;
		case reparer_Lampe:
			return c.action(this);
			break;
		case reparer_Outil:
			return c.action(this);
			break;
		case reparer_Chariot:
			return c.action(this);
			break;
		}
		return false;
	}
	
	public void revele() {
		switch (this) {
		case CTRESOR1:
			this.file = "../ressources/SaboteurTresor0.png";
			break;
		case CTRESOR2:
			this.file = "../ressources/SaboteurTresor0bis.png";
			break;
		case CTRESOR3:
			this.file = "../ressources/SaboteurTresor1.png";
			break;
		case default:
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
