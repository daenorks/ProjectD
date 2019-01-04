package saboteur;

import java.awt.Container;
import java.awt.event.ActionListener;

import javax.swing.Icon;

import basic.Carre;
import basic.Carte;
import basic.Joueur;

public enum SCarte implements Carte, Carre {

	DEPART(1,1,1,1);
	C1(1,0,1,1,false,true,"fichier");
	C2(1,1,0,1,false,true,"fichier");
	C3(0,0,0,1,false,true,"fichier");
	C4(1,1,1,1,false,true,"fichier");
	C5(0,0,1,1,false,true,"fichier");		
	C6(0,1,0,1,false,true,"fichier");
	C7(1,0,1,1,false,false,"fichier"); // SaboteurChemin 7 n est pas traversable.
	C8(1,1,0,0,false,true,"fichier");
	CTRESOR1(1,0,1,0,true,"fichier");
	CTRESOR2(0,1,1,0,true,"fichier");
	CTRESOR3(1,1,1,1,true,"fichier");
	
	saboter_Lampe();saboter_Outil();saboter_Chariot();reparer_Lampe();reparer_Outil();reparer_Chariot();

	
	private final int h;
	private final int b;
	private final int g;
	private final int d;
	
	private final int a;
	private final boolean traversable;
	private final boolean tresor;
	private File file;

	public void SCarte(int x, int y, int z, int c, boolean b,boolean t, file f) {
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
		// 
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
