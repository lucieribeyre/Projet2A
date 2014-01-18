package Animation3;

import java.awt.*; 


/**
 *
 */

public class ToucheBlancheD extends Touche{

	public ToucheBlancheD(int xPos, int yPos, String s){
		super(Color.WHITE, xPos, yPos, s);				
	}

	@Override
	public void dessinerTouche(Graphics g) {
		g.setColor(colorT);
		g.fillRect(x+w/2-4,y,w-w/2+4,h/2);
		g.fillRect(x, y+h/2,w,h/2);

	}
	
	public void ecrireSymbole(Graphics g){
		super.ecrireSymbole(g);
		g.drawString(a,x+12,y+163);
	}

}