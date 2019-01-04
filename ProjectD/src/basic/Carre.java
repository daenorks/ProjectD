package basic;

import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;

public interface Carre {
	int getH();
	int getD();
	int getG();
	int getB();
	File getPicture();
	Icon getIcon();
	default JButton getButton() {
		JButton button = new JButton(getIcon());
		button.setBorder(BorderFactory.createEmptyBorder());
		button.setContentAreaFilled(false);
		return button;
	}
}
