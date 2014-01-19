package Animation;

import java.awt.*; 


/**
 * 
 *
 */

public class ToucheBlancheM extends Touche{

	public ToucheBlancheM(int xPos, int yPos, String s){
		super(Color.WHITE, xPos, yPos, s);				
	}

	@Override
	public void dessinerTouche(Graphics g) {
		g.setColor(colorT);
		g.fillRect(x+w/2-4,y,w/2,h/2);
		g.fillRect(x, y+h/2,w,h/2);

	}
	
	public void ecrireSymbole(Graphics g){
		super.ecrireSymbole(g);
		g.drawString(a,x+12,y+163);
	}
	@Override
	public Color getCouleur() {
		// TODO Auto-generated method stub
		return Color.WHITE;
	}

}