package Animation;

import java.awt.*; 


/**
 * 
 *
 */

public class ToucheBlancheG extends Touche{

	public ToucheBlancheG(int xPos, int yPos, String s){
		super(Color.WHITE, xPos, yPos, s);				
	}

	@Override
	public void dessinerTouche(Graphics g) {
		g.setColor(colorT);
		g.fillRect(x, y,w-4,h/2);
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
