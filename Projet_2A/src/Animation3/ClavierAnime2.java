package Animation3;

import java.util.ArrayList;
import java.util.List;

public class ClavierAnime2 extends Thread {
	
	private List<Touche> Touches;
	private List<ToucheBlanche> TouchesBlanches;
	private List<ToucheNoire> TouchesNoires;
	private ImageN6K im; 
	
	public ClavierAnime2(){
		Touches = new ArrayList<Touche>();
		Touches.addAll(TouchesBlanches);
		Touches.addAll(TouchesNoires);
		im = new ImageN6K();
	}
	
	public void paint(){
		for(Touche t : Touches){
			t.dessinerTouche(im.getGraphics());
			t.ecrireSymbole(im.getGraphics());
		}
		im.repaint();
	}
	
	
	public void run(){
		while(true){
			//on peint le clavier
			this.paint();
			
			 //regarder l'entier reçu de Claire
			
			// changer de couleur en fonction du resultat
			
			
			//repos du clavier (Thread)
			try {
				this.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
