package domino2d;

import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import basic.Carre;

public enum DCarre implements Carre {
	C0(0, "/ressources/Dice0.png"), C1(1, "/ressources/Dice1.png"), C2(2, "/ressources/Dice2.png"),
	C3(3, "/ressources/Dice3.png"), C4(4, "/ressources/Dice4.png"), C5(5, "/ressources/Dice5.png"),
	C6(6, "/ressources/Dice6.png");

	private int n;
	private Icon icon;

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
		this.icon = toIcon(file);
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

	public boolean egal(DCarre c) {
		return (this.n == c.n);
	}

	public int getN() {
		return this.n;
	}

	@Override
	public Icon getIcon() {
		return icon;
	}

	@Override
	public Icon toIcon(String str) {
		Image image = null;
		try {
			image = ImageIO.read(getClass().getResource(str));
		} catch (IOException e) {
			System.out.println("da");
			e.printStackTrace();
		}
		ImageIcon icon = new ImageIcon(image);
		return icon;
	}
}
