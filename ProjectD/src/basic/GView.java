package basic;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import basic.Jeu.State;

public class GView extends JFrame {
	Jeu jeu;
	Container action;
	Container plateau;
	
	public void update() {
		
	}
	
	public GView(Jeu jeu) {
		this.jeu = jeu;
		Container cont = getContentPane();
		cont.add(buildPlateau(), BorderLayout.PAGE_END);
		cont.add(buildAction(), BorderLayout.PAGE_END);
	}
	
	private Container buildAction() {
		if (jeu.getState() == State.CHOOSEACTION)
			return buildActionChoix();
		if (jeu.getState() == State.CHOOSECARTEACTION) {
			if (jeu.getCarte().estPosable())
				return buildActionPosable();
			else
				return buildActionPasPosable();
		}
		return null;
	}

	private Container buildActionChoix() {
		action = new Container();
		ArrayList<Carte> main = jeu.getActualHand();
		if (jeu.canPioche)
			action.add(buildPioche());
		if (jeu.canPasse())
			action.add(buildPasser());
		for (int x = 0; x < main.size() ; x++)
				action.add(carteMain(main.get(x), x));
		return action;
	}
	
	private Container buildActionPasPosable() {
		action = new Container();
		if (jeu.canDef())
			action.add(buildDef());
		for (Joueur j : jeu.getJoueurs())
			;
		return null;
	}
	
	private Container buildActionPosable() {
		action = new Container();
		if (jeu.canDef())
			action.add(buildDef());
		action.add(buildRotate());
		action.add(buildCarte());
		return action;
	}
	
	private Component buildCarte() {
		// TODO Auto-generated method stub
		return null;
	}

	private Component buildRotate() {
		// TODO Auto-generated method stub
		return null;
	}

	private JButton buildDef() {
		JButton button = new JButton("Passe");
		button.addActionListener(e -> {
			if (jeu.defausse()) {
				update();
			};
		});
		return button;
	}

	private JButton buildPasser() {
		JButton button = new JButton("Passe");
		button.addActionListener(e -> {
			if (jeu.passer()) {
				update();
			};
		});
		return button;
	}

	private JButton buildPioche() {
		JButton button = new JButton("Pioche");
		button.addActionListener(e -> {
			if (jeu.pioche()) {
				update();
			};
		});
		return button;
	}

	private JButton carrePlateau(Carre carre, int x, int y) {
		JButton button = null;
		if (carre == null)
			button = fillerButton();
		else
			button = carre.getButton();
		button.addActionListener(e -> {
			if (jeu.poserCarte(x, y)) {
				update();
			};
		});
		return button;
	}
	
	private JButton fillerButton() {
		JButton button = new JButton();
		button.setBorder(BorderFactory.createEmptyBorder());
		button.setContentAreaFilled(false);
		return button;
	}

	private Container carteMain(Carte carte, int x) {
		return carte.getCont(e -> {});
	}

	private Container buildPlateau() {
		Container plateau = new Container();
		Carre[][] carres = jeu.getPCarres();
		plateau.setLayout(new GridLayout(carres[0].length, carres.length));
		for (int y = 0; y < carres[0].length; y++)
			for (int x = 0; x < carres.length; x++)
				plateau.add(carrePlateau(carres[x][y], x, y));
		return plateau;
	}
}
