package puzzle;

import java.awt.*;
import java.awt.Container;
import java.awt.event.ActionListener;

import javax.swing.Icon;

import basic.Carre;
import basic.Carte;
import basic.Joueur;

public class PPiece implements Carte, Carre {

	private int id_piece;
	private Icon icon;

	public PPiece(int id_piece, File f) {
		this.id_piece = id_piece;
		this.icon = toIcon(f);
	}

	public PPiece(int id_piece, Image img) {
		this.id_piece = id_piece;
		this.icon = (Icone) new ImageIcone(img); // cast � voir
	}

	@Override
	public int getH() {
		return this.id_piece;
	}

	@Override
	public Icone getIcone() {
		return this.icon;
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
	public Icon toIcon(String str) {
		Image image = null;
		try {
			image = ImageIO.read(getClass().getResource(str));
		} catch (IOException e) {
			e.printStackTrace();
		}
		ImageIcon icon = new ImageIcon(image);
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
