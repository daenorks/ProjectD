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
		if (jeu.estFini())
			all.add(buildWinners(), BorderLayout.CENTER);
		else {
		all.add(buildJoueur(jeu.actuel), BorderLayout.LINE_START);
		all.add(buildPlateau(), BorderLayout.CENTER);
		all.add(buildAction(), BorderLayout.PAGE_END);
		}
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
		Container b = new Container();
		b.setLayout(new FlowLayout());
		ArrayList<Carte> main = jeu.getActualHand();
		if (jeu.canPioche)
			b.add(buildPioche());
		if (jeu.canPasse())
			b.add(buildPasser());
		for (Carte carte : main) {
			b.add(buildHandCarte(carte));
		}
		return b;
	}

	private Container buildHandCarte(Carte carte) {
		return carte.getCont(e -> {
			jeu.setCarte(carte);
			update();
		});
	}

	private Container buildActionPasPosable() {
		action = new Container();
		action.setLayout(new FlowLayout());
		if (jeu.canDef())
			if (jeu.defausse()) {
				update();
			}
		;
		action.add(buildDef());
		action.add(buildRetour());
		for (Joueur j : jeu.getJoueurs())
			action.add(buildJoueur(j));
		return action;
	}

	private Container buildActionPosable() {
		action = new Container();
		action.setLayout(new FlowLayout());
		if (jeu.canDef())
			action.add(buildDef());
		action.add(buildRotate());
		action.add(buildCarte());
		action.add(buildRetour());
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
	
	private JButton buildRetour() {
		JButton button = new JButton("Retour");
		button.addActionListener(e -> {
			jeu.setInitalState();
			update();
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
	
	private Container buildWinners() {
		Container cont = new Container();
		cont.setLayout(new FlowLayout());
		for (Joueur j : jeu.lesGagnants())
			cont.add(buildJoueur(j));
		return cont;
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
