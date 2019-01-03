package domino;

import java.io.File;

import basic.Carre;

public enum DCarre implements Carre {
	C0(0, "Dice0.png"),
	C1(1, "Dice1.png"),
	C2(2, "Dice2.png"),
	C3(3, "Dice3.png"),
	C4(4, "Dice4.png"),
	C5(5, "Dice5.png"),
	C6(6, "Dice6.png");
	
	private int n;
	private File file;

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

}
