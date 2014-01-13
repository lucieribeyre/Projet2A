package Animation3;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * Cette classe crée une touche noire : un rectangle de taille 13*65 px et d'angle superieur gauche
 * de coordonnees (x,0).Sur cette touche sera ecrit le symbole a correspondant du clavier de l'ordinateur
 * en position (x+13, 49).
 *
 */

public class ToucheNoire extends Touche{

	public ToucheNoire(Color colT, int xPos, int yPos, String s){
		super(colT, xPos, yPos, s);				
	}
	
	@Override
	public void dessinerTouche(Graphics g) {
		// TODO Auto-generated method stub
		g.drawRect(x, y, 13, 65);
		g.setColor(colorT.BLACK);
		g.drawString(a, x + 13, 49);
	}

	@Override
	public void ecrireSymbole(Graphics g) {
		// TODO Auto-generated method stub
		Color col = new Color(COLOR,0,0);
		Font font = new Font("Helvetica",GRAS,TAILLE);
		g.setFont(font);      
		g.setColor(col);
		g.drawString(a,x+13,49);
	}

}
