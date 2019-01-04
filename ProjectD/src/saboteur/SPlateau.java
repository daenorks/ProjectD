package saboteur;

import basic.Carre;
import basic.Carte;
import basic.Plateau;

public class SPlateau extends Plateau {

	
	private int[] tresor;
	private boolean[] tresor_revele;
	private boolean[][] aux;
	

	public SPlateau(Carre[][] c) {
		super(new Carre[11][11]);
		tresor = new int[3];
		tresor_revele = new boolean[3];
		for (int i = 0; i < 3; i++) {
			tresor[i] = (int) ((Math.random() * ((100 - 1) + 1)) + 1);
		}
		put(SCarte.CTRESOR1, 10, 0);
		put(SCarte.CTRESOR2, 10, 10);
		put(SCarte.CTRESOR3, 10, 5);
		put(SCarte.CTRESOR3, 10, 10);
	}
	
	public boolean partie_finie() {
		for (int i = 0; i < 3; i++) {
			if (!tresor_revele[i])
				return false;
		}
		return true;
	}

	@Override
	public boolean poser(SCarte carte, int x, int y) {
		if ((hasVoisin(x, y)) && (check(carte, x, y))) {
			this.carres[x][y] = carte;
			return true;
		}
		return false;
	}

	

	public boolean[] parcourir() {
		this.aux = new boolean[21][21];
		parcourir_aux(new boolean[3], 10, 10);
	}

	private boolean[] parcourir_aux(boolean []b,int x, int y) {
		
		if (partie_finie()) return b;
		SCarte sc = (SCarte) carres[x][y];
		aux[x][y]=true;
		
		switch(sc) {
		case CTRESOR1:
			if(!tresor_revele[1]) {
				sc.revele();
				tresor_revele[1]=true;
				b[1]=true;
			}
			break;
		case CTRESOR2:
			if(!tresor_revele[2]) {
				sc.revele();
				tresor_revele[2]=true;
				b[2]=true;
			}
			break
		case CTRESOR3:
			if(!tresor_revele[2]) {
				sc.revele();
				tresor_revele[2]=true;
				b[2]=true;
			}
			break;
		case default:
				break;
		}
		
		if((SCarte)carres[x][y].getTraversable()) {
			if ((x<carres.length && x > -1) && carres[x+1][y]!=null && (!aux[x+1][y])) {
				b=parcourir_aux(b,x+1,y);
			}
		
			if ((x<carres.length && x > -1) && carres[x-1][y]!=null && (!aux[x-1][y])) {
				b=parcourir_aux(b,x-1,y);
			}
			
			if ((y < carres.length && y > -1) && carres[x][y+1]!=null && (!aux[x][y+1])) {
				b=parcourir_aux(b,x,y+1);
			}
		
			if ((y<carres.length && y > -1) && carres[x][y-1]!=null && (!aux[x][y-1])) {
				b=parcourir_aux(b,x,y+1);
			}
		}
		
		return b;
	}
}
