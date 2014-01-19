package Animation;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Cette classe crée une touche noire : un rectangle de taille 13*65 px.
 * Sur cette touche sera ecrit le symbole "a" du clavier de l'ordinateur correspondant a la note
 * jouee. Il est en position (x+13, 49).
 *
 */

public class ToucheNoire extends Touche{

	public ToucheNoire(int xPos, int yPos, String s){
		super(Color.BLACK, xPos, yPos, s);				
	}
	
	@Override
	public void dessinerTouche(Graphics g) {
		g.setColor(colorT);
		g.drawRect(69,141,(w+1)*28,h+1);
		g.fillRect(x, y, w/2, h/2);
	}
	
	public void ecrireSymbole(Graphics g){
		super.ecrireSymbole(g);
		g.drawString(a,x+3,y-7);
	}
	
	@Override
	public Color getCouleur() {
		// TODO Auto-generated method stub
		return Color.BLACK;
	}

}
