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

	public Lecteur(Synthetiseur sy, int num, ArrayList<Integer> a){
		numero=num;
		s=new EmettreSon(numero, sy);
		enr=a;
		l=false;
		i=0;
	}

	public void setLecture(Boolean lc){
		l=lc;
		if(lc==false)
			i=0;
	}

	public Boolean getLecture(){
		return l;
	}

	public void run(){
		while(true){
			if(enr.size()!=0){
				
				if(l){
					s.accord(enr.get(i));
					i++;
					if(i>= enr.size()){
						l=false;
						i=0;
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
