package enregistrer_lire;
import java.util.ArrayList;

import main.Clavier;



public class Enregistreur extends Thread{

	private ArrayList<Integer> enre;
	static Clavier c;
	private Boolean record;

	public Enregistreur(Clavier cl){
		c=cl;
		enre =  new ArrayList<Integer>();
		record = false;
	}

	/*pemet d'ajouter une note a la piste de lecture*/
	public void addNote(int i){
		enre.add(i);
	}

	
	/*retourne la piste d'enregistrement qui est une liste d'entier*/
	public ArrayList<Integer> list(){
		return enre;
	}

	/*remet la piste d'enregistrement a zero*/
	public void reset(){
		enre.clear();
	}

	/*permet de choisir si la piste est en mode enregistrement ou non*/
	public void setRecord(Boolean b){
		record=b;
	}

	/*thread permettant d'enregistrer la piste*/
	public void run(){
		while(true){
			
			if(record){
				enre.add((c.getNote()));
			}
			try {
				this.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
