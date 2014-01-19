package enregistrer_lire;

public class GestionBouton extends Thread{
	/*cette classe permet de gerer le fait que les boutons changent automatiquement
	 * quand tous les lecteurs ont fini leur lecture
	 */
	
	static TableauLecteur tl;
	
	public GestionBouton(TableauLecteur t){
		tl=t;
	}
	
	public void run(){
		while(true){
			if(tl.fini())
				tl.stopper();
		}
	}

}
