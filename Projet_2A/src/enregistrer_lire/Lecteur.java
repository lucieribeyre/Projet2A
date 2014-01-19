package enregistrer_lire;
import java.util.ArrayList;

import Sons.EmettreSon;
import Sons.Synthetiseur;


public class Lecteur extends Thread{

	private ArrayList<Integer> enr;
	private EmettreSon s;
	private int numero;
	private Boolean l;
	private int i;
	int[] note = new int[1000];
	int compteur=0;
	private Boolean fini;

	public Lecteur(Synthetiseur sy, int num, ArrayList<Integer> a, int instru){
		numero=num;
		s=new EmettreSon(numero, sy);
		s.changerInstrument(instru);
		enr=a;
		l=false;
		i=0;
		fini=false;
	}

	/*permet de changer l'etat de lecture du thread*/
	public void setLecture(Boolean lc){
		l=lc;
		fini=false;
		if(lc==false)
			i=0;
	}
	
	/*permet de faire un pause dans la lecture*/
	public void pause(){
		l=false;
	}
	
	/*retourne l'etat de lecture du thread*/
	public Boolean getLecture(){
		return l;
	}
	
	/*permet de couper les notes,
	 * ! ici la profondeur des notes n'est pa pris en compte
	 * elle est automatiquement de 1s
	 */
	public void decompte(int b){
		if(b<note.length-2){
			s.off(note[b+1]);
		}
		if(b==note.length-1){
			s.off(note[0]);
		}
	}
	
	/*retourne l'etat de fin de lecture*/
	public Boolean getFini(){
		return fini;
	}

	public void run(){
		while(true){
			if(enr.size()!=0){
				
				if(l){
					s.accord(enr.get(i));
					note[compteur]=enr.get(i);
					decompte(compteur);
					compteur++;
					if(compteur==note.length)
						compteur=0;
					i++;
					if(i>= enr.size()){
						l=false;
						i=0;
						s.allOff();
						fini=true;
					}

				}

			}
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
