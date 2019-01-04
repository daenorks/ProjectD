package puzzle;

import java.awt.*;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.io.File; 
import javax.swing.Icon;
import javax.imageio.ImageIO;
import java.io.IOException;
import basic.Carre;
import basic.Carte;
import basic.Joueur;
import java.awt.image.*;
import javax.swing.* ;
import java.awt.*;
import javax.swing.ImageIcon ;

public class PPiece implements Carte, Carre {

	private int id_piece;
	private Icon icon;

	public PPiece(int id_piece, File f) {
		this.id_piece = id_piece;
		this.icon = toIcon(f.toString());
	}

	public PPiece(int id_piece, Image img) {
		this.id_piece = id_piece;
		this.icon = (Icon) new ImageIcon(img); // cast à voir
	}
	
	public int getH() {
		return this.id_piece;
	}
	
	public Icon getIcon() {
		return this.icon;// cast ï¿½ voir
	}

	public int getD() {
		// TODO Auto-generated method stub
		return 0;
	}


	public int getG() {
		// TODO Auto-generated method stub
		return 0;
	}


	public int getB() {
		// TODO Auto-generated method stub
		return 0;
	}


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
