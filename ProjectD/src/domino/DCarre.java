package domino;

import java.io.File;

import basic.Carre;

public enum DCarre implements Carre {
	C0(0, "Dice0.png"), C1(1, "Dice1.png"), C2(2, "Dice2.png"), C3(3, "Dice3.png"), C4(4, "Dice4.png"),
	C5(5, "Dice5.png"), C6(6, "Dice6.png");

	private int n;
	private File file;

	public static DCarre iDCarre(int i) {
		switch (i) {
		case 0:
			return C0;
		case 1:
			return C1;
		case 2:
			return C2;
		case 3:
			return C3;
		case 4:
			return C4;
		case 5:
			return C5;
		case 6:
			return C6;
		default:
			return null;
		}
	}

	private DCarre(int n, String file) {
		this.n = n;
		this.file = new File(file);
	}

	@Override
	public int getH() {
		return n;
	}

	@Override
	public int getD() {
		return n;
	}

	@Override
	public int getG() {
		return n;
	}

	@Override
	public int getB() {
		return n;
	}

	@Override
	public File getPicture() {
		return file;
	}

	public boolean egal(DCarre c) {
		return (this.n == c.n);
	}

	public int getN() {
		return this.n;
	}

}
