package Animation3;

import java.awt.*; 


/**
 * Cette classe crée une touche blanche : un rectangle de taille 26*130 px et d'angle superieur gauche
 * de coordonnees (x,y). Sur cette touche sera ecrit le symbole a correspondant du clavier de l'ordinateur
 * en position (x+13, 98).
 *
 */

public class ToucheBlanche extends Touche{

	public ToucheBlanche(Color colT, int xPos, int yPos, String s){
		super(colT, xPos, yPos, s);				
	}

	@Override
	public void dessinerTouche(Graphics g) {
		// TODO Auto-generated method stub
		g.drawRect(x, y, 26, 130);
		g.setColor(colorT.WHITE);
		g.drawString(a,  x + 13, 98);
	}

	@Override
	public void ecrireSymbole(Graphics g) {
		// TODO Auto-generated method stub
		Color col = new Color(COLOR,0,0);
		Font font = new Font("Helvetica",GRAS,TAILLE);
		g.setFont(font);      
		g.setColor(col);
		g.drawString(a,x+13,98);
	}

	@Override
	public void changerCouleur(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(colorT.BLUE);
	}

}
