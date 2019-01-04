package puzzle;

import java.awt.Container;
import java.awt.event.ActionListener;

import javax.swing.Icon;

import basic.Carre;
import basic.Carte;
import basic.Joueur;

public class PPiece implements Carte, Carre {
	
	private int id_piece;
	private Icon icon;

	public PPiece (int id_piece, File f) {
		this.id_piece = id_piece;
		this.icon = toIcon(f);
	}
	
	@Override
	public int getH() {
		this.id_piece;
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
	public Icon getIcon() {
		return icon;
	}

	@Override
	public boolean estPosable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean action(Joueur j) {
		// TODO Auto-generated method stub
		return false;
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
