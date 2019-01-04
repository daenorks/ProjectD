package puzzle;

import java.util.ArrayList;

import basic.Jeu;
import basic.Joueur;

import basic.Carte;
import basic.Carre;
import basic.Plateau;
import basic.Joueur;
import java.awt.image.*;
import javax.swing.* ;
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
import javax.swing.* ;
import java.awt.*;
import javax.swing.ImageIcon ;
import java.awt.Component ;


public class PJeu extends Jeu {
	
	
	public void Pajouter(Image img) {
		Image []imag = ((PPlateau)plateau).decouper(img);
		for (int i = 0; i<imag.length;i++) {
			actuel.add(new PPiece (i,imag[i]));
		}
	}
	@Override
	public boolean estFini() {
		return ((PPlateau)plateau).check_victoire();
	}

	@Override
	public ArrayList<Joueur> lesGagnants() {
		return joueurs;
	}

	@Override
	protected void prochainTour() {
		if (estFini()) {
			//fin du jeu, puzzle termine
		} else {
			
		}
	}

}
