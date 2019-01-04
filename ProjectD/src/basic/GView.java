package basic;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class GView extends JFrame {
	Jeu jeu;
	
	public GView(Jeu jeu, GController gc) {
		this.jeu = jeu;
		Container cont = getContentPane();
		cont.add(buildPlateau(gc), BorderLayout.PAGE_END);
		cont.add(buildMain(gc), BorderLayout.PAGE_END);
	}

	private Container buildMain(GController gc) {
		Container action = new Container();
		ArrayList<Carte> main = jeu.getActualHand();
		action.add(buildPioche(gc));
		action.add(buildPasser(gc));
		for (int x = 0; x < main.size() ; x++)
				action.add(carteMain(main.get(x), x, gc));
		return action;
	}
	
	private Component buildPasser(GController gc) {
		// TODO Auto-generated method stub
		return null;
	}

	private Component buildPioche(GController gc) {
		// TODO Auto-generated method stub
		return null;
	}

	private JButton carrePlateau(Carre carre, int x, int y, GController gc) {
		JButton button = carre.getButton();
		button.addActionListener(e -> {gc.clickPlateauXY(x, y);});
		return button;
	}
	
	private Container carteMain(Carte carte, int x, GController gc) {
		return carte.getCont(e -> {gc.clickCarteX(x);});
	}

	private Container buildPlateau(GController gc) {
		Container plateau = new Container();
		Carre[][] carres = jeu.getPCarres();
		plateau.setLayout(new GridLayout(carres[0].length, carres.length));
		for (int y = 0; y < carres[0].length; y++)
			for (int x = 0; x < carres.length; x++)
				plateau.add(carrePlateau(carres[x][y], x, y, gc));
		return plateau;
	}
}
