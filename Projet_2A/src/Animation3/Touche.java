package Animation3;

import java.awt.Color;
import java.awt.Graphics;


/**
 *  Cette classe est abstraite car les classes ToucheBlanche et ToucheNoire, qui heritent
 *  de cette classe, ont des points communs qu'il est pratique de regrouper ici
 */

public abstract class Touche {
	
	protected int COLOR = 125;
	protected int TAILLE = 10;
	protected int GRAS = 0;
	protected Color colorT;
	int x;
	protected int y;
	protected String a;
	
	public Touche(Color colT, int xPos, int yPos, String s){
		this.colorT = colT;
		this.x = xPos;
		this.y = yPos;
		this.a = s;
	}
	
	public void setColor(Color c){ //methode necessaire?
		this.colorT = c;
	}
	
	public void setXY(int xPos, int yPos){
		this.x = xPos;
		this.y = yPos;
	}
	
	
	public abstract void dessinerTouche(Graphics g);

	public abstract void ecrireSymbole(Graphics g);
}
