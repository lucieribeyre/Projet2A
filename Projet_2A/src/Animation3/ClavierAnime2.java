package Animation3;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import Sons.Clavier;

public class ClavierAnime2 extends Thread  {

	private List<Touche> Touches = new ArrayList<Touche>();
	Clavier c;
	Graphics g;
	private int a=30;
	private int decalageBN = 5;

	public ClavierAnime2(Graphics g, Clavier c){

		this.g = g;
		this.c = c;

		Touches.add(new ToucheBlancheG(0,0,"Ctrl"));
		Touches.add(new ToucheBlancheM( a+1,0,"alt"));
		Touches.add(new ToucheBlancheD( 2*(a+1),0,"<>"));
		Touches.add(new ToucheBlancheG( 3*(a+1),0,"W"));
		Touches.add(new ToucheBlancheM( 4*(a+1),0,"X"));
		Touches.add(new ToucheBlancheM( 5*(a+1),0,"C"));
		Touches.add(new ToucheBlancheD( 6*(a+1),0,"V"));
		Touches.add(new ToucheBlancheG( 7*(a+1),0,"B"));
		Touches.add(new ToucheBlancheM( 8*(a+1),0,"N"));
		Touches.add(new ToucheBlancheD( 9*(a+1),0,"?"));
		Touches.add(new ToucheBlancheG( 10*(a+1),0,".;"));
		Touches.add(new ToucheBlancheM( 11*(a+1),0,":/"));
		Touches.add(new ToucheBlancheM( 12*(a+1),0,"!�"));
		Touches.add(new ToucheBlancheD( 13*(a+1),0,"�%"));
		Touches.add(new ToucheBlancheG( 14*(a+1),0,"*�"));
		Touches.add(new ToucheBlancheM( 15*(a+1),0,"A"));
		Touches.add(new ToucheBlancheD( 16*(a+1),0,"Z"));
		Touches.add(new ToucheBlancheG( 17*(a+1),0,"E"));
		Touches.add(new ToucheBlancheM( 18*(a+1),0,"R"));
		Touches.add(new ToucheBlancheM( 19*(a+1),0,"T"));
		Touches.add(new ToucheBlancheD( 20*(a+1),0,"Y"));
		Touches.add(new ToucheBlancheG( 21*(a+1),0,"U"));
		Touches.add(new ToucheBlancheM( 22*(a+1),0,"I"));
		Touches.add(new ToucheBlancheD( 23*(a+1),0,"O"));
		Touches.add(new ToucheBlancheG( 24*(a+1),0,"P"));
		Touches.add(new ToucheBlancheM( 25*(a+1),0,"^�"));
		Touches.add(new ToucheBlancheM( 26*(a+1),0,"�$"));
		Touches.add(new ToucheBlancheD( 27*(a+1),0,"Ent"));

		Touches.add(new ToucheNoire((a+1)-decalageBN,0,"Verr"));
		Touches.add(new ToucheNoire(2*(a+1)-decalageBN,0,"Q"));
		Touches.add(new ToucheNoire(4*(a+1)-decalageBN,0,"S"));
		Touches.add(new ToucheNoire(5*(a+1)-decalageBN,0,"D"));
		Touches.add(new ToucheNoire(6*(a+1)-decalageBN,0,"F"));
		Touches.add(new ToucheNoire(8*(a+1)-decalageBN,0,"H"));
		Touches.add(new ToucheNoire(9*(a+1)-decalageBN,0,"J"));
		Touches.add(new ToucheNoire(11*(a+1)-decalageBN,0,"K"));
		Touches.add(new ToucheNoire(12*(a+1)-decalageBN,0,"L"));
		Touches.add(new ToucheNoire(13*(a+1)-decalageBN,0,"M"));
		Touches.add(new ToucheNoire(15*(a+1)-decalageBN,0,"1"));
		Touches.add(new ToucheNoire(16*(a+1)-decalageBN,0,"2"));
		Touches.add(new ToucheNoire(18*(a+1)-decalageBN,0,"4"));
		Touches.add(new ToucheNoire(19*(a+1)-decalageBN,0,"5"));
		Touches.add(new ToucheNoire(20*(a+1)-decalageBN,0,"6"));
		Touches.add(new ToucheNoire(22*(a+1)-decalageBN,0,"8"));
		Touches.add(new ToucheNoire(23*(a+1)-decalageBN,0,"9"));
		Touches.add(new ToucheNoire(25*(a+1)-decalageBN,0,")�]"));
		Touches.add(new ToucheNoire(26*(a+1)-decalageBN,0,"=+}"));
		Touches.add(new ToucheNoire(27*(a+1)-decalageBN,0,"Del"));



	}

	public void paint(){
		for(Touche t : Touches){
			t.dessinerTouche(g);
			t.ecrireSymbole(g);
		}
	}


	public void run(){
		while(true){
			//on peint le clavier
			this.paint();

			//regarder l'entier re�u de Claire
			// changer de couleur en fonction du resultat
			for(int i=0; i<Touches.size(); i++){
				if(c.getNote()==i+48){
					Touches.get(i).setColor(Color.BLUE);
				}
			}

			//repos du clavier (Thread)
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
