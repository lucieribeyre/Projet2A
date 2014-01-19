package metronome;

import javax.swing.border.TitledBorder;

import Sons.EmettreSon;
import Sons.Synthetiseur;

public class Metronom extends Thread{
	
	private Synthetiseur s;
	private EmettreSon e;
	private Boolean etat;
	private int vitesse;
	
	public Metronom(){
		s= new Synthetiseur();
		e= new EmettreSon(1, s);
		e.changerInstrument(210);
		vitesse = 60;
		etat=false;
		
	}
	
	/*retourne l'etat de lecture du metronome*/
	public void setState(Boolean b){
		etat=b;
	}
	
	/*permet de regler la vitesse du metronome*/
	public void setSpeed(int v){
		vitesse=v;
	}
	
	public void run(){
		while(true){
			if(etat){
				e.accord(90);
				e.off(90);
				try {
					Thread.sleep(60*1000/(vitesse));
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		}
	}

}
