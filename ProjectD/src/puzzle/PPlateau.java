package puzzle;

import basic.Carte;
import basic.Carre;
import basic.Plateau;
import basic.Joueur;
import java.awt.image.*;
import javax.swing.*;
import java.awt.*;
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
import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;
import java.awt.Component;

public class PPlateau extends Plateau {

	private PPiece[][] plateau_final;

	public PPlateau(Image img, int x, int y) {
		super(new Carre[x][y]);
		this.plateau_final = new PPiece[x][y];
		remplir(decouper(img));
	}

	public boolean poser(PPiece carte, Joueur j, int x, int y) {
		if (carres[x][y] != null)
			return false;
		put(carte, x, y);
		j.remove(carte);
		return true;
	}

	public boolean retirer(Joueur j, int x, int y) {
		if ((x < 0 || y < 0) || (x >= carres.length || y >= carres[0].length))
			return false;
		if (carres[x][y] == null)
			return false;
		else {
			PPiece c = (PPiece) carres[x][y];
			carres[x][y] = null;
			j.add(c);
			return true;
		}

	}

	private boolean check(int x, int y) {
		return (carres[x][y].getH() == plateau_final[x][y].getH());
	}
	
	
	public boolean poser(Carte c, int i, int x) {
		//inutile;
		return false;
	}

	public boolean check_victoire() {
		int x = plateau_final.length;
		int y = plateau_final[0].length;
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (!check(i, j))
					return false;
			}
		}
		return true;
	}

	public Image[] decouper(Image img) {
		int x = plateau_final.length;
		int y = plateau_final[0].length;
		Image[] imag = new Image[x * y];
		int c=0;
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				Component comp;
				comp = null; //ca va bug je pense, a tester
				imag[c] = comp.createImage(
						new FilteredImageSource(img.getSource(), new CropImageFilter(j * img.getWidth(null) / y,
								i * img.getHeight(null) / x, (img.getWidth(null) / y), img.getHeight(null) / x)));
				c++;
			}
		}
		return imag;
	}

	public void remplir(Image[] img) {
		int c = 0;
		for (int i = 0; i < plateau_final.length; i++) {
			for (int j = 0; j < plateau_final[0].length; j++) {
				plateau_final[i][j] = new PPiece(c, img[c]);
				c++;
			}
		}
	}

}
