package Animation;
import Sons.Clavier;


public class NoteAnimee extends Thread {
	/**
	 * Cette classe a pour fonction de faire changer de couleur une touche/note du clavier graphique
	 * lorsqu'elle reçoit une note NOTE.
	 * L'objet cree est un thread
	 */

	// l'attribut de cet objet est un clavier(cree par Claire). 
	// Methode Clavier : getNote(); qui renvoie un tableau d'entiers

	private Clavier c;

	public NoteAnimee(Clavier clavier){
		c=clavier;		
	}

	public void run(){
		{

		}
	}

}
