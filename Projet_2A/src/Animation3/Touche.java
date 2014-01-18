package Animation3;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


/**
 *  Cette classe est abstraite car les classes ToucheBlanche et ToucheNoire, qui heritent
 *  de cette classe, ont des points communs qu'il est pratique de regrouper ici
 */

public abstract class Touche {

	protected int R = 250;		// taux de rouge dans le symbole de la touche
	protected int G = 130;		// taux de vert dans le symbole de la touche
	protected int B = 0;		// taux de bleu dans le symbole de la touche
	protected int TAILLE = 12;  // taille de ce symbole
	protected int GRAS = 0;		
	protected Color colorT;		// couleur d'une touche (blanche ou noire)
	protected int x;			// abscisse de l'angle sup gauche d'une touche
	protected int y;			// ordonne de ce meme point
	protected String a;			// symbole de la touche
	protected int w = 30;			// largeur d'une touche
	protected int h = 150;			// hauteur d'une touche
	
	public Touche(Color colT, int xPos, int yPos, String s){
		this.colorT = colT;
		setXY(xPos, yPos);
		this.a = s;
	}

	public void setColor(Color c){ //methode necessaire?
		this.colorT = c;
	}

	public void setXY(int xPos, int yPos){
		this.x = 70+xPos;
		this.y = 150+yPos;
	}

	public abstract void dessinerTouche(Graphics g);

	public void ecrireSymbole(Graphics g){
		Color col = new Color(R,G,B);     			// couleur du symbole = rouge
		Font font = new Font("Helvetica",GRAS,TAILLE);	// police du symbole
		g.setFont(font);      
		g.setColor(col);
	}


}
