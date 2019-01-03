package domino;

import java.util.ArrayList;
import java.util.Collections;

import basic.Carte;
import basic.Pioche;

import java.util.ArrayList;
import java.util.Collections;

public class DPioche extends Pioche {
	public DPioche() {
		ArrayList<Carte> dominos = new ArrayList<Carte>();
		for (int i = 0; i <= 6; i++)
			for (int b = 0; b <= i; b++)
				dominos.add(new Domino(DCarre.iDCarre(i), DCarre.iDCarre(b)));
		Collections.shuffle(dominos);
		hand = dominos;
	}
}