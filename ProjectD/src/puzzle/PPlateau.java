package puzzle;

import basic.Carte;
import basic.Plateau;

public class PPlateau extends Plateau {

	private PPiece[][] plateau_final;

	public PPlateau(Image img, int x, int y) {
		super(x, y);
		this.plateau_final = new PPiece[x][y];
		remplir(decouper(img));
	}

	@Override
	public boolean poser(Carte carte, int x, int y) {
		if (plateau[x][y] != null)
			return false;
		put(carte, x, y);
		actuel.remove(c);
		return true;
	}

	public boolean retirer(int x, int y) {
		if ((x<0 || y<0) || (x>=plateau.length || y>=plateau[0].length)) 
			return false;
		if (plateau[x][y] == null)
			return false;
		else {
			Carte c = plateau[x][y];
			plateau[x][y]=null;
			actuel.add(c);
		}
	}

	private boolean check(int x, int y) {
		return (carres[x][y].getH()==plateau_final[x][y].getH());
	}

	public boolean check_victoire() {
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < y.length; j++) {
				if (!check(i,j))
					return false;
			}
		}
		return true;
	}
	
	public Image[] decouper(Image img){
		Image []imag = new Image[x.length*y.length];
		int c;
		for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < y.length; j++) {
                 imag[c] = createImage(new FilteredImageSource(resized.getSource(),
                		new CropImageFilter(j*width/y.length,i*height/x.length,(width/y.length), height/x.length)));
                 c++;
            }
		}
		return imag;
	}
	
	public 	void remplir(Image[] img) {
		int c = 0;
		for (int i=0; i < plateau_final.length; i++) {
			for (int j=0; j<plateau_final[0].length;j++) {
				plateau_final[i][j] = new PPiece(c,img[c]);
				actuel.hand.add((Carte) new PPiece (c,img[c]));
				c++;
			}
		}
	}
	
		

}
