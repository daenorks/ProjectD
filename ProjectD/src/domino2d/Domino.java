package domino2d;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import basic.Carte;
import basic.Joueur;

public class Domino implements Carte {
	private DCarre carre1;
	private DCarre carre2;
	private int side;

	public Domino(DCarre c1, DCarre c2) {
		carre1 = c1;
		carre2 = c2;
	}

	public DCarre getCarre1() {
		return carre1;
	}

	public DCarre getCarre2() {
		return carre2;
	}

	@Override
	public boolean estPosable() {
		return true;
	}

	public void afficher() {
		System.out.println("[" + carre1.getN() + "|" + carre2.getN() + "]");
	}

	public void reverse() {
		DCarre d = carre1;
		carre1 = carre2;
		carre2 = d;
	}

	@Override
	public boolean action(Joueur j) {
		return false;
	}

	@Override
	public Container getCont(ActionListener e) {
		Container c = new Container();
		c.setLayout(new FlowLayout());
		JButton b = new JButton(carre1.getN() + " " + carre2.getN());
		b.addActionListener(e);
		c.add(b);
		return c;
	}

	@Override
	public int getSide() {
		return side;
	}

	@Override
	public void setSide(int s) {
		side = s;
	}

}