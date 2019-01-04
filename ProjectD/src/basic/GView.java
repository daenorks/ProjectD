package basic;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import basic.Jeu.State;

@SuppressWarnings("serial")
public class GView extends JFrame {
	Jeu jeu;
	Container all;
	Container action;
	Container plateau;

	public void update() {
		all.removeAll();
		all.add(buildJoueur(jeu.actuel), BorderLayout.LINE_START);
		all.add(buildPlateau(), BorderLayout.CENTER);
		all.add(buildAction(), BorderLayout.PAGE_END);
		all.revalidate();
		repaint();
	}

	public GView(Jeu jeu) {
		this.jeu = jeu;
		all = getContentPane();
		all.add(buildJoueur(jeu.actuel), BorderLayout.LINE_START);
		all.add(buildPlateau(), BorderLayout.CENTER);
		all.add(buildAction(), BorderLayout.PAGE_END);
		setVisible(true);
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
		for (Carte carte : main)
			action.add(buildHandCarte(carte));
		return action;
	}

	private Container buildHandCarte(Carte carte) {
		return carte.getCont(e -> {
			jeu.setCarte(carte);
		});
	}

	private Container buildActionPasPosable() {
		action = new Container();
		if (jeu.canDef())
			if (jeu.defausse()) {
				update();
			}
		;
		action.add(buildDef());
		for (Joueur j : jeu.getJoueurs())
			action.add(buildJoueur(j));
		return action;
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
		return jeu.getCarte().getCont(e -> {
		});
	}

	private Component buildRotate() {
		JButton button = new JButton("Tourne");
		button.addActionListener(e -> {
			jeu.getCarte().rotate();
			update();
		});
		return button;
	}

	private JButton buildDef() {
		JButton button = new JButton("Defausse");
		button.addActionListener(e -> {
			if (jeu.defausse()) {
				update();
			}
			;
		});
		return button;
	}

	private JButton buildPasser() {
		JButton button = new JButton("Passe");
		button.addActionListener(e -> {
			if (jeu.passer()) {
				update();
			}
			;
		});
		return button;
	}

	private JButton buildPioche() {
		JButton button = new JButton("Pioche");
		button.addActionListener(e -> {
			if (jeu.pioche()) {
				update();
			}
			;
		});
		return button;
	}

	private JButton buildJoueur(Joueur j) {
		JButton joueur = new JButton("Joueur " + j.getNumJ() + "\n" + (j.getBloquer()[0] ? "Chariot casse" : "") + "\n"
				+ (j.getBloquer()[1] ? "Outil casse" : "") + "\n" + (j.getBloquer()[2] ? "Lampe casse" : "") + "\n");
		return joueur;
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
			}
			;
		});
		return button;
	}

	private JButton fillerButton() {
		JButton button = new JButton();
		//button.setBorder(BorderFactory.createEmptyBorder());
		//button.setContentAreaFilled(false);
		return button;
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
