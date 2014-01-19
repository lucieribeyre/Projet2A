package Animation;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import main.Clavier;

public class ClavierAnime extends Thread {

	private List<Touche> Touches = new ArrayList<Touche>();
	Clavier c;
	Graphics g;
	private int a=30;
	private int decalageBN = 5;
	private int[] note = new int[200];
	private int compteur=0;

	public ClavierAnime(Graphics gr, Clavier cl){

		this.g = gr;
		this.c = cl;

		Touches.add(new ToucheBlancheG(0,0,"Ctrl"));
		Touches.add(new ToucheNoire((a+1)-decalageBN,0,"Verr"));
		Touches.add(new ToucheBlancheM( a+1,0,"Shift"));
		Touches.add(new ToucheNoire(2*(a+1)-decalageBN,0,"Q"));
		Touches.add(new ToucheBlancheD( 2*(a+1),0,"<>"));
		Touches.add(new ToucheBlancheG( 3*(a+1),0,"W"));
		Touches.add(new ToucheNoire(4*(a+1)-decalageBN,0,"S"));
		Touches.add(new ToucheBlancheM( 4*(a+1),0,"X"));
		Touches.add(new ToucheNoire(5*(a+1)-decalageBN,0,"D"));
		Touches.add(new ToucheBlancheM( 5*(a+1),0,"C"));
		Touches.add(new ToucheNoire(6*(a+1)-decalageBN,0,"F"));
		Touches.add(new ToucheBlancheD( 6*(a+1),0,"V"));
		Touches.add(new ToucheBlancheG( 7*(a+1),0,"B"));
		Touches.add(new ToucheNoire(8*(a+1)-decalageBN,0,"H"));
		Touches.add(new ToucheBlancheM( 8*(a+1),0,"N"));
		Touches.add(new ToucheNoire(9*(a+1)-decalageBN,0,"J"));
		Touches.add(new ToucheBlancheD( 9*(a+1),0,"?"));
		Touches.add(new ToucheBlancheG( 10*(a+1),0,".;"));
		Touches.add(new ToucheNoire(11*(a+1)-decalageBN,0,"K"));
		Touches.add(new ToucheBlancheM( 11*(a+1),0,":/"));
		Touches.add(new ToucheNoire(12*(a+1)-decalageBN,0,"L"));
		Touches.add(new ToucheBlancheM( 12*(a+1),0,"!§"));
		Touches.add(new ToucheNoire(13*(a+1)-decalageBN,0,"M"));
		Touches.add(new ToucheBlancheD( 13*(a+1),0,"ù%"));
		Touches.add(new ToucheBlancheG( 14*(a+1),0,"*µ"));
		Touches.add(new ToucheNoire(15*(a+1)-decalageBN,0,"1"));
		Touches.add(new ToucheBlancheM( 15*(a+1),0,"A"));
		Touches.add(new ToucheNoire(16*(a+1)-decalageBN,0,"2"));
		Touches.add(new ToucheBlancheD( 16*(a+1),0,"Z"));
		Touches.add(new ToucheBlancheG( 17*(a+1),0,"E"));
		Touches.add(new ToucheNoire(18*(a+1)-decalageBN,0,"4"));
		Touches.add(new ToucheBlancheM( 18*(a+1),0,"R"));
		Touches.add(new ToucheNoire(19*(a+1)-decalageBN,0,"5"));
		Touches.add(new ToucheBlancheM( 19*(a+1),0,"T"));
		Touches.add(new ToucheNoire(20*(a+1)-decalageBN,0,"6"));
		Touches.add(new ToucheBlancheD( 20*(a+1),0,"Y"));
		Touches.add(new ToucheBlancheG( 21*(a+1),0,"U"));
		Touches.add(new ToucheNoire(22*(a+1)-decalageBN,0,"8"));
		Touches.add(new ToucheBlancheM( 22*(a+1),0,"I"));
		Touches.add(new ToucheNoire(23*(a+1)-decalageBN,0,"9"));
		Touches.add(new ToucheBlancheD( 23*(a+1),0,"O"));
		Touches.add(new ToucheBlancheG( 24*(a+1),0,"P"));
		Touches.add(new ToucheNoire(25*(a+1)-decalageBN,0,")°]"));
		Touches.add(new ToucheBlancheM( 25*(a+1),0,"^¨"));
		Touches.add(new ToucheNoire(26*(a+1)-decalageBN,0,"=+}"));
		Touches.add(new ToucheBlancheM( 26*(a+1),0,"£$"));
		Touches.add(new ToucheNoire(27*(a+1)-decalageBN,0,"Del"));
		Touches.add(new ToucheBlancheD( 27*(a+1),0,"Ent"));



	}

	public void paint(){
		for(Touche t : Touches){
			t.dessinerTouche(g);
			t.ecrireSymbole(g);
		}
	}

	public void decompte(int b){

		if(b<note.length-2){
			if(note[b+1]!=-48){
				Touches.get(note[b+1]).setColor(Touches.get(note[b+1]).getCouleur());
			}
		}

		if(b==note.length-1){
			if(note[0]!=-48){
				Touches.get(note[0]).setColor(Touches.get(note[0]).getCouleur());
			}
		}
	}


	public void run(){
		while(true){


			//regarder l'entier reçu de Claire
			// changer de couleur en fonction du resultat
			int a=c.getNote();
			for(int i=0; i<Touches.size(); i++){
				if(a==i+48){
					Touches.get(i).setColor(Color.BLUE);
				}
			}
			note[compteur]=a-48;
			decompte(compteur);
			compteur++;
			if(compteur==note.length)
				compteur=0;
			//on peint le clavier
			this.paint();

			//repos du clavier (Thread)
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
